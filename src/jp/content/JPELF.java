package jp.content;

import arc.*;
import arc.audio.Sound;
import arc.math.*;
import arc.util.*;
import mindustry.content.Fx;
import mindustry.entities.*;
import mindustry.entities.Effect;
import mindustry.game.EventType.*;
import mindustry.gen.Sounds;
import mindustry.type.*;
import mindustry.world.Tile;
import mindustry.world.blocks.production.*;

import static mindustry.Vars.*;


/** Factory with explodeOnFull because Anuke haven't added explodeonfull to factories yet */
public class JPELF extends GenericCrafter {
    public boolean explodeOnFull = true;
    public float baseLightRadius = 65f;
    public int explosionRadius = 12;
    public int explosionDamage = 0;
    public Effect explodeEffect = Fx.none;
    public Sound explodeSound = Sounds.none;

    public int explosionPuddles = 10;
    public float explosionPuddleRange = tilesize * 2f;
    public float explosionPuddleAmount = 100f;
    public @Nullable Liquid explosionPuddleLiquid;
    public float explosionMinWarmup = 0f;

    public float explosionShake = 0f, explosionShakeDuration = 6f;
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
        public void draw(){
            drawer.draw(this);
        }

        @Override
        public void drawLight(){
            super.drawLight();
            drawer.drawLight(this);
        }

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

        @Override
        public void onDestroyed(){
            super.onDestroyed();

            if(state.rules.reactorExplosions){
                createExplosion();
            }
        }

        public boolean shouldExplode(){
            return warmup() >= explosionMinWarmup;
        }

        public void createExplosion(){
            if(shouldExplode()){
                if(explosionDamage > 0){
                    Damage.damage(x, y, explosionRadius * tilesize, explosionDamage);
                }

                explodeEffect.at(this);
                explodeSound.at(this);

                if(explosionPuddleLiquid != null){
                    for(int i = 0; i < explosionPuddles; i++){
                        Tmp.v1.trns(Mathf.random(360f), Mathf.random(explosionPuddleRange));
                        Tile tile = world.tileWorld(x + Tmp.v1.x, y + Tmp.v1.y);
                        Puddles.deposit(tile, explosionPuddleLiquid, explosionPuddleAmount);
                    }
                }

                if(explosionShake > 0){
                    Effect.shake(explosionShake, explosionShakeDuration, this);
                }
            }
        }
    }
}