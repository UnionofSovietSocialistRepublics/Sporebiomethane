package jp.content;

import arc.math.*;
import arc.math.geom.*;
import arc.util.*;
import mindustry.*;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.core.*;
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
// Observed AI Behavior: wack
public class JPSentientFly extends AIController{
    final static Rand rand = new Rand();
    final static BlockFlag[] randomTargets = {core, storage, generator, launchPad, factory, repair, battery, reactor, drill};

    @Override
    public void updateMovement(){
        unloadPayloads();
        Building core = unit.closestEnemyCore();

        if(target == null && state.rules.waves && unit.team == state.rules.defaultTeam){
            moveTo(getClosestSpawner(), state.rules.dropZoneRadius + 130f);
        }
        seekClosestTarget(core);
        seekToEngage();
        faceTarget();
        faceMovement();
    }

    void seekClosestTarget(Building core) {
        if (core == null || !core.isValid()) {
            return;
        }

        if (unit.within(core, unit.range())) {
            engage(core);
        } else {
                Building alt = null;
                int range = 200;
                int maxRange = 5000;

                while(alt == null && range <= maxRange){
                    alt = Vars.indexer.findEnemyTile(
                        unit.team,
                        unit.x,
                        unit.y,
                        range,
                        b -> b.team != unit.team
                    );
                    range += 200;
                }

                if(alt != null){
                    moveTo(alt, 10f);
                }
                
            }
        }

    void seekToEngage() {
        Unit enemy = Units.closestEnemy(unit.team, unit.x, unit.y, unit.range(), u -> true);
        Building block = Vars.indexer.findEnemyTile(unit.team, unit.x, unit.y, unit.range(), b -> b.block != null);

        if (enemy != null && enemy.isValid() && unit.within(enemy, unit.range())) {
            engage(enemy);
        } else if (block != null && block.isValid() && unit.within(block, unit.range())) {
            engage(block);
        }
    }

    void engage(Unit u) {
        if (u == null || !u.isValid()) return;
        for (var mount : unit.mounts) {
            if(u.type.flying){
                if (mount.weapon.controllable && mount.weapon.bullet != null && mount.weapon.bullet.collidesAir) {
                    if(unit.type.faceTarget) unit.lookAt(u);
                    mount.target = u;
                }
            } else {
                if (mount.weapon.controllable && mount.weapon.bullet != null && mount.weapon.bullet.collidesGround) {
                    if(unit.type.faceTarget) unit.lookAt(u);
                    mount.target = u;
                }
            }
        }
    }

    void engage(Building b) {
        if (b == null || !b.isValid()) return;
        for (var mount : unit.mounts) {
            if (mount.weapon.controllable && mount.weapon.bullet != null && mount.weapon.bullet.collidesGround) {
                if(unit.type.faceTarget) unit.lookAt(b);
                mount.target = b;
            }
        }
    }

}