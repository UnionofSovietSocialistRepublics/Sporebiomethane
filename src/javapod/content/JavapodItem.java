package javapod.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

public class JavapodItem{
    public static Item

    Azurite,Biomass,BioSil,Carbinecomposite,Fluoresilt,Fluorite,Nanitealloy,Neocells,Vanadium,VCA,Voltaicgas,Zinc;
    public static void load(){
        Azurite = new Item("Azurite", Color.valueOf("245485")){{
            hardness = 3;
            cost = 0.5f;
        }};

        Biomass = new Item("Biomass", Color.valueOf("8B73C7")){{
            cost = 1f;
            flammability = 3.5f;
        }};

        BioSil = new Item("BioSil", Color.valueOf("45368F")){{
            cost = 1.25f;
            flammability = 0.65f;
        }};

        Carbinecomposite = new Item("Carbine-composite", Color.valueOf("45368F")){{
            cost = 1.5f;
            flammability = 2f;
        }};

        Fluoresilt = new Item("Fluoresilt", Color.valueOf("23DBDE")){{
            hardness = 1;
            cost = 1.5f;
        }};

        Fluorite = new Item("Fluorite", Color.valueOf("23DBDE")){{
            cost = 1.75f;
        }};

        Nanitealloy = new Item("Nanitealloy", Color.valueOf("45368F")){{
            cost = 1f;
            flammability = 2f;
            charge = 1f;
            explosiveness = 0.5f;
        }};

        Neocells = new Item("Neocells", Color.valueOf("590e14")){{
            cost = 1.5f;
            flammability = 1.25f;
            explosiveness = 1.5f;
        }};

        Vanadium = new Item("Carbine-composite", Color.valueOf("485767")){{
            hardness = 3;
            cost = 1.5f;
            flammability = 2f;
        }};

        VCA = new Item("VCA", Color.valueOf("303a45")){{
            cost = 2f;
        }};

        Voltaicgas = new Item("Voltaicgas", Color.valueOf("45368F")){{
            cost = 1f;
            flammability = 2f;
        }};

        Zinc = new Item("Zinc", Color.valueOf("747474")){{
            hardness = 69;
            cost = 0.5f;
        }};

}};