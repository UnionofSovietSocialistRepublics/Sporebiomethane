package javapod.content.blocks;

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

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;

import javapod.content.JavapodUnits;

public class JavapodUnitFactory{
    public static UnitFactory
        pool,Synapsetower;

        public static void load(){
        pool = new UnitFactory("pool"){{
            requirements(Category.units, with(copper,50,lead,120,silicon, 80));
            plans = Seq.with(
                new UnitPlan(JavapodUnits.Zergling, 60f * 15, with(silicon, 10, lead, 10)),
                new UnitPlan(JavapodUnits.Baneling, 60f * 10, with(silicon, 8, coal, 10)),
                new UnitPlan(JavapodUnits.Imp, 60f * 40, with(silicon, 30, lead, 20, titanium, 20))
            );
            size = 3;
            consumePower(1.2f);

        }};
        Synapsetower = new UnitFactory("Synapse-tower"){{
            requirements(Category.units, with(copper,50,lead,120,silicon,80));
            plans = Seq.with(
                new UnitPlan(JavapodUnits.Thera, 60f * 15, with( silicon, 10, lead, 10)),
                new UnitPlan(JavapodUnits.Autus, 60f * 10, with( silicon, 8, coal, 10)),
                new UnitPlan(JavapodUnits.Imp, 60f * 40, with( silicon, 30, lead, 20, titanium, 20))
            );
            size = 3;
            consumePower(1.2f);

        }};

}};