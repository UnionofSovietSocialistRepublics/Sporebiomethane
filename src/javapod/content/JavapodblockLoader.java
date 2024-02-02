package javapod.content;

import javapod.content.blocks.*;

public class JavapodblockLoader {
    public static void load(){
        JavapodUnitFactory.load();
        Javapodenv.load();
    }
}