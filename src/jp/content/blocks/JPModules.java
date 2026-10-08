package jp.content.blocks;

import mindustry.type.Category;
import jp.content.*;
import mindustry.content.*;
import mindustry.world.blocks.units.*;
import mindustry.world.meta.*;

import static mindustry.type.ItemStack.*;

public class JPModules{
    public static UnitAssemblerModule
        acidifierModule;

        public static void load(){
        acidifierModule = new UnitAssemblerModule("acidifierModule"){{
            requirements(Category.units, with(Items.silicon, 400, JPItem.biomass, 125, JPItem.naniteAlloy,50));
            scaledHealth = 40f;
            size = 3;
            consumePower(5f);
            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};
        
        }};

