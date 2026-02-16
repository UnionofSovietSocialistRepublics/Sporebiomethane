package jp.content;

import arc.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.scene.ui.layout.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;

import static mindustry.Vars.*;


// An extremely lazy version of a spawner ability that can spawn either one of two unit
// Hopefully this should be a tempeorary solution, will make a flexible version later
public class UnitSpawnAbility extends Ability{
    public UnitType unit;
    public float spawnTime = 60f, spawnX, spawnY;
    public Effect spawnEffect = Fx.spawn;
    public boolean parentizeEffects;

    protected float timer;
    protected int rand;

    public UnitSpawnAbility(UnitType unit, UnitType altUnit, float spawnTime, float spawnX, float spawnY){
        this.unit = unit;
        this.altUnit = altUnit;
        this.spawnTime = spawnTime;
        this.spawnX = spawnX;
        this.spawnY = spawnY;
    }

    public UnitSpawnAbility(){
    }

    @Override
    public void addStats(Table t){
        super.addStats(t);
        t.add(abilityStat("buildtime", Strings.autoFixed(spawnTime / 60f, 2)));
        t.row();
        t.add((unit.hasEmoji() ? unit.emoji() : "") + "[stat]" + unit.localizedName);
    }

    @Override
    public void update(Unit unit){
        // Should randomize between zero and one
        float x;
        // Unit u;
        rand = (int)Math.random()*1;
        timer += Time.delta * state.rules.unitBuildSpeed(unit.team);

        if(timer >= spawnTime){
            if(Units.canCreate(unit.team, this.unit)&&rand==0){
                x = unit.x + Angles.trnsx(unit.rotation, spawnY, -spawnX), y = unit.y + Angles.trnsy(unit.rotation, spawnY, -spawnX);
                spawnEffect.at(x, y, 0f, parentizeEffects ? altUnit : null);
                u.rotation = unit.rotation;
                u.set(x, y);
                Events.fire(new UnitCreateEvent(u, null, unit));
                if(!Vars.net.client()){
                    u.add();
                    Units.notifyUnitSpawn(u);
                }

                timer = 0f;
            }
            else if(Units.canCreate(altUnit.team, this.altUnit)&&rand==1){
                x = altUnit.x + Angles.trnsx(altUnit.rotation, spawnY, -spawnX), y = altUnit.y + Angles.trnsy(altUnit.rotation, spawnY, -spawnX);
                spawnEffect.at(x, y, 0f, parentizeEffects ? altUnit : null);
                u.rotation = altUnit.rotation;
                u.set(x, y);
                Events.fire(new UnitCreateEvent(u, null, altUnit));
                if(!Vars.net.client()){
                    u.add();
                    Units.notifyUnitSpawn(u);
                }

                timer = 0f;
            }
        }
    }
// 
    @Override
    public void draw(Unit unit){
        if(Units.canCreate(unit.team, this.unit)){
            Draw.draw(Draw.z(), () -> {
                float x = unit.x + Angles.trnsx(unit.rotation, spawnY, -spawnX), y = unit.y + Angles.trnsy(unit.rotation, spawnY, -spawnX);
                Drawf.construct(x, y, this.unit.fullIcon, unit.rotation - 90, timer / spawnTime, 1f, timer);
            });
        }
    }

    @Override
    public String localized(){
        return Core.bundle.format("ability.unitspawn", unit.localizedName);
    }
}