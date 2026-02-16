package jp.content.blocks;

import mindustry.type.Category;
import mindustry.type.PayloadStack;
import jp.content.*;
import mindustry.content.*;
import mindustry.world.blocks.units.*;

import static mindustry.type.ItemStack.*;

public class JPUnitAssembler{
    public static UnitAssembler
        apollyonAssembler, Acidifier;

        public static void load(){

        apollyonAssembler = new UnitAssembler("apollyon-assembler"){{
            requirements(Category.units, with(Items.silicon, 1000, JPItem.VCA, 250, JPItem.Nanitealloy, 750, JPItem.Biomass, 800));
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            size = 6;
            droneType = JPUnits.zeta;
            plans.add(
            new AssemblerUnitPlan(JPUnits.gorgon, 60f * 60f, PayloadStack.list(UnitTypes.vela, 1, JPUnits.roach, 3, JPUnits.zergling, 10)),
            new AssemblerUnitPlan(JPUnits.basilisk, 180f * 60f, PayloadStack.list(JPUnits.behomoth, 2, JPUnits.baneling, 10, JPUnits.Guardian, 5, UnitTypes.toxopid, 1))
            );
            areaSize = 13;
            researchCostMultiplier = 0.5f;

            consumePower(15f);
        }};
        }};

