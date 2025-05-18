package jp.content;

import arc.math.Mathf;
import mindustry.entities.bullet.*;
import mindustry.gen.Bullet;
import arc.util.*;
import mindustry.gen.*;


//Mechanic: Spawn 2 roach if target unit hp < 25% of target unit max hp (and insta-kill the targeted unit).
public class InfestationBulletType extends BasicBulletType {

    public InfestationBulletType(float speed, float damage){
        super(speed, damage);
    }

    @Override
    public void hitEntity(Bullet b, Hitboxc other, float initialHealth){
        if(other instanceof Unit unit){
            Tmp.v3.set(unit).sub(b.x, b.y).nor().scl(knockback * 80f);
            unit.impulse(Tmp.v3);
            //Unit that cannot be infested
            if (unit.type == JPUnits.Roach || unit.type == JPUnits.Frost || unit.type == JPUnits.FrostC) return;
            //health check
            if( (unit.health <= (unit.maxHealth*0.25)) || (unit.health <= 100f) ){
                Infest(b, unit);
            }
        }
    }

    public void Infest(Bullet b, Unit u){
        //Lobber is placeholder, might or might not add roachling later.
        var maxSpawn = (2 + Math.round(u.maxHealth/30000f * 3f * 10f));
        for (int i = 0; i < maxSpawn; i++) {
            var unit = JPUnits.Lobber.create(b.team);
            unit.set(u.x, u.y);
            unit.add();
        }
        u.kill();

    }

}
