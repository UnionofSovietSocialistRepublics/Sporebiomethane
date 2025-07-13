package jp.content;

import arc.graphics.*;
import mindustry.content.Planets;
import mindustry.type.*;

public class JPItem{
    public static Item

    Azurite,Biomass,BioSil,Carbinecomposite,Fluoresilt,Fluorite,Nanitealloy,Neocells,Vanadium,VCA,Voltaicgas,Zinc;
    public static void load(){
        Azurite = new Item("Azurite", Color.valueOf("245485")){{
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            hardness = 3;
            cost = 0.5f;
        }};

        Biomass = new Item("Biomass", Color.valueOf("8B73C7")){{
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            cost = 1f;
            flammability = 3.5f;
        }};

        BioSil = new Item("BioSil", Color.valueOf("45368F")){{
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            cost = 1.25f;
            flammability = 0.65f;
        }};

        Carbinecomposite = new Item("Carbine-composite", Color.valueOf("45368F")){{
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            cost = 1.5f;
            flammability = 2f;
        }};

        Fluoresilt = new Item("Fluoresilt", Color.valueOf("23DBDE")){{
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            hardness = 1;
            cost = 1.5f;
        }};

        Fluorite = new Item("Fluorite", Color.valueOf("23DBDE")){{
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            cost = 1.75f;
        }};

        Nanitealloy = new Item("Nanitealloy", Color.valueOf("45368F")){{
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            cost = 1f;
            flammability = 2f;
            charge = 1f;
            explosiveness = 0.5f;
        }};

        Neocells = new Item("Neocells", Color.valueOf("590e14")){{
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            cost = 1.5f;
            flammability = 1.25f;
            explosiveness = 1.5f;
        }};

        Vanadium = new Item("Vanadium", Color.valueOf("485767")){{
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            hardness = 3;
            cost = 1.5f;
        }};

        VCA = new Item("VCA", Color.valueOf("303a45")){{
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            cost = 2f;
        }};

        Voltaicgas = new Item("Voltaicgas", Color.valueOf("45368F")){{
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            cost = 1f;
            flammability = 2f;
        }};

        Zinc = new Item("Zinc", Color.valueOf("747474")){{
            shownPlanets.addAll(Planets.serpulo, Planets.erekir);
            hardness = 69;
            cost = 0.5f;
        }};

}};