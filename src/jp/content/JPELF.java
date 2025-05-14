package jp.content;

import arc.*;
import arc.math.*;
import arc.util.*;
import mindustry.game.EventType.*;
import mindustry.type.*;
import mindustry.world.blocks.production.*;


/** Factory with explodeOnFull because Anuke haven't added explodeonfull to factories yet */
public class JPELF extends GenericCrafter {
    public boolean explodeOnFull = true;
    public float baseLightRadius = 65f;
    public @Nullable Liquid explosionPuddleLiquid;
    public float updateEffectSpread = 4f;

    public JPELF(String name) {
        super(name);
    }

    @Override
    public void init() {

        if(outputItems == null && outputItem != null){
            outputItems = new ItemStack[]{outputItem};
        }
        if(outputLiquids == null && outputLiquid != null){
            outputLiquids = new LiquidStack[]{outputLiquid};
        }

        if(outputLiquid == null && outputLiquids != null && outputLiquids.length > 0){
            outputLiquid = outputLiquids[0];
        }
        outputsLiquid = outputLiquids != null;

        if(outputItems != null) hasItems = true;
        if(outputLiquids != null) hasLiquids = true;

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