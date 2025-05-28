package jp.content;

import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.consumers.ConsumeLiquidBase;

//Why consume no work?? Hello, modding help department???
public abstract class JPConsumeLiquidBase extends ConsumeLiquidBase {

    public float amount;

    public JPConsumeLiquidBase(float amount){
        this.amount = amount;
    }

    public JPConsumeLiquidBase(){}

    @Override
    public void apply(Block block){
        block.hasLiquids = true;
    }

    public abstract boolean consumes(Liquid liquid);
}