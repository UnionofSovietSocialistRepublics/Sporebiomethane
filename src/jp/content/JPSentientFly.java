package jp.content;

import arc.math.*;
import arc.math.geom.*;
import arc.util.*;
import mindustry.*;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.entities.units.*;
import mindustry.gen.*;
import mindustry.world.meta.*;
import mindustry.async.*;
import mindustry.entities.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.payloads.*;


import static mindustry.Vars.*;
import static mindustry.world.meta.BlockFlag.*;
//FlyingAI Ripoff Attempt N.69210
// Observed AI Behavior: Do not mve
public class JPSentientFly extends AIController{
    final static Rand rand = new Rand();
    final static BlockFlag[] randomTargets = {core, storage, generator, launchPad, factory, repair, battery, reactor, drill};

    @Override
    public void updateMovement(){
        unloadPayloads();

        if(target != null && unit.hasWeapons()){
            if(unit.type.circleTarget){
                circleAttack(unit.type.circleTargetRadius);
            }else{
                moveTo(target, unit.type.range * 0.8f);
                unit.lookAt(target);
            }
        }

        if(target == null && state.rules.waves && unit.team == state.rules.defaultTeam){
            moveTo(getClosestSpawner(), state.rules.dropZoneRadius + 130f);
        }
    }

    @Override
    public Teamc findTarget(float x, float y, float range, boolean air, boolean ground){
//        var result = findMainTarget(x, y, range, air, ground);
        Teamc result = target(x, y, range, air, ground);
        //if the main target is in range, use it, otherwise target whatever is closest
        return checkTarget(result, x, y, range) ? target(x, y, range, air, ground) : result;
    }

    @Override
    public Teamc findMainTarget(float x, float y, float range, boolean air, boolean ground){
//        var mainTarget = targetFlag(x, y, BlockFlag.core, true);
        Teamc mainTarget = target(x, y, range, air, ground);

        if(mainTarget != null && Mathf.within(x, y, mainTarget.getX(), mainTarget.getY(), range)){
            return mainTarget;
        }

        if(state.rules.randomWaveAI){
            //when there are no waves, it's just random based on the unit
            rand.setSeed(unit.type.id + (state.rules.waves ? state.wave : unit.id));
            //try a few random flags first
            for(int attempt = 0; attempt < 5; attempt++){
                Teamc result = targetFlagActive(x, y, randomTargets[rand.random(randomTargets.length - 1)], true);
                if(result != null) return result;
            }
            //try the closest target
            Teamc result = target(x, y, range, air, ground);
            if(result != null) return result;
        }else{
            for(var flag : unit.type.targetFlags){
                if(flag == null){
                    Teamc result = target(x, y, range, air, ground);
                    if(result != null) return result;
                }else if(ground){
                    Teamc result = targetFlagActive(x, y, flag, true);
                    if(result != null) return result;
                }
            }
        }

        return mainTarget;
    }
}