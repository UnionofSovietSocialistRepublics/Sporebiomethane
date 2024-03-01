package jp.content;

import arc.math.Angles;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.content.Fx;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import jp.content.JPCopterUnitType;
import jp.content.Blade;

import static jp.content.Blade.BladeMount;

public class JPCopterUnitEntity extends UnitEntity {
    public BladeMount[] blades;
    public float bladeMoveSpeedScl = 1f;
    public long drawSeed = 0;
    @Override
    public String toString() {
        return "JPCopterUnit#" + id;
    }

    @Override
    public int classId() {
        return JPUnits.classID(getClass());
    }

    @Override
    public void setType(UnitType type) {
        super.setType(type);
        if (type instanceof JPCopterUnitType ornitopter) {
            blades = new BladeMount[ornitopter.blade.size];
            for (int i = 0; i < blades.length; i++) {
                Blade bladeType = ornitopter.blade.get(i);
                blades[i] = new BladeMount(bladeType);
            }
        }
    }


    @Override
    public void update() {
        super.update();
        drawSeed++;
        JPCopterUnitType type = (JPCopterUnitType) this.type;
        float rX = x + Angles.trnsx(rotation - 90, type.fallSmokeX, type.fallSmokeY);
        float rY = y + Angles.trnsy(rotation - 90, type.fallSmokeX, type.fallSmokeY);

        // Slows down rotor when dying
        if (dead || health() <= 0) {
            rotation += Time.delta * (type.spinningFallSpeed * vel().len()) * Mathf.signs[id % 2];
            if (Mathf.chanceDelta(type.fallSmokeChance)) {
                Fx.fallSmoke.at(rX, rY);
                Fx.burning.at(rX, rY);
            }
            bladeMoveSpeedScl = Mathf.lerpDelta(bladeMoveSpeedScl, 0f, type.bladeDeathMoveSlowdown);
        } else {
            bladeMoveSpeedScl = Mathf.lerpDelta(bladeMoveSpeedScl, 1f, type.bladeDeathMoveSlowdown);
        }

        for (BladeMount blade : blades) {
            blade.bladeRotation += ((blade.blade.bladeMoveSpeed * bladeMoveSpeedScl) + blade.blade.minimumBladeMoveSpeed) * Time.delta;
        }
        type.fallSpeed = 0.006f;
    }
}