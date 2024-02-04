package jp.content.blocks;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
//import jp.content.jpAC;
import jp.content.*;
import mindustry.content.Fx;
import mindustry.content.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;


public class JPTurret{
    public static Block
Impalercannon,Flakaccelerator;

        public static void load(){

        Impalercannon= new ItemTurret("Impalercannon"){{
            requirements(Category.turret, with(surgeAlloy, 750, JPItem.Nanitealloy, 500,thorium, 500,silicon, 450));
            recoil = 0.5f;
            size = 4;
            rotateSpeed = 2f;
            reload = 300f;
            recoil = 2f;
            shootCone = 2f;
            ammoPerShot = 5;
            ammoUseEffect = Fx.casing1;
            health = 250;
            inaccuracy = 2f;
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);
            researchCostMultiplier = 0.05f;

            ammo(
               JPItem.Biomass, new PointBulletType(){{
                    shootEffect = Fx.instShoot;
                    hitEffect = Fx.instHit;
                    smokeEffect = Fx.smokeCloud;
                    trailEffect = Fx.instTrail;
                    despawnEffect =  Fx.instBomb;
                    trailLength = 20;
                    trailColor = Color.valueOf("8B73C7");
                    damage = 2000f;
                    buildingDamageMultiplier = 0.25f;
                    speed = 500f;
                    ammoMultiplier = 1.5f;
                }});
            consumePower(7f);
            consumeLiquid(Liquids.neoplasm, 15f / 60f);
        }};
        Flakaccelerator = new ItemTurret("Flakaccelerator"){{
            requirements(Category.turret, with(surgeAlloy, 750, JPItem.Nanitealloy, 500,thorium, 500,silicon, 450));
            recoil = 0.5f;
            size = 4;
            rotateSpeed = 2f;
            reload = 300f;
            recoil = 2f;
            shootCone = 2f;
            ammoPerShot = 5;
            ammoUseEffect = Fx.casing1;
            health = 1500;
            shoot.shots = 2;
            shoot.shotDelay = 5f;
            inaccuracy = 2f;
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);
            researchCostMultiplier = 0.05f;

            ammo(
               JPItem.Biomass, new FlakBulletType(){{
                    damage = 25f;
                    speed = 5f;
                    fragBullets = 6;
                    fragBullet = new BasicBulletType(3f, 5){{
                        width = 5f;
                        height = 12f;
                        shrinkY = 1f;
                        damage = 5f;
                        lifetime = 20f;
                        backColor = Pal.gray;
                        frontColor = Color.white;
                        despawnEffect = Fx.none;
                        collidesGround = false;
                    }};
                }});
        }};


}};