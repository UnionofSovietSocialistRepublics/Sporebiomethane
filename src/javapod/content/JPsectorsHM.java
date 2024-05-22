package jp.content;

import mindustry.type.*;

import static mindustry.content.Planets.*;

public class JPsectorsHM{
    public static SectorPreset
    SkiHM, DigHM, Frosted;


    public static void load(){
        //region serpulo
        SkiHM = new SectorPreset("SkiHM", serpulo, 241){{
            difficulty = 4;
            captureWave = 25;
        }};
        DigHM = new SectorPreset("DigHM", serpulo, 198){{
            difficulty = 5;
            captureWave = 30;
        }};
        Frosted = new SectorPreset("Frost", serpulo, 111){{
            difficulty = 69;
            captureWave = 45;
        }};
    }
}