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
    Impalercannon,Flakaccelerator,Artilleryturret,Oarch,Sporegarrison,Mitocannon,Suppressor,Sentinel;

        public static void load(){

        Impalercannon= new ItemTurret("Impalercannon"){{
            requirements(Category.turret, with(surgeAlloy, 750, JPItem.Nanitealloy, 500,thorium, 500,silicon, 450));
            health = 3600;
            size = 4;
            range = 300f;
            rotateSpeed = 2f;
            reload = 160f;
            recoil = 2f;
            shootCone = 2f;
            ammoPerShot = 5;
            ammoUseEffect = Fx.casing1;
            inaccuracy = 2f;
            rotateSpeed = 10f;
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
                    pierceArmor = true;
                }});
            coolantMultiplier = 0.2f;
            coolant = consumeCoolant(2f);
            consumePower(7f);
            unitSort = UnitSorts.strongest;
            ammoUseEffect = Fx.casing3Double;
            shootSound = Sounds.railgun;
        }};
        Flakaccelerator = new ItemTurret("Flakaccelerator"){{
            requirements(Category.turret, with(graphite, 125, silicon, 100, JPItem.Biomass, 75));
            health = 1000;
            size = 3;
            rotateSpeed = 2f;
            range = 250f;
            reload = 35f;
            recoil = 2f;
            shootCone = 2f;
            shootY = 2;
            ammoUseEffect = Fx.casing1;
            targetGround = false;
            shoot.shots = 2;
            shoot.shotDelay = 10f;
            inaccuracy = 2f;
            rotateSpeed = 10f;

            ammo(
                sporePod, new FlakBulletType(){{
                    lifetime = 40f;
                    damage = 50f;
                    speed = 5f;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                }}
               JPItem.Biomass, new FlakBulletType(){{
                    lifetime = 40f;
                    damage = 30f;
                    speed = 5f;
                    fragBullets = 6;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    fragBullet = new BasicBulletType(3f, 5){{
                        width = 5f;
                        height = 5f;
                        backColor = Color.valueOf("8B73C7");
                        frontColor = Color.valueOf("8B73C7");
                        lightColor = Color.valueOf("8B73C7");
                        splashDamage = 15f;
                        splashDamageRadius = 15f;
                        damage = 15f;
                        lifetime = 20f;
                        backColor = Pal.gray;
                        frontColor = Color.white;
                        despawnEffect = Fx.none;
                        collidesGround = false;
                    }};
                }});
                coolant = consumeCoolant(0.1f);
                drawer = new DrawTurret(){{
                parts.add(new RegionPart("-canright"){{
                    progress = PartProgress.recoil;
                    under = true;
                    moveX = 4f;
                    moveRot = -20f;
                }});
                parts.add(new RegionPart("-canleft"){{
                    progress = PartProgress.recoil;
                    under = true;
                    moveX = -4f;
                    moveRot = 20f;
                }});
            }};
        }};
        Artilleryturret = new ItemTurret("Artilleryturret"){{
            requirements(Category.turret, with(graphite, 675, JPItem.Nanitealloy, 250, JPItem.Biomass, 150));
            size = 3;
            rotateSpeed = 2f;
            range = 260f;
            reload = 180f;
            recoil = 5f;
            shootCone = 10f;
            ammoPerShot = 3;
            ammoUseEffect = Fx.casing1;
            health = 1500;
            shoot.shots = 4;
            shoot.shotDelay = 10f;
            inaccuracy = 2f;
            rotateSpeed = 10f;
            ammo(
                sporePod, new FlakBulletType(){{
                    lifetime = 75f;
                    damage = 100f;
                    speed = 4f;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    width = height = 15f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    collidesGround = true;
                }}
               JPItem.Biomass, new BasicBulletType(){{
                    lifetime = 75f;
                    damage = 225f;
                    speed = 4f;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    width = height = 15f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    collidesGround = true;
                    despawnEffect = Fx.blastExplosion;
                    pierceArmor = true;
                }});
                shootSound = JPSounds.Arty;
                coolantMultiplier = 0.5f;
                coolant = consumeCoolant(0.5f);
        }};
        Oarch = new ItemTurret("Oarch"){{
            requirements(Category.turret, with(graphite, 200, silicon, 125, JPItem.Nanitealloy, 95));
            size = 2;
            rotateSpeed = 2f;
            range = 250f;
            reload = 40f;
            recoil = 2f;
            shootCone = 2f;
            ammoUseEffect = Fx.casing1;
            health = 750;
            inaccuracy = 2f;
            rotateSpeed = 10f;
            ammo(
                sporePod, new FlakBulletType(){{
                    lifetime = 50f;
                    damage = 25f;
                    splashDamage = 5f;
                    splashDamageRadius = 15f;
                    speed = 5f;
                    height = width = 15f;
                    fragBullets = 5;
                    statusDuration = 60f * 3;
                    status = StatusEffects.slow;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    collidesGround = true;
                    collidesAir = true;
                    fragBullet = new BasicBulletType(3f, 5){{
                        width = 5f;
                        height = 5f;
                        backColor = Color.valueOf("8B73C7");
                        frontColor = Color.valueOf("8B73C7");
                        lightColor = Color.valueOf("8B73C7");
                        damage = 5f;
                        lifetime = 20f;
                        backColor = Pal.gray;
                        frontColor = Color.white;
                        despawnEffect = Fx.none;
                        collidesGround = true;
                        collidesAir = true;
                    }};
                }}
               JPItem.Biomass, new FlakBulletType(){{
                    lifetime = 50f;
                    damage = 75f;
                    splashDamage = 25f;
                    splashDamageRadius = 15f;
                    speed = 5f;
                    height = width = 15f;
                    fragBullets = 7;
                    statusDuration = 60f * 5;
                    status = StatusEffects.slow;
                    //sprite = "ExplodingTNT";
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    collidesGround = true;
                    collidesAir = true;
                    fragBullet = new BasicBulletType(3f, 5){{
                        width = 5f;
                        height = 5f;
                        backColor = Color.valueOf("8B73C7");
                        frontColor = Color.valueOf("8B73C7");
                        lightColor = Color.valueOf("8B73C7");
                        damage = 5f;
                        lifetime = 20f;
                        backColor = Pal.gray;
                        frontColor = Color.white;
                        despawnEffect = Fx.none;
                        collidesGround = true;
                        collidesAir = true;
                    }};
                }});
                shootSound = JPSounds.Arty;
                coolant = consumeCoolant(0.15f);
        }};
        Sporegarrison = new PowerTurret("Sporegarrison"){{
            requirements(Category.turret, with(graphite, 125, silicon, 145, JPItem.Biomass, 95));
            health = 1000;
            size = 2;
            rotateSpeed = 2f;
            range = 225f;
            reload = 35f;
            recoil = 2f;
            shootCone = 2f;
            ammoUseEffect = Fx.casing1;
            inaccuracy = 2f;
            rotateSpeed = 10f;

               shootType = new BasicBulletType(){{
                    height = width = 15f;
                    damage = 40f;
                    speed = 5f;
                    lifetime = 45f;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                }};
                coolant = consumeCoolant(0.2f);
                consumePower(7f);
                drawer = new DrawTurret(){{
                parts.add(new RegionPart("-gun"){{
                    progress = PartProgress.recoil;
                    under = true;
                    moveY = -1.5f;
                }});
            }};
        }};
        Mitocannon = new PowerTurret("Mitocannon"){{
            requirements(Category.turret, with(graphite, 300, JPItem.Neocells, 240, JPItem.Nanitealloy, 150));
            health = 1500;
            size = 2;
            rotateSpeed = 2f;
            range = 225f;
            liquidCapacity = 200F;
            reload = 25f;
            recoil = 2f;
            shootCone = 2f;
            ammoUseEffect = Fx.casing1;
            hasPower = true;
            inaccuracy = 2f;
            rotateSpeed = 10f;

               shootType = new BasicBulletType(){{
                    height = width = 15F;
                    damage = 150f;
                    speed = 5f;
                    fragBullets = 6;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    fragBullet = new BasicBulletType(3f, 5){{
                        width = 5f;
                        height = 5f;
                        backColor = Color.valueOf("8B73C7");
                        frontColor = Color.valueOf("8B73C7");
                        lightColor = Color.valueOf("8B73C7");
                        damage = 25f;
                        lifetime = 25f;
                        backColor = Pal.gray;
                        frontColor = Color.white;
                        despawnEffect = Fx.none;
                        collidesGround = false;
                    }};
                }};
                shootSound = Sounds.shootBig;
                coolant = consumeCoolant(0.225f);
                consumePower(7f);
        }};
        Suppressor = new ItemTurret("Suppressor"){{
            requirements(Category.turret, with(graphite, 225, JPItem.Nanitealloy, 25, JPItem.Biomass, 45));
            health = 850;
            size = 3;
            rotateSpeed = 2f;
            range = 200f;
            reload = 10f;
            recoil = 1f;
            shootCone = 10f;
            shoot = new ShootAlternate(){{
                barrels = 2;
            }};
            shootSound = Sounds.shootBig;
            ammoUseEffect = Fx.casing1;
            rotateSpeed = 10f;

            ammo(
               JPItem.Biomass, new BasicBulletType(){{
                    
                    lifetime = 45f;
                    damage = 50f;
                    splashDamage = 15f;
                    splashDamageRadius = 7f;
                    speed = 5f;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    width = height = 15f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    collidesGround = true;
                }});
                coolantMultiplier = 0.75f;
                coolant = consumeCoolant(0.5f);
        }};
        Sentinel = new ContinuousTurret("Sentinel"){{
            requirements(Category.turret, with(graphite, 675, JPItem.Nanitealloy, 250, JPItem.Neocells, 150));
            health = 1500;
            size = 2;
            rotateSpeed = 1.5f;
            liquidCapacity = 200F;
            range = 225f;
            reload = 180f;
            recoil = 2f;
            shootCone = 10f;
            minWarmup = 0.94f;
            shootWarmupSpeed = 0.05f;
            shootY = -1f;
            ammoUseEffect = Fx.casing1;
            shootType = new PointLaserBulletType(){{
	            //sprite = "Sentinellaser";
	            collidesTeam = true;
	            damage = 115;
                hitColor = Color.valueOf("fda981");
                pierceArmor = true;
            }};
            drawer = new DrawTurret("-bottom"){{
                parts.add(new RegionPart("-prongs"){{
                    progress = PartProgress.warmup;
                    mirror = true;
                    moveX = 1.5f;
                    moveY = 1.25f;
                    moveRot = -10f;
            }});
                parts.add(new RegionPart("-bottom"){{
            }});

        }};
        shootSound = Sounds.none;
        loopSoundVolume = 1f;
        loopSound = Sounds.minebeam;
        consumeLiquid(Liquids.water, 15f / 60f);
        consumePower(7f);
        }};
}};