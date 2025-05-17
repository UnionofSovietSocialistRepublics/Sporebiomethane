package jp.content;

import mindustry.entities.bullet.*;
import mindustry.game.Team;
import mindustry.gen.Bullet;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.gen.*;

import static mindustry.game.Team.*;
import static mindustry.gen.Nulls.unit;

//Mechanic: Spawn 2 roach if target unit hp < 10% of target unit max hp (and insta-kill the targeted unit).
public class SpawnerArtyBulletType extends ArtilleryBulletType {

    public SpawnerArtyBulletType(float speed, float damage){
        super(speed, damage);
    }

    @Override
    public void hitEntity(Bullet b, Hitboxc other, float initialHealth){
        if(other instanceof Unit unit){
            Tmp.v3.set(unit).sub(b.x, b.y).nor().scl(knockback * 80f);
            unit.impulse(Tmp.v3);
            if(unit.hasEffect(StatusEffects.boss)) return;
            if(!Vars.net.client() && (unit.healthf() <= (unit.maxHealth*1))) Infest(b, unit);
        }
    }

    public void Infest(Bullet b, Unit u){
        for (int i = 0; i < 2; i++) {
            var unit = UnitTypes.gamma.create(b.team);
            unit.set(u.x, u.y);
            unit.add();
        }
        u.kill();

    }

}
