package jp.content.blocks;

import mindustry.content.Liquids;
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
        requirements(Category.distribution, with(titanium, 2, silicon, 2, metaglass,4, JPItem.biomass,1));
        envEnabled = Env.spores;
        health = 300;
        size = 1;
        speed = 3f;
        shownPlanets.add(Planets.serpulo);
        shownPlanets.add(Planets.erekir);
    }};

    harvesterBay = new JPMiningOutPost("harvesterBay"){{
        requirements(Category.distribution, with(silicon, 95,JPItem.biomass, 45,JPItem.naniteAlloy,15));
        health = 100;
        unitType = JPUnits.harvester;
        size = 2;
        unitBuildTime = 60f * 8f;
        consumePower(240f / 60f);
        itemCapacity = 200;

    }};

    }};