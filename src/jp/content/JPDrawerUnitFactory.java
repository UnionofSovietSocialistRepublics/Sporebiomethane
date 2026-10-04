package jp.content;

import arc.graphics.g2d.*;
import arc.struct.*;
import arc.util.*;
import mindustry.entities.units.*;
import mindustry.graphics.*;
import mindustry.world.blocks.units.*;
import mindustry.world.draw.*;

import static mindustry.Vars.*;

//Custom unit factory with drawers n stuff
//Poorly implemented.
public class JPDrawerUnitFactory extends UnitFactory {

    public TextureRegion bottomRegion;

    public JPDrawerUnitFactory(String name) {
        super(name);
        update = true;
        solid = true;
    }

    public DrawBlock drawer = new DrawDefault();

    @Override
    public void drawPlanRegion(BuildPlan plan, Eachable<BuildPlan> list){
        drawer.drawPlan(this, plan, list);
        Draw.rect(outRegion, plan.drawx(), plan.drawy(), plan.rotation * 90);
        Draw.rect(topRegion, plan.drawx(), plan.drawy());
    }
    @Override
    public TextureRegion[] icons(){
        return new TextureRegion[]{bottomRegion, region, outRegion, topRegion};
    }
    @Override public void getRegionsToOutline(Seq<TextureRegion> out){
        drawer.getRegionsToOutline(this, out);
    }
    @Override public void load(){
        super.load();
        this.bottomRegion = this.findFactoryRegion("-bottom");
        drawer.load(this);
    }


    public class JPDrawerUnitFactoryBuild extends UnitFactoryBuild{

        @Override
        public void draw(){
            drawer.draw(this);
            Draw.rect(outRegion, x, y, rotdeg());

            if(currentPlan != -1){
                UnitPlan plan = plans.get(currentPlan);
                Draw.draw(Layer.blockOver, () -> Drawf.construct(this, plan.unit, rotdeg() - 90f, progress / plan.time, speedScl, time));
            }

            Draw.z(Layer.blockOver);

            payRotation = rotdeg();
            drawPayload();

            Draw.z(Layer.blockOver + 0.1f);

            Draw.rect(topRegion, x, y);
        }
        @Override
        public void drawLight(){
            super.drawLight(); drawer.drawLight(this);
        }

    }
}
