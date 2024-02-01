package javapod.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.content.*;
import mindustry.type.ammo.*;
import mindustry.type.unit.*;
import mindustry.type.weapons.*;
import mindustry.entities.abilities.UnitSpawnAbility;
import mindustry.world.meta.*;
import javapod.content.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class JavapodUnits {
    public static UnitType
    //Legs
    Carci,Imp, Baslisk, Autus, Baneling, Zergling, Behomoth, Lobber, Breacher, Scarabid,
    //missiles
    Bomb,
    //Floaty
    Guardian,Thera,DeathImp,Drone,Interceptor;



        public static void load(){

        DeathImp = new UnitType("DeathImp"){{
            this.constructor = UnitEntity::create;
            speed = 1.75f;
            hitSize = 8f;
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
                bullet = new BombBulletType(2.5f, 9){{
                    rangeOverride = 30f;
                    width = 0f;
                    height = 0f;
                    lifetime = 10f;
                    splashDamage = 175f;
                    splashDamageRadius = 60f;
                    killShooter = true;
                }};
            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.neoplasm;}});
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
                bullet = new BombBulletType(2.5f, 9){{
                    rangeOverride = 30f;
                    width = 0f;
                    height = 0f;
                    lifetime = 10f;
                    splashDamage = 175f;
                    splashDamageRadius = 60f;
                    killShooter = true;
                }};
            }});

            healColor = Color.valueOf("590e14");
            outlineColor = Color.valueOf("303a45");
            abilities.add(new SpawnDeathAbility(DeathImp, 1, 11f));
            abilities.add(new RegenAbility(){{percentAmount = 1f / (70f * 60f) * 100f;}});
            abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.neoplasm;}});
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
                bullet = new BombBulletType(2.5f, 9){{
                    rangeOverride = 30f;
                    width = 0f;
                    height = 0f;
                    lifetime = 10f;
                    splashDamage = 200f;
                    splashDamageRadius = 60f;
                    killShooter = true;
                }};
            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (120f * 60f) * 100f;}});
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
                    lifetime = 75f;
                    damage = 25f;
                }};
            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (120f * 60f) * 100f;}});
            }};
            Autus = new UnitType("Autus"){{
            this.constructor = LegsUnit::create;
            speed = 1f;
            hitSize = 8f;
            health = 1500;
            armor = 4;
            range = 40f;
            legCount = 4;
            legLength = 13f;
            legExtension = 7f;
            legBaseOffset = 6f;
            weapons.add(new Weapon(name + "-flamer"){{

                top = true;
                reload = 5f;
                x = 0f;
                y = 0f;
                mirror = false;
                recoil = 0f;
                shootStatus = StatusEffects.shielded;
                shootStatusDuration = 80f;
                shootSound = Sounds.flame;
                ejectEffect = Fx.none;
                bullet = new BasicBulletType(2.5f, 9){{
                    collidesAir = true;
                    damage = 65f;
                    lifetime = 15f;
                    lightColor = Color.valueOf("8B73C7");
                    pierce = true;
                    pierceBuilding = true;
                    pierceCap = 3;
                    shootEffect = new ParticleEffect() {{
                    particles = 30;
                    sizeFrom = 5f;
                    sizeTo = 0f;
                    length = 80f;
                    lifetime = 25f;
                    lightColor = Color.valueOf("8B73C7");
                    colorFrom = Color.valueOf("8B73C7");
                    colorTo = Color.valueOf("8B73C7");
                    cone = 10f;
                    hittable = false;
                    reflectable = false;
                }};
                }};
            }});
            healColor = Color.valueOf("590e14");
            outlineColor = Color.valueOf("303a45");
            parts.add(new RegionPart("-hand"){{
                mirror = true;
                progress = PartProgress.warmup;
                layerOffset= 0.0001f;
                under = true;
                x = 3f;
                y = 3f;
                moveX = -1.5f;
                moveY = -1.25f;
                moveRot = 10f;
            }});
            abilities.add(new RegenAbility(){{percentAmount = 1f / (70f * 60f) * 100f;}});
            abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.neoplasm;}});
        }};
        Thera = new UnitType("Thera"){{
            this.constructor = UnitEntity::create;
            speed = 1.75f;
            hitSize = 8f;
            health = 1150;
            range = 75f;
            engineOffset = 5f;
            engineSize = 4f;
            rotateSpeed = 7f;
            flying = true;
            hitSize = 9f;
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
                            splashDamage = 75f;
                            splashDamageRadius = 60f;
                    }};}});
                    healColor = Color.valueOf("590e14");
                    outlineColor = Color.valueOf("303a45");
                    }};
                }};
            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (70f * 60f) * 100f;}});
            abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.neoplasm;}});
        }};  
            Carci = new UnitType("Carci"){{
            this.constructor = LegsUnit::create;
            speed = 0.65f;
            targetAir = false;
            hitSize = 8f;
            health = 875;
            armor = 2;
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
            abilities.add(new RegenAbility(){{percentAmount = 1f / (70f * 60f) * 100f;}});
            abilities.add(new LiquidExplodeAbility(){{liquid = Liquids.neoplasm;}});
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
                y = 0f;
                mirror = false;
                bullet = new BasicBulletType(2.5f, 9){{
                    speed = 3f;
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootBigSmoke;
                    splashDamage = 30f;
                    splashDamageRadius = 25f;
                    lifetime = 50f;
                    statusDuration = 60f * 4;
                    status = StatusEffects.slow;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                    collidesTiles = true;
                    trailLength = 5;
                    trailColor = Color.valueOf("8B73C7");
                }};
            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (60f * 60f) * 100f;}});
        }};
            Behomoth = new UnitType("Behomoth"){{
            this.constructor = LegsUnit::create;
            speed = 0.65f;
            hitSize = 16f;
            health = 9000;
            range = 50f;
            legCount = 4;
            legLength = 30f;
            legExtension = -15f;
            legBaseOffset = 10f;
            weapons.add(new Weapon(name + "-gun"){{
                reload = 200f;
                x = 0f;
                y = -23f;
                recoil = 4f;
                mirror = false;
                bullet = new BasicBulletType(2.5f, 9){{
                    hitEffect = Fx.sapExplosion;
                    width = 15f;
                    height = 30f;
                    speed = 3f;
                    lifetime = 75f;
                    splashDamage = 150f;
                    splashDamageRadius = 25f;
                    statusDuration = 60f * 4;
                    status = StatusEffects.slow;
                    backColor = Color.valueOf("8B73C7");
                    frontColor = Color.valueOf("8B73C7");
                    lightColor = Color.valueOf("8B73C7");
                }};

            }});
            weapons.add(new Weapon(name + "-mini"){{
                reload = 15f;
                x = -15f;
                y = -23f;
                mirror = true;
                bullet = new BasicBulletType(2.5f, 9){{
                    hitEffect = Fx.sapExplosion;
                    collidesTiles = false;
                    width = 10f;
                    height = 10f;
                    speed = 3f;
                    lifetime = 55f;
                    damage = 45f;
                    backColor = Color.valueOf("CBC3E3");
                    frontColor = Color.valueOf("CBC3E3");
                }};

            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (200f * 60f) * 100f;}});
            abilities.add(new UnitSpawnAbility(Lobber,550f,0f,-7f));
            }};

            Guardian = new UnitType("Guardian"){{
            this.constructor = UnitEntity::create;
            speed = 1f;
            hitSize = 18f;
            health = 1500;
            armor = 4;
            range = 175f;
            legCount = 4;
            flying = true;
            engineOffset = 10f;
            engineSize = 4f;
            drag = 0.04f;
            accel = 0.08f;               
            weapons.add(new Weapon(name + "-gun"){{
                reload = 125f;
                x = 11f;
                y = 4f;
                mirror = true;
                bullet = new BasicBulletType(2.5f, 9){{
                    speed = 3f;
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootBigSmoke;
                    damage = 145f;
                    splashDamage = 30f;
                    splashDamageRadius = 5f;
                    lifetime = 110f;
                    statusDuration = 60f * 4;
                    status = JavapodStatus.Dissolving;
                    backColor = Color.valueOf("8FFE09");
                    frontColor = Color.valueOf("8FFE09");
                    lightColor = Color.valueOf("8FFE09");
                    collidesTiles = true;
                    trailLength = 3;
                    trailColor = Color.valueOf("bbfe6b");
                }};
            }});
            outlineColor = Color.valueOf("303a45");
            abilities.add(new RegenAbility(){{percentAmount = 1f / (120f * 60f) * 100f;}});
        }};
}}