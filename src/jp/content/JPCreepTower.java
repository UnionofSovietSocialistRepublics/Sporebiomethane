package jp.content;

import arc.math.*;
import mindustry.content.*;

import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.production.*;

import static mindustry.Vars.*;
public class JPCreepTower extends Block {
    public int radius = 3;

    public JPCreepTower(String name) {
        super(name);
    }

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid){

        Drawf.dashCircle(x * tilesize + offset, y * tilesize + offset, radius, Pal.placing);
    }
    public class JPCreepTowerBuild extends Building {
        @Override
        public void updateTile(){
            super.updateTile();

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
                    other.setFloor(result);
                    if(floor!=null) other.setOverlay(floor);

                }
            }

            private Floor getExplosionResult(Tile tile){
                if(tile.overlay() == EnvironmentBlocks.oreNickel){
                    return EnvironmentBlocks.nickelFloor.asFloor();
                }

                if(tile.floor() == Blocks.water||tile.floor() == Blocks.taintedWater){
                        return Blocks.rhyoliteCrater.asFloor();
                }

                return targetFloor;
            }
        }

    }
}
