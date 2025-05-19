package jp.content;

import arc.math.*;
import arc.util.*;
import mindustry.ai.types.*;
import mindustry.entities.Units;
import mindustry.entities.units.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;
import static mindustry.world.meta.BlockFlag.*;

public class JPSeekerAI extends FlyingAI {
    final static Rand rand = new Rand();
    final static BlockFlag[] randomTargets = {core, storage, generator, launchPad, factory, repair, battery, reactor, drill};
    protected @Nullable Teamc Followedtarget;
    protected @Nullable Teamc ClosestBuilding;

    @Override
    public void updateMovement(){
        unloadPayloads();

        if(Followedtarget != null && unit.hasWeapons()){
            if(unit.type.circleTarget) {
                circleAttack(120f);
            }else if (Followedtarget != null){
                moveTo(Followedtarget, unit.type.range * 0.8f);
                unit.lookAt(Followedtarget);
            }else if (target != null){
                moveTo(target, unit.type.range * 0.8f);
                unit.lookAt(target);
            }
        }

        if(target == null && state.rules.waves && unit.team == state.rules.defaultTeam){
            moveTo(getClosestSpawner(), state.rules.dropZoneRadius + 130f);
        }
        if(timer.get(timerTarget3, 30f)){
            Followedtarget = Units.closestTarget(unit.team, unit.x, unit.y, Math.max(unit.type.range, 600f), u -> !u.isFlying());
        }
    }


    @Override
    public Teamc findTarget(float x, float y, float range, boolean air, boolean ground){
        var result = findMainTarget(x, y, range, air, ground);

        //if the main target is in range, use it, otherwise target whatever is closest
        return checkTarget(result, x, y, range) ? target(x, y, range, air, ground) : result;
    }

//    @Override
//    public Teamc findMainTarget(float x, float y, float range, boolean air, boolean ground){
//        var core = targetFlag(x, y, BlockFlag.core, true);
//
//        if(core != null && Mathf.within(x, y, core.getX(), core.getY(), range)){
//            return core;
//        }
//
//        if(state.rules.randomWaveAI){
//            //when there are no waves, it's just random based on the unit
//            rand.setSeed(unit.type.id + (state.rules.waves ? state.wave : unit.id));
//            //try a few random flags first
//            for(int attempt = 0; attempt < 5; attempt++){
//                Teamc result = targetFlag(x, y, randomTargets[rand.random(randomTargets.length - 1)], true);
//                if(result != null) return result;
//            }
//            //try the closest target
//            Teamc result = target(x, y, range, air, ground);
//            if(result != null) return result;
//        }else{
//            for(var flag : unit.type.targetFlags){
//                if(flag == null){
//                    Teamc result = target(x, y, range, air, ground);
//                    if(result != null) return result;
//                }else if(ground){
//                    Teamc result = targetFlag(x, y, flag, true);
//                    if(result != null) return result;
//                }
//            }
//        }

}