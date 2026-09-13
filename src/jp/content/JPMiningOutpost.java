package jp.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.scene.ui.layout.Table;
import arc.struct.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.units.*;

import static mindustry.Vars.content;
import static mindustry.Vars.indexer;

public class JPMiningOutpost extends UnitCargoLoader {
    public float unitBuildTime = 60f * 8f;
    public float staleTimeDuration = 60f * 6f;
    public float polyStroke = 1.8f, polyRadius = 6f;
    public int polySides = 8;
    public float polyRotateSpeed = 1f;
    public Color polyColor = Pal.accent;

    public JPMiningOutpost(String name) {
        super(name);
        unitType = JPUnits.harvester;
        update = solid = true;
        hasItems = true;
        configurable = true;
        saveConfig = true;
        clearOnDoubleTap = true;
//      I will only ever use this class on 1 block so uhhh, yeah. (Indicates that the sprite have corners)
        squareSprite = false;
        itemCapacity = 200;
        ambientSound = Sounds.loopUnitBuilding;

        config(Item.class, (JPMiningOutpostBuild build, Item item) -> build.item = item);
        configClear((JPMiningOutpostBuild build) -> build.item = null);
    }
    @Override
    public boolean outputsItems(){
        return true;
    }

    public class JPMiningOutpostBuild extends UnitTransportSourceBuild {
        public @Nullable Item item;
        public float staleTimer;
        public boolean stale;


        @Override
        public void updateTile(){
            super.updateTile();

            if(items.total() < itemCapacity){
                staleTimer = 0f;
                stale = false;
            }

            if(dumpAccumulate()){
                staleTimer = 0f;
                stale = false;
            }else if(items.total() >= itemCapacity && (staleTimer += Time.delta) >= staleTimeDuration){
                stale = true;
            }
        }

        @Override
        public boolean acceptItem(Building source, Item item){
            return false;
        }

        @Override
        public int acceptStack(Item item, int amount, Teamc source){
            if(!(source instanceof Unit u)) return 0;
            if(u.type != JPUnits.harvester) return 0;

            return Math.min(itemCapacity - items.total(), amount);
        }

        public void buildConfiguration(Table table){
            Seq<Item> mineable = content.items().select(item ->
                    (indexer.hasOre(item) && JPUnits.harvester.mineFloor && item.hardness <= JPUnits.harvester.mineTier)
                            ||(indexer.hasWallOre(item) && JPUnits.harvester.mineWalls && item.hardness <= JPUnits.harvester.mineTier));
            ItemSelection.buildTable(JPMiningOutpost.this, table, mineable, () -> item, this::configure);
        }

        @Override
        public Object config(){
            return item;
        }

        @Override
        public void draw(){
            Draw.rect(block.region, x, y);
            if(unit == null){
                Draw.draw(Layer.blockOver, () -> {
                    Drawf.construct(this, unitType.fullIcon, 0f, buildProgress, warmup, totalProgress);
                });
            }else{
                Draw.z(Layer.bullet - 0.01f);
                Draw.color(item == null ? polyColor : item.color);
                Lines.stroke(polyStroke * readyness);
                Lines.poly(x, y, polySides, polyRadius, Time.time * polyRotateSpeed);
                Draw.reset();
                Draw.z(Layer.block);
            }
        }

        @Override
        public void write(Writes write){
            super.write(write);
            write.s(item == null ? -1 : item.id);
            write.bool(stale);
        }

        @Override
        public void read(Reads read, byte revision){
            super.read(read, revision);
            item = Vars.content.item(read.s());
            stale = read.bool();
        }

    }
}
