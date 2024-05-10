package jp;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import jp.content.*;
public class Unloader extends Mod{

    public Unloader(){
        Log.info("Unloading the storm");
        Events.on(ClientLoadEvent.class, e -> {
        double random = Math.floor(Math.random() * 5);
        //undouble the random (java double are wacky and they refuses to be inside switch case)
        int rand = (int) Math.round(random);
        //replace subtitle with author with funky thing
        switch(rand){
        case 1:
        Vars.mods.locateMod("jp").meta.author="Walter white";
        Vars.mods.locateMod("jp").meta.subtitle="Now with extra coffee";
        break;
        case 2:
        Vars.mods.locateMod("jp").meta.author="Not water molecules";
        Vars.mods.locateMod("jp").meta.subtitle="Now with mosquitoes and fly";
        break;
        case 3:
        Vars.mods.locateMod("jp").meta.author="Moonupper";
        Vars.mods.locateMod("jp").meta.subtitle="Red sun is now over paradise";
        break;
        case 4:
        Vars.mods.locateMod("jp").meta.author="Water molecules";
        Vars.mods.locateMod("jp").meta.subtitle="Extra frosty editon"; //boss (Frost) reference
        break;
        case 5:
        Vars.mods.locateMod("jp").meta.author="Horizon";
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
    public void loadContent(){
        Log.info("Ah shit here we go again. Another mod, another load.");
        JPStatus.load();
        JPAttribute.load();
        JPSounds.load();
        Log.info("Loading items");
        JPItem.load();
        Log.info("Loading units");
        JPUnits.load();
        Log.info("Loading blocks");
        JPBlockLoader.load();
        Log.info("Loading Techcub- I mean Techtree");
        if(Core.settings.getBool("HM") == true){
        JPsectorsHM.load();}
        else{
        JPsectors.load();
        }
        JPtechtree.load();
    }

}