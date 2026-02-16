package jp.content;

import mindustry.type.*;

import static mindustry.content.Planets.*;

public class JPsectorsHM{
    public static SectorPreset
    skiHM, digHM, birthHM, magmaHM, Frosted, biomassHM;


    public static void load(){
        //region serpulo
        skiHM = new SectorPreset("skiHM", serpulo, 241){{
            difficulty = 4;
            captureWave = 20;
        }};
        biomassHM = new SectorPreset("biomassHM", serpulo, 81){{
            difficulty = 3;
            captureWave = 25;
//            alwaysUnlocked = true;
        }};
        digHM = new SectorPreset("digHM", serpulo, 198){{
            difficulty = 5;
            captureWave = 25;
        }};
        birthHM = new SectorPreset("birthHM", serpulo, 263){{
            difficulty = 6;
           // alwaysUnlocked = true;
        }};
        magmaHM = new SectorPreset("magmaHM", serpulo, 271){{
            difficulty = 6;
            captureWave = 30;
           // alwaysUnlocked = true;
        }};
        Frosted = new SectorPreset("frost", serpulo, 111){{
            difficulty = 69;
            captureWave = 45;
        }};
    }
}