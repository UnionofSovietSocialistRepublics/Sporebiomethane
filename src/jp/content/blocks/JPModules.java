package jp.content.blocks;

import mindustry.type.Category;
import jp.content.*;
import mindustry.content.*;
import mindustry.world.blocks.units.*;

import static mindustry.type.ItemStack.*;

public class JPModules{
    public static UnitAssemblerModule
        acidifierModule;

        public static void load(){
        acidifierModule = new UnitAssemblerModule("acidifier-module"){{
            requirements(Category.units, with(Items.silicon, 400, JPItem.Nanitealloy,50, JPItem.Biomass, 250));
            consumePower(5f);
            size = 3;
            health = 475;
        }};
        }};

