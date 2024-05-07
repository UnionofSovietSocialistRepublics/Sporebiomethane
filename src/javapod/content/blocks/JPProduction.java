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
import mindustry.content.*;
import jp.content.OreCrafter;
import jp.content.blocks.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;


public class JPProduction{
    public static Block
        Extractor,ZincExtractor,
        Masscultivator,
        Nanoprocessor,Naniteinfuser,CCB,FR,Gaschamber,BioSynthesizer,Vanadicarbide,Neostabilizer,
        Biomassreactor,Neocell,Lotus,Oilburner,Voltaicburner;

        public static void load(){

        Nanoprocessor = new GenericCrafter("Nanoprocessor"){{
            requirements(Category.crafting, with(silicon, 75, graphite, 90));

            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.Biomass, 1);
            craftTime = 50f;
            size = 2;
            hasItems = true;
            hasPower = true;

            consumePower(1f);
            consumeItem(sporePod, 5);
        }};
        Naniteinfuser = new GenericCrafter("Naniteinfuser"){{
            requirements(Category.crafting, with(silicon, 325, graphite, 275,JPItem.BioSil,95));

            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.Nanitealloy, 1);
            craftTime = 50f;
            size = 2;
            hasPower = true;
            hasItems = true;

            consumePower(5f);
            consumeItems(with(JPItem.Biomass, 5,JPItem.BioSil,5,silicon,10));
        }};
        CCB = new GenericCrafter("Carbine-composite-smelter"){{
            requirements(Category.crafting, with(JPItem.Vanadium,600,JPItem.BioSil, 450,JPItem.Nanitealloy, 425));

            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(JPItem.Carbinecomposite, 1);
            craftTime = 80f;
            size = 2;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("8B73C7")));
            hasPower = true;
            hasItems = true;

            consumePower(4f);
            consumeItems(with(JPItem.BioSil, 2,JPItem.Vanadium,4,JPItem.Nanitealloy, 3));
        }};
        FR = new GenericCrafter("Fluoresilt-refinery"){{
            requirements(Category.crafting, with(JPItem.Biomass, 250,silicon, 150, graphite, 145));

            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.Fluorite, 1);
            craftTime = 50f;
            size = 2;
            hasPower = true;
            hasItems = true;

            consumePower(1f);
            consumeItem(JPItem.Fluoresilt, 3);
        }};
        Gaschamber = new GenericCrafter("Voltaicchamber"){{
            requirements(Category.crafting, with(graphite, 475,titanium, 350, plastanium, 75));

            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.Voltaicgas, 1);
            craftTime = 70f;
            size = 3;
            hasItems = true;
            hasPower = true;
            hasLiquids = true;

            consumePower(5f);
            consumeItem(sporePod, 5);
            consumeLiquid(Liquids.water, 15f / 60f);
        }};
        BioSynthesizer = new GenericCrafter("BioSynthesizer"){{
            requirements(Category.crafting, with(JPItem.Biomass, 375,silicon, 150, graphite, 90));

            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.BioSil, 1);
            craftTime = 80f;
            size = 3;
            hasItems = true;
            hasPower = true;
            hasLiquids = true;

            consumePower(5f);
            consumeItems(with(JPItem.Biomass, 3,silicon, 2,graphite, 2));
        }};
        Neostabilizer = new GenericCrafter("Neostabilizer"){{
            health = 1000;
            requirements(Category.crafting, with(JPItem.Biomass, 650,JPItem.Nanitealloy, 450,JPItem.Carbinecomposite, 450));

            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.Neocells, 1);
            craftTime = 60f;
            size = 3;
            hasItems = true;
            hasPower = true;
            hasLiquids = true;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.water), new DrawLiquidTile(Liquids.neoplasm){{drawLiquidLight = true;}}, new DrawDefault());
            consumePower(10f);
            consumeItems(with(JPItem.Vanadium, 4,JPItem.Zinc, 2));
            consumeLiquid(Liquids.neoplasm, 6f / 60f);
        }};
        Masscultivator = new GenericCrafter("Masscultivator"){{
            health = 750;
            requirements(Category.production, with(silicon, 650,JPItem.Biomass, 250,thorium, 450));
            outputItem = new ItemStack(sporePod, 5);
            craftTime = 75f;
            size = 3;
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
        Vanadicarbide = new HeatProducer("Vanadicarbide"){{
            health = 750;
            requirements(Category.crafting, with(silicon, 270,JPItem.Biomass, 125,JPItem.Vanadium, 450));
            craftEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(JPItem.VCA, 1);
            craftTime = 50f;
            size = 2;
            hasItems = true;
            hasPower = true;
            heatOutput = 5f;
            consumePower(5f);
            consumeItems(with(JPItem.Vanadium, 5,JPItem.BioSil, 3));
        }};
        ZincExtractor = new OreCrafter("ZincExtractor"){{
            requirements(Category.power, with(silicon, 175,JPItem.Vanadium, 125,JPItem.Biomass, 50));
            health = 625;
            baseEfficiency = 1f;
            consumePower(5f);
            consumeItems(with(JPItem.Biomass, 5,JPItem.Vanadium, 2));
            outputItem = new ItemStack(JPItem.Zinc, 1);
            ores.put(JPEnv.ZincOre, 1f);
            size = 2;
        }};
        Lotus = new SolarGenerator("Lotus-panel"){{
            requirements(Category.power, with(silicon, 175,JPItem.Vanadium, 125,JPItem.Biomass, 50));
            health = 625;
            size = 4;
            powerProduction = 3f;
        }};
        Neocell = new ConsumeGenerator("Neocell-generator"){{
            requirements(Category.power, with(silicon, 225,JPItem.Vanadium, 75,JPItem.Neocells, 95));
            health = 650;
            size = 2;
            powerProduction = 10f;
            consumeItem(JPItem.Neocells);
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
        }};
        Extractor = new Drill("Extractor"){{
            requirements(Category.production, with(silicon, 25,graphite, 30));
            health = 300;
            tier = 4;
            size = 2;
            hasLiquids = true;
            drillTime = 200f;
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
        Oilburner = new ConsumeGenerator("Oil-burner"){{
            requirements(Category.power, with(silicon, 100,graphite, 75,JPItem.Biomass, 25));
            health = 180;
            size = 1;
            powerProduction = 6f;
            consumeLiquid(Liquids.oil, 0.2f);
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.03f;
            generateEffect = Fx.generatespark;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("8B73C7")));
        }};
        Voltaicburner = new ConsumeGenerator("Voltatic-burner"){{
            requirements(Category.power, with(silicon, 225,JPItem.Nanitealloy, 145,JPItem.Biomass, 95));
            health = 450;
            size = 2;
            powerProduction = 12.5f;
            itemDuration = 110f;
            consumeItem(JPItem.Voltaicgas);
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.06f;
            generateEffect = Fx.generatespark;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("8B73C7")));
        }};
        }};

