package jp.content;

import arc.func.Prov;
import arc.graphics.*;
import arc.struct.*;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.part.DrawPart.PartProgress;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.content.*;
import mindustry.type.unit.*;
import mindustry.world.meta.*;



public class JPUnits {
    public static UnitType
    //Legs
    Carci,Imp, Basilisk, Autus, Baneling, Zergling, Behomoth, Lobber, Breacher, Scarabid, Frost, Roach, Purger, Gorgon, Raptor, FrostC, Demolisher,
    //missiles
    //Bomb,
    //Floaty
    Guardian,Thera,DeathImp,Drone,Interceptor,Hivedefender,HiveSentinel,Sporophage,Rizomorph,
    //Le tether
    Zeta,
    //Winged
    Gragoth, Slasher, Saboteur, Protectorate, Carrier, Spitter;
    private static final ObjectMap.Entry<Class<? extends Entityc>, Prov<? extends Entityc>>[] types = new ObjectMap.Entry[]{
            prov(JPCopterUnitEntity.class, JPCopterUnitEntity::new)
    };

    private static final ObjectIntMap<Class<? extends Entityc>> idMap = new ObjectIntMap<>();

    /**
     * Internal function to flatmap {@code Class -> Prov} into an {@link ObjectMap.Entry}.
     * @author GlennFolker
     */
    private static <T extends Entityc> ObjectMap.Entry<Class<T>, Prov<T>> prov(Class<T> type, Prov<T> prov) {
        ObjectMap.Entry<Class<T>, Prov<T>> entry = new ObjectMap.Entry<>();
        entry.key = type;
        entry.value = prov;
        return entry;
    }

    /**
     * Setups all entity IDs and maps them into {@link EntityMapping}.
     * <p>
     * Put this inside load()
     * </p>
     * @author GlennFolker
     */
    private static void setupID() {
        for (
                int i = 0,
                j = 0,
                len = EntityMapping.idMap.length;
                i < len;
                i++
        ) {
            if (EntityMapping.idMap[i] == null) {
                idMap.put(types[j].key, i);
                EntityMapping.idMap[i] = types[j].value;
                if (++j >= types.length) break;
            }
        }
    }

    /**
     * Retrieves the class ID for a certain entity type.
     * @author GlennFolker
     */
    public static <T extends Entityc> int classID(Class<T> type) {
        return idMap.get(type, -1);
    }



