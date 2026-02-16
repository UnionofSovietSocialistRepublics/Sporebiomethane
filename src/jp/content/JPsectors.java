package jp.content;

import mindustry.type.*;

import static mindustry.content.Planets.*;

public class JPsectors{
    public static SectorPreset
    ski, biomass, dig, birth, magma, frost;


    public static void load(){
        //region serpulo
        ski = new SectorPreset("ski", serpulo, 241){{
            difficulty = 3;
            captureWave = 20;
            //alwaysUnlocked = true;
        }};
        biomass = new SectorPreset("biomass", serpulo, 81){{
            difficulty = 3;
            captureWave = 20;
//            alwaysUnlocked = true;
        }};
        dig = new SectorPreset("dig", serpulo, 198){{
            difficulty = 3;
            captureWave = 25;
            //alwaysUnlocked = true;
        }};
        birth = new SectorPreset("birth", serpulo, 263){{
            difficulty = 4;
           // alwaysUnlocked = true;
        }};
        magma = new SectorPreset("magma", serpulo, 271){{
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