package jp.content.blocks;

import arc.Core;
import arc.graphics.*;
import arc.math.Mathf;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.WrapEffect;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;
import jp.content.*;
import mindustry.content.*;
import mindustry.world.meta.*;


import static mindustry.Vars.tilesize;
import static mindustry.content.UnitTypes.block;
import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;


public class JPProduction{
    public static Block
        extractor,zincExtractor,
        massCultivator,
        nanoProcessor,naniteInfuser,carbideCompositeSmelter,fluoresiltRefinery,voltaicChamber,bioSynthesizer,vanadiumCarbideAlloyer,neostabilizer,neodestabilizer,
        biomassReactor,neocellGenerator,lotusPanel,oilBurner,voltaicBurner,lunarFactory,lunarCrusher;

        public static void load(){

        nanoProcessor = new GenericCrafter("nanoProcessor"){{
            requirements(Category.crafting, with(silicon, 60, graphite, 45));
            envEnabled = Env.spores;
            health = 125;
            size = 2;
            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.biomass, 1);
            craftTime = 45f;
            hasItems = true;
            hasPower = true;
            consumePower(1f);
            consumeItem(sporePod, 5);
            drawer = new DrawMulti(
            new DrawRegion("-bottom"),
            new DrawDefault(),
            new DrawWarmupRegion(){{
                region = Core.atlas.find(block.name + "-warmup");
                color = Color.valueOf("8B73C7");
            }},
            new DrawRegion("-rotor"){{
                rotateSpeed = 2f;
            }},
            new DrawRegion("-rotor"){{
                rotateSpeed = -2f;
                rotation = 45f;
            }},
            new DrawRegion("-top")
            );
            
            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        naniteInfuser = new GenericCrafter("naniteInfuser"){{
            requirements(Category.crafting, with(silicon, 325, graphite, 275,JPItem.biosil,95));
            envEnabled = Env.spores;
            health = 350;
            size = 2;
            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.naniteAlloy, 1);
            craftTime = 50f;
            hasPower = true;
            hasItems = true;
            consumePower(5f);
            consumeItems(with(JPItem.biomass, 5,JPItem.biosil,5,silicon,10));

            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion(){{
                color = Color.valueOf("8B73C7");
            }});

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        carbideCompositeSmelter = new GenericCrafter("carbideCompositeSmelter"){{
            requirements(Category.crafting, with(JPItem.vanadium,300,JPItem.biosil, 250,JPItem.naniteAlloy, 225));
            envEnabled = Env.spores;
            health = 475;
            size = 2;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(JPItem.Carbinecomposite, 1);
            craftTime = 80f;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("8B73C7")));
            hasPower = true;
            hasItems = true;

            consumePower(4f);
            consumeItems(with(JPItem.biosil, 2,JPItem.vanadium,4,JPItem.naniteAlloy, 3));

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        vanadiumCarbideAlloyer = new HeatProducer("vanadiumCarbideAlloyer"){{
            requirements(Category.crafting, with(silicon, 270,JPItem.biomass, 125,JPItem.vanadium, 450));
            envEnabled = Env.spores;
            health = 750;
            size = 2;
            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.vanadiumCarbideAlloy, 1);
            craftTime = 50f;
            hasItems = true;
            hasPower = true;
            heatOutput = 5f;
            consumePower(5f);
            consumeItems(with(JPItem.vanadium, 5,JPItem.biosil, 3));

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        fluoresiltRefinery = new GenericCrafter("fluoresiltRefinery"){{
            requirements(Category.crafting, with(JPItem.biomass, 45,silicon, 75, graphite, 125));
            envEnabled = Env.spores;
            health = 120;
            size = 2;
            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.fluorite, 1);
            craftTime = 50f;
            hasPower = true;
            hasItems = true;

            consumePower(1f);
            consumeItem(JPItem.fluoresilt, 3);

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        voltaicChamber = new GenericCrafter("voltaicChamber"){{
            requirements(Category.crafting, with(graphite, 225,JPItem.biomass, 115, plastanium, 75));
            envEnabled = Env.spores;
            health = 360;
            size = 3;
            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.voltaicGas, 1);
            craftTime = 70f;
            hasItems = true;
            hasPower = true;
            hasLiquids = true;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.water, 1f){{drawLiquidLight = true;}}, new DrawDefault());
            consumePower(5f);
            consumeItem(sporePod, 5);
            consumeLiquid(Liquids.water, 15f / 60f);

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);            
        }};

