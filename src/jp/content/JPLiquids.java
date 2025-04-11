package jp.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class JPLiquids {
    public static Liquid
    liquidSpore;

    public static void load(){

        liquidSpore = new Liquid("liquidSpore", Color.valueOf("8B73C7")){{
            coolant = false;
            effect = JPStatus.Dissolving;
            hidden = true;
            capPuddles = false;
        }};

}}
