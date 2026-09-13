package jp.content;

import arc.util.*;
import mindustry.entities.units.AIController;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;

import static mindustry.Vars.*;
// CargoAI If it was a miner instead of a delivery guy
public class JPMiningAI extends AIController {
    public boolean mining = true;
    public Item targetItem;
    public Tile ore;
    public static float emptyWaitTime = 60f * 2f, dropSpacing = 60f * 1.5f;
    public static float transferRange = 20f, moveRange = 4f, moveSmoothing = 20f;

    public @Nullable JPMiningOutpost.JPMiningOutpostBuild outpostBuild;
    public @Nullable Item itemTarget;
    @Override
    public void updateMovement() {
        if (!(unit instanceof BuildingTetherc tether) || tether.building() == null) return;
        var build = tether.building();
//      actually let me use unloadPoint's fucking function (why, Java?)
        if (build instanceof JPMiningOutpost.JPMiningOutpostBuild outpost) {
            outpostBuild = outpost;
        }

        if (mining) {
//          If requested item is not the same as item on unit OR outpost haven't requested item, dump item and go back to outpost.
            if((outpostBuild.item != unit.item()&&unit.hasItem())||outpostBuild.item==null){
                unit.mineTile = null;
                moveTo(build, moveRange, moveSmoothing);
                if (unit.within(outpostBuild, transferRange) && timer.get(timerTarget2, dropSpacing)) {
                    int max = outpostBuild.acceptStack(unit.item(), unit.stack.amount, unit);
                    //deposit if possible, if not, dump.
                    if (max > 0 && unit.hasItem()) {
                        Call.transferItemTo(unit, unit.item(), max, unit.x, unit.y, outpostBuild);
                    }
                    unit.clearItem();
                    return;
                }
            }
            targetItem = outpostBuild.item;
            if (indexer.hasOre(targetItem) && unit.type.mineFloor) {
                ore = indexer.findClosestOre(build.x, build.y, targetItem);
            } else if (indexer.hasWallOre(targetItem) && unit.type.mineWalls) {
                ore = indexer.findClosestWallOre(build.x, build.y, targetItem);
//          If selected item is invalid
            }else{
                moveTo(build, moveRange, moveSmoothing);
                return;
            }
            if (unit.stack.amount >= unit.type.itemCapacity || (targetItem != null && !unit.acceptsItem(targetItem))) {
                mining = false;
            } else if (ore != null) {
                moveTo(ore, unit.type.mineRange / 2f, 20f);

                if (unit.within(ore, unit.type.mineRange) && unit.validMine(ore)) {
                    unit.mineTile = ore;
                }
            }
        } else {
            moveTo(outpostBuild, moveRange, moveSmoothing);

            //deposit in bursts, unloading can take a while
            if (unit.within(outpostBuild, transferRange) && timer.get(timerTarget2, dropSpacing)) {
                int max = outpostBuild.acceptStack(unit.item(), unit.stack.amount, unit);
                //deposit items when it's possible
                if (max > 0) {
                    Call.transferItemTo(unit, unit.item(), max, unit.x, unit.y, outpostBuild);
                }

                if (!unit.hasItem()) {
                    mining = true;
                }
            }

        }
    }
}



