package jp.content;

import mindustry.type.*;

import static mindustry.content.Planets.*;

public class JPsectorsHM{
    public static SectorPreset
    Frosted, DS;


    public static void load(){
        //region serpulo
        DS = new SectorPreset("DS", serpulo, 241){{
            difficulty = 5;
            captureWave = 30;
            //alwaysUnlocked = true;
        }};
        Frosted = new SectorPreset("Frost", serpulo, 111){{
            difficulty = 69;
            captureWave = 45;
           // alwaysUnlocked = true;
        }};
    }
}