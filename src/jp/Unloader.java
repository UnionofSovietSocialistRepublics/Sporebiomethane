package jp;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import jp.content.*;


public class Unloader extends Mod{

    public Unloader(){
        Log.info("Unloading the storm");
        Events.on(ClientLoadEvent.class, e -> {
        double random = Math.floor(Math.random() * 5);
        //undoable the random (java double are wacky, and they refuse to be inside switch case)
        int rand = (int) Math.round(random);
        //replace subtitle with author with funky thing
        switch(rand){
        case 1:
        Vars.mods.locateMod("jp").meta.author="Hydroabyss & Coffee molecules";
        Vars.mods.locateMod("jp").meta.subtitle="Now with extra coffee";
        break;
        case 2:
        Vars.mods.locateMod("jp").meta.author="Hydroabyss & Neoplasm Molecule";
        Vars.mods.locateMod("jp").meta.subtitle="Red sun over serpulo";
        break;
        case 3:
        Vars.mods.locateMod("jp").meta.author="ssybaordyH & seluceloM retaW";
        Vars.mods.locateMod("jp").meta.subtitle="...gnorw si gnihtemoS ?gnorw gnihtemos sI";
        break;
        case 4:
        Vars.mods.locateMod("jp").meta.author="Hydrogen & Oxygen";
        Vars.mods.locateMod("jp").meta.subtitle="2 H2 + O2 = 2 H2O!";
        break;
        case 5:
        Vars.mods.locateMod("jp").meta.author="Abyss & Duke";
        Vars.mods.locateMod("jp").meta.subtitle="Json has fallen, billion must java.";
        break;
        default:
        Vars.mods.locateMod("jp").meta.author="Hydroabyssal & Germanium";
        Vars.mods.locateMod("jp").meta.subtitle="For the Deutschland!";
        break;
        }
        //Nothing suspicious around here, trust me bro
        if (Vars.mods.locateMod("aquarion") != null){
            Log.info("Bro got caught lackin");
            Vars.mods.locateMod("aquarion").meta.displayName="Aquarium";
            Vars.mods.locateMod("aquarion").meta.author="Twmoney";
//            Vars.mods.locateMod("aquarion").meta.description="Aquarium.";
            Vars.mods.locateMod("aquarion").meta.subtitle="Aquarium";
        }
        });
    }
    @Override
    public void init() {
        // IDK what super and init does but settings only work when init
        super.init();
        JPSettings.init();
    }
    @Override
    public void loadContent(){
        Log.info("Ah shit here we go again. Another mod, another load.");
        JPStatus.load();
        JPLiquids.load();
        JPAttribute.load();
        JPSounds.load();
        Log.info("Loading items");
        JPItem.load();
        Log.info("Loading units");
        JPUnits.load();
        Log.info("Loading blocks");
        JPBlockLoader.load();
        Log.info("Loading Techcub- I mean Techtree");
        if(Core.settings.getBool("HM")){
        JPsectorsHM.load();}
        else{
        JPsectors.load();
        }
        JPtechtree.load();
    }

}

