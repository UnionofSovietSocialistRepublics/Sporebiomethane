package jp.content;

import mindustry.type.*;

import static mindustry.content.Planets.*;

public class JPsectors{
    public static SectorPreset
    Ski, Dig, Frost;


    public static void load(){
        //region serpulo
        Ski = new SectorPreset("Ski", serpulo, 241){{
            difficulty = 3;
            captureWave = 20;
            //alwaysUnlocked = true;
        }};
        Dig = new SectorPreset("Dig", serpulo, 198){{
            difficulty = 3;
            captureWave = 30;
            //alwaysUnlocked = true;
        }};
        Frost = new SectorPreset("Frost", serpulo, 111){{
            difficulty = 69;
            captureWave = 30;
           // alwaysUnlocked = true;
        }};
    }
}