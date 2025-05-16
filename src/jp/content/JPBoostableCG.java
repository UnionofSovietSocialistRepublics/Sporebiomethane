package jp.content;

import mindustry.world.blocks.power.*;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;


public class JPBoostableCG extends ConsumeGenerator {

    public float useTime = 400f;
    public float liquidBoostIntensity = 1.6f;

    public JPBoostableCG(String name) {
        super(name);
    }

    @Override
    public void setStats() {
        super.setStats();
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

    public class JPBoostableCGBuild extends ConsumeGeneratorBuild{


        }
    }

