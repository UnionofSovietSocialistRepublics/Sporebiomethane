package jp.content;

import arc.graphics.*;
import mindustry.content.Planets;
import mindustry.type.*;
import mindustry.world.meta.*;

public class JPItem{
    public static Item

    azurite,biomass,biosil,Carbinecomposite,fluoresilt,
    fluorite,naniteAlloy,neocell,vanadium,vanadiumCarbideAlloy,
    voltaicGas,zinc,umbratechChip,voidStone;

    public static void load(){
        azurite = new Item("azurite", Color.valueOf("245485")){{
            hardness = 3;
            cost = 0.5f;
        }};

        biomass = new Item("biomass", Color.valueOf("8B73C7")){{
            cost = 1f;
            flammability = 3.5f;
        }};

        biosil = new Item("biosil", Color.valueOf("45368F")){{
            cost = 1.25f;
            flammability = 0.65f;
        }};

        Carbinecomposite = new Item("carbineComposite", Color.valueOf("45368F")){{
            cost = 1.5f;
            flammability = 2f;
        }};

        fluoresilt = new Item("fluoresilt", Color.valueOf("23DBDE")){{
            hardness = 1;
            cost = 1.5f;
        }};

        fluorite = new Item("fluorite", Color.valueOf("23DBDE")){{
            cost = 1.75f;
        }};

        naniteAlloy = new Item("naniteAlloy", Color.valueOf("45368F")){{
            cost = 1f;
            flammability = 2f;
            charge = 1f;
            explosiveness = 0.5f;
        }};

        neocell = new Item("neocell", Color.valueOf("590e14")){{
            cost = 1.5f;
            flammability = 1.25f;
            explosiveness = 1.5f;
        }};

        vanadium = new Item("vanadium", Color.valueOf("485767")){{
            hardness = 3;
            cost = 1.5f;
        }};

        vanadiumCarbideAlloy = new Item("vanadiumCarbideAlloy", Color.valueOf("303a45")){{
            cost = 2f;
        }};

        voltaicGas = new Item("voltaicGas", Color.valueOf("45368F")){{
            cost = 1f;
            flammability = 2f;
        }};

        zinc = new Item("zinc", Color.valueOf("747474")){{
            hardness = 69;
            cost = 0.5f;
        }};

        umbratechChip = new Item("umbratechChip", Color.valueOf("ffffff")){{
        }};

        voidStone = new Item("voidStone", Color.valueOf("ffffff")){{
        }};

}};