package jp.content;

import mindustry.type.*;

import static mindustry.content.Planets.*;

public class JPsectorsHM{
    public static SectorPreset
    SkiHM, DigHM, BirthHM, MagmaHM, Frosted, BiomassHM;


    public static void load(){
        //region serpulo
        SkiHM = new SectorPreset("SkiHM", serpulo, 241){{
            difficulty = 4;
            captureWave = 20;
        }};
        BiomassHM = new SectorPreset("BiomassHM", serpulo, 81){{
            difficulty = 3;
            captureWave = 25;
//            alwaysUnlocked = true;
        }};
        DigHM = new SectorPreset("DigHM", serpulo, 198){{
            difficulty = 5;
            captureWave = 25;
        }};
        BirthHM = new SectorPreset("BirthHM", serpulo, 263){{
            difficulty = 6;
           // alwaysUnlocked = true;
        }};
        MagmaHM = new SectorPreset("MagmaHM", serpulo, 271){{
            difficulty = 6;
            captureWave = 30;
           // alwaysUnlocked = true;
        }};
        Frosted = new SectorPreset("Frost", serpulo, 111){{
            difficulty = 69;
            captureWave = 45;
        }};
    }
}