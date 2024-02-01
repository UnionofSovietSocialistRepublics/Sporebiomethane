package javapod.content.blocks;

import arc.graphics.g2d.TextureRegion;
import arc.struct.Seq;
import mindustry.type.Category;
import mindustry.type.PayloadSeq;
import mindustry.type.PayloadStack;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.world.blocks.units.Reconstructor;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.type.*;
import javapod.content.JavapodItem;
import javapod.content.JavapodUnits;


import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;



public class JavapodUnitFactory{
    public static UnitFactory
        pool,Synapsetower;

        public static void load(){
        pool = new UnitFactory("pool"){{
            requirements(Category.units, with(silicon,150,JavapodItem.Biomass,45));
            plans = Seq.with(
                new UnitPlan(JavapodUnits.Imp, 15 * 60f, with(silicon, 65)),
                new UnitPlan(JavapodUnits.Imp, 10 * 60f, with(silicon, 45))
            );
            size = 3;
            consumePower(1.2f);

        }};

        
        Synapsetower = new UnitFactory("Synapse-tower"){{
            requirements(Category.units, with(silicon,250,JavapodItem.Biomass,75));
            plans = Seq.with(
                new UnitPlan(JavapodUnits.Thera, 60f * 15, with( silicon, 10, lead, 10)),
                new UnitPlan(JavapodUnits.Autus, 60f * 10, with( silicon, 8, coal, 10)),
                new UnitPlan(JavapodUnits.Imp, 60f * 40, with( silicon, 30, lead, 20, titanium, 20))
            );
            size = 3;
            consumePower(1.2f);

        }};

}};