package jp.content;

import mindustry.type.*;

import static mindustry.content.Planets.*;

public class JPsectors{
    public static SectorPreset
    Ski, Biomass, Dig, Birth, Magma, frost;


    public static void load(){
        //region serpulo
        Ski = new SectorPreset("Ski", serpulo, 241){{
            difficulty = 3;
            captureWave = 20;
            //alwaysUnlocked = true;
        }};
        Biomass = new SectorPreset("Biomass", serpulo, 81){{
            difficulty = 3;
            captureWave = 20;
//            alwaysUnlocked = true;
        }};
        Dig = new SectorPreset("Dig", serpulo, 198){{
            difficulty = 3;
            captureWave = 25;
            //alwaysUnlocked = true;
        }};
        Birth = new SectorPreset("Birth", serpulo, 263){{
            difficulty = 4;
           // alwaysUnlocked = true;
        }};
        Magma = new SectorPreset("Magma", serpulo, 271){{
            difficulty = 4;
            captureWave = 30;
           // alwaysUnlocked = true;
        }};
        frost = new SectorPreset("frost", serpulo, 111){{
            difficulty = 69;
            captureWave = 30;
           // alwaysUnlocked = true;
        }};
    }
}