package jp.content;

import mindustry.world.blocks.power.*;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;
import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.annotations.Annotations.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.units.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.logic.*;
import mindustry.type.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;

public class JPBoostableCG extends ConsumeGenerator {

    public float useTime = 400f;
    public float liquidBoostIntensity = 1.6f;

    public JPBoostableCG(String name) {
        super(name);
    }

    public class JPBoostableCGBuild extends ConsumeGeneratorBuild{

        public void setStats() {
            stats.timePeriod = useTime;


            if(liquidBoostIntensity != 1 && findConsumer(f -> f instanceof ConsumeLiquidBase && f.booster) instanceof ConsumeLiquidBase consBase){
                stats.remove(Stat.booster);
                stats.add(Stat.booster,
                        StatValues.speedBoosters("{0}" + StatUnit.timesSpeed.localized(),
                                consBase.amount,
                                liquidBoostIntensity * liquidBoostIntensity, false, consBase::consumes)
                );
            }
        }
        }
    }

