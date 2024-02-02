package javapod.content.blocks;

import arc.graphics.g2d.TextureRegion;
import arc.struct.Seq;
import mindustry.type.Category;
import mindustry.type.PayloadSeq;
import mindustry.type.PayloadStack;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.units.Reconstructor;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.type.*;
import javapod.content.*;
import mindustry.content.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;



public class JavapodUnitFactory{
    public static UnitFactory
        pool,Synapsetower,Assembler,Gestator;

        public static void load(){
        pool = new UnitFactory("pool"){{
            requirements(Category.units, with(silicon,150,JavapodItem.Biomass,45));
            plans = Seq.with(
                new UnitPlan(JavapodUnits.Zergling, 15 * 60f, with(silicon, 65)),
                new UnitPlan(JavapodUnits.Baneling, 10 * 60f, with(silicon, 45))
            );
            health = 500;
            size = 3;
            consumePower(1.5f);

        }};

        
        Synapsetower = new UnitFactory("Synapse-tower"){{
            requirements(Category.units, with(silicon,250,JavapodItem.Biomass,75));
            plans = Seq.with(
                new UnitPlan(JavapodUnits.Thera, 60f * 15, with( silicon, 10, lead, 10)),
                new UnitPlan(JavapodUnits.Autus, 60f * 10, with( silicon, 8, coal, 10)),
                new UnitPlan(JavapodUnits.Imp, 60f * 40, with( silicon, 30, lead, 20, titanium, 20))
            );
            health = 500;
            size = 3;
            consumePower(1.5f);

        }};
        Gestator = new UnitFactory("Gestator"){{
            requirements(Category.units, with(silicon,750,JavapodItem.Nanitealloy,500,JavapodItem.Biomass,250,JavapodItem.Neocells,75));
            plans = Seq.with(
                new UnitPlan(JavapodUnits.Carci, 60f * 25, with( silicon, 150, thorium, 75, JavapodItem.Neocells, 30)),
                new UnitPlan(JavapodUnits.Autus, 60f * 35, with( silicon, 200, JavapodItem.Biomass,75,pyratite,45, JavapodItem.Neocells, 75)),
                new UnitPlan(JavapodUnits.Thera, 60f * 25, with( silicon, 175, JavapodItem.Biomass,75, JavapodItem.Neocells, 75)),
                new UnitPlan(JavapodUnits.Imp, 60f * 15, with( silicon, 45, pyratite, 15, JavapodItem.Biomass,5, JavapodItem.Neocells, 15))
            );
            health = 2500;
            size = 3;
            consumePower(7f);
            consumeLiquid(Liquids.neoplasm, 15f / 60f);

        }};
        Assembler = new UnitFactory("Assembler"){{
            requirements(Category.units, with(silicon,250,JavapodItem.Biomass,75));
            plans = Seq.with(
                new UnitPlan(JavapodUnits.Breacher, 60f * 15, with( silicon, 350, JavapodItem.Biomass,75)),
                new UnitPlan(JavapodUnits.Guardian, 60f * 10, with( silicon, 300, JavapodItem.Biomass,75)),
                new UnitPlan(JavapodUnits.Behomoth, 60f * 40, with( silicon, 850, JavapodItem.Biomass,400, JavapodItem.Nanitealloy,400)),
                new UnitPlan(JavapodUnits.Scarabid, 60f * 40, with( silicon, 300, plastanium, 90, JavapodItem.Biomass,25))
            );
            health = 1750;
            size = 4;
            consumePower(1.2f);

        }};
}};