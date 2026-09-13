package jp.content;

import arc.graphics.*;
import arc.scene.ui.layout.Table;
import arc.struct.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.units.*;

import static mindustry.Vars.content;

public class JPMiningOutPost extends UnitCargoLoader {
    public float unitBuildTime = 60f * 8f;

    public float staleTimeDuration = 60f * 6f;

    public JPMiningOutPost(String name) {
        super(name);
        unitType = JPUnits.harvester;
        update = solid = true;
        hasItems = true;
        configurable = true;
        saveConfig = true;
        clearOnDoubleTap = true;

        config(Item.class, (JPMiningOutpostBuild build, Item item) -> build.item = item);
        configClear((JPMiningOutpostBuild build) -> build.item = null);
        itemCapacity = 200;
        ambientSound = Sounds.loopUnitBuilding;
    }

    public class JPMiningOutpostBuild extends UnitTransportSourceBuild {
        public @Nullable Unit unit;
        public Item item;
        public float staleTimer;
        public boolean stale;


        @Override
        public void updateTile(){
            super.updateTile();

            if(items.total() < itemCapacity){
                staleTimer = 0f;
                stale = false;
            }

            if(dumpAccumulate()){
                staleTimer = 0f;
                stale = false;
            }else if(items.total() >= itemCapacity && (staleTimer += Time.delta) >= staleTimeDuration){
                stale = true;
            }
        }
        @Override
        public int acceptStack(Item item, int amount, Teamc source){
            return Math.min(itemCapacity - items.total(), amount);
        }

        public void buildConfiguration(Table table){
            ItemSelection.buildTable(JPMiningOutPost.this, table, content.items(), () -> item, this::configure);
        }

        @Override
        public Object config(){
            return item;
        }

    }
}
