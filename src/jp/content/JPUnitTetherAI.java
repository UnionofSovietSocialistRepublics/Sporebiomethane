package jp.content;

import arc.util.*;
import mindustry.entities.units.*;
import mindustry.gen.*;

public class JPUnitTetherAI extends AIController {
    public @Nullable Unit shooter;
    boolean shoot=false;

    @Override
    public void updateMovement(){
        if(shooter != null && !shooter.dead()){
            unit.lookAt(shooter.aimX, shooter.aimY);
        }
        if(shooter!=null && shooter.isShooting()){
            shoot = true;
        }

        unit.controlWeapons(shoot);
    }
}
