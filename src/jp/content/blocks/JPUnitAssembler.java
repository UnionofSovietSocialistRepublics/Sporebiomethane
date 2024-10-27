package jp.content.blocks;

import mindustry.type.Category;
import mindustry.type.PayloadStack;
import jp.content.*;
import mindustry.content.*;
import mindustry.world.blocks.units.*;

import static mindustry.type.ItemStack.*;

public class JPUnitAssembler{
    public static UnitAssembler
        ApollyonAssembler, Acidifier;

        public static void load(){

        ApollyonAssembler = new UnitAssembler("ApollyonAssembler"){{
            requirements(Category.units, with(Items.silicon, 1000, JPItem.VCA, 250, JPItem.Nanitealloy, 750, JPItem.Biomass, 800));
            size = 6;
            droneType = JPUnits.Zeta;
            plans.add(
            new AssemblerUnitPlan(JPUnits.Gorgon, 60f * 60f, PayloadStack.list(UnitTypes.vela, 1, JPUnits.Roach, 3, JPUnits.Zergling, 10)),
            new AssemblerUnitPlan(JPUnits.Basilisk, 180f * 60f, PayloadStack.list(JPUnits.Behomoth, 2, JPUnits.Baneling, 10, JPUnits.Guardian, 5, UnitTypes.toxopid, 1))
            );
            areaSize = 13;
            researchCostMultiplier = 0.5f;

            consumePower(15f);
        }};
        }};

