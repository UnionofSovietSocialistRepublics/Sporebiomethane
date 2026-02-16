package jp.content.blocks;

import arc.struct.Seq;
import mindustry.type.Category;
import mindustry.world.blocks.units.UnitFactory;
import jp.content.*;
import mindustry.content.*;

import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;



public class JPUnitFactory{
    public static UnitFactory
        pool,synapseTower,assembler,gestator,
        ApollyonAssembler;

        public static void load(){
        pool = new UnitFactory("pool"){{
            requirements(Category.units, with(silicon,150,JPItem.Biomass,45));
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            plans = Seq.with(
                new UnitPlan( JPUnits.zergling, 15 * 60f, with(silicon, 25,JPItem.Biomass,5)),
                new UnitPlan( JPUnits.baneling, 10 * 60f, with(silicon, 15,JPItem.Biomass,5)),
                new UnitPlan( JPUnits.roach, 20 * 60f, with(silicon, 65,JPItem.Biomass,35)),
                new UnitPlan( JPUnits.purger, 25 * 60f, with(silicon, 95,JPItem.Biomass,45))
            );
            health = 500;
            size = 3;
            consumePower(1.5f);

        }};

        
        synapseTower = new UnitFactory("synapse-tower"){{
            requirements(Category.units, with(silicon,250,JPItem.Biomass,75));
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            plans = Seq.with(
                new UnitPlan( JPUnits.drone, 60f * 15, with(silicon, 15, JPItem.Biomass,10,lead, 25)),
                new UnitPlan( JPUnits.interceptor, 60f * 10, with(silicon, 35, JPItem.Biomass,10)),
                new UnitPlan( JPUnits.Rizomorph, 60f * 25, with(silicon, 150, JPItem.Biomass,45))
            );
            health = 500;
            size = 3;
            consumePower(1.5f);

        }};
        gestator = new UnitFactory("gestator"){{
            requirements(Category.units, with(silicon,750,JPItem.Nanitealloy,500,JPItem.Biomass,250,JPItem.Neocells,75));
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            plans = Seq.with(
                new UnitPlan( JPUnits.carci, 60f * 25, with( silicon, 150, thorium, 75, JPItem.Neocells, 30)),
                new UnitPlan( JPUnits.autus, 60f * 35, with( silicon, 200, JPItem.Biomass,75,pyratite,45, JPItem.Neocells, 75)),
                new UnitPlan( JPUnits.thera, 60f * 25, with( silicon, 175, JPItem.Biomass,75, JPItem.Neocells, 75)),
                new UnitPlan( JPUnits.imp, 60f * 15, with( silicon, 35, pyratite, 15, JPItem.Biomass,5, JPItem.Neocells, 15))
            );
            health = 2500;
            size = 3;
            consumePower(7f);
            consumeLiquid(Liquids.neoplasm, 15f / 60f);

        }};
        assembler = new UnitFactory("assembler"){{
            requirements(Category.units, with(silicon,675,JPItem.Nanitealloy,75,JPItem.Biomass,225));
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            plans = Seq.with(
                new UnitPlan( JPUnits.breacher, 60f * 15, with( silicon, 175, JPItem.Biomass,55, JPItem.Nanitealloy,45)),
                new UnitPlan( JPUnits.Guardian, 60f * 10, with( silicon, 195, JPItem.Biomass,65, JPItem.Nanitealloy,65)),
                new UnitPlan( JPUnits.behomoth, 60f * 50, with( silicon, 850, JPItem.Biomass,400, JPItem.Nanitealloy,400)),
                new UnitPlan( JPUnits.Scarabid, 60f * 40, with( silicon, 225, plastanium, 90, JPItem.Biomass,25))
            );
            health = 1750;
            size = 4;
            consumePower(1.2f);

        }};
}};