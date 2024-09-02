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

public class JPModules{
    public static UnitAssemblerModule
        Acidifier;

        public static void load(){
        Acidifier = new UnitAssemblerModule("AcidifierModule"){{
            requirements(Category.units, with(Items.silicon, 400, JPItem.Nanitealloy,50, JPItem.Biomass, 250));
            consumePower(5f);
            size = 3;
            health = 475;
        }};
        }};