        public static void load(){
            setupID();

        Zeta = new UnitType("Zeta"){{
            this.constructor = BuildingTetherPayloadUnit::create;
            controller = u -> new AssemblerAI();
            speed = 1f;
            hitSize = 11f;
            health = 400;
            range = 50f;    
            flying = true;
            engineOffset = 7f;
            engineSize = 4f;
            drag = 0.05f;
            accel = 0.11f;
            targetable = false;
            bounded = false;
            isEnemy = false;
            hidden = true;
            useUnitCap = false;
            logicControllable = false;
            playerControllable = false;
            allowedInPayloads = false;
            createWreck = false;
            outlineColor = Color.valueOf("303a45");
        }};

        Zergling = new UnitType("Zergling"){{
            this.constructor = LegsUnit::create;
            speed = 1.45f;
            hitSize = 8f;
            health = 250;
            range = 50f;
            legCount = 4;
            weapons.add(new Weapon("claws"){{
                reload = 30f;
                x = 0f;
                mirror = false;
                y = 0f;
                bullet = new BasicBulletType(2.5f, 9){{
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    speed = 3f;
                    lifetime = 45f;
                    damage = 25f;
                }};
            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (120f * 60f * 2f) * 100f;}});
            }};

        Lobber = new UnitType("Lobber"){{
            this.constructor = LegsUnit::create;
            speed = 1f;
            hitSize = 8f;
            health = 215;
            armor = 2;
            range = 60f;
            legCount = 4;
            weapons.add(new Weapon(name + "-gun"){{
                reload = 60f;
                x = 0f;
                y = -5f;
                mirror = false;
                shootSound = Sounds.artillery;
                bullet = new BasicBulletType(2.5f, 9){{
                    speed = 3f;
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootBigSmoke;
                    splashDamage = 30f;
                    splashDamageRadius = 25f;
                    lifetime = 75f;

                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    collidesTiles = true;
                    trailLength = 5;
                    trailColor = Color.valueOf("8B73C7");
                }};
                parts.add(new RegionPart("-barrel"){{
                    progress = PartProgress.recoil;
                    mirror = false;
                    moveY = -2.5f;
                    layerOffset = -0.000001f;
                }});
            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (60f * 60f * 2f) * 100f;}});
        }};

        Raptor = new UnitType("Raptor"){{
            this.constructor = LegsUnit::create;
            speed = 2f;
            armor = 2f;
            hitSize = 8f;
            health = 450;
            range = 50f;
            legCount = 4;
            weapons.add(new Weapon("claws"){{
                reload = 20f;
                x = 0f;
                mirror = false;
                y = 0f;
                bullet = new BasicBulletType(3f, 35){{
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lifetime = 45f;
                }};
            }});
            weapons.add(new Weapon("grapplinghook"){{
                reload = 645f;
                x = 0f;
                mirror = false;
                y = 0f;
                bullet = new BasicBulletType(9f, 180){{
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lifetime = 10f;
                    splashDamage = 200f;
                    splashDamageRadius = 25.5f;
                    recoil = -24f;
                    trailLength = 10;
                    trailWidth = 4f;
                    trailColor = Color.valueOf("8B73C7");
                    trailInterval = 3f;
                    despawnSound = Sounds.spark;
                    hitEffect = new MultiEffect(
                            new WaveEffect(){{
                                colorFrom = colorTo = Color.valueOf("8B73C7");
                                sizeFrom = 0f;
                                sizeTo = 30f;
                                lifetime = 20f;
                                strokeFrom = 0f;
                                strokeTo = 5.5f;
                            }}
                    );
                }};
            }});
            parts.add(new RegionPart("-wing"){{
                mirror = true;
                progress = PartProgress.recoil;
                x = 3.5f;
                y = -6f;
                moveX = 1.5f;
                moveY = 2f;
                moveRot = 10;
            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (120f * 60f * 2f) * 100f;}});
            }};

        Baneling = new UnitType("Baneling"){{
            this.constructor = LegsUnit::create;
            speed = 1.25f;
            hitSize = 8f;
            health = 225;
            range = 50f;
            legCount = 4;
            weapons.add(new Weapon("kys"){{
                reload = 5f;
                x = 0f;
                y = 0f;
                top = false;
                shootOnDeath = true;
                shoot.firstShotDelay = 90f;
                bullet = new BombBulletType(0f, 100f){{
                    rangeOverride = 30f;
                    width = 0f;
                    height = 0f;
                    lifetime = 10f;
                    statusDuration = 60f * 2;
                    status = JPStatus.Dissolving;
                    splashDamage = 250f;
                    splashDamageRadius = 60f;
                    killShooter = true;
                    collidesAir = true;
                    buildingDamageMultiplier = 1.25f;
                    shootStatus = StatusEffects.unmoving;
                    statusDuration = 180f;
                    hitSound = Sounds.explosion;
                    fragBullets = 6;
                    fragBullet = new LiquidBulletType(JPLiquids.liquidSpore){{
                        lifetime = 17f;
                        speed = 3f;
                        puddleSize = 20f;
                        orbSize = 4f;
                        status = JPStatus.Dissolving;
                        statusDuration = 60f * 4f;
                        damage = 40f;
                        layer = Layer.bullet - 2f;
                    }};
                }};
                shootSound = Sounds.explosion;
            }});

            parts.add(new RegionPart("-sac"){{
                mirror = false;
                progress = PartProgress.warmup;
                heatProgress = PartProgress.warmup;
                heatColor = Color.valueOf("8B73C7");
                heatLayerOffset = 0.1f;
                layerOffset = -0.0001f;
                x = 0f;
                y = 0f;
                growX = 0.15f;
                growY = 0.1f;
            }});

            immunities.add(JPStatus.Dissolving);
            outlineColor = Color.valueOf("303a45");
            abilities.add(new LiquidExplodeAbility(){{liquid = JPLiquids.liquidSpore; amount = 250f;}});
            abilities.add(new RegenAbility(){{percentAmount = 1f / (120f * 60f) * 100f;}});
        }};

        Roach = new UnitType("Roach"){{
            this.constructor = LegsUnit::create;
            speed = 1f;
            hitSize = 18f;
            health = 650;
            armor = 5;
            range = 125f;
            legCount = 4;
            stepShake = 0f;      
            weapons.add(new Weapon(name + "-gun"){{
                reload = 75f;
                x = -10f;
                y = 0f;
                recoil = 6;
                mirror = true;
                targetAir = false;
                bullet = new ArtilleryBulletType(2.5f, 9){{
                    speed = 6f;
                    height = width = 20f;
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootBigSmoke;
                    damage = 90f;
                    splashDamage = 90f;
                    splashDamageRadius = 17f;
                    lifetime = 40f;
                    statusDuration = 60f * 4;
                    status = JPStatus.Dissolving;
                    backColor = Color.valueOf("8FFE09");
                    frontColor = Color.valueOf("8FFE09");
                    lightColor = Color.white;
                    collidesTiles = true;
//                    trailLength = 3;
                    trailColor = Color.valueOf("bbfe6b");
                }};
                shootSound = Sounds.artillery;
            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (120f * 60f * 2f) * 100f;}});
        }};

        Scarabid = new UnitType("Scarabid"){{
            this.constructor = LegsUnit::create;
            speed = 1f;
            hitSize = 18f;
            health = 1150;
            armor = 4;
            range = 125f;
            legCount = 4;
            stepShake = 0.15f;       
            weapons.add(new Weapon(name + "-Cannon"){{
                reload = 75f;
                x = 0f;
                y = -8f;
                mirror = false;
                targetAir = false;
                shoot.shots = 4;
                inaccuracy = 12f;
                velocityRnd = 0.2f;
                recoil = 2;
                bullet = new ArtilleryBulletType(2.5f, 9){{
                    speed = 6f;
                    height = width = 20f;
                    damage = 90f;
                    splashDamage = 125f;
                    splashDamageRadius = 17f;
                    lifetime = 50f;
                    statusDuration = 60f * 4;
                    status = JPStatus.Dissolving;
                    backColor = Color.valueOf("8FFE09");
                    frontColor = Color.valueOf("8FFE09");
                    lightColor = Color.valueOf("8FFE09");
                    collides = true;
                    collidesTiles = true;
                    trailLength = 3;
                    trailColor = Color.valueOf("bbfe6b");
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootBigSmoke;
                }};
                shootSound = Sounds.artillery;
            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (120f * 60f * 2f) * 100f;}});
        }};

        Breacher = new UnitType("Breacher"){{
            this.constructor = LegsUnit::create;
            speed = 1f;
            hitSize = 18f;
            health = 1150;
            armor = 4;
            range = 125f;
            legCount = 4;            
            weapons.add(new Weapon(name + "-gun"){{
                reload = 250f;
                x = 0f;
                y = -10f;
                mirror = false;
                shoot.shots = 8;
                shoot.shotDelay = 5f;
                recoil = 5;
                bullet = new MissileBulletType(6f, 85){{
                    height = width = 10f;
                    hitEffect = Fx.sapExplosion;
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootBigSmoke;
                    splashDamage = 10f;
                    splashDamageRadius = 5f;
                    lifetime = 25f;
                    homingPower = 0.1f;
                    homingRange = 60f;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.white;
                    lightColor = Color.valueOf("8B73C7");
                    collidesTiles = true;
                    trailLength = 3;
                    trailColor = Color.valueOf("8B73C7");
                }};
                shootSound = Sounds.missile;
            }});
            weapons.add(new Weapon(name + "-thestorm"){{
                reload = 5f;
                x = -11f;
                y = 2f;
                mirror = true;
                bullet = new BasicBulletType(3f, 20f){{
                    collidesTiles = true;
                    width = 15f;
                    height = 15f;
                    lifetime = 45f;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.white;
                    lightColor = Color.valueOf("8B73C7");
                }};

            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (120f * 60f * 2f) * 100f;}});
        }};

        Purger = new UnitType("Purger"){{
            this.constructor = LegsUnit::create;
            speed = 1f;
            hitSize = 8f;
            health = 650;
            armor = 4;
            range = 45f;
            legCount = 4;
            legLength = 13f;
            legExtension = 7f;
            legBaseOffset = 6f;
            weapons.add(new Weapon(name + "-flamer"){{
                top = true;
                x = 11f;
                y = 1f;
                mirror = true;
                recoil = 0.5f;
                shootSound = Sounds.torch;
                ejectEffect = Fx.none;
                alternate = false;
                continuous = true;
                alwaysContinuous = true;
                bullet = new ContinuousFlameBulletType() {{
                    lightStroke = 35;
                    divisions = 40;
                    width = 3.8f;
                    drawFlare = false;
                    length = 70;
                    pierce = true;
                    pierceBuilding = true;
                    pierceArmor = false;
                    pierceCap = 3;
                    damage = 25;
                    damageInterval = 10;
                    hitColor = Color.valueOf("c69789");
                    colors = new Color[]{Color.valueOf("8B73C7"), Color.valueOf("A865C9"), Color.valueOf("A865C9"), Color.valueOf("ffffff")};
                }};

                parts.add(new RegionPart("-fuel"){{
                    mirror = false;
                    progress = PartProgress.recoil;
                    heatProgress = PartProgress.warmup;
                    heatColor = Color.valueOf("8B73C7");
                    heatLayerOffset = 0.1f;
                    growX = 0.15f;
                    growY = 0.1f;
                }});

            }});
            immunities.add(StatusEffects.burning);
            immunities.add(StatusEffects.melting);
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (120f * 60f * 2f) * 100f;}});
        }};

        Gorgon = new UnitType("Gorgon"){{
            this.constructor = LegsUnit::create;
            speed = 1f;
            hitSize = 27f;
            health = 12000;
            range = 150f;    
            legCount = 4;
            legLength = 25f; 
            weapons.add(new Weapon("-Mouh"){{
                reload = 300f;
                shootY = 8f;
                x = 0f;
                y = 26f;
                continuous = true;
                shoot.firstShotDelay = JPFx.purpleLaserChargeSmall.lifetime -1f;
                chargeSound = Sounds.lasercharge2;
                shootSound = Sounds.beam;
                mirror = false;
                bullet = new ContinuousLaserBulletType(65f){{
                    width = 10f;
                    length = 180f;
                    drawSize = 420f;
                    lifetime = 160f;
                    healPercent = 1f;
                    collidesTeam = true;
                    chargeEffect = JPFx.purpleLaserChargeSmall;
                    colors = new Color[]{Color.valueOf("8B73C7"), Color.valueOf("A865C9"), Color.valueOf("A865C9"), Color.valueOf("ffffff")};
                }};
            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (120f * 60f * 2f) * 100f;}});
        }};

        Behomoth = new UnitType("Behomoth"){{
            this.constructor = LegsUnit::create;
            speed = 0.65f;
            hitSize = 44f;
            armor = 6;
            health = 14000;
            range = 50f;
            legCount = 4;
            legLength = 30f;
            legExtension = -15f;
            legBaseOffset = 10f;
            weapons.add(new Weapon(name + "-gun"){{
                layerOffset = 1f;
                reload = 160f;
                x = 0f;
                y = -23f;
                recoil = 6f;
                mirror = false;
                ejectEffect = Fx.casing1;
                shootSound = JPSounds.ArtyBig;
                bullet = new BasicBulletType(2.5f, 9){{
                    width = 15f;
                    height = 30f;
                    speed = 6f;
                    lifetime = 50f;
                    splashDamage = 100f;
                    splashDamageRadius = 25f;
                    status = StatusEffects.slow;
                    statusDuration = 60f * 4;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    shootEffect = Fx.shootBig;
                    hitEffect = Fx.sapExplosion;
                }};

            }});
            weapons.add(new Weapon(name + "-mini"){{
                reload = 5f;
                x = -15f;
                y = -23f;
                mirror = true;
                shootSound = Sounds.shootBig;
                bullet = new BasicBulletType(2.5f, 9){{
                    width = 15f;
                    height = 15f;
                    speed = 4.5f;
                    lifetime = 70f;
                    damage = 50f;
                    backColor = Color.valueOf("CBC3E3");
                    frontColor = Color.valueOf("CBC3E3");
                    collides = true;
                    collidesTiles = true;
                }};

            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (200f * 60f * 2f) * 100f;}});
            abilities.add(new UnitSpawnAbility(Lobber,475f,0f,-7f));
        }};

        Basilisk = new UnitType("Basilisk"){{
            this.constructor = LegsUnit::create;
            speed = 0.55f;
            hitSize = 44f;
            health = 35000;
            armor = 10;
            range = 125f;
            legCount = 4;     
            legLength = 30f;
            legExtension = -15f;
            legBaseOffset = 10f;       
            weapons.add(new Weapon("Superarty"){{
                reload = 400f;
                x = 0f;
                y = 0f;
                mirror = false;
                bullet = new ArtilleryBulletType(3f, 120){{
                    hitEffect = Fx.sapExplosion;
                    knockback = 0.8f;
                    lifetime = 120f;
                    width = height = 30f;
                    collides = true;
                    collidesTiles = true;
                    splashDamageRadius = 65f;
                    splashDamage = 650f;
                    status = JPStatus.Dissolving;
                    statusDuration = 60f * 6;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    fragBullets = 6;
                    fragBullet = new ArtilleryBulletType(2.3f, 30){{
                        hitEffect = Fx.sapExplosion;
                        knockback = 0.8f;
                        lifetime = 30f;
                        width = height = 20f;
                        collidesTiles = false;
                        splashDamageRadius = 65f;
                        splashDamage = 250f;
                        backColor = Color.valueOf("8B73C7");
                        frontColor = Color.valueOf("8B73C7");
                        lightning = 2;
                        lightningLength = 5;
                        smokeEffect = Fx.shootBigSmoke2;
                        hitShake = 5f;
                        lightRadius = 30f;
                        lightColor = Color.valueOf("8B73C7");
                        lightOpacity = 0.5f;
                    }};
                }};
                shootSound = Sounds.artillery;
            }});
            weapons.add(new Weapon(name + "-mini-body"){{
                reload = 30f;
                x = 15f;
                y = 18f;
                mirror = true;
                controllable = false;
                autoTarget = true;
                rotate = true;
                bullet = new BasicBulletType(4f, 50){{
                    hitEffect = Fx.blastExplosion;
                    knockback = 2.5f;
                    lifetime = 40f;
                    width = height = 14f;
                    collides = true;
                    collidesTiles = true;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    }};
                    shootSound = Sounds.artillery;
                parts.add(new RegionPart("-barrel"){{
                    mirror = true;
                    progress = PartProgress.recoil;
//                    layerOffset= -0.1f;
                    under = true;
                    y = 1.5f;
                    moveY = -2f;
                }});
                }});
            weapons.add(new Weapon(name + "-mini-body"){{
                reload = 30f;
                x = 15f;
                y = -18f;
                mirror = true;
                controllable = false;
                autoTarget = true;
                rotate = true;
                bullet = new BasicBulletType(4f, 50){{
                    hitEffect = Fx.blastExplosion;
                    knockback = 2.5f;
                    lifetime = 40f;
                    width = height = 14f;
                    collides = true;
                    collidesTiles = true;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    }};
                    shootSound = Sounds.artillery;
                    parts.add(new RegionPart("-barrel"){{
                        mirror = true;
                        progress = PartProgress.recoil;
//                        layerOffset= -0.1f;
                        under = true;
                        y = 1.5f;
                        moveY = -2f;
                    }});
                }});

            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (240f * 60f * 2f) * 100f;}});
        }};

        Drone = new UnitType("Drone"){{
            this.constructor = UnitEntity::create;
            controller = u -> new MinerAI();
            defaultCommand = UnitCommand.mineCommand;
            speed = 1f;
            hitSize = 10f;
            health = 400;
            range = 50f;    
            flying = true;
            engineOffset = 5f;
            engineSize = 4f;
            mineSpeed = 3f;
            buildSpeed = 0.75f;
            mineTier = 3;
            drag = 0.05f;
            accel = 0.11f;
            itemCapacity = 10;
            weapons.add(new Weapon("laser"){{
                reload = 65f;
                x = 0f;
                y = 0f;
                layerOffset = -1f;
                rotate = false;
                mirror = false;
                bullet = new SapBulletType(){{
                    sapStrength = 0.5f;
                    length = 75f;
                    damage = 15;
                    shootEffect = Fx.shootSmall;
                    hitColor = color = Color.valueOf("8B73C7");
                    despawnEffect = Fx.none;
                    width = 0.54f;
                    lifetime = 35f;
                    knockback = -1.24f;
                }};
            }});
                outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (60f * 60f * 2f) * 100f;}});
        }};

        Interceptor = new UnitType("Interceptor"){{
            this.constructor = UnitEntity::create;
            speed = 1f;
            hitSize = 18f;
            health = 200;
            range = 125f;      
            flying = true;
            engineOffset = 12f;
            engineSize = 5f;
            drag = 0.05f;
            accel = 0.11f;
            weapons.add(new Weapon("-Mouh"){{
                reload = 75f;
                x = 0f;
                y = 0f;
                mirror = false;
                bullet = new BasicBulletType(6f, 45){{
                    height = width = 10f;
                    lifetime = 30f;
                    backColor = Color.valueOf("8FFE09");
                    frontColor = Color.valueOf("8FFE09");
                    lightColor = Color.valueOf("8FFE09");
                    collidesTiles = true;
                    trailLength = 3;
                    trailColor = Color.valueOf("bbfe6b");
                }};
            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (90f * 60f * 2f) * 100f;}});
        }};

        Rizomorph = new UnitType("Rizomorph"){{
            this.constructor = UnitEntity::create;
            speed = 1.65f;
            accel = 0.08f;
            drag = 0.016f;
            flying = true;
            hitSize = 10f;
            engineSize = 5f;
            health = 925;
            targetAir = false;
            engineOffset = 7.8f;


            range = 140f;
            faceTarget = false;
            circleTarget = true;
            weapons.add(new Weapon("Ambutakam"){{
                minShootVelocity = 0.75f;
                x = 0;
                y = 5;
                shootY = 0f;
                reload = 25f;
                shootCone = 180f;
                ejectEffect = Fx.none;
                inaccuracy = 15f;
                ignoreRotation = true;
                shoot.shots = 3;
                shoot.shotDelay = 10f;
                shootSound = Sounds.none;
                bullet = new BombBulletType(27f, 25f){{
                    width = 10f;
                    height = 14f;
                    hitEffect = Fx.flakExplosion;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                    splashDamage = 25f;
                    backColor = Color.valueOf("8b73c7");
                    frontColor = Color.valueOf("7357cf");
                    lightColor = Color.valueOf("8b73c7");
                    splashDamageRadius = 32f;
                    status = StatusEffects.blasted;
                    statusDuration = 60f;
                }};
            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new MoveEffectAbility(-7f, -7f, Pal.sapBulletBack, Fx.missileTrailShort, 4f){{
                teamColor = true;
            }});
            abilities.add(new MoveEffectAbility(7f, -7f, Pal.sapBulletBack, Fx.missileTrailShort, 4f){{
                teamColor = true;
            }});
            abilities.add(new RegenAbility(){{percentAmount = 1f / (120f * 60f * 2f) * 100f;}});
        }};

        Guardian = new UnitType("Guardian"){{
            this.constructor = UnitEntity::create;
            speed = 1f;
            hitSize = 18f;
            health = 1500;
            armor = 7;
            range = 175f;
            flying = true;
            targetAir = false;
            engineOffset = 10f;
            engineSize = 4f;
            drag = 0.04f;
            accel = 0.08f;               
            weapons.add(new Weapon(name + "-gun"){{
                reload = 125f;
                x = 11f;
                y = 4f;
                mirror = true;
                recoil = 6f;
                layerOffset = -0.01f;
                bullet = new ArtilleryBulletType(4.5f, 75){{
                    recoil = 1f;
                    speed = 4.5f;
                    height = 15f;
                    width = 7f;
                    splashDamage = 125f;
                    splashDamageRadius = 25f;
                    lifetime = 60f;
                    statusDuration = 60f * 4;
                    status = JPStatus.Dissolving;
                    backColor = Color.valueOf("8FFE09");
                    frontColor = Color.valueOf("8FFE09");
                    lightColor = Color.valueOf("8FFE09");
                    collides = true;
                    collidesTiles = true;
                    trailLength = 6;
                    trailWidth = 2.8f;
                    trailColor = Color.valueOf("bbfe6b");
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootBigSmoke;
                }};
                shootSound = Sounds.artillery;
            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (120f * 60f * 2f) * 100f;}});
        }};

        DeathImp = new UnitType("DeathImp"){{
            this.constructor = UnitEntity::create;
            speed = 1.75f;
            health = 215;
            range = 50f;
            engineOffset = 5f;
            engineSize = 4f;
            rotateSpeed = 7f;
            flying = true;
            hidden = true;
            hitSize = 9f;
            drag = 0.05f;
            accel = 0.11f;
            weapons.add(new Weapon("kys"){{
                reload = 5f;
                x = 0f;
                y = 0f;
                top = false;
                shootOnDeath = true;
                bullet = new BombBulletType(2.5f, 9){{
                    rangeOverride = 30f;
                    width = 0f;
                    height = 0f;
                    lifetime = 10f;
                    splashDamage = 175f;
                    splashDamageRadius = 60f;
                    killShooter = true;
                    collidesAir = true;
                    hitSound = Sounds.explosion;
                }};
                shootSound = Sounds.explosion;
            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.neoplasm; amount = 210f;}});
        }};        
        
        Imp = new UnitType("Imp"){{
            this.constructor = LegsUnit::create;
            speed = 1.5f;
            hitSize = 8f;
            health = 450;
            range = 50f;
            weapons.add(new Weapon("kys"){{
                reload = 5f;
                x = 0f;
                y = 0f;
                top = false;
                shootOnDeath = true;
                bullet = new BombBulletType(2.5f, 9){{
                    rangeOverride = 30f;
                    width = 0f;
                    height = 0f;
                    lifetime = 10f;
                    status = StatusEffects.burning;
                    statusDuration = 60f* 4.5f;
                    splashDamage = 150f;
                    splashDamageRadius = 60f;
                    killShooter = true;
                    collidesAir = true;
                    buildingDamageMultiplier = 1.75f;
                    hitSound = Sounds.explosion;
                    incendChance = 100f;
                    incendSpread = 25f;
                    incendAmount = 25;
                }};
                shootSound = Sounds.explosion;
            }});
            immunities.add(StatusEffects.burning);
            immunities.add(StatusEffects.melting);
            immunities.add(StatusEffects.freezing);
            healColor = Color.valueOf("590e14");
            outlineColor = Color.valueOf("303a45");
            abilities.add(new SpawnDeathAbility(DeathImp, 1, 11f));
            abilities.add(new RegenAbility(){{percentAmount = 1f / (70f * 60f) * 100f;}});
            abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.neoplasm; amount = 75f;}});
        }};

        Carci = new UnitType("Carci"){{
            this.constructor = LegsUnit::create;
            speed = 0.65f;
            targetAir = false;
            hitSize = 8f;
            health = 875;
            armor = 4;
            range = 50f;
            legCount = 4;
            legLength = 8f;
            legExtension = 4f;
            legBaseOffset = 5f;
            weapons.add(new Weapon("mouh"){{
                reload = 60f;
                x = 0f;
                y = 0f;
                mirror = false;
                shootSound = Sounds.artillery;
                bullet = new ArtilleryBulletType(2.5f, 9){{
                    speed = 3f;
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootBigSmoke;
                    splashDamageRadius = 25f;
                    splashDamage = 125f;
                    lifetime = 75f;
                    statusDuration = 60f * 4;
                    status = StatusEffects.slow;
                    backColor = Color.valueOf("85151e");
                    frontColor = Color.valueOf("85151e");
                    collidesTiles = true;
                    trailLength = 5;
                    trailColor = Color.valueOf("69262b");
                }};
            }});
            healColor = Color.valueOf("590e14");
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (70f * 60f * 2f) * 100f;}});
            abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.neoplasm;}});
        }};

        Autus = new UnitType("Autus"){{
            this.constructor = LegsUnit::create;
            speed = 0.75f;
            hitSize = 8f;
            health = 1500;
            armor = 7;
            range = 40f;
            legCount = 4;
            legLength = 13f;
            legExtension = 7f;
            legBaseOffset = 6f;
            weapons.add(new Weapon(name + "-flamer"){{
                top = true;
                x = 0f;
                y = -3f;
                shootY = 7f;
                mirror = false;
                recoil = 0.5f;
                shootStatus = StatusEffects.shielded;
                shootStatusDuration = 80f;
                shootSound = Sounds.torch;
                ejectEffect = Fx.none;
                continuous = true;
                alwaysContinuous = true;
                bullet = new ContinuousFlameBulletType() {{
                    lightStroke = 35;
                    divisions = 40;
                    width = 3.8f;
                    drawFlare = false;
                    length = 70;
                    pierce = true;
                    pierceBuilding = true;
                    pierceArmor = false;
                    pierceCap = 3;
                    damage = 50;
                    damageInterval = 10;
                    hitColor = Color.valueOf("c69789");
                    colors = new Color[]{Color.valueOf("9e3736"), Color.valueOf("cc603f"), Color.valueOf("c69789"), Color.valueOf("edc6ba")};
                }};

                parts.add(new RegionPart("-flesh"){{
                    mirror = false;
                    progress = PartProgress.recoil;
                    heatProgress = PartProgress.warmup;
                    heatColor = Color.valueOf("590e14");
                    heatLayerOffset = 0.1f;
                    growX = 0.15f;
                    growY = 0.1f;
                }});

            }});
            healColor = Color.valueOf("590e14");
            outlineColor = Color.valueOf("303a45");
            parts.add(new RegionPart("-hand"){{
                mirror = true;
                progress = PartProgress.warmup;
                layerOffset= -0.0001f;
                under = true;
                x = 3f;
                y = 3f;
                moveX = -1.5f;
                moveY = -1.25f;
                moveRot = 10f;
            }});
            immunities.add(StatusEffects.burning);
            immunities.add(StatusEffects.melting);
            abilities.add(new RegenAbility(){{percentAmount = 1f / (120f * 60f * 2f) * 100f;}});
            abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.neoplasm;}});
        }};

            Demolisher = new UnitType("Demolisher"){{
                this.constructor = LegsUnit::create;
                speed = 0.6f;
                hitSize = 8f;
                armor = 6;
                health = 6200;
                range = 50f;
                legCount = 4;
                legLength = 17f;
                legExtension = 7f;
                legBaseOffset = 6f;
                weapons.add(new Weapon(name + "-laser"){{
                    reload = 225f;
                    layerOffset = -0.01f;
                    x = 12f;
                    y = -2f;
                    mirror = true;
                    shoot.shots = 3;
                    shoot.shotDelay = 10f;
                    recoil = 8;
                    bullet = new LaserBulletType(75f){{
                        colors = new Color[]{Color.valueOf("8B73C7").cpy().a(0.4f), Color.valueOf("8B73C7"), Color.white};
//                        chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                        chargeEffect = JPFx.purpleLaserChargeSmall;
                        lifetime = 16f;
                        buildingDamageMultiplier = 1.5f;
                    }};
                    shootSound = Sounds.laser;
                }});
                weapons.add(new Weapon(name + "-missile"){{
                    x = 0f;
                    y = -10f;
                    mirror = false;
                    reload = 600f;
                    recoil = 5.5f;
//                    shoot.firstShotDelay = 125f;
//                    shoot = new ShootSpread(5, 1.5f);
                    shoot.shots = 6;
                    shoot.shotDelay = 30f;
                    bullet = new MissileBulletType(3.5f, 20){{
                        width = 14f;
                        height = 14f;
                        velocityRnd = 0.05f;
                        inaccuracy = 2f;
                        splashDamageRadius = 35f;
                        splashDamage = 65f;
                        shootStatus = StatusEffects.unmoving;
                        shootStatusDuration = 4 * 60f;
                        hitEffect = Fx.blastExplosion; 
                        despawnEffect = Fx.blastExplosion;
                        weaveScale = 8f;
                        weaveMag = 2f;
                        fragBullets = 5;
                        buildingDamageMultiplier = 1.5f;
                        fragBullet = new MissileBulletType(4.5f, 5f){{
                            width = 8f;
                            height = 8f;
                            velocityRnd = 0.05f;
                            inaccuracy = 2f;
                            splashDamageRadius = 25f;
                            splashDamage = 10f;
                            hitEffect = Fx.blastExplosion;
                            despawnEffect = Fx.blastExplosion;
                            weaveScale = 8f;
                            weaveMag = 2f;
                            buildingDamageMultiplier = 3f;
                        }};
                    }};
                    shootSound = Sounds.missile;
                }});
                weapons.add(new Weapon(name + "-beam"){{
                    x = -7f;
                    y = -7f;
                    mirror = true;
                    reload = 75f;
                    recoil = 2.5f;
                    minWarmup = 0.94f;
                    shootWarmupSpeed = 0.05f;
                    bullet = new MissileBulletType(3.5f, 50f){{
                        buildingDamageMultiplier = 1.5f;
                        homingPower = 0.1f;
                        homingRange = 5f;
                    }};
                    parts.add(new RegionPart("-cover"){{
                        progress = PartProgress.warmup;
                        mirror = true;
                        y = -1f;
                        moveX = 1.5f;
                        moveY = 1.25f;
                        moveRot = -10f;
                    }});
                    shootSound = Sounds.missile;
                }});
                healColor = Color.valueOf("590e14");
                outlineColor = Color.valueOf("303a45");
                abilities.add(new RegenAbility(){{percentAmount = 1f / (120f * 60f * 2f) * 100f;}});
                abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.neoplasm;}});
            }};

        Protectorate = new JPCopterUnitType("Protectorate"){{
            speed = 1.25f;
            armor = 4;
            hitSize = 9f;
            health = 800;
            range = 125f;    
            flying = true;
            drag = 0.05f;
            accel = 0.11f;
            engineSize = 0f;

            weapons.add(new Weapon("Mouh"){{
                mirror = false;
                reload = 10f;
                x = 0f;
                y = 0f;
                layerOffset = -1f;
                bullet = new BasicBulletType(3.7f, 18){{
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    buildingDamageMultiplier = 0.75f;
                    width = 8f;
                    height = 8f;
                    damage = 15f;
                }};
            }});
            blade.add(
                new Blade(name + "-wing"){{
                y = -1f; x = 5f;
                bladeMoveSpeed = 80f;
                bladeBlurAlphaMultiplier = 0.5f;
                //bladeLayer = -1f;
            }});
            healColor = Color.valueOf("590e14");
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (90f * 60f * 2f) * 100f;}});
            abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.neoplasm;}});
            abilities.add(new RepairFieldAbility(35f, 60f * 8, 50f){{
                lightColor = Color.valueOf("8B73C7");
            }});
            abilities.add(new StatusFieldAbility(StatusEffects.overclock, 60f * 6, 60f * 4f, 60f));
            abilities.add(new ShieldRegenFieldAbility(25f, 250f, 60f * 6, 60f));
        }};

        Saboteur = new JPCopterUnitType("Saboteur"){{
            speed = 1.25f;
            armor = 2;
            hitSize = 9f;
            health = 450;
            range = 125f;    
            flying = true;
            drag = 0.05f;
            accel = 0.11f;
            engineSize = 0f;
            weapons.add(new Weapon("Mouh"){{
                reload = 50f;
                x = 0f;
                y = 0f;
                layerOffset = -1f;
                bullet = new BasicBulletType(3.7f, 18){{
                    recoil = 4f;
                    statusDuration = 60f * 4;
                    status = StatusEffects.electrified;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    width = 8f;
                    height = 8f;
                    damage = 75f;
                    splashDamageRadius = 20f;
                    splashDamage = 45f;
                    buildingDamageMultiplier = 1.5f;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                }};
            }});
            blade.add(
                new Blade(name + "-wing"){{
                y = -1f; x = 5f;
                bladeMoveSpeed = 80f;
                bladeBlurAlphaMultiplier = 0.5f;
                //bladeLayer = -1f;
            }});
            healColor = Color.valueOf("590e14");
            outlineColor = Color.valueOf("303a45");
            abilities.add(new SuppressionFieldAbility(){{
                particleColor = Color.valueOf("8B73C7");
                orbRadius = 0.1f;
            }});
            abilities.add(new RegenAbility(){{percentAmount = 1f / (90f * 60f * 2f) * 100f;}});
            abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.neoplasm;}});
        }};

        Spitter = new JPCopterUnitType("Spitter"){{
            speed = 1.5f;
            armor = 3;
            hitSize = 9f;
            health = 600;
            flying = true;
            targetAir = false;
            targetFlags = new BlockFlag[]{BlockFlag.extinguisher, null};
            weapons.add(new Weapon(name + "-Gun"){{
                recoil = 1f;
                reload = 5f;
                x = 0f;
                y = 4f;
                layerOffset = -1f;
                shootSound = Sounds.flame;
                bullet = new LiquidBulletType(Liquids.neoplasm){{
                    lifetime = 47f;
                    damage = 25f;
                    splashDamage = 25f;
                    splashDamageRadius = 25f;
                    collidesAir = false;
                }};
            }});
            blade.add(
                new Blade(name + "-wing"){{
                y = -1f; x = 5f;
                bladeMoveSpeed = 80f;
                bladeBlurAlphaMultiplier = 0.5f;
                //bladeLayer = -1f;
            }});
            healColor = Color.valueOf("590e14");
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (90f * 60f * 2f) * 100f;}});
            abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.neoplasm;}});
        }};

        Carrier = new JPCopterUnitType("Carrier"){{
            speed = 1.65f;
            armor = 2;
            flying = true;
            hitSize = 10f;
            health = 980;
            targetAir = false;
            range = 140f;
            faceTarget = false;
            circleTarget = true;
            
            weapons.add(new Weapon("Eggspawner"){{
                x = 6f;
                y = 6f;
                mirror = true;
                shoot.firstShotDelay = 200f;
                reload = 400f;
                top = false;
                alwaysShooting = true;
                shootSound = Sounds.none;
                bullet = new BasicBulletType(0f, 0f){{
                    shootEffect = Fx.none;
                    collidesAir = false;
                    width = 0f;
                    height = 0f;
                    lifetime = 10f;
                    spawnUnit = new MissileUnitType("egg"){{
                    flying = false;
                    speed = 0f;
                    useUnitCap = false;
                    lifetime = 123f;
                    health = 600f;
                    hitSize = 3f;
                    hidden = true;
                    drawCell = false;
                    outlineColor = Color.valueOf("303a45");
                    abilities.add(new UnitSpawnAbility(Protectorate,120f,0f,0f));
                    abilities.add(new RegenAbility(){{percentAmount = 1f / (120f * 60f * 2f) * -500f;}});
                    }};
                }};
            }});
            weapons.add(new Weapon("Ambutakam"){{
                minShootVelocity = 0.75f;
                x = 0;
                y = 5;
                shootY = 0f;
                reload = 100f;
                shootCone = 180f;
                ejectEffect = Fx.none;
                inaccuracy = 15f;
                ignoreRotation = true;
                shoot.shots = 3;
                shoot.shotDelay = 10f;
                shootSound = Sounds.none;
                bullet = new BombBulletType(25f, 25f){{
                    fragBullets = 3;
                    width = 10f;
                    height = 14f;
                    hitEffect = Fx.flakExplosion;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                    splashDamage = 15f;
                    backColor = Color.valueOf("8b73c7");
                    frontColor = Color.valueOf("7357cf");
                    lightColor = Color.valueOf("8b73c7");
                    splashDamageRadius = 32f;
                    status = StatusEffects.blasted;
                    statusDuration = 60f;
                    fragBullet = new BombBulletType(25f, 25f){{
                        shrinkX = 0f;
                        shrinkY = 0f;
                        spin = 4.6f;
                        speed = 6;
                        splashDamage = 15f;
                        splashDamageRadius = 32f;
                        width = 10f;
                        height = 7f;
                        backColor = Color.valueOf("8b73c7");
                        frontColor = Color.valueOf("7357cf");
                        lightColor = Color.valueOf("8b73c7");
                        lifetime = 75f;
                        despawnEffect = Fx.none;
                    }};
                }};
            }});
            blade.add(
                new Blade(name + "-wing"){{
                y = -1f; x = 4f;
                bladeMoveSpeed = 80f;
                bladeBlurAlphaMultiplier = 0.5f;
                //bladeLayer = -1f;
            }});
            healColor = Color.valueOf("590e14");
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (120f * 60f * 2f) * 100f;}});
            abilities.add(new SpawnDeathAbility(Saboteur, 1, 11f));
            abilities.add(new SpawnDeathAbility(Protectorate, 1, 11f));
            abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.neoplasm;}});
        }};

        Thera = new UnitType("Thera"){{
            this.constructor = UnitEntity::create;
            speed = 1.75f;
            hitSize = 8f;
            health = 1150;
            range = 75f;
            armor = 3;
            engineOffset = 5f;
            engineSize = 4f;
            rotateSpeed = 7f;
            flying = true;
            drag = 0.05f;
            accel = 0.11f;
            weapons.add(new Weapon("balls"){{
                x = 6f;
                y = 6f;
                mirror = true;
                reload = 75f;
                top = false;
                bullet = new BasicBulletType(2.5f, 9){{
                    collidesAir = false;
                    width = 0f;
                    height = 0f;
                    lifetime = 10f;
                    damage = 0f;
                    shoot.shots = 4;
                    alternate = true;
                    shoot.shotDelay = 5f;
                    spawnUnit = new MissileUnitType("Bomb"){{
                    flying = true;
                    useUnitCap = false;
                    lifetime = 50f;
                    trailLength = 3;
                    trailColor = Color.valueOf("A865C9");
                    health = 1120f;
                    hitSize = 3f;
                    hidden = true;
                    drawCell =false;
                    weapons.add(new Weapon(){{
                        shootCone = 360f;
                        mirror = false;
                        reload = 1f;
                        shootOnDeath = true;
                        bullet = new ExplosionBulletType(110f, 25f){{
                            killShooter = true;
                            shootEffect = Fx.massiveExplosion;
                            collidesAir = true;
                            splashDamage = 145f;
                            splashDamageRadius = 30f;
                            buildingDamageMultiplier = 0.5f;
                    }};}});
                    outlineColor = Color.valueOf("303a45");
                    }};
                }};
                shootSound = Sounds.missileSmall;
            }});
            healColor = Color.valueOf("590e14");
            outlineColor = Color.valueOf("303a45");
            abilities.add(new MoveEffectAbility(-7f, -3f, Pal.sapBulletBack, Fx.missileTrailShort, 4f){{
                teamColor = true;
            }});
            abilities.add(new MoveEffectAbility(7f, -3f, Pal.sapBulletBack, Fx.missileTrailShort, 4f){{
                teamColor = true;
            }});
            abilities.add(new RegenAbility(){{percentAmount = 1f / (70f * 60f * 2f) * 100f;}});
            abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.neoplasm;}});
        }};  

        Gragoth = new JPCopterUnitType("Gragoth"){{
            speed = 1.55f;
            armor = 3;
            hitSize = 18f;
            health = 2400;
            range = 125f;    
            flying = true;
            drag = 0.05f;
            accel = 0.11f;
            engineSize = 0f;
            weapons.add(new Weapon(name + "-railgun"){{
                reload = 250f;
                recoil = 6f;
                x = 0f;
                y = 8f;
                layerOffset = -1f;
                mirror = false;
                bullet = new BasicBulletType(2.5f, 9){{
                    recoil = 4f;
                    speed = 3f;
                    height = 15f;
                    width = 30f;
                    pierce = true;
                    pierceBuilding = true;
                    pierceCap = 7;
                    damage = 250f;
                    lifetime = 95f;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    collidesTiles = true;
                    trailEffect = Fx.missileTrail;
                    trailInterval = 3f;
                    trailParam = 4f;
                    speed = 3f;
                    damage = 75f;
                    lifetime = 60f;
                    width = height = 15f;
                    shrinkX = shrinkY = 0f;
                    trailColor = Color.valueOf("8B73C7");
                    trailLength = 12;
                    trailWidth = 2.2f;
                    despawnEffect = hitEffect = new ExplosionEffect(){{
                        waveColor = Pal.sapBullet;
                        smokeColor = Color.gray;
                        sparkColor = Pal.sap;
                        waveStroke = 4f;
                        waveRad = 40f;
                    }};
                    intervalBullet = new LightningBulletType(){{
                    damage = 16;
                    collidesAir = false;
                    ammoMultiplier = 1f;
                    lightningColor = Pal.sapBullet;
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
                    bulletInterval = 4f;

                    lightningColor = Color.valueOf("8B73C7");
                    lightningDamage = 17;
                    lightning = 8;
                    lightningLength = 2;
                    lightningLengthRand = 8;
                    despawnSound = Sounds.spark;
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootBigSmoke;
                }};
                shootSound = Sounds.shockBlast;
            }});
            blade.add(
                new Blade(name + "-wing"){{
                y = -4f; x = 10f;
                bladeMoveSpeed = 80f;
                bladeBlurAlphaMultiplier = 0.5f;
                //bladeLayer = -1f;
            }},
            new Blade(name + "-wing2"){{
                y = 3f; x = 8f;
                bladeMoveSpeed = 80f;
                bladeBlurAlphaMultiplier = 0.5f;
                //bladeLayer = -1f;
            }});
            healColor = Color.valueOf("590e14");
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (70f * 60f * 2f) * 100f;}});
            abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.neoplasm;}});
        }};

        Slasher = new JPCopterUnitType("Slasher"){{
            speed = 1.75f;
            armor = 6;
            hitSize = 18f;
            health = 2700;
            range = 125f;    
            flying = true;
            drag = 0.05f;
            accel = 0.11f;
            engineSize = 0f;

            weapons.add(new Weapon(name + "-Invis"){{
                mirror = false;
                shoot.firstShotDelay = 125f;
                shoot = new ShootSpread(10, 5f);
                velocityRnd = 0.4f;
                inaccuracy = 7f;
                reload = 200f;
                recoil = 6f;
                x = 0f;
                y = 8f;
                layerOffset = -1f;
                bullet = new MissileBulletType(3.7f, 18){{
                    width = 8f;
                    height = 8f;
                    splashDamageRadius = 25f;
                    splashDamage = 65f;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                    weaveScale = 8f;
                    weaveMag = 2f;
                }};
                shootSound = Sounds.missile;
            }});
            blade.add(
                new Blade(name + "-wing"){{
                y = -1f; x = 10f;
                bladeMoveSpeed = 80f;
                bladeBlurAlphaMultiplier = 0.5f;
                //bladeLayer = -1f;
            }});
            parts.add(new RegionPart("-Heart"){{
                mirror = false;
                progress = PartProgress.warmup;
                layerOffset= -0.0001f;
                under = true;
                x = 0f;
                y = 0f;
                //moveX = -1.5f;
                moveY = 8f;
                moveRot = 0f;
            }});
            parts.add(new RegionPart("-blade"){{
                mirror = true;
                progress = PartProgress.warmup;
                layerOffset= -0.0001f;
                under = true;
                x = 3f;
                y = 3f;
                moveX = 1.5f;
                moveY = 1.25f;
                moveRot = -10f;
            }});
            healColor = Color.valueOf("590e14");
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (120f * 60f * 2f) * 100f;}});
            abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.neoplasm;}});
        }};
            
            FrostC = new UnitType("FrostC"){{
                this.constructor = LegsUnit::create;
                speed = 0.25f;
                hitSize = 8f;
                health = 58000;
                armor = 30;
                range = 80f;
                legCount = 4;
                legLength = 13f;
                legExtension = 7f;
                legBaseOffset = 6f;
                weapons.add(new Weapon() {{
                    shoot.firstShotDelay = 180;
                    reload = 750;
                    recoil = 12;
                    mirror = false;
                    rotate = false;
                    x = 0;
                    y = 0;
                    shootSound = JPSounds.ArtyBig;
                    bullet = new BasicBulletType(0.5f, 1500f) {{
                        rangeOverride = 100f;
                        chargeEffect = Fx.none;
                        shootStatus = StatusEffects.unmoving;
                        despawnEffect = Fx.blastExplosion;
                        shootStatusDuration = 210f;
                        hittable = false;
                        width = 145;
                        height = 145;
                        backColor = Color.valueOf("87ceeb");
                        frontColor = Color.white;
                        lightColor = Color.valueOf("87ceeb");
                        shrinkX = 0;
                        shrinkY = 0;
                        lifetime = 1800f;
                        lightRadius = 70f;
                        clipSize = 250f;
                        sprite = "circle-bullet";
                        splashDamage = 1800f;
                        splashDamageRadius = 100f;
                        hitShake = 8f;
                        pierce = true;
                        splashDamagePierce = true;
                        trailLength = 175;
                        trailWidth = 65;
                        trailColor = Color.valueOf("87ceeb");
                        hitEffect = despawnEffect = JPFx.bulletExplosion;
                        intervalBullet = new LightningBulletType(){{
                            damage = 800;
                            collidesAir = false;
                            lightningColor = Color.valueOf("87ceeb");
                            lightningLength = 24;
                            lightningLengthRand = 25;

                            //for visual stats only.
                            buildingDamageMultiplier = 0.25f;
                        }};
                        chargeEffect = new MultiEffect(
                        new WaveEffect(){{
                            colorFrom = colorTo = Color.valueOf("87ceeb");
                            sizeFrom = 160f;
                            sizeTo = 0f;
                            lifetime = 90f;
                            strokeFrom = 0f;
                            strokeTo = 10f;
                        }},
                        new WaveEffect(){{
                            colorFrom = colorTo = Color.valueOf("87ceeb");
                            sizeFrom = 200f;
                            sizeTo = 0f;
                            lifetime = 120f;
                            strokeFrom = 0f;
                            strokeTo = 12f;
                        }},
                        new WaveEffect(){{
                            colorFrom = colorTo = Color.valueOf("87ceeb");
                            sizeFrom = 280f;
                            sizeTo = 0f;
                            lifetime = 180f;
                            strokeFrom = 0f;
                            strokeTo = 15f;
                        }}
                    );
                    }};
                }});
                healColor = Color.valueOf("87ceeb");
                outlineColor = Color.valueOf("303a45");
                parts.add(new RegionPart("-hand"){{
                    mirror = true;
                    progress = PartProgress.warmup;
                    layerOffset= -0.0001f;
                    under = true;
                    x = 3f;
                    y = 3f;
                    moveX = 1.5f;
                    moveY = 2f;
                    moveRot = -10f;
                }});
                hidden = true;
                immunities.add(StatusEffects.burning);
                immunities.add(StatusEffects.melting);
                immunities.add(StatusEffects.freezing);
                immunities.add(StatusEffects.sporeSlowed);
                immunities.add(StatusEffects.slow);
                abilities.add(new RegenAbility(){{percentAmount = 1f / (800f * 60f * 2f) * 100f;}});
                abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.cryofluid;}});
                abilities.add(new StatusFieldAbility(JPStatus.Frostshield, 60f * 3, 60f * 5f, 60f));
            }};

            Frost = new UnitType("Frost"){{
                this.constructor = LegsUnit::create;
                speed = 0.25f;
                hitSize = 8f;
                health = 58000;
                armor = 30;
                range = 80f;
                legCount = 4;
                legLength = 13f;
                legExtension = 7f;
                legBaseOffset = 6f;
                weapons.add(new Weapon("Flamethrowar"){{
                    reload = 5f;
                    x = 0f;
                    y = 7f;
                    recoil = 0f;
                    mirror = false;
                    shootStatus = JPStatus.Frostshield;
                    shootStatusDuration = 80f;
                    shootSound = Sounds.flame;
                    ejectEffect = Fx.none;
                    bullet = new BasicBulletType(2.5f, 9){{
                        statusDuration = 60f * 4;
                        status = StatusEffects.freezing;
                        collidesAir = true;
                        shootEffect = Fx.none;
                        speed = 6f;
                        width = 0.1f;
                        height = 0.1f;
                        damage = 250f;
                        lifetime = 25f;
                        pierce = true;
                        pierceBuilding = true;
                        despawnEffect = Fx.none;
                        pierceCap = 5;
                        hittable = false;
                        reflectable = false;
                        shootEffect = new ParticleEffect() {{
                            particles = 360;
                            sizeFrom = 4f;
                            sizeTo = 0f;
                            length = 200f;
                            lifetime = 30f;
                            lightColor = Color.valueOf("87ceeb");
                            colorFrom = Color.valueOf("87ceeb");
                            colorTo = Color.valueOf("87ceeb");
                            cone = 10f;
                        }};
                    }};
                }});
                weapons.add(new Weapon("Thingy"){{
                    range = 150f;
                    reload = 198419841984f;
                    x = 0f;
                    y = 7f;
                    recoil = 0f;
                    mirror = false;
                    shootStatus = JPStatus.ReversionD;
                    shootStatusDuration = 300f;
                    shoot.firstShotDelay = 301f;
                    ejectEffect = Fx.none;
                bullet = new BasicBulletType(25f, 500){{
                    rangeOverride = 200f;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lifetime = 15f;
                    splashDamage = 2000f;
                    splashDamageRadius = 25.5f;
                    recoil = -125f;
                    trailLength = 60;
                    trailWidth = 8f;
                    trailColor = Color.valueOf("8B73C7");
                    trailInterval = 3f;
                    despawnSound = Sounds.spark;
                    hitEffect = new MultiEffect(
                        new WaveEffect(){{
                            colorFrom = colorTo = Color.valueOf("8B73C7");
                            sizeFrom = 0f;
                            sizeTo = 90f;
                            lifetime = 25f;
                            strokeFrom = 0f;
                            strokeTo = 5.5f;
                        }}
                    );
                }};
                }});
                weapons.add(new Weapon("AG"){{
                    reload = 2500f;
                    x = 0f;
                    y = 0f;
                    mirror = false;
                    alwaysShooting = true;
                    recoil = 0f;
                    shootStatus = JPStatus.Frostshield;
                    shootStatusDuration = 360f;
                    shootSound = Sounds.none;
                    ejectEffect = Fx.none;
                    bullet = new BasicBulletType(5f,0){{
                        rangeOverride = 1f;
                        lifetime = 1f;
                        fragBullets = 4;
                        fragBullet = new BasicBulletType(3f,250f){{
                            width = 20f;
                            height = 20f;
                            shrinkX = shrinkY = 0.1f;
                            lifetime = 20f;
                            sprite = "jp-Target";
                            fragBullets = 1;
                            fragBullet = new BasicBulletType(0,0){{
                                spawnUnit = JPUnits.Autus;
                            }};
                        }};
                    }};
                }});
                healColor = Color.valueOf("87ceeb");
                outlineColor = Color.valueOf("303a45");
                parts.add(new RegionPart("-hand"){{
                    mirror = true;
                    progress = PartProgress.warmup;
                    layerOffset= -0.0001f;
                    under = true;
                    x = 3f;
                    y = 3f;
                    moveX = -1.5f;
                    moveY = -1.25f;
                    moveRot = 10f;
                }});
                deathExplosionEffect = JPFx.bulletExplosion;
                immunities.add(StatusEffects.burning);
                immunities.add(StatusEffects.melting);
                immunities.add(StatusEffects.freezing);
                abilities.add(new SpawnDeathAbility(FrostC, 1, 0f));
                abilities.add(new RegenAbility(){{percentAmount = 1f / (800f * 60f * 2f) * 100f;}});
                abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.cryofluid;}});
                abilities.add(new StatusFieldAbility(JPStatus.Frostshield, 60f * 3, 60f * 9f, 60f));
            }};

        Hivedefender = new UnitType("Hivedefender"){{
            this.constructor = UnitEntity::create;
            speed = 2.75f;
            armor = 1;
            hitSize = 18f;
            health = 175;
            range = 125f;    
            flying = true;
            engineOffset = 7f;
            engineSize = 4f;
            mineSpeed = 2f;
            buildSpeed = 1;
            mineTier = 3;
            drag = 0.05f;
            accel = 0.11f;
            weapons.add(new Weapon(name + "-gun"){{
                reload = 75f;
                x = -6f;
                y = 2f;
                layerOffset = -1f;
                mirror = true;
                shoot.shots = 2;
                shoot.shotDelay = 5f;
                recoil = 2.5f;
                bullet = new BasicBulletType(5f, 15){{
                    height = width = 10f;
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootBigSmoke;
                    buildingDamageMultiplier = 0.05f;
                    lifetime = 50f;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    collidesTiles = true;
                }};
            }});
            outlineColor = Color.valueOf("303a45"); 
            abilities.add(new RegenAbility(){{percentAmount = 1f / (60f * 60f * 2f) * 100f;}});
        }};

        HiveSentinel = new UnitType("HiveSentinel"){{
            this.constructor = UnitEntity::create;
            speed = 2.5f;
            armor = 2;
            hitSize = 18f;
            health = 400;
            range = 125f;    
            flying = true;
            engineOffset = 12f;
            engineSize = 4f;
            mineSpeed = 3f;
            buildSpeed = 2;
            mineTier = 4;
            drag = 0.05f;
            accel = 0.11f;
            weapons.add(new Weapon(name + "-gun"){{
                reload = 65f;
                x = -9f;
                y = 5f;
                layerOffset = -1f;
                mirror = true;
                shoot.shots = 4;
                shoot.shotDelay = 5f;
                recoil = 4f;
                bullet = new BasicBulletType(4.5f, 25){{
                    height = width = 15f;
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootBigSmoke;
                    buildingDamageMultiplier = 0.05f;
                    lifetime = 50f;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    collidesTiles = true;
                }};
            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (60f * 60f * 2f) * 100f;}});
        }};

        Sporophage = new UnitType("Sporophage"){{
            this.constructor = UnitEntity::create;
            speed = 2f;
            armor = 3;
            hitSize = 17f;
            health = 425;
            range = 125f;      
            flying = true;
            mineSpeed = 3.5f;
            buildSpeed = 2.5f;
            mineTier = 6;
            engineOffset = 12f;
            engineSize = 4f;
            drag = 0.05f;
            accel = 0.11f;
            weapons.add(new Weapon("-Mouh"){{
                reload = 75f;
                shootY = 8f;
                x = 0f;
                y = 0f;
                continuous = true;
                shoot.firstShotDelay = JPFx.purpleLaserChargeSmall.lifetime -1f;
                chargeSound = Sounds.lasercharge2;
                shootSound = Sounds.beam;
                shootStatus = StatusEffects.slow;
                shootStatusDuration = 60f * 3;
                mirror = false;
                bullet = new ContinuousLaserBulletType(50f){{
                    width = 2f;
                    length = 75f;
                    drawSize = 100f;
                    lifetime = 125f;
                    healPercent = 0.5f;
                    collidesTeam = true;
                    buildingDamageMultiplier = 0.10f;
                    colors = new Color[]{Color.valueOf("8B73C7"), Color.valueOf("A865C9"), Color.valueOf("A865C9"), Color.valueOf("ffffff")};
                    chargeEffect = JPFx.purpleLaserChargeSmall;
                }};
            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (75f * 60f * 2f) * 100f;}});
        }};
}}