package jp.content;

import arc.math.*;
import arc.util.io.*;
import mindustry.content.*;

import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.production.*;

import static mindustry.Vars.*;
public class JPCreepTower extends Block {
    public int radius = 3;
//    public float convertSpeed = 2f;

    public JPCreepTower(String name) {
        super(name);

        update = solid = true;
        outlineIcon = true;
    }

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid){
        super.drawPlace(x,y,rotation,valid);
        Drawf.dashCircle(x * tilesize + offset, y * tilesize + offset, radius*tilesize, Pal.placing);
    }

    public class JPCreepTowerBuild extends Building {
        public float progress;

        @Override
        public void updateTile(){
            int cx = tile.x;
            int cy = tile.y;

            for(int x = -radius; x <= radius; x++){
                for(int y = -radius; y <= radius; y++){

                    float dst2 = x * x + y * y;
                    if(dst2 > radius * radius) continue;

                    Tile other = world.tile(cx + x, cy + y);
                    if(other == null) continue;

                    if(other.floor().isLiquid) continue;
                    Floor floor = null;
                    boolean hadOre = other.overlay() != Blocks.air && other.overlay().itemDrop != null;
                    if(hadOre) floor = other.overlay();
                    boolean protectOverlay = false;

                    Floor result = Blocks.moss.asFloor();
                    if(other.floor().isLiquid&&(other.floor()==Blocks.water||other.floor()==Blocks.sandWater)) result = Blocks.taintedWater.asFloor();
                    if(other.floor().isLiquid&&(other.floor()==Blocks.darksandWater)) result = Blocks.darksandTaintedWater.asFloor();
                    if(other.floor().isLiquid&&(other.floor()==Blocks.deepwater)) result = Blocks.deepTaintedWater.asFloor();


                    other.setFloor(result);
                    if(floor!=null) other.setOverlay(floor);

                }
            }
        }

        @Override
        public void drawSelect(){
            Drawf.dashCircle(x, y, radius * tilesize, Pal.accent);
        }

        @Override
        public float progress(){
            return progress;
        }

        @Override
        public void write(Writes write){
            super.write(write);

            write.f(progress);
        }

        @Override
        public void read(Reads read, byte revision){
            super.read(read, revision);

            progress = read.f();
        }

    }
}
