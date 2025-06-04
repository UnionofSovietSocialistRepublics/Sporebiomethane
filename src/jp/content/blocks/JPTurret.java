package jp.content.blocks;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.draw.*;
//import jp.content.jpAC;
import jp.content.*;
import mindustry.content.Fx;
import mindustry.content.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static mindustry.content.Liquids.*;
import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;

public class JPTurret{
    public static Block
    Impalercannon,Flakaccelerator,Artilleryturret,Oarch,Sporegarrison,Mitocannon,Suppressor,Sentinel;

        public static void load(){

        Sporegarrison = new PowerTurret("Sporegarrison"){{
            requirements(Category.turret, with(graphite, 125, silicon, 95, JPItem.Biomass, 75));
            health = 720;
            size = 2;
            rotateSpeed = 10f;
            range = 200f;
            reload = 60f;
            recoil = 2f;
            shootCone = 2f;
            ammoUseEffect = Fx.casing1;
            inaccuracy = 2f;
            shootType = new BasicBulletType(4f, 35f){{
                height = width = 15f;;
                lifetime = 20f;
                status = StatusEffects.electrified;
                statusDuration = 60f * 3;
                ammoMultiplier = 1f;
                buildingDamageMultiplier = 0.25f;
                lightningColor = Color.valueOf("bf92f9");
                backColor = Color.valueOf("bf92f9");
                frontColor = Color.valueOf("bf92f9");
                despawnEffect = Fx.hitBulletColor;
                intervalBullet = new LightningBulletType(){{
                    damage = 8;
                    collidesAir = false;
                    ammoMultiplier = 1f;
                    lightningColor = Color.valueOf("bf92f9");
                    lightningLength = 3;
                    lightningLengthRand = 6;
                    buildingDamageMultiplier = 0.25f;

                    lightningType = new BulletType(0.0001f, 0f){{
                        lifetime = Fx.lightning.lifetime;
                        hitEffect = Fx.hitLancer;
                        despawnEffect = Fx.none;
                        hittable = false;
                        lightColor = Color.white;
                        buildingDamageMultiplier = 0.25f;
                        }};
                }};
                fragBullets = 1;
                fragRandomSpread = fragAngle = 0;
                fragVelocityMin = fragLifeMin = 0.8f;
                fragBullet = new BasicBulletType(4f, 35f){{
                    height = width = 15f;;
                    lifetime = 20f;
                    status = StatusEffects.electrified;
                    statusDuration = 60f * 3;
                    ammoMultiplier = 1f;
                    buildingDamageMultiplier = 0.25f;
                    lightningColor = Color.valueOf("bf92f9");
                    backColor = Color.valueOf("bf92f9");
                    frontColor = Color.valueOf("bf92f9");
                    despawnEffect = Fx.hitBulletColor;
                    intervalBullet = new LightningBulletType(){{
                        damage = 8;
                        collidesAir = false;
                        ammoMultiplier = 1f;
                        lightningColor = Color.valueOf("bf92f9");
                        lightningLength = 3;
                        lightningLengthRand = 6;
                        buildingDamageMultiplier = 0.25f;

                        lightningType = new BulletType(0.0001f, 0f){{
                            lifetime = Fx.lightning.lifetime;
                            hitEffect = Fx.hitLancer;
                            despawnEffect = Fx.none;
                            hittable = false;
                            lightColor = Color.white;
                            buildingDamageMultiplier = 0.25f;
                        }};
                    }};
                    fragBullets = 1;
                    fragRandomSpread = fragAngle = 0;
                    fragVelocityMin = fragLifeMin = 0.8f;
                    fragBullet = new BasicBulletType(4f, 35f){{
                        height = width = 15f;;
                        lifetime = 20f;
                        lightning = 2;
                        lightningLength = 7;
                        status = StatusEffects.electrified;
                        statusDuration = 60f * 3;
                        ammoMultiplier = 1f;
                        buildingDamageMultiplier = 0.25f;
                        lightningColor = Color.valueOf("bf92f9");
                        backColor = Color.valueOf("bf92f9");
                        frontColor = Color.valueOf("bf92f9");
                        despawnEffect = Fx.hitBulletColor;
//                        intervalBullet = new LightningBulletType(){{
//                            damage = 8;
//                            collidesAir = false;
//                            ammoMultiplier = 1f;
//                            lightningColor = Color.valueOf("bf92f9");
//                            lightningLength = 3;
//                            lightningLengthRand = 6;
//                            buildingDamageMultiplier = 0.25f;
//
//                            lightningType = new BulletType(0.0001f, 0f){{
//                                lifetime = Fx.lightning.lifetime;
//                                hitEffect = Fx.hitLancer;
//                                despawnEffect = Fx.none;
//                                hittable = false;
//                                lightColor = Color.white;
//                                buildingDamageMultiplier = 0.25f;
//                            }};
//                        }};

                    }};
                }};
                }};
            coolant = consumeCoolant(0.2f);
            consumePower(4f);
            drawer = new DrawTurret(){{
                parts.add(new RegionPart("-barrel"){{
                    progress = PartProgress.recoil;
                    under = true;
                    moveY = -1.5f;
                }});
            }};
            outlineColor = Color.valueOf("19171b");
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
            shootY = -2.5f;
            ammo(
                sporePod, new BasicBulletType(5f, 15f){{
                    lifetime = 50f;
                    reloadMultiplier = 0.5f;
                    splashDamage = 5f;
                    splashDamageRadius = 45f;
                    knockback = 1.5f;
                    height = width = 15f;
                    status = StatusEffects.sporeSlowed;
                    statusDuration = 60f * 14;
                    backColor = Color.valueOf("7457ce");
                    frontColor = Color.white;
//                    lightColor = Color.valueOf("7457ce");
                    collidesGround = true;
                    collidesAir = true;
                }},
                JPItem.Biomass, new BasicBulletType(5f, 25f){{
                    height = width = 10f;
                    lifetime = 50f;
                    splashDamage = 25f;
                    splashDamageRadius = 30f;
                    fragBullets = 7;
                    status = StatusEffects.slow;
                    statusDuration = 60f * 5;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.white;
//                    lightColor = Color.valueOf("8B73C7");
                    ammoMultiplier = 1f;
                    collidesGround = true;
                    collidesAir = true;
                    fragBullet = new BasicBulletType(2.5f, 5){{
                        width = height = 5f;
                        lifetime = 20f;
                        status = StatusEffects.slow;
                        statusDuration = 60f * 7;
                        backColor = Color.valueOf("8B73C7");
                        frontColor = Color.white;
//                        lightColor = Color.valueOf("8B73C7");
                        despawnEffect = Fx.none;
                        collidesGround = true;
                        collidesAir = true;
                    }};
                }},
                JPItem.VCA, new BasicBulletType(5f, 95f){{
                    reloadMultiplier = 0.5f;
                    height = width = 10f;
                    lifetime = 50f;
                    status = JPStatus.stunned;
                    statusDuration = 60f * 2f;
                    backColor = Color.valueOf("303a45");
//                    frontColor = Color.valueOf("303a45");
//                    lightColor = Color.valueOf("303a45");
                    ammoMultiplier = 1f;
                    collidesGround = true;
                    collidesAir = true;
                }});

            shootSound = JPSounds.Arty;
            coolant = consumeCoolant(0.15f);
            outlineColor = Color.valueOf("19171b");
        }};
        
        Mitocannon = new PowerTurret("Mitocannon"){{
            requirements(Category.turret, with(graphite, 300, JPItem.Neocells, 240, JPItem.Nanitealloy, 150));
            health = 1500;
            size = 2;
            rotateSpeed = 10f;
            range = 225f;
            liquidCapacity = 200F;
            reload = 60f;
            recoil = 2f;
            shootCone = 2f;
            ammoUseEffect = Fx.casing1;
            hasPower = true;
            inaccuracy = 2f;
            shootType = new BasicBulletType(7f, 215f){{
                height = 10f;
                width = 5f;
                lifetime = 30f;
                status = StatusEffects.wet;
                statusDuration = 60f * 3;
                pierceBuilding = true;
                pierceArmor = true;
                backColor = Color.valueOf("bf92f9");
                frontColor = Color.valueOf("bf92f9");
                ammoMultiplier = 1f;
                buildingDamageMultiplier = 0.25f;
                intervalBullet = new LightningBulletType(){{
                    damage = 32;
                    collidesAir = false;
                    ammoMultiplier = 1f;
                    lightningColor = Color.valueOf("bf92f9");
                    lightningLength = 3;
                    lightningLengthRand = 6;
                    buildingDamageMultiplier = 0.25f;

                    lightningType = new BulletType(0.0001f, 0f){{
                        lifetime = Fx.lightning.lifetime;
                        hitEffect = Fx.hitLancer;
                        despawnEffect = Fx.none;
                        hittable = false;
                        lightColor = Color.white;
                        buildingDamageMultiplier = 0.25f;
                    }};}};
                fragBullets = 1;
                fragRandomSpread = fragAngle = 0;
                fragVelocityMin = fragLifeMin = 0.8f;
                fragBullet = new EmpBulletType(){{
                    float rad = splashDamageRadius = 40;
                    scaleLife = false;
                    lightOpacity = 0.7f;
                    healPercent = 0f;
                    timeIncrease = 0f;
                    lifetime = 1;
                    splashDamage = 70f;
                    status = StatusEffects.shocked;
                    hitEffect = new Effect(50f, 100f, e -> {
                        e.scaled(7f, b -> {
                            color(JPPal.sporeBullet, b.fout());
                            Fill.circle(e.x, e.y, rad);
                        });

                        color(JPPal.sporeBullet);
                        stroke(e.fout() * 3f);
                        Lines.circle(e.x, e.y, rad);

                        int points = 10;
                        float offset = Mathf.randomSeed(e.id, 360f);
                        for(int i = 0; i < points; i++){
                            float angle = i* 360f / points + offset;
                                Drawf.tri(e.x + Angles.trnsx(angle, rad), e.y + Angles.trnsy(angle, rad), 6f, 25f * e.fout(), angle/* + s*180f*/);
                        }

                        Fill.circle(e.x, e.y, 12f * e.fout());
                        color();
                        Fill.circle(e.x, e.y, 6f * e.fout());
                        Drawf.light(e.x, e.y, rad * 1.6f, JPPal.sporeBullet, e.fout());
                    });

                }};
            }};
            shootSound = Sounds.shootBig;
            consumeLiquid(water,0.225f);
            consumePower(7f);
            outlineColor = Color.valueOf("19171b");
        }};

        Sentinel = new ContinuousTurret("Sentinel"){{
            requirements(Category.turret, with(graphite, 200, JPItem.Nanitealloy, 75, JPItem.Neocells, 25));
            health = 975;
            size = 2;
            rotateSpeed = 1.25f;
            liquidCapacity = 200F;
            range = 175f;
            reload = 60f;
            recoil = 1f;
            shootCone = 10f;
            minWarmup = 0.94f;
            shootWarmupSpeed = 0.05f;
            shootY = 1.5f;
            ammoUseEffect = Fx.casing1;
            shootType = new PointLaserBulletType(){{
	            collidesTeam = true;
	            damage = 100;
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
                parts.add(new RegionPart("-bottom"){
                });

        }};
        shootSound = Sounds.none;
        loopSoundVolume = 1f;
        loopSound = Sounds.minebeam;
        consumeLiquid(water, 45f / 60f);
        consumePower(10f);
        outlineColor = Color.valueOf("19171b");
        }};

        Flakaccelerator = new ItemTurret("Flakaccelerator"){{
            requirements(Category.turret, with(graphite, 125, silicon, 100, JPItem.Biomass, 75));
            health = 1250;
            size = 3;
            rotateSpeed = 10f;
            range = 220f;
            reload = 15f;
            recoil = 2f;
            shootCone = 2f;
            shootY = 3f;
            recoils = 2;
            ammoUseEffect = Fx.casing1;
            targetGround = false;
            inaccuracy = 2f;
            shoot = new ShootAlternate(){{
                barrels = 2;
                spread = 0f;
            }};
            ammo(
                sporePod, new FlakBulletType(5f, 450f){{
                    lifetime = 45f;
                    reloadMultiplier = 0.5f;
                    recoils = 2;
                    backColor = Color.valueOf("7457ce");
                    frontColor = Color.valueOf("7457ce");
                    lightColor = Color.valueOf("7457ce");
                }},
               JPItem.Biomass, new FlakBulletType(5f, 25f){{
                    lifetime = 45f;
                    fragBullets = 6;
                    splashDamage = 50f;
                    splashDamageRadius = 35f;
                    recoils = 2;
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
                parts.add(new RegionPart("-canl"){{
                    progress = PartProgress.recoil;
                    recoilIndex = 0;
                    mirror = true;
                    under = true;
                    moveX = -4f;
                    moveRot = 20f;
                }});
                parts.add(new RegionPart("-cans"){{
                    progress = PartProgress.recoil;
                    recoilIndex = 1;
                    mirror = true;
                    under = true;
                    moveX = -4f;
                    moveRot = 20f;
                }});
                outlineColor = Color.valueOf("19171b");
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
            shootY = -2.5f;
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
//                    frontColor = Color.valueOf("8B73C7");
//                    lightColor = Color.valueOf("8B73C7");
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
            outlineColor = Color.valueOf("19171b");
        }};

        Suppressor = new ItemTurret("Suppressor"){{
            requirements(Category.turret, with(graphite, 225, JPItem.Nanitealloy, 75, JPItem.Biomass, 95));
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
//                    frontColor = Color.valueOf("7457ce");
//                    lightColor = Color.valueOf("7457ce");
                    width = height = 15f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    collidesGround = true;
                    despawnEffect = Fx.blastExplosion;
                    fragBullets = 6;
                    recoils = 2;
                    fragBullet = new BasicBulletType(4f, 5f){{
                        width = height = 10f;
                        splashDamage = 5f;
                        splashDamageRadius = 40f;
                        backColor = Color.valueOf("7457ce");
//                        frontColor = Color.valueOf("7457ce");
//                        lightColor = Color.valueOf("7457ce");
                        lifetime = 30f;
                        collidesGround = true;
                        collidesAir = true;
                        fragBullets = 6;
                        fragBullet = new BasicBulletType(3f, 2.5f){{
                            width = height = 5f;
                            splashDamage = 2.5f;
                            splashDamageRadius = 40f;
                            backColor = Color.valueOf("7457ce");
//                            frontColor = Color.valueOf("7457ce");
//                            lightColor = Color.valueOf("7457ce");
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
//                    frontColor = Color.valueOf("8B73C7");
//                    lightColor = Color.valueOf("8B73C7");
                    ammoMultiplier = 1f;
                    width = height = 15f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    collidesGround = true;
                }});
                coolantMultiplier = 0.75f;
                coolant = consumeCoolant(0.5f);
            drawer = new DrawTurret(){{
                parts.add(new RegionPart("-barrel-l"){{
                    progress = PartProgress.recoil;
                    heatProgress = PartProgress.recoil;
                    recoilIndex = 0;
                    moveY = -2f;
                    under = true;
                }});
                parts.add(new RegionPart("-barrel-r"){{
                    progress = PartProgress.recoil;
                    heatProgress = PartProgress.recoil;
                    recoilIndex = 1;
                    moveY = -2f;
                    under = true;
                }});
                outlineColor = Color.valueOf("19171b");
            }};
        }};

        Impalercannon= new ItemTurret("Impalercannon"){{
            requirements(Category.turret, with(surgeAlloy, 750, JPItem.Nanitealloy, 500,thorium, 500,silicon, 450));
            health = 4250;
            size = 4;
            range = 325f;
            rotateSpeed = 2f;
            reload = 160f;
            recoil = 4f;
            shake = 4f;
            shootCone = 2f;
            maxAmmo = 60;
            shootY = 3f;
            ammoPerShot = 5;
            ammoUseEffect = Fx.casing1;
            inaccuracy = 2f;
            ammo(
                JPItem.Biomass, new PointBulletType(){{
                    speed = 500f;
                    damage = 2000f;
                    buildingDamageMultiplier = 0.25f;
                    shootEffect = JPFx.fsinsShoot;
                    hitEffect = JPFx.fsinsHit;
                    smokeEffect = Fx.smokeCloud;
                    trailEffect = JPFx.fsinsTrail;
                    despawnEffect =  JPFx.fsinsBomb;
                    trailLength = 20;
                    trailColor = Color.valueOf("8B73C7");
                    ammoMultiplier = 1f;
                    pierceArmor = true;
                    hitShake = 6f;
            }},
                JPItem.VCA, new PointBulletType(){{
                    speed = 500f;
                    damage = 8000f;
                    reloadMultiplier = 0.5f;
                    buildingDamageMultiplier = 0.25f;
                    shootEffect = JPFx.fsinsShoot;
                    hitEffect = JPFx.fsinsHit;
                    smokeEffect = Fx.smokeCloud;
                    trailEffect = JPFx.fsinsTrail;
                    despawnEffect =  JPFx.fsinsBomb;
                    trailLength = 20;
                    trailColor = Color.valueOf("303a45");
                    ammoMultiplier = 2f;
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
            outlineColor = Color.valueOf("19171b");
        }};
}};