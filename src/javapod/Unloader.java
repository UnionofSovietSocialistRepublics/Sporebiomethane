package javapod;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import javapod.content.JavapodItem;
import javapod.content.JavapodblockLoader;
import javapod.content.*;

public class Unloader extends Mod{

    public Unloader(){
        Log.info("Unloading the storm");
    }

    @Override
    public void loadContent(){
        Log.info("Ah shit here we go again. Another mod, another load.");
        JavapodStatus.load();
        Log.info("Loading items");
        JavapodItem.load();
        Log.info("Loading units");
        JavapodUnits.load();
        Log.info("Loading blocks");
        JavapodblockLoader.load();
    }

}