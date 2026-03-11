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
        acidifierModule = new UnitAssemblerModule("acidifierModule"){{
            requirements(Category.units, with(Items.silicon, 400, JPItem.naniteAlloy,50, JPItem.biomass, 250));
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            consumePower(5f);
            size = 3;
            health = 475;
        }};
        }};

