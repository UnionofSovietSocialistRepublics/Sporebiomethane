package jp.content;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.meta.*;

public class JPItem{
    public static Item

    tree,azurite,biomass,biosil,Carbinecomposite,fluoresilt,
    fluorite,naniteAlloy,neocell,vanadium,vanadiumCarbideAlloy,
    voltaicGas,zinc,umbratechChip,voidStone;

    public static void load(){
        tree = new Item("tree", Color.valueOf("245485")){{
            hidden=true;
        }};
        azurite = new Item("azurite", Color.valueOf("245485")){{
            hardness = 3;
            cost = 0.5f;
            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        biomass = new Item("biomass", Color.valueOf("8B73C7")){{
            cost = 1f;
            flammability = 3.5f;
            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);

        }};

        biosil = new Item("biosil", Color.valueOf("45368F")){{
            cost = 1.25f;
            flammability = 0.65f;
            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        Carbinecomposite = new Item("carbineComposite", Color.valueOf("45368F")){{
            cost = 1.5f;
            flammability = 2f;
            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        fluoresilt = new Item("fluoresilt", Color.valueOf("23DBDE")){{
            hardness = 1;
            cost = 1.5f;
            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        fluorite = new Item("fluorite", Color.valueOf("23DBDE")){{
            cost = 1.75f;
            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        naniteAlloy = new Item("naniteAlloy", Color.valueOf("45368F")){{
            cost = 1f;
            flammability = 2f;
            charge = 1f;
            explosiveness = 0.5f;
            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        neocell = new Item("neocell", Color.valueOf("590e14")){{
            cost = 1.5f;
            flammability = 1.25f;
            explosiveness = 1.5f;
            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        vanadium = new Item("vanadium", Color.valueOf("485767")){{
            hardness = 3;
            cost = 1.5f;
            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        vanadiumCarbideAlloy = new Item("vanadiumCarbideAlloy", Color.valueOf("303a45")){{
            cost = 2f;
            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        voltaicGas = new Item("voltaicGas", Color.valueOf("45368F")){{
            cost = 1f;
            flammability = 2f;
            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        zinc = new Item("zinc", Color.valueOf("747474")){{
            hardness = 69;
            cost = 0.5f;
            shownPlanets.add(Planets.serpulo);
            shownPlanets.add(Planets.erekir);
        }};

        umbratechChip = new Item("umbratechChip", Color.valueOf("ffffff")){{
            shownPlanets.add(Planets.gier);
        }};

        voidStone = new Item("voidStone", Color.valueOf("ffffff")){{
            shownPlanets.add(Planets.gier);
        }};

}};