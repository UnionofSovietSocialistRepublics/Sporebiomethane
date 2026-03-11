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
            requirements(Category.units, with(silicon,150,JPItem.biomass,45));
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            plans = Seq.with(
                new UnitPlan( JPUnits.zergling, 15 * 60f, with(silicon, 25,JPItem.biomass,5)),
                new UnitPlan( JPUnits.baneling, 10 * 60f, with(silicon, 15,JPItem.biomass,5)),
                new UnitPlan( JPUnits.roach, 20 * 60f, with(silicon, 65,JPItem.biomass,35)),
                new UnitPlan( JPUnits.purger, 25 * 60f, with(silicon, 95,JPItem.biomass,45))
            );
            health = 500;
            size = 3;
            consumePower(1.5f);

        }};

        
        synapseTower = new UnitFactory("synapseTower"){{
            requirements(Category.units, with(silicon,250,JPItem.biomass,75));
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            plans = Seq.with(
                new UnitPlan( JPUnits.drone, 60f * 15, with(silicon, 15, JPItem.biomass,10,lead, 25)),
                new UnitPlan( JPUnits.interceptor, 60f * 10, with(silicon, 35, JPItem.biomass,10)),
                new UnitPlan( JPUnits.rizomorph, 60f * 25, with(silicon, 150, JPItem.biomass,45))
            );
            health = 500;
            size = 3;
            consumePower(1.5f);

        }};
        gestator = new UnitFactory("gestator"){{
            requirements(Category.units, with(silicon,750,JPItem.naniteAlloy,500,JPItem.biomass,250,JPItem.neocell,75));
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            plans = Seq.with(
                new UnitPlan( JPUnits.carci, 60f * 25, with( silicon, 150, thorium, 75, JPItem.neocell, 30)),
                new UnitPlan( JPUnits.autus, 60f * 35, with( silicon, 200, JPItem.biomass,75,pyratite,45, JPItem.neocell, 75)),
                new UnitPlan( JPUnits.thera, 60f * 25, with( silicon, 175, JPItem.biomass,75, JPItem.neocell, 75)),
                new UnitPlan( JPUnits.imp, 60f * 15, with( silicon, 35, pyratite, 15, JPItem.biomass,5, JPItem.neocell, 15))
            );
            health = 2500;
            size = 3;
            consumePower(7f);
            consumeLiquid(Liquids.neoplasm, 15f / 60f);

        }};
        assembler = new UnitFactory("assembler"){{
            requirements(Category.units, with(silicon,675,JPItem.naniteAlloy,75,JPItem.biomass,225));
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            plans = Seq.with(
                new UnitPlan( JPUnits.breacher, 60f * 15, with( silicon, 175, JPItem.biomass,55, JPItem.naniteAlloy,45)),
                new UnitPlan( JPUnits.guardian, 60f * 10, with( silicon, 195, JPItem.biomass,65, JPItem.naniteAlloy,65)),
                new UnitPlan( JPUnits.behomoth, 60f * 50, with( silicon, 850, JPItem.biomass,400, JPItem.naniteAlloy,400)),
                new UnitPlan( JPUnits.scarabid, 60f * 40, with( silicon, 225, plastanium, 90, JPItem.biomass,25))
            );
            health = 1750;
            size = 4;
            consumePower(1.2f);

        }};
}};