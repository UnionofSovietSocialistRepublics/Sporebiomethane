package jp.content;

import mindustry.content.Fx;
import mindustry.world.*;
import mindustry.entities.*;
import mindustry.entities.Units.*;
import mindustry.game.*;
import mindustry.gen.*;

import mindustry.world.blocks.defense.turrets.*;

import static mindustry.Vars.world;

public class JPDormantUnit extends PowerTurret {

    public JPDormantUnit(String name) {
        super(name);
        liquidCapacity = 20f;
        outlinedIcon = 1;
        drawLiquidLight = false;
        sync = true;
        rotate = true;
        quickRotate = false;
        drawArrow = false;
        ignoreLineRotation = true;
        rotateDrawEditor = false;
        visualRotationOffset = -90f;
        regionRotated1 = 1;
        regionRotated2 = 2;
    }
//  Son
//  Im crine
    public class JPDormantUnitBuild extends PowerTurretBuild {
//        Ts so fun
        @Override
        public void updateTile(){

            if(team == Team.derelict){
                Effect placeeffect = Fx.placeBlock;
                Units.nearby(null,x, y, range(), unit -> {
                    if(unit.team() != Team.derelict && !unit.dead()){
                        changeTeam(unit.team);
                        enabled = true;
                        if(power != null){
                            power.links.clear();
                            powerGraphRemoved();
                        }
                        checkAllowUpdate();
                        updateProximity();
                        onRepaired();
                        world.tileChanges ++;
                        placeEffect.at(tile.drawx(), tile.drawy(), size);
                    }
                });
            }

            super.updateTile();

        }
    }
}
