package jp.content;

import mindustry.type.*;

import static mindustry.content.Planets.*;

public class JPsectors{
    public static SectorPreset
    Frost, Ski;


    public static void load(){
        //region serpulo
        Ski = new SectorPreset("Ski", serpulo, 193){{
            difficulty = 3;
            captureWave = 20;
            //alwaysUnlocked = true;
        }};
        Frost = new SectorPreset("Frost", serpulo, 111){{
            difficulty = 69;
            captureWave = 30;
           // alwaysUnlocked = true;
        }};
    }
}