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
            if (unit.type == JPUnits.roach || unit.type == JPUnits.Frost || unit.type == JPUnits.FrostC) return;
            //Health check when bullet hits
            // Condition is as follow: unit health smaller than 25% of max OR
            // unit health < 100 OR unit have infested status effect
            // Might oooor might or be overpowered due to how much health late game unit have
            if( (unit.health <= (unit.maxHealth*0.25)) || (unit.health <= 100f || (unit.getDuration(JPStatus.infested)) > 0) ){
                Infest(b, unit);
            }
            //  if unit health is smaller than 45% of its max health, apply status effect
            if((unit.health <= (unit.maxHealth*0.45))) {
                unit.apply(JPStatus.infested, 200f);
            }
        }
    }

    public void Infest(Bullet b, Unit u){
        //Lobber is placeholder, might or might not add roachling later.
        // The math is uhhhh 2 lobber + round(unitmaxhp/30000*3*10)
        var maxSpawn = (2 + Math.round(u.maxHealth/30000f * 3f * 10f));
        for (int i = 0; i < maxSpawn; i++) {
            // create a unit lobber on team of the bullet (should be fairly obvious)
            var unit = JPUnits.Lobber.create(b.team);
            // on x and y position of the unit that got hit by the bullet.
            unit.set(u.x, u.y);
            // actually spawning the unit
            unit.add();
        }
        // Might be more balanced if stronger unit don't get insta kill'd
        u.kill();

    }

}
