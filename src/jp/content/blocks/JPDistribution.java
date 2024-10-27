package jp.content.blocks;

import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.distribution.*;
import jp.content.*;

import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;

public class JPDistribution{
    public static Block
    Itempipe;

    public static void load(){
    
    Itempipe = new Duct("Item-pipe"){{
        requirements(Category.distribution, with(titanium, 2, silicon, 2, metaglass,4, JPItem.Biomass,1));
        health = 300;
        size = 1;
        speed = 3f;
    }};





    }};