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
import mindustry.world.meta.*;
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
    impalerCannon,flakAccelerator,artilleryTurret,oarch,sporeGarrison,mitoCannon,suppressor,sentinel;

        public static void load(){

        sporeGarrison = new PowerTurret("sporeGarrison"){{
            requirements(Category.turret, with(graphite, 125, silicon, 95, JPItem.biomass, 75));
            envEnabled = Env.spores;
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
                width = 12f; height = 16f;
                lifetime = 20f;
                status = StatusEffects.electrified;
                statusDuration = 60f * 3;
                ammoMultiplier = 1f;
                buildingDamageMultiplier = 0.25f;
                lightningColor = Pal.accent;
                backColor = JPPal.sporeBulletBack;
                frontColor = JPPal.sporeBulletFront;
                despawnEffect = Fx.hitBulletColor;
                intervalBullet = new LightningBulletType(){{
                    damage = 8;
                    collidesAir = false;
                    ammoMultiplier = 1f;
                    lightningColor = Pal.accent;
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
                    width = 8f; height = 12f;
                    lifetime = 20f;
                    status = StatusEffects.electrified;
                    statusDuration = 60f * 3;
                    ammoMultiplier = 1f;
                    buildingDamageMultiplier = 0.25f;
                    lightningColor = Pal.accent;
                    backColor = JPPal.sporeBulletBack;
                    frontColor = JPPal.sporeBulletFront;
                    despawnEffect = Fx.hitBulletColor;
                    intervalBullet = new LightningBulletType(){{
                        damage = 8;
                        collidesAir = false;
                        ammoMultiplier = 1f;
                        lightningColor = Pal.accent;
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
                        width = 4f; height = 8f;
                        lifetime = 20f;
                        lightning = 2;
                        lightningLength = 7;
                        status = StatusEffects.electrified;
                        statusDuration = 60f * 3;
                        ammoMultiplier = 1f;
                        buildingDamageMultiplier = 0.25f;
                        lightningColor = JPPal.sporeBulletBack;
                        backColor = JPPal.sporeBulletBack;
                        frontColor = JPPal.sporeBulletFront;
                        despawnEffect = Fx.hitBulletColor;
//                        intervalBullet = new LightningBulletType(){{
//                            damage = 8;
//                            collidesAir = false;
//                            ammoMultiplier = 1f;
//                            lightningColor = Pal.accent;
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

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        oarch = new ItemTurret("oarch"){{
            requirements(Category.turret, with(graphite, 200, silicon, 125, JPItem.naniteAlloy, 95));
            envEnabled = Env.spores;
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
                    reloadMultiplier = 0.65f;
                    height = 15f;
                    width = 11f;
                    sprite = "jp-oarch-bullet";
                    lifetime = 50f;
                    splashDamage = 5f;
                    splashDamageRadius = 45f;
                    knockback = 1.5f;
                    status = StatusEffects.sporeSlowed;
                    statusDuration = 60f * 14;
                    // backColor = Color.valueOf("7457ce");
                    frontColor = Color.white;
                    lightOpacity = 0.3f;
                }},
                JPItem.biomass, new BasicBulletType(5f, 25f){{
                    height = 10f;
                    width = 6f;
                    sprite = "jp-oarch-bullet";
                    lifetime = 50f;
                    splashDamage = 25f;
                    splashDamageRadius = 30f;
                    fragBullets = 7;
                    status = StatusEffects.slow;
                    statusDuration = 60f * 5;
                    backColor = JPPal.sporeBulletBack;
                    frontColor = Color.white;
                    ammoMultiplier = 1f;
                    collidesGround = true;
                    collidesAir = true;
                    fragBullet = new BasicBulletType(2.5f, 5){{
                        width = height = 5f;
                        lifetime = 20f;
                        status = StatusEffects.slow;
                        statusDuration = 60f * 7;
                        backColor = JPPal.sporeBulletBack;
                        frontColor = Color.white;
                        despawnEffect = Fx.none;
                        lightOpacity = 0.3f;
                    }};
                }},
                JPItem.vanadiumCarbideAlloy, new BasicBulletType(5f, 95f){{
                    reloadMultiplier = 0.5f;
                    height = 10f;
                    width = 6f;
                    backSprite="jp-oarch-bullet-back";
                    sprite = "jp-oarch-bullet";
                    lifetime = 50f;
                    status = JPStatus.stunned;
                    statusDuration = 60f * 2f;
                    // backColor = Color.valueOf("303a45");
//                    frontColor = Color.valueOf("303a45");
//                    lightColor = Color.valueOf("303a45");
                    ammoMultiplier = 1f;
                    lightOpacity = 0.3f;
                }});

            shootSound = JPSounds.Arty;
            coolant = consumeCoolant(0.15f);
            outlineColor = Color.valueOf("19171b");

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};
        
        mitoCannon = new PowerTurret("mitoCannon"){{
            requirements(Category.turret, with(graphite, 300, JPItem.neocell, 240, JPItem.naniteAlloy, 150));
            envEnabled = Env.any;
            health = 1500;
            size = 2;
            rotateSpeed = 10f;
            range = 225f;
            liquidCapacity = 200F;
            reload = 115f;
            recoil = 2f;
            shootCone = 2f;
            ammoUseEffect = Fx.casing1;
            hasPower = true;
            inaccuracy = 2f;
            shootType = new BasicBulletType(7f, 75f){{
                height = 10f;
                width = 5f;
                lifetime = 30f;
                status = StatusEffects.wet;
                statusDuration = 60f * 3;
                pierceArmor = true;
                backColor = JPPal.sporeBulletBack;
                frontColor = JPPal.sporeBulletFront;
                ammoMultiplier = 1f;
                buildingDamageMultiplier = 0.25f;
                intervalBullet = new LightningBulletType(){{
                    damage = 32;
                    collidesAir = false;
                    ammoMultiplier = 1f;
                    lightningColor = Pal.accent;
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
                    splashDamage = 215f;
                    status = StatusEffects.shocked;
                    hitEffect = new Effect(50f, 100f, e -> {
                        e.scaled(7f, b -> {
                            color(JPPal.sporeBulletBack, b.fout());
                            Fill.circle(e.x, e.y, rad);
                        });

                        color(JPPal.sporeBulletBack);
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
                        Drawf.light(e.x, e.y, rad * 1.6f, JPPal.sporeBulletBack, e.fout());
                    });

                }};
            }};
            shootSound = Sounds.shootSalvo;
            consumeLiquid(water,0.225f);
            consumePower(7f);
            outlineColor = Color.valueOf("19171b");

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        sentinel = new ContinuousTurret("sentinel"){{
            requirements(Category.turret, with(graphite, 200, JPItem.naniteAlloy, 75, JPItem.neocell, 25));
            envEnabled = Env.spores;
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
                sprite = "jp-sentinel-laser";
                collidesTeam = true;
                damage = 100;
                status = StatusEffects.sapped;
                statusDuration = 60f * 3;
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
            loopSound = Sounds.loopMineBeam;
            consumeLiquid(water, 45f / 60f);
            consumePower(10f);
            outlineColor = Color.valueOf("19171b");

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        flakAccelerator = new ItemTurret("flakAccelerator"){{
            requirements(Category.turret, with(graphite, 125, silicon, 100, JPItem.biomass, 75));
            envEnabled = Env.spores;
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
//                sporePod, new FlakBulletType(7.5f, 225f){{
//                    lifetime = 25f;
//                    reloadMultiplier = 0.6f;
//                    recoils = 2;
//                    backColor = Color.valueOf("7457ce");
//                    frontColor = Color.valueOf("7457ce");
//                    lightColor = Color.valueOf("7457ce");
//                    fragBullets = 3;
//                    fragBullet = new BasicBulletType(3f, 2){{
//                        splashDamage = 5f;
//                        splashDamageRadius = 15f;
//                        width = 5f;
//                        height = 7f;
//                        backColor = JPPal.sporeBulletBack;
//                        frontColor = JPPal.sporeBulletFront;
//                        lightColor = Color.valueOf("8B73C7");
//                        lifetime = 20f;
//                        backColor = Pal.gray;
//                        frontColor = Color.white;
//                        despawnEffect = Fx.none;
//                        collidesGround = false;
//                    }};
//                }},
               JPItem.biomass, new FlakBulletType(5f, 25f){{
                    lifetime = 45f;
                    fragBullets = 6;
                    splashDamage = 50f;
                    splashDamageRadius = 35f;
                    recoils = 2;
                    backColor = JPPal.sporeBulletBack;
                    frontColor = JPPal.sporeBulletFront;
                    lightColor = JPPal.sporeBulletBack;
                    ammoMultiplier = 1f;
                    fragBullet = new BasicBulletType(3f, 15){{
                        splashDamage = 25f;
                        splashDamageRadius = 15f;
                        width = 5f;
                        height = 7f;
                        backColor = JPPal.sporeBulletBack;
                        frontColor = JPPal.sporeBulletFront;
                        lightColor =JPPal.sporeBulletBack;
                        lifetime = 20f;
                        backColor = Pal.gray;
                        frontColor = Color.white;
                        despawnEffect = Fx.none;
                        collidesGround = false;
                    }};
                }},
                JPItem.naniteAlloy, new FlakBulletType(5f, 25f){{
                    lifetime = 45f;
                    splashDamage = 50f;
                    splashDamageRadius = 35f;
                    recoils = 2;
                    backColor = JPPal.sporeBulletBack;
                    frontColor = JPPal.sporeBulletFront;
                    lightColor = Color.valueOf("8B73C7");
                    ammoMultiplier = 1f;
                    fragBullets = 12;
                    fragVelocityMin = fragVelocityMax = 1f;
                    fragLifeMax = 1f;
                    fragLifeMin = 0.6f;
                    fragBullet = new BasicBulletType(3f, 0){{
                        splashDamage = 25f;
                        splashDamageRadius = 15f;
                        width = 5f;
                        height = 7f;
                        weaveMag = 4f;
                        weaveScale = 55f;
                        backColor = JPPal.sporeBulletBack;
                        frontColor = JPPal.sporeBulletFront;
                        lightColor = Color.valueOf("8B73C7");
                        backColor = Pal.gray;
                        frontColor = Color.white;
                        despawnEffect = Fx.none;
                        fragBullets = 12;
                        fragVelocityMin = fragVelocityMax = 1f;
                        fragLifeMax = 1f;
                        fragLifeMin = 1f;
                        collidesGround = false;
                        fragBullet = new BasicBulletType(3f, 45){{
                            width = 5f;
                            height = 7f;
                            backColor = JPPal.sporeBulletBack;
                            frontColor = JPPal.sporeBulletFront;
                            lightColor = Color.valueOf("45368F");
                            lifetime = 20f;
                            backColor = Pal.gray;
                            frontColor = Color.white;
                            collidesGround = false;
                        }};
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

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        artilleryTurret = new ItemTurret("artilleryTurret"){{
            requirements(Category.turret, with(graphite, 675, JPItem.naniteAlloy, 250, JPItem.biomass, 150));
            envEnabled = Env.spores;
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
               JPItem.biomass, new BasicBulletType(){{
                lifetime = 75f;
                damage = 225f;
                speed = 4f;
                backColor = JPPal.sporeBulletBack;
                frontColor = JPPal.sporeBulletFront;
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

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        suppressor = new ItemTurret("suppressor"){{
            requirements(Category.turret, with(graphite, 225, JPItem.naniteAlloy, 75, JPItem.biomass, 95));
            envEnabled = Env.spores;
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
            shootSound = Sounds.shootSalvo;
            ammoUseEffect = Fx.casing1;
            ammo(
               sporePod, new BasicBulletType(5f, 10f){{
                    lifetime = 45f;
                    splashDamage = 25f;
                    splashDamageRadius = 40f;
                    reloadMultiplier = 0.5f;
                    backColor = Color.valueOf("7457ce");
                    frontColor = Color.valueOf("7457ce");
                    lightColor = Color.valueOf("7457ce");
                    height = 15f;
                    width = (height-2f);
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    collidesGround = true;
                    despawnEffect = Fx.blastExplosion;
                    fragBullets = 6;
                    recoils = 2;
                    fragBullet = new BasicBulletType(4f, 10f){{
                        height = 10f;
                        width = (height-3f);
                        splashDamage = 10f;
                        splashDamageRadius = 40f;
                        backColor = Color.valueOf("7457ce");
                        frontColor = Color.valueOf("7457ce");
                        lightColor = Color.valueOf("7457ce");
                        lifetime = 30f;
                        collidesGround = true;
                        collidesAir = true;
                        fragBullets = 6;
                        fragBullet = new BasicBulletType(3f, 5f){{
                            height = 6f;
                            width = (height-2f);
                            splashDamage = 5f;
                            splashDamageRadius = 40f;
                            backColor = Color.valueOf("7457ce");
                            frontColor = Color.valueOf("7457ce");
                            lifetime = 20f;
                            despawnEffect = Fx.none;
//                            collidesGround = false;
                        }};
                    }};
                }},
               JPItem.biomass, new BasicBulletType(5f, 60f){{
                    lifetime = 45f;
//                    splashDamage = 15f;
//                    splashDamageRadius = 15f;
                    backColor = JPPal.sporeBulletBack;
                    frontColor = JPPal.sporeBulletFront;
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

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        impalerCannon= new ItemTurret("impalerCannon"){{
            requirements(Category.turret, with(surgeAlloy, 750, JPItem.naniteAlloy, 500,thorium, 500,silicon, 450));
            envEnabled = Env.spores;
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
                JPItem.biomass, new PointBulletType(){{
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
                JPItem.vanadiumCarbideAlloy, new PointBulletType(){{
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
            shootSound = Sounds.shootForeshadow;
            outlineColor = Color.valueOf("19171b");

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};
}};