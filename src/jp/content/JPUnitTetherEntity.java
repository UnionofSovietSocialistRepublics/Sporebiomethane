package jp.content;

import mindustry.gen.*;

public class JPUnitTetherEntity extends UnitEntity implements UnitTetherc {
    Unit unit;
    int unitId;
    @Override
    public String toString() {
        return "JPTetherUnitEntity#" + id;
    }

    @Override
    public int classId() {
        return JPUnits.classID(getClass());
    }

    public static JPUnitTetherEntity create(){
        return new JPUnitTetherEntity();
    }

    @Override
    public Unit spawner() {
        return unit;
    }

    @Override
    public int spawnerUnitId() {
        return unitId;
    }

    @Override
    public void spawner(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void spawnerUnitId(int i) {
        this.unitId = i;
    }
}
