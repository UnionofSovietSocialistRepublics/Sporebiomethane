package jp.content;

import arc.util.Nullable;
import mindustry.gen.*;
import mindustry.world.blocks.storage.*;

public class JPHarvesterUnitEntity extends BuildingTetherPayloadUnit {

    @Override
    public String toString() {
        return "JPHarvesterUnit#" + id;
    }

    @Override
    public int classId() {
        return JPUnits.classID(getClass());
    }

    public static JPHarvesterUnitEntity create(){
        return new JPHarvesterUnitEntity();
    }
//  By default, tether unit deposit item into nearby cores, overriding AI behavior, this exists to prevent tether entity from finding any core at all.
    @Override
    @Nullable public CoreBlock.CoreBuild closestCore(){
        return null;
    }
}
