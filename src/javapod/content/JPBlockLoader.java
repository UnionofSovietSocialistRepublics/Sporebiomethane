package jp.content;

import jp.content.blocks.*;

public class JPBlockLoader {
    public static void load(){
        JPUnitFactory.load();
        JPEnv.load();
        JPProduction.load();
        JPOther.load();
        JPTurret.load();
        JPDistribution.load();
    }
}