package jp.content;

import arc.audio.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.Vars;
import mindustry.content.*;

import mindustry.entities.*;
import mindustry.entities.units.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.draw.*;

import static mindustry.Vars.*;

//Spreads moss, moss made this way die after the block is destroyed.
public class JPCreepTower extends Block{

    /** Maximum expansion distance from the outer edge of the tower footprint, in tiles. */
    public int radius = 3;

    /** Number of tiles converted per second at full efficiency.*/
    public float convertSpeed = 10f;

    /** Power consumed per second. */
    public float powerUse = 1f;

    /** Visual range interpolation speed. */
    public float rangeDisplaySmooth = 0.12f;

    /** Max amount of attempt that can be performed per frame, both for conversion and repair */
    public float maxPerFrame = 20f;

    public JPCreepTower(String name){
        super(name);

        update = true;
        solid = true;
        hasPower = true;

        consumePower(powerUse);
    }

    public DrawBlock drawer = new DrawDefault();

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid){
        super.drawPlace(x, y, rotation, valid);

        float footprintRadius = (size - 1) / 2f;
        float range = footprintRadius + radius;

        Drawf.dashCircle(
                x * tilesize + size * tilesize / 2f - tilesize / 2f,
                y * tilesize + size * tilesize / 2f - tilesize / 2f,
                range * tilesize,
                Pal.placing
        );
    }

    @Override
    public void drawPlanRegion(BuildPlan plan, Eachable<BuildPlan> list){
        drawer.drawPlan(this, plan, list);
    }
    @Override
    public TextureRegion[] icons(){
        return drawer.finalIcons(this);
    }
    @Override public void getRegionsToOutline(Seq<TextureRegion> out){
        drawer.getRegionsToOutline(this, out);
    }
    @Override public void load(){
        super.load(); drawer.load(this);
    }

    public class JPCreepTowerBuild extends Building{

        /** Current expansion ring. 0 is the tower footprint. */
        public int currentRing;

        /** Conversion accumulator; one whole unit converts one tile. */
        public float convertTimer;

        /** Radius used for visuals; smoothly follows currentRing. */
        public float visualRadius;

        public float progress;

        public float repairTimer;

        public final Seq<Tile> ringTiles = new Seq<>();

        public int ringTotal;

        public boolean ringPrepared;

        /** Tells the drawer that handles animation to shut up once the block is disabled. */
        public float animationProgress;

        public boolean creepShrinkStarted;

        public float shrinkTimer;

        /** Stores converted tile to revert to once the block is gone*/
        public final Seq<CreepRecord> converted = new Seq<>();

        public boolean isShrinking;

        @Override
        public void draw(){
            drawer.draw(this);
        }
        @Override
        public void drawLight(){
            super.drawLight(); drawer.drawLight(this);
        }

        @Override
        public float totalProgress(){
            return animationProgress;
        }

        @Override
        public void updateTile(){
            float targetVisualRadius = Math.min(currentRing, radius);
            visualRadius = Mathf.lerpDelta(visualRadius, targetVisualRadius, rangeDisplaySmooth);

            if(efficiency <= 0f){
                return;
            }

            animationProgress += (Time.delta * efficiency)%360;

            // Expansion phase.
            if(currentRing <= radius){
                if(!ringPrepared){
                    prepareRing();
                }

                // Convert at a rate of convertSpeed tiles/second, scaled by efficiency.
                convertTimer += convertSpeed * efficiency * Time.delta / 60f;

                int convertedThisFrame = 0;

                while(convertTimer >= 1f && !ringTiles.isEmpty() && convertedThisFrame++ < maxPerFrame){
                    convertTimer -= 1f;

                    int index = Mathf.random(ringTiles.size - 1);
                    Tile tile = ringTiles.remove(index);

                    convertTile(tile, currentRing);

                    progress = ringTotal <= 0
                            ? 1f
                            : 1f - (float)ringTiles.size / (float)ringTotal;
                }

                if(ringTiles.isEmpty()){
                    progress = 1f;
                    currentRing++;
                    ringPrepared = false;
                    ringTotal = 0;
                    progress = 0f;
                }
            }else{
                // Repairs tile inside radius
                repairTimer += convertSpeed * efficiency * Time.delta/60f;
                int repairedThisFrame = 0;
                while(repairTimer >= 1 && repairedThisFrame++ < maxPerFrame){
                    repairTimer -= 1;
                    repairRandomTile();
                }
            }
        }

        private void prepareRing(){
            ringTiles.clear();
            ringPrepared = true;

            if(currentRing > radius){
                ringTotal = 0;
                progress = 1f;
                return;
            }

            int left = tile.x + block.sizeOffset - currentRing;
            int right = tile.x + block.sizeOffset + block.size - 1 + currentRing;
            int bottom = tile.y + block.sizeOffset - currentRing;
            int top = tile.y + block.sizeOffset + block.size - 1 + currentRing;

            for(int tx = left; tx <= right; tx++){
                for(int ty = bottom; ty <= top; ty++){
                    Tile other = Vars.world.tile(tx, ty);
                    if(other == null) continue;

                    float dst2 = distanceToFootprint2(other.x, other.y);

                    // Ring 0 is the whole footprint.
                    // Later rings contain only tiles farther than the previous ring,
                    // but no farther than the current ring.
                    if(currentRing == 0){
                        if(dst2 > 0f) continue;
                    }else{
                        float outer2 = currentRing * currentRing;
                        float inner2 = (currentRing - 1) * (currentRing - 1);

                        if(dst2 > outer2 || dst2 <= inner2) continue;
                    }

                    ringTiles.add(other);
                }
            }

            ringTotal = ringTiles.size;

            // Edge case stuff
            if(ringTotal == 0){
                progress = 1f;
            }
        }

        private float distanceToFootprint2(int tx, int ty){
            int left = tile.x + block.sizeOffset;
            int right = left + block.size - 1;
            int bottom = tile.y + block.sizeOffset;
            int top = bottom + block.size - 1;

            int dx = 0;
            int dy = 0;

            if(tx < left){
                dx = left - tx;
            }else if(tx > right){
                dx = tx - right;
            }

            if(ty < bottom){
                dy = bottom - ty;
            }else if(ty > top){
                dy = ty - top;
            }

            return dx * dx + dy * dy;
        }

        private void convertTile(@Nullable Tile target, int ring){
            Effect convertEffect = Fx.breakProp;
            Sound convertSound = Sounds.plantBreak;
            if(target == null) return;

            Floor result = creepResult(target.floor());
            if(result == null) return;

            CreepRecord record = findRecord(target.pos());

            if(record == null){
                record = new CreepRecord(
                        target.pos(),
                        ring,
                        target.floor(),
                        result
                );

                converted.add(record);
            }else{
                record.creepFloor = result;
            }

            if(target.floor() != result){
                convertEffect.at(target.worldx(), target.worldy(), JPPal.sporeBulletBack);
                convertSound.at(target.worldx(), target.worldy(), 1);
                target.setFloor(result);
            }
        }

        private @Nullable Floor creepResult(Floor floor){
            if(floor == null) return null;

            if(floor == Blocks.water.asFloor() || floor == Blocks.sandWater.asFloor()){
                return Blocks.taintedWater.asFloor();
            }

            if(floor == Blocks.darksandWater.asFloor()){
                return Blocks.darksandTaintedWater.asFloor();
            }

            if(floor == Blocks.deepwater.asFloor()){
                return Blocks.deepTaintedWater.asFloor();
            }

//          Ignores other liquids (tar, slag, etc...)
            if(floor.isLiquid) return null;

            return Blocks.moss.asFloor();
        }

        private void repairRandomTile(){
            if(converted.isEmpty()) return;

            // Try several random records so one invalid/dead tile does not waste the attempt.
            int tries = Math.min(converted.size, 8);

            while(tries-- > 0){
                CreepRecord record = converted.random();
                Tile target = Vars.world.tile(record.pos);

                if(target == null) continue;

                if(target.floor() != record.creepFloor){
                    target.setFloor(record.creepFloor);
                }

                return;
            }
        }

        private @Nullable CreepRecord findRecord(int pos){
            for(CreepRecord record : converted){
                if(record.pos == pos){
                    return record;
                }
            }

            return null;
        }

        /**
         * Returns another live creep tower covering the given tile.
         * The current tower is excluded.
         */
        private @Nullable JPCreepTowerBuild findOverlappedTowers(Tile target){
            final JPCreepTowerBuild[] result = {null};

            Groups.build.each(build -> {
                if(result[0] != null) return;
                if(!(build instanceof JPCreepTowerBuild other)) return;
                if(other == this || !other.isValid()) return;

                if(other.covers(target)){
                    result[0] = other;
                }
            });

            return result[0];
        }

        public boolean covers(Tile target){
            if(target == null || tile == null) return false;

            return distanceToFootprint2(target.x, target.y) <= radius * radius;
        }

        private void transferRecord(JPCreepTowerBuild other, CreepRecord source){
            if(other == null) return;

            CreepRecord existing = other.findRecord(source.pos);

            if(existing == null){
                other.converted.add(new CreepRecord(
                        source.pos,
                        source.ring,
                        source.originalFloor,
                        source.creepFloor
                ));
                return;
            }

            if(isCreepFloor(existing.originalFloor) && !isCreepFloor(source.originalFloor)){
                existing.originalFloor = source.originalFloor;
            }
        }

        private boolean isCreepFloor(Floor floor){
            return floor == Blocks.moss.asFloor()
                    || floor == Blocks.taintedWater.asFloor()
                    || floor == Blocks.darksandTaintedWater.asFloor()
                    || floor == Blocks.deepTaintedWater.asFloor();
        }

        @Override
        public void drawSelect(){
            float footprintRadius = (block.size - 1) / 2f;
            float range = footprintRadius + visualRadius;

            Drawf.dashCircle(x, y, range * tilesize, Pal.accent);
        }

        @Override
        public float progress(){
            return progress;
        }

        private void beginCreepShrink(){
            if(creepShrinkStarted || converted.isEmpty()) return;

            creepShrinkStarted = true;
            isShrinking = true;
            shrinkTimer = 0f;

            Time.run(1f, this::updateCreepShrink);
        }

        private void updateCreepShrink(){
            if(converted.isEmpty()) return;

            shrinkTimer += convertSpeed * Time.delta/60f;

            int safety = 1;

            while(shrinkTimer >= 1f && !converted.isEmpty() && safety-- > 0){
                shrinkTimer -= 1f;
                restoreOneShrinkTile();
            }

            if(!converted.isEmpty()){
                Time.run(6f, this::updateCreepShrink);
            }
        }

        private void restoreOneShrinkTile(){
            if(converted.isEmpty()) return;

            int outerRing = -1;

            for(CreepRecord record : converted){
                if(record.ring > outerRing){
                    outerRing = record.ring;
                }
            }

            if(outerRing < 0){
                converted.clear();
                return;
            }

            int candidates = 0;

            for(CreepRecord record : converted){
                if(record.ring == outerRing){
                    candidates++;
                }
            }

            if(candidates == 0){
                return;
            }

            int choice = Mathf.random(candidates - 1);
            int index = -1;

            for(int i = 0; i < converted.size; i++){
                if(converted.get(i).ring != outerRing) continue;

                if(choice-- == 0){
                    index = i;
                    break;
                }
            }

            if(index == -1) return;

            CreepRecord record = converted.get(index);
            Tile target = Vars.world.tile(record.pos);

            converted.remove(index);

            if(target == null || record.originalFloor == null){
                return;
            }

            JPCreepTowerBuild other = findOverlappedTowers(target);

            if(other != null){
                transferRecord(other, record);
                return;
            }

            if(target.floor() == record.creepFloor){
                Fx.breakProp.at(target.worldx(), target.worldy(), JPPal.sporeBulletBack);
                Sounds.plantBreak.at(target.worldx(), target.worldy(), 1);
                target.setFloor(record.originalFloor);
            }
        }

        @Override
        public void onRemoved(){
            beginCreepShrink();
            super.onRemoved();
        }

        @Override
        public void onDestroyed(){
            beginCreepShrink();
            super.onDestroyed();
        }

        @Override
        public byte version(){
            return 1;
        }

        @Override
        public void write(Writes write){
            super.write(write);

            write.f(progress);
            write.i(currentRing);
            write.f(convertTimer);
            write.f(visualRadius);
            write.f(repairTimer);
            write.bool(isShrinking);
            write.f(shrinkTimer);

            write.i(converted.size);

            for(CreepRecord record : converted){
                write.i(record.pos);
                write.i(record.ring);
                write.s(record.originalFloor == null ? -1 : record.originalFloor.id);
                write.s(record.creepFloor == null ? -1 : record.creepFloor.id);
            }
        }

        @Override
        public void read(Reads read, byte revision){
            super.read(read, revision);

            progress = read.f();

            currentRing = 0;
            convertTimer = 0f;
            visualRadius = 0f;
            repairTimer = 0f;
            creepShrinkStarted = false;
            isShrinking = false;
            shrinkTimer = 0f;

            converted.clear();
            ringTiles.clear();
            ringPrepared = false;
            ringTotal = 0;

            if(revision >= 1){
                currentRing = read.i();
                convertTimer = read.f();
                visualRadius = read.f();
                repairTimer = read.f();
                isShrinking = read.bool();
                shrinkTimer = read.f();

                int count = Math.max(0, read.i());

                for(int i = 0; i < count; i++){
                    int pos = read.i();
                    int ring = read.i();

                    short originalFloorId = read.s();
                    short creepFloorId = read.s();

                    Floor originalFloor = readFloor(originalFloorId);
                    Floor creepFloor = readFloor(creepFloorId);

                    if(originalFloor != null && creepFloor != null){
                        converted.add(new CreepRecord(
                                pos,
                                ring,
                                originalFloor,
                                creepFloor
                        ));
                    }
                }

                if(isShrinking && !converted.isEmpty()){
                    creepShrinkStarted = true;
                    updateCreepShrink();
                }
            }
        }

        private @Nullable Floor readFloor(short id){
            if(id == -1) return null;

            Block block = Vars.content.block(id);
            return block instanceof Floor floor ? floor : null;
        }
    }

    public static class CreepRecord{
        public int pos;
        public int ring;

        /** Floor that existed before the tower converted this tile. */
        public Floor originalFloor;

        /** Floor the tower currently wants the tile to have. */
        public Floor creepFloor;

        public CreepRecord(int pos, int ring, Floor originalFloor, Floor creepFloor){
            this.pos = pos;
            this.ring = ring;
            this.originalFloor = originalFloor;
            this.creepFloor = creepFloor;
        }
    }
}