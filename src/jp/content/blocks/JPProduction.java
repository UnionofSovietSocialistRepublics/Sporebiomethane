package jp.content.blocks;

import arc.Core;
import arc.graphics.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;
import jp.content.*;
import mindustry.content.*;

import static mindustry.content.UnitTypes.block;
import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;


public class JPProduction{
    public static Block
        Extractor,ZincExtractor,
        Masscultivator,
        Nanoprocessor,Naniteinfuser,CCB,FR,Gaschamber,BioSynthesizer,Vanadicarbide,Neostabilizer,Packageopener,
        Biomassreactor,Neocell,Lotus,Oilburner,Voltaicburner;

        public static void load(){

        Nanoprocessor = new GenericCrafter("Nanoprocessor"){{
            requirements(Category.crafting, with(silicon, 75, graphite, 90));
            health = 125;
            size = 2;
            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.Biomass, 1);
            craftTime = 50f;
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

        }};

        Naniteinfuser = new GenericCrafter("Naniteinfuser"){{
            requirements(Category.crafting, with(silicon, 325, graphite, 275,JPItem.BioSil,95));
            health = 350;
            size = 2;
            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.Nanitealloy, 1);
            craftTime = 50f;
            hasPower = true;
            hasItems = true;
            consumePower(5f);
            consumeItems(with(JPItem.Biomass, 5,JPItem.BioSil,5,silicon,10));

            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion(){{
                color = Color.valueOf("8B73C7");
            }});
        }};

        CCB = new GenericCrafter("Carbine-composite-smelter"){{
            requirements(Category.crafting, with(JPItem.Vanadium,600,JPItem.BioSil, 450,JPItem.Nanitealloy, 425));
            health = 475;
            size = 2;
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(JPItem.Carbinecomposite, 1);
            craftTime = 80f;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("8B73C7")));
            hasPower = true;
            hasItems = true;

            consumePower(4f);
            consumeItems(with(JPItem.BioSil, 2,JPItem.Vanadium,4,JPItem.Nanitealloy, 3));
        }};

        Vanadicarbide = new HeatProducer("Vanadicarbide"){{
            requirements(Category.crafting, with(silicon, 270,JPItem.Biomass, 125,JPItem.Vanadium, 450));
            health = 750;
            size = 2;
            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.VCA, 1);
            craftTime = 50f;
            hasItems = true;
            hasPower = true;
            heatOutput = 5f;
            consumePower(5f);
            consumeItems(with(JPItem.Vanadium, 5,JPItem.BioSil, 3));
        }};

        FR = new GenericCrafter("Fluoresilt-refinery"){{
            requirements(Category.crafting, with(JPItem.Biomass, 250,silicon, 150, graphite, 145));
            health = 120;
            size = 2;
            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.Fluorite, 1);
            craftTime = 50f;
            hasPower = true;
            hasItems = true;

            consumePower(1f);
            consumeItem(JPItem.Fluoresilt, 3);
        }};

        Gaschamber = new GenericCrafter("Voltaicchamber"){{
            requirements(Category.crafting, with(graphite, 375,titanium, 250, plastanium, 75));
            health = 360;
            size = 3;
            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.Voltaicgas, 1);
            craftTime = 70f;
            hasItems = true;
            hasPower = true;
            hasLiquids = true;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.water, 1f){{drawLiquidLight = true;}}, new DrawDefault());
            consumePower(5f);
            consumeItem(sporePod, 5);
            consumeLiquid(Liquids.water, 15f / 60f);
        }};

        BioSynthesizer = new GenericCrafter("BioSynthesizer"){{
            requirements(Category.crafting, with(JPItem.Biomass, 375,silicon, 150, graphite, 90));
            health = 360;
            size = 3;
            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.BioSil, 1);
            craftTime = 80f;
            hasItems = true;
            hasPower = true;
            consumePower(5f);
            consumeItems(with(JPItem.Biomass, 3,silicon, 2,graphite, 2));
        }};

        Neostabilizer = new GenericCrafter("Neostabilizer"){{
            requirements(Category.crafting, with(JPItem.Biomass, 650,JPItem.Nanitealloy, 450,JPItem.Carbinecomposite, 450));
            health = 1000;
            size = 3;
            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.Neocells, 1);
            craftTime = 60f;
            hasItems = true;
            hasPower = true;
            hasLiquids = true;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.water), new DrawLiquidTile(Liquids.neoplasm){{drawLiquidLight = true;}}, new DrawDefault());
            consumePower(10f);
            consumeItems(with(JPItem.Vanadium, 4,JPItem.Zinc, 2));
            consumeLiquid(Liquids.neoplasm, 6f / 60f);
        }};

        Packageopener = new GenericCrafter("Package-opener"){{
            requirements(Category.crafting, with(JPItem.Biomass, 650,JPItem.Nanitealloy, 450,JPItem.Carbinecomposite, 450));
            health = 2400;
            size = 3;
            craftEffect = Fx.pulverizeMedium;
            inputItem = new ItemStack(JPItem.Neocells, 1);
            craftTime = 60f;
            hasItems = true;
            hasPower = true;
            hasLiquids = true;
            explodeOnFull = true;
            consumePower(25f);
            consumeItems(with(JPItem.Vanadium, 4,JPItem.Zinc, 2));
            outputLiquid = new LiquidStack(Liquids.cyanogen, 6f / 60f);
        }};

        Masscultivator = new GenericCrafter("Masscultivator"){{
            requirements(Category.production, with(silicon, 650,JPItem.Biomass, 250,thorium, 450));
            health = 750;
            size = 3;
            outputItem = new ItemStack(sporePod, 5);
            craftTime = 75f;
            hasItems = true;
            itemCapacity = 50;
            hasPower = true;
            hasLiquids = true;
            drawer = new DrawMulti(
            new DrawRegion("-bottom"), 
            new DrawLiquidTile(Liquids.water), 
            new DrawDefault(),
            new DrawCultivator(),
            new DrawRegion("-top")
            );
            consumePower(10f);
            consumeLiquid(Liquids.water, 18f / 60f);
        }};

        ZincExtractor = new GenericCrafter("ZincExtractor"){{
            requirements(Category.production, with(silicon, 175,JPItem.Vanadium, 125,JPItem.Biomass, 50));
            health = 625;
            size = 2;
            outputItem = new ItemStack(JPItem.Zinc, 1);
            consumePower(5f);
            consumeItems(with(JPItem.Biomass, 2));
            drawer = new DrawMulti(new DrawDefault(), new DrawRegion("-rotator"){{
                spinSprite = true;
                rotateSpeed = 2f;
            }},
            new DrawRegion("-top"));
        }};

        Extractor = new Drill("Extractor"){{
            requirements(Category.production, with(silicon, 25,graphite, 30));
            health = 300;
            tier = 4;
            size = 2;
            hasLiquids = true;
            drillTime = 150f;
            itemCapacity = 40;
            drillMultipliers.put(Items.copper, 0f);
            drillMultipliers.put(Items.lead, 0f);
            drillMultipliers.put(Items.titanium, 0f);
            drillMultipliers.put(Items.thorium, 0f);
            drillMultipliers.put(Items.scrap, 0f);
            drillMultipliers.put(Items.beryllium, 0f);
            drillMultipliers.put(Items.tungsten, 0f);
            consumeLiquid(Liquids.water, 0.05f).boost();
        }};
        
        //Power blocks

        Oilburner = new ConsumeGenerator("Oil-burner"){{
            requirements(Category.power, with(silicon, 75,graphite, 125,JPItem.Biomass, 45));
            health = 180;
            size = 1;
            powerProduction = 3.75f;
            liquidCapacity = 25f;
            consumeLiquid(Liquids.oil, 0.2f);
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.03f;
            generateEffect = Fx.generatespark;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("8B73C7")));
        }};

        Voltaicburner = new ConsumeGenerator("Voltatic-burner"){{
            requirements(Category.power, with(silicon, 125,JPItem.Nanitealloy, 65,JPItem.Biomass, 45));
            health = 450;
            size = 2;
            powerProduction = 12.25f;
            itemDuration = 110f;
            consumeItem(JPItem.Voltaicgas);
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.06f;
            generateEffect = Fx.generatespark;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("8B73C7")));
            
        }};

        Neocell = new ConsumeGenerator("Neocell-generator"){{
            requirements(Category.power, with(silicon, 225,JPItem.Vanadium, 75,JPItem.Neocells, 95));
            health = 650;
            size = 2;
            powerProduction = 11.5f;
            itemDuration = 275f;
            consumeItem(JPItem.Neocells);

            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion(){{
                color = Color.valueOf("9e3736");
            }});
        }};

        Lotus = new SolarGenerator("Lotus-panel"){{
            requirements(Category.power, with(silicon, 175,JPItem.Vanadium, 125,JPItem.Biomass, 50));
            health = 625;
            size = 4;
            powerProduction = 3f;
        }};

        Biomassreactor = new ImpactReactor("Biomassreactor"){{
            requirements(Category.power, with(silicon, 225,JPItem.Vanadium, 75,JPItem.Neocells, 95));
            health = 1750;
            size = 4;
            hasLiquids = false;
            consumePower(10f);
            powerProduction = 40f;
            consumeItem(JPItem.Biomass);
            warmupSpeed = 0.0025f;
            explosionRadius = 10;
            explosionDamage = 4000;
            ambientSound = Sounds.pulse;
            ambientSoundVolume = 0.07f;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawPlasma(), new DrawDefault(), new DrawWarmupRegion(){{
                color = Color.valueOf("8B73C7");
            }});
        }};

        }}

