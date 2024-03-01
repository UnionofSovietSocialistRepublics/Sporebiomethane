package jp.content;

import mindustry.type.*;

import static mindustry.content.Planets.*;

public class JPsectors{
    public static SectorPreset
    Frost;


    public static void load(){
        //region serpulo
        Frost = new SectorPreset("Frost", serpulo, 111){{
            difficulty = 69;
            captureWave = 30;
            alwaysUnlocked = true;
        }};
    }
}