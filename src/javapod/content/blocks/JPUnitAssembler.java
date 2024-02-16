package jp.content.blocks;

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
import jp.content.*;
import mindustry.content.*;
import mindustry.world.blocks.units.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;

public class JPUnitAssembler{
    public static UnitAssembler
        ApollyonAssembler;

        public static void load(){

        ApollyonAssembler = new UnitAssembler("ApollyonAssembler"){{
            requirements(Category.units, with(Items.thorium, 500, Items.oxide, 150, Items.carbide, 80, Items.silicon, 500));
            size = 6;
            droneType = JPUnits.Zeta;
            plans.add(
            new AssemblerUnitPlan(JPUnits.Gorgon, 80f * 60f, PayloadStack.list(UnitTypes.vela, 1, JPUnits.Roach, 5, JPUnits.Zergling, 10)),
            new AssemblerUnitPlan(JPUnits.Basilisk, 220f * 60f * 3f, PayloadStack.list(JPUnits.Behomoth, 2, JPUnits.Baneling, 10, JPUnits.Guardian, 5, UnitTypes.toxopid, 1))
            );
            areaSize = 13;
            researchCostMultiplier = 0.5f;

            consumePower(15f);
        }};

        }};