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
            health = 3000;
            size = 4;
            range = 325f;
            rotateSpeed = 2f;
            reload = 160f;
            recoil = 4f;
            shake = 4f;
            shootCone = 2f;
            maxAmmo = 60;
            ammoPerShot = 5;
            ammoUseEffect = Fx.casing1;
            inaccuracy = 2f;
            ammo(
               JPItem.Biomass, new PointBulletType(){{
                    shootEffect = JPFx.fsinsShoot;
                    hitEffect = JPFx.fsinsHit;
                    smokeEffect = Fx.smokeCloud;
                    trailEffect = JPFx.fsinsTrail;
                    despawnEffect =  JPFx.fsinsBomb;
                    trailLength = 20;
                    trailColor = Color.valueOf("8B73C7");
                    damage = 2000f;
                    buildingDamageMultiplier = 0.25f;
                    speed = 500f;
                    ammoMultiplier = 1.5f;
                    pierceArmor = true;
                    hitShake = 6f;
            }});
            rotateSpeed = 2.5f;
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
            rotateSpeed = 10f;
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

            ammo(
                sporePod, new FlakBulletType(5f, 450f){{
                    lifetime = 65f;
                    reloadMultiplier = 0.5f;
                    backColor = Color.valueOf("7457ce");
                    frontColor = Color.valueOf("7457ce");
                    lightColor = Color.valueOf("7457ce");
                }},
               JPItem.Biomass, new FlakBulletType(5f, 25f){{
                    lifetime = 65f;
                    fragBullets = 6;
                    splashDamage = 50f;
                    splashDamageRadius = 35f;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    ammoMultiplier = 1f;
                    fragBullet = new BasicBulletType(3f, 5){{
                        damage = 15f;
                        splashDamage = 25f;
                        splashDamageRadius = 15f;
                        width = 5f;
                        height = 5f;
                        backColor = Color.valueOf("8B73C7");
                        frontColor = Color.valueOf("8B73C7");
                        lightColor = Color.valueOf("8B73C7");
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
            rotateSpeed = 10f;
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
            ammo(
                sporePod, new BasicBulletType(){{
                    lifetime = 45f;
                    damage = 100f;
                    speed = 8f;
                    backColor = Color.valueOf("7457ce");
                    frontColor = Color.valueOf("7457ce");
                    lightColor = Color.valueOf("7457ce");
                    width = height = 15f;
                    ammoMultiplier = 4f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    collidesGround = true;
                }},
               JPItem.Biomass, new BasicBulletType(){{
                    lifetime = 75f;
                    damage = 225f;
                    speed = 4f;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    ammoMultiplier = 1f;
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
            rotateSpeed = 10f;
            range = 250f;
            reload = 40f;
            recoil = 2f;
            shootCone = 2f;
            ammoUseEffect = Fx.casing1;
            health = 750;
            inaccuracy = 2f;
            ammo(
                sporePod, new BasicBulletType(5f, 15f, "-bullet"){{
                    lifetime = 50f;
                    reloadMultiplier = 0.5f;
                    splashDamage = 5f;
                    splashDamageRadius = 45f;
                    knockback = 1.5f;
                    height = width = 15f;
                    status = StatusEffects.sporeSlowed;
                    statusDuration = 60f * 14;
                    backColor = Color.valueOf("7457ce");
                    frontColor = Color.valueOf("7457ce");
                    lightColor = Color.valueOf("7457ce");
                    collidesGround = true;
                    collidesAir = true;
                }},
               JPItem.Biomass, new BasicBulletType(5f, 25f, "Oarch-bullet"){{
                    height = width = 10f;
                    lifetime = 50f;
                    splashDamage = 25f;
                    splashDamageRadius = 30f;
                    fragBullets = 7;
                    status = StatusEffects.slow;
                    statusDuration = 60f * 5;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    ammoMultiplier = 1f;
                    collidesGround = true;
                    collidesAir = true;
                    fragBullet = new BasicBulletType(2.5f, 5){{
                        width = height = 5f;
                        lifetime = 20f;
                        status = StatusEffects.slow;
                        statusDuration = 60f * 7;
                        backColor = Color.valueOf("8B73C7");
                        frontColor = Color.valueOf("8B73C7");
                        lightColor = Color.valueOf("8B73C7");

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
            rotateSpeed = 10f;
            range = 225f;
            reload = 35f;
            recoil = 2f;
            shootCone = 2f;
            ammoUseEffect = Fx.casing1;
            inaccuracy = 2f;
            shootType = new BasicBulletType(5f, 40f){{
                    height = width = 15f;
                    lifetime = 45f;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    ammoMultiplier = 1f;
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
            rotateSpeed = 10f;
            range = 225f;
            liquidCapacity = 200F;
            reload = 25f;
            recoil = 2f;
            shootCone = 2f;
            ammoUseEffect = Fx.casing1;
            hasPower = true;
            inaccuracy = 2f;

               shootType = new BasicBulletType(5f, 150f){{
                    height = width = 15F;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.white;
                    lightColor = Color.valueOf("8B73C7");
                    fragBullets = 5;
                    ammoMultiplier = 1f;
                    fragBullet = new BasicBulletType(3f, 5){{
                       width = 5f;
                       height = 5f;
                       backColor = Color.valueOf("8B73C7");
                       frontColor = Color.white;
                       lightColor = Color.valueOf("8B73C7");
                       damage = 25f;
                       lifetime = 25f;
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
            health = 1850;
            size = 3;
            rotateSpeed = 10f;
            range = 200f;
            reload = 10f;
            recoil = 1f;
            shootCone = 10f;
            shoot = new ShootAlternate(){{
                barrels = 2;
            }};
            shootSound = Sounds.shootBig;
            ammoUseEffect = Fx.casing1;
            ammo(
               sporePod, new BasicBulletType(5f, 10f){{
                    lifetime = 45f;
                    splashDamage = 25f;
                    splashDamageRadius = 40f;
                    reloadMultiplier = 0.3f;
                    backColor = Color.valueOf("7457ce");
                    frontColor = Color.valueOf("7457ce");
                    lightColor = Color.valueOf("7457ce");
                    width = height = 15f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    collidesGround = true;
                    despawnEffect = Fx.blastExplosion;
                    fragBullets = 6;
                    fragBullet = new BasicBulletType(4f, 5f){{
                        width = height = 10f;
                        splashDamage = 5f;
                        splashDamageRadius = 40f;
                        backColor = Color.valueOf("7457ce");
                        frontColor = Color.valueOf("7457ce");
                        lightColor = Color.valueOf("7457ce");
                        lifetime = 30f;
                        collidesGround = true;
                        collidesAir = true;
                        fragBullets = 6;
                        fragBullet = new BasicBulletType(3f, 2.5f){{
                            width = height = 5f;
                            splashDamage = 2.5f;
                            splashDamageRadius = 40f;
                            backColor = Color.valueOf("7457ce");
                            frontColor = Color.valueOf("7457ce");
                            lightColor = Color.valueOf("7457ce");
                            lifetime = 20f;
                            despawnEffect = Fx.none;
                            collidesGround = false;
                        }};
                    }};
                }},
               JPItem.Biomass, new BasicBulletType(5f, 60f){{
                    lifetime = 45f;
                    splashDamage = 15f;
                    splashDamageRadius = 15f;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    ammoMultiplier = 1f;
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
                ammoMultiplier = 1f;
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