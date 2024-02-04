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
    }

    @Override
    public void loadContent(){
        Log.info("Ah shit here we go again. Another mod, another load.");
        JPStatus.load();
        JPAttribute.load();
        Log.info("Loading items");
        JPItem.load();
        Log.info("Loading units");
        JPUnits.load();
        Log.info("Loading blocks");
        JPBlockLoader.load();
    }

}