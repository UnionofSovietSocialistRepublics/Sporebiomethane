package jp.content.blocks;

import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.storage.*;
import jp.content.*;
import mindustry.world.meta.*;

import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;


public class JPOther{
    public static Block
    vanadiumCarbideWallLarge,hatchery,hive,nydusaeCore,lunarCore;

        public static void load(){
        
        vanadiumCarbideWallLarge = new Wall("vanadiumCarbideWallLarge"){{
            requirements(Category.defense, with(JPItem.vanadiumCarbideAlloy, 40));
            health = 6500;
            size = 2;
            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};
        hatchery = new CoreBlock("hatchery"){{
            requirements(Category.effect, with(JPItem.biomass, 3000, JPItem.naniteAlloy, 2000, silicon, 4000));
            envEnabled = Env.spores;;
            unitType = JPUnits.hiveDefender;
            health = 6500;
            itemCapacity = 11000;
            size = 4;
            thrusterLength = 34/4f;

            unitCapModifier = 24;
            researchCostMultiplier = 0.5f;

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};
        hive = new CoreBlock("hive"){{
            requirements(Category.effect, with(JPItem.biomass, 6000, JPItem.naniteAlloy, 4000, silicon, 6000, surgeAlloy, 4000));
            envEnabled = Env.spores;;
            unitType = JPUnits.hiveSentinel;
            health = 9500;
            itemCapacity = 15000;
            size = 5;
            thrusterLength = 34/4f;

            unitCapModifier = 32;
            researchCostMultiplier = 0.25f;

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};
        nydusaeCore = new CoreBlock("nydusaeCore"){{
            requirements(Category.effect, with(JPItem.biomass, 12000, JPItem.naniteAlloy, 8000, JPItem.vanadiumCarbideAlloy, 4000, silicon, 8000, surgeAlloy, 6000));
            envEnabled = Env.spores;;
            unitType = JPUnits.sporophage;
            health = 16250;
            itemCapacity = 25000;
            size = 6;
            thrusterLength = 34/4f;

            unitCapModifier = 48;
            researchCostMultiplier = 0.15f;

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        lunarCore = new CoreBlock("lunarCore"){{
            requirements(Category.effect, with(JPItem.fluorite, 6000, JPItem.vanadiumCarbideAlloy, 2000));
            envEnabled = Env.spores;;
            unitType = JPUnits.spark;
            health = 4200;
            itemCapacity = 6500;
            size = 3;
            thrusterLength = 34/4f;

            unitCapModifier = 48;
            researchCostMultiplier = 0.15f;

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};
}}