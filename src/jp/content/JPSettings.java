package jp.content;

import arc.Core;
import mindustry.*;

public class JPSettings {
    public static void init() {
        //Each you turn on or off those setting you need to restart the game for it to take effect. (They're not on by default.)
        Vars.ui.settings.addCategory(Core.bundle.get("jpsettings"), "jp-sporeset", jp -> {
            jp.checkPref("HM", false);
        });

    }
}