        bioSynthesizer = new GenericCrafter("bioSynthesizer"){{
            requirements(Category.crafting, with(JPItem.biomass, 100,silicon, 75, graphite, 125));
            envEnabled = Env.spores;
            health = 360;
            size = 3;
            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.biosil, 1);
            craftTime = 80f;
            hasItems = true;
            hasPower = true;
            consumePower(5f);
            consumeItems(with(JPItem.biomass, 3,silicon, 2,graphite, 2));

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);           
        }};

        neostabilizer = new GenericCrafter("neostabilizer"){{
            requirements(Category.crafting, with(JPItem.biomass, 250,JPItem.naniteAlloy, 75,JPItem.Carbinecomposite, 75));
            envEnabled = Env.spores;
            health = 1000;
            size = 3;
            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.neocell, 1);
            craftTime = 45f;
            hasItems = true;
            hasPower = true;
            hasLiquids = true;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.water), new DrawLiquidTile(Liquids.neoplasm){{drawLiquidLight = true;}}, new DrawDefault());
            consumePower(10f);
            consumeItems(with(JPItem.vanadium, 4,JPItem.zinc, 2));
            consumeLiquid(Liquids.neoplasm, 6f / 60f);

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        neodestabilizer = new JPELF("neodestabilizer"){{
            requirements(Category.crafting, with(JPItem.biomass, 325,JPItem.naniteAlloy, 125,JPItem.Carbinecomposite, 125));
            envEnabled = Env.spores;
            health = 1150;
            size = 4;
            craftEffect = Fx.pulverizeMedium;
            craftTime = 60f;
            hasItems = true;
            hasPower = true;
            hasLiquids = true;
            liquidCapacity = 200f;
            consumePower(5f);
            consumeItem(JPItem.neocell, 1);
            outputLiquid = new LiquidStack(Liquids.neoplasm, 6f / 60f);
            drawer = new DrawMulti(new DrawRegion("-bottom"),
                    new DrawLiquidRegion(Liquids.neoplasm),
                    new DrawAdvancedPistons(){{
                        suffix = "-p";
                        sinMag = 2f;
                        sinScl = 10f;
                        sideOffset = Mathf.pi * 2;
                    }},
                    new DrawPistons(){{
                        suffix = "-ep";
                        sinMag = 2.75f;
                        sinScl = 5f;
                        sides = 4;
                        sideOffset = Mathf.PI / 2f;
                    }},
                    new DrawDefault(),
                    new DrawRegion("-rotor"){{
                        spinSprite = true;
                        rotateSpeed = 2f;
                    }});
            ambientSound = Sounds.loopBio;
            ambientSoundVolume = 0.2f;

            explosionRadius = 7;
            explosionDamage = 1500;
            explodeEffect = new MultiEffect(Fx.bigShockwave, new WrapEffect(Fx.titanSmoke, Liquids.neoplasm.color), Fx.neoplasmSplat);
            explodeSound = Sounds.explosionReactorNeoplasm;
            explosionPuddles = 40;
            explosionPuddleRange = tilesize * 3f;
            explosionPuddleLiquid = Liquids.neoplasm;
            explosionPuddleAmount = 60f;
            explosionMinWarmup = 0.5f;

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        extractor = new Drill("extractor"){{
            requirements(Category.production, with(silicon, 15,graphite, 30));
            envEnabled = Env.spores;
            health = 275;
            tier = 4;
            size = 2;
            drillTime = 125f;
            itemCapacity = 25;
            drillMultipliers.put(Items.copper, 0f);
            drillMultipliers.put(Items.lead, 0f);
            drillMultipliers.put(Items.titanium, 0f);
            drillMultipliers.put(Items.thorium, 0f);
            drillMultipliers.put(Items.scrap, 0f);
            drillMultipliers.put(Items.beryllium, 0f);
            drillMultipliers.put(Items.tungsten, 0f);
            hasLiquids = true;
            consumeLiquid(Liquids.water, 0.05f).boost();

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        zincExtractor = new GenericCrafter("zincExtractor"){{
            requirements(Category.production, with(silicon, 45,JPItem.biomass, 25,JPItem.vanadium, 125));
            envEnabled = Env.spores;
            health = 625;
            size = 2;
            outputItem = new ItemStack(JPItem.zinc, 1);
            consumePower(5f);
            consumeItems(with(JPItem.biomass, 2));
            drawer = new DrawMulti(new DrawDefault(), new DrawRegion("-rotator"){{
                spinSprite = true;
                rotateSpeed = 2f;
            }},
            new DrawRegion("-top"));

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        massCultivator = new GenericCrafter("massCultivator"){{
            requirements(Category.production, with(silicon, 450,metaglass, 350,JPItem.biomass, 75));
            envEnabled = Env.any;
            health = 750;
            size = 3;
            outputItem = new ItemStack(sporePod, 5);
            craftTime = 50f;
            hasItems = true;
            itemCapacity = 50;
            hasPower = true;
            hasLiquids = true;
            liquidCapacity = 300f;
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidRegion(Liquids.water){{
                        suffix = "-bottom";
                    }},
                    new DrawCultivator(),
                    new DrawDefault(),
                    new DrawRegion("-top")
            );
            consumePower(10f);
            consumeLiquid(Liquids.water, 18f / 60f);

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};
        
        //Power blocks

        oilBurner = new ConsumeGenerator("oilBurner"){{
            requirements(Category.power, with(silicon, 75,graphite, 125,JPItem.biomass, 45));
            envEnabled = Env.spores;
            health = 180;
            size = 1;
            powerProduction = 3.75f;
            liquidCapacity = 25f;
            consumeLiquid(Liquids.oil, 0.2f);
            ambientSound = Sounds.loopSmelter;
            ambientSoundVolume = 0.03f;
            generateEffect = Fx.generatespark;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("8B73C7")));

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        voltaicBurner = new ConsumeGenerator("voltaticBurner"){{
            requirements(Category.power, with(silicon, 125,JPItem.naniteAlloy, 65,JPItem.biomass, 45));
            envEnabled = Env.spores;
            health = 450;
            size = 2;
            powerProduction = 12f;
            itemDuration = 180f;
            consumeItem(JPItem.voltaicGas);
            ambientSound = Sounds.loopSmelter;
            ambientSoundVolume = 0.06f;
            generateEffect = Fx.generatespark;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("8B73C7")));

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        neocellGenerator = new JPBoostableCG("neocellGenerator"){{
            requirements(Category.power, with(silicon, 225,JPItem.vanadium, 75,JPItem.neocell, 95));
            envEnabled = Env.spores;
            health = 650;
            size = 2;
            powerProduction = 15f;
            itemDuration = 360f;
            consumeItem(JPItem.neocell);
            //troll emoji
            liquidBoostIntensity = 3f;
            consumeLiquid(Liquids.neoplasm, 18f / 60f).boost();

            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion(){{
                color = Color.valueOf("9e3736");
            }});

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        lotusPanel = new SolarGenerator("lotusPanel"){{
            requirements(Category.power, with(silicon, 175,JPItem.vanadium, 125,JPItem.biomass, 50));
            envEnabled = Env.spores;
            health = 625;
            size = 4;
            powerProduction = 3f;

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        biomassReactor = new ImpactReactor("biomassReactor"){{
            requirements(Category.power, with(silicon, 225,JPItem.biomass, 115, JPItem.vanadium, 75,JPItem.naniteAlloy, 95));
            envEnabled = Env.spores;
            health = 1750;
            size = 4;
            hasLiquids = false;
            itemDuration = 90f;
            consumePower(10f);
            powerProduction = 55f;
            consumeItem(JPItem.biomass);
            warmupSpeed = 0.0025f;
            explosionRadius = 10;
            explosionDamage = 4000;
            ambientSound = Sounds.loopPulse;
            ambientSoundVolume = 0.07f;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawPlasma(), new DrawDefault(), new DrawWarmupRegion(){{
                color = Color.valueOf("8B73C7");
            }});

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        lunarFactory = new GenericCrafter("lunarFactory"){{
            requirements(Category.crafting, with(JPItem.vanadium, 75, JPItem.fluorite, 45));
            envEnabled = Env.spores;
            health = 750;
            size = 2;
            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.umbratechChip, 1);
            craftTime = 50f;
            hasItems = true;
            hasPower = true;
            consumePower(5f);
            consumeItems(with(JPItem.fluorite, 2,JPItem.voidStone, 3, JPItem.vanadium, 3));

            shownPlanets.add(Planets.gier);
        }};

        lunarCrusher = new GenericCrafter("lunarCrusher"){{
            requirements(Category.crafting, with(JPItem.vanadium, 75, JPItem.fluorite, 45));
            envEnabled = Env.spores;
            health = 750;
            size = 2;
            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.vanadiumCarbideAlloy, 1);
            craftTime = 50f;
            hasItems = true;
            hasPower = true;
            consumePower(5f);
            consumeItems(with(JPItem.vanadium, 5,JPItem.biosil, 3));

            shownPlanets.add(Planets.gier);
        }};

        }}

