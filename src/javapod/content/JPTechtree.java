package mindustry.content;

import arc.struct.*;
import mindustry.game.Objectives.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.SectorPresets.craters;
import static mindustry.content.SectorPresets.*;
import static mindustry.content.TechTree.*;
import static mindustry.content.UnitTypes.*;

public class JPTechtree{

    public static void load(){
        Planets.serpulo.techTree = nodeRoot("serpulo", coreShard, () -> {
                        node(conveyor, () -> {
                            node(duo);
                        });
        });
    }
}