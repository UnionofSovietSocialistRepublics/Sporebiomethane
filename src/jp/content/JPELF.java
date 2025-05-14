package jp.content;

import arc.*;
import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.game.EventType.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;
import mindustry.world.blocks.production.*;

import static mindustry.Vars.tilesize;

/** Factory with explodeOnFull because Anuke haven't added explodeonfull to factories yet */
public class JPELF extends GenericCrafter {
    public boolean explodeOnFull = false;
    public float baseLightRadius = 65f;
    public @Nullable Liquid explosionPuddleLiquid;
    public float updateEffectSpread = 4f;

    public JPELF(String name) {
        super(name);
    }

    @Override
    public void init() {
        if (explodeOnFull && outputLiquid != null && explosionPuddleLiquid == null) {
            explosionPuddleLiquid = outputLiquid.liquid;
        }
        emitLight = true;
        lightRadius = baseLightRadius * size;
        super.init();
    }


    public class JPELFBuild extends GenericCrafterBuild {

        @Override
        public void updateTile(){
            if(efficiency > 0){
                progress += getProgressIncrease(craftTime);
                warmup = Mathf.approachDelta(warmup, warmupTarget(), warmupSpeed);

                //continuously output based on efficiency
                if(outputLiquids != null){
                    float inc = getProgressIncrease(1f);
                    for(var output : outputLiquids){
                        handleLiquid(this, output.liquid, Math.min(output.amount * inc, liquidCapacity - liquids.get(output.liquid)));
                    }
                    if (explodeOnFull && liquids.get(outputLiquid.liquid) >= liquidCapacity - 0.01f) {
                        kill();
                        Events.fire(new GeneratorPressureExplodeEvent(this));
                    }
                }

                if(wasVisible && Mathf.chanceDelta(updateEffectChance)){
                    updateEffect.at(x + Mathf.range(size * updateEffectSpread), y + Mathf.range(size * updateEffectSpread));
                }
            }else{
                warmup = Mathf.approachDelta(warmup, 0f, warmupSpeed);
            }


            totalProgress += warmup * Time.delta;

            if(progress >= 1f){
                craft();
            }

            dumpOutputs();
        }
    }
}