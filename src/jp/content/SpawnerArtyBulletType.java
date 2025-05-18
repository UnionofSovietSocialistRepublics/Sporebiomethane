package jp.content;

import mindustry.entities.bullet.*;
import mindustry.game.Team;
import mindustry.gen.Bullet;
import arc.util.*;
import mindustry.content.*;
import mindustry.gen.*;


//Mechanic: Spawn 2 roach if target unit hp < 10% of target unit max hp (and insta-kill the targeted unit).
public class SpawnerArtyBulletType extends BasicBulletType {

    public SpawnerArtyBulletType(float speed, float damage){
        super(speed, damage);
    }

    @Override
    public void hitEntity(Bullet b, Hitboxc other, float initialHealth){
        if(other instanceof Unit unit){
            Tmp.v3.set(unit).sub(b.x, b.y).nor().scl(knockback * 80f);
            unit.impulse(Tmp.v3);
            if(unit.hasEffect(StatusEffects.boss)) return;
            unit.apply(JPStatus.dissolving, 120f);
            Infest(b, unit);
        }
    }

    public void Infest(Bullet b, Unit u){
        var unit = JPUnits.Roach.create(Team.sharded);
        u.health = 69f;
        unit.set(u.x, u.y);
        unit.add();
        unit.add();
        u.kill();

    }

}
