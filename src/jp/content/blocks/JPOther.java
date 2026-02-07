package jp.content.blocks;

import mindustry.content.Planets;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.storage.*;
import jp.content.*;

import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;


public class JPOther{
    public static Block
VCAwall,Sporecore,Hive,Nydusaecore;

        public static void load(){
        
        VCAwall = new Wall("Vanadiumcarbidewall"){{
            requirements(Category.defense, with(JPItem.VCA, 40));
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            size = 2;
            health = 6500;
        }};
        Sporecore = new CoreBlock("Sporecore"){{
            requirements(Category.effect, with(JPItem.Biomass, 3000, JPItem.Nanitealloy, 2000, silicon, 4000));
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            unitType = JPUnits.Hivedefender;
            health = 6500;
            itemCapacity = 11000;
            size = 4;
            thrusterLength = 34/4f;

            unitCapModifier = 24;
            researchCostMultiplier = 0.5f;
        }};
        Hive = new CoreBlock("Hive"){{
            requirements(Category.effect, with(JPItem.Biomass, 6000, JPItem.Nanitealloy, 4000, silicon, 6000, surgeAlloy, 4000));
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            unitType = JPUnits.HiveSentinel;
            health = 9500;
            itemCapacity = 15000;
            size = 5;
            thrusterLength = 34/4f;

            unitCapModifier = 32;
            researchCostMultiplier = 0.25f;
        }};
        Nydusaecore = new CoreBlock("Nydusaecore"){{
            requirements(Category.effect, with(JPItem.Biomass, 12000, JPItem.Nanitealloy, 8000, JPItem.VCA, 4000, silicon, 8000, surgeAlloy, 6000));
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            unitType = JPUnits.sporophage;
            health = 16250;
            itemCapacity = 25000;
            size = 6;
            thrusterLength = 34/4f;

            unitCapModifier = 48;
            researchCostMultiplier = 0.15f;
        }};
}}