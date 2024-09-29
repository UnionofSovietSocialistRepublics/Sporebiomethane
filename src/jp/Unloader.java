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
        Vars.mods.locateMod("jp").meta.author="Coffee molecules";
        Vars.mods.locateMod("jp").meta.subtitle="Now with extra coffee";
        break;
        case 2:
        Vars.mods.locateMod("jp").meta.author="Neoplasm";
        Vars.mods.locateMod("jp").meta.subtitle="The dance of the nightbugs!";
        break;
        case 3:
        Vars.mods.locateMod("jp").meta.author="Moonupper";
        Vars.mods.locateMod("jp").meta.subtitle="Red sun is now over paradise";
        break;
        case 4:
        Vars.mods.locateMod("jp").meta.author="Ice molecules";
        Vars.mods.locateMod("jp").meta.subtitle="Extra frosty editon"; //boss (Frost) reference
        break;
        case 5:
        Vars.mods.locateMod("jp").meta.author="Duke";
        Vars.mods.locateMod("jp").meta.subtitle="The javafication shall begun";
        break;
        default:
        Vars.mods.locateMod("jp").meta.author="Hardmode water";
        Vars.mods.locateMod("jp").meta.subtitle="Now with extra difficulty spike"; //frozen farland reference!111!111 (frozen farland difficulty spike is so unreal I cant even) Also commented out because too long
        break;
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

