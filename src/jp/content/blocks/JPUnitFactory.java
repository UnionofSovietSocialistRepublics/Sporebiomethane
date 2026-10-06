package jp.content.blocks;

import arc.struct.Seq;
import mindustry.type.Category;
import mindustry.world.blocks.units.UnitFactory;
import jp.content.*;
import mindustry.content.*;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawLiquidTile;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;
import mindustry.world.meta.*;

import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;



public class JPUnitFactory{
    public static UnitFactory
        pool,synapseTower,assembler,gestator,
        ApollyonAssembler;

        public static void load(){
        pool = new UnitFactory("pool"){{
            requirements(Category.units, with(silicon,150,JPItem.biomass,45));
            scaledHealth = 60f;
            size = 3;
            consumePower(1.5f);
            plans = Seq.with(
                new UnitPlan( JPUnits.zergling, 60f * 15, with(silicon, 25,JPItem.biomass,5)),
                new UnitPlan( JPUnits.baneling, 60f * 10, with(silicon, 15,JPItem.biomass,5)),
                new UnitPlan( JPUnits.roach, 60f * 30, with(silicon, 65,JPItem.biomass,30)),
                new UnitPlan( JPUnits.purger, 60f* 35, with(JPItem.biosil, 45,JPItem.biomass,45))
            );

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};
        
        synapseTower = new UnitFactory("synapseTower"){{
            requirements(Category.units, with(silicon,250,JPItem.biomass,75));
            scaledHealth = 60f;
            size = 3;
            consumePower(1.5f);
            plans = Seq.with(
                new UnitPlan( JPUnits.drone, 60f * 20, with(silicon, 15, JPItem.biomass,10,lead, 25)),
                new UnitPlan( JPUnits.interceptor, 60f * 25, with(silicon, 35, JPItem.biomass,25)),
                new UnitPlan( JPUnits.rizomorph, 60f * 30, with(silicon, 55, JPItem.biomass,45))
            );

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        gestator = new JPDrawerUnitFactory("gestator"){{
            requirements(Category.units, with(silicon,750,JPItem.naniteAlloy,500,JPItem.biomass,250,JPItem.neocell,75));
            scaledHealth = 90f;
            size = 3;
            consumePower(7f);
            consumeLiquid(Liquids.neoplasm, 15f / 60f);
            plans = Seq.with(
                new UnitPlan( JPUnits.imp, 60f * 25, with( silicon, 35, JPItem.biomass,10, JPItem.neocell, 5)),
                new UnitPlan( JPUnits.carci, 60f * 35, with( silicon, 95, thorium, 75, JPItem.neocell, 15)),
                new UnitPlan( JPUnits.autus, 60f * 50, with( silicon, 135, JPItem.biomass,55, JPItem.naniteAlloy,25, JPItem.neocell, 25)),
                new UnitPlan( JPUnits.thera, 60f * 55, with( JPItem.biosil, 40, JPItem.biomass,95, JPItem.neocell, 30))
            );

            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.neoplasm,1.5f){{drawLiquidLight = true;}}, new DrawDefault());
            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        assembler = new UnitFactory("assembler"){{
            requirements(Category.units, with(silicon,675,JPItem.naniteAlloy,75,JPItem.biomass,225));
            scaledHealth = 80f;
            size = 4;
            consumePower(8f);
            plans = Seq.with(
                new UnitPlan( JPUnits.guardian, 60f * 50, with( silicon, 155, JPItem.biomass,35, JPItem.naniteAlloy,25)),
                new UnitPlan( JPUnits.scarabid, 60f * 40, with( silicon, 175, plastanium, 90, JPItem.biomass,25)),
                new UnitPlan( JPUnits.breacher, 60f * 45, with( JPItem.biosil, 55, JPItem.biomass,40, JPItem.naniteAlloy,35)),
                new UnitPlan( JPUnits.behomoth, 60f * 115, with( JPItem.biosil, 225, JPItem.biomass,325, JPItem.naniteAlloy,125))
            );

            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};
}};