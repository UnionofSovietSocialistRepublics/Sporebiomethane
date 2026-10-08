package jp.content.blocks;

import mindustry.content.Planets;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.distribution.*;
import jp.content.*;
import mindustry.world.meta.*;

import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;

public class JPDistribution{
    public static Block
    biomassPipe, harvesterBay;

    public static void load(){
    biomassPipe = new Duct("biomassPipe"){{
        requirements(Category.distribution, with(graphite, 2,silicon, 2, JPItem.biomass,1));
        scaledHealth = 265f;
        size = 1;
        speed = 3f;
        shownPlanets.add(Planets.serpulo);
        shownPlanets.add(Planets.erekir);
    }};

    harvesterBay = new JPMiningOutpost("harvesterBay"){{
        requirements(Category.distribution, with(silicon, 95,JPItem.biomass, 45,JPItem.naniteAlloy,15));
        scaledHealth = 60f;
        size = 2;
        unitBuildTime = 60f * 8f;
        consumePower(240f / 60f);
        itemCapacity = 100;

        shownPlanets.add(Planets.serpulo);
        shownPlanets.add(Planets.erekir);
    }};

    }};