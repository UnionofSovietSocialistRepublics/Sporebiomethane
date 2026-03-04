package jp.content;

import mindustry.world.meta.Attribute;

public class JPAttribute {
    public static Attribute
    zinc;

    public static void load() {
        zinc = Attribute.add("zinc");
    }
}