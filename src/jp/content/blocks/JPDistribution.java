package jp.content.blocks;

import mindustry.content.Planets;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.distribution.*;
import jp.content.*;

import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;

public class JPDistribution{
    public static Block
    itemPipe;

    public static void load(){
    
    itemPipe = new Duct("itemPipe"){{
        requirements(Category.distribution, with(titanium, 2, silicon, 2, metaglass,4, JPItem.biomass,1));
        shownPlanets.addAll(Planets.serpulo, Planets.erekir);
        health = 300;
        size = 1;
        speed = 3f;
    }};

    }};