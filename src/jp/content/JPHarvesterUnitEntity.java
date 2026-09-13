package jp.content;

import arc.util.Nullable;
import mindustry.gen.Building;
import mindustry.gen.BuildingTetherc;
import mindustry.gen.Call;
import mindustry.gen.UnitEntity;

public class JPHarvesterUnitEntity extends UnitEntity implements BuildingTetherc {

    public @Nullable Building building;

    @Override
    public Building building() {
        return null;
    }

    @Override
    public void building(Building building) {
    }

    @Override
    public String toString() {
        return "JPCopterUnit#" + id;
    }

    @Override
    public int classId() {
        return JPUnits.classID(getClass());
    }

    @Override
    public void update(){
        if(building == null || !building.isValid() || building.team != team){
            Call.unitDespawn(self());
        }

        super.update();
    }
}
