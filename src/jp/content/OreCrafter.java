package jp.content;

import arc.*;
import mindustry.game.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import arc.struct.*;
import arc.util.*;
import mindustry.world.blocks.production.*;

import static mindustry.Vars.world;


/** A crafter that gains efficiency from attribute tiles. */
public class OreCrafter extends GenericCrafter{
    public ObjectFloatMap<Block> ores = new ObjectFloatMap<>();
    public Attribute attribute = Attribute.heat;
    public float baseEfficiency = 1f;
    public float boostScale = 1f;
    public float maxBoost = 1f;
    public float minEfficiency = -1f;
    public float displayEfficiencyScale = 1f;
    public boolean displayEfficiency = true;
    public boolean scaleLiquidConsumption = false;

    public OreCrafter(String name){
        super(name);
    }

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid){
        super.drawPlace(x, y, rotation, valid);

        Tile t = world.tile(x, y);
        if(t != null) drawPlaceText(Core.bundle.formatFloat("bar.efficiency", getSum(t) * 100, 1), x, y, valid);
    }
    private static final Seq<Block> list = new Seq<>();
   @Override
    public void setStats(){
        super.setStats();
        stats.add(Stat.input, table -> {
            table.left();
            list.clear();
            for(Block b : ores.keys()){
                list.add(b);
            }

            list.sort(Structs.comparingFloat(a -> ores.get(a, 0f)));

            table.table(l -> {
                l.left();

                for(int i = 0; i < list.size; i++){
                    Block item = list.get(i);

                    l.image(item.uiIcon).size(32f);
                    l.add(" " + (int)(ores.get(item, 0f) * 100) + "%").color(item.mapColor);
                    if(i < list.size - 1) l.add(" / ");
                }
            });
        });
    }


    @Override
    public boolean canPlaceOn(Tile tile, Team team, int rotation){
        return getSum(tile) > 0.00001f;
    }

    public float getEfficiency(Block b){
        return ores.get(b, 0f);
    }
    
    public float getSum(Tile tile){
        return tile.getLinkedTilesAs(this, tempTiles).sumf(t -> getEfficiency(t.overlay()));
    }

    public class AttributeCrafterBuild extends GenericCrafterBuild{
        public float sum, maxf, heat;
        public Block maxB = null;
        public float attrsum;

        @Override
        public float getProgressIncrease(float base){
            return super.getProgressIncrease(base) * efficiencyMultiplier();
        }

        public float efficiencyMultiplier(){
            return baseEfficiency + Math.min(maxBoost, boostScale * attrsum) + attribute.env();
        }

        @Override
        public float efficiencyScale(){
            return scaleLiquidConsumption ? efficiencyMultiplier() : super.efficiencyScale();
        }

        @Override
        public void pickedUp(){
            attrsum = 0f;
            warmup = 0f;
        }


        @Override
        public void onProximityAdded(){
            super.onProximityAdded();

            maxf = 0f;
            sum = tile.getLinkedTilesAs(block, tempTiles).sumf(t -> {
                float g = getEfficiency(t.overlay());
                if(g > 0.0001f && (maxB == null || g > maxf)){
                    maxf = g;
                    maxB = t.overlay();
                }
                return g;
            });};
    }
}