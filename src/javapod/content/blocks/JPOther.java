package jp.content.blocks;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
//import jp.content.jpAC;
import jp.content.*;
import mindustry.content.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;


public class JPOther{
    public static Block
VCAwall,Sporecore,Hive;

        public static void load(){
        
        VCAwall = new Wall("Vanadiumcarbidewall"){{
            requirements(Category.defense, with(JPItem.VCA, 40));
            size = 2;
            health = 8500;
        }};
        Sporecore = new CoreBlock("Sporecore"){{
            requirements(Category.effect, with(JPItem.Biomass, 3000, JPItem.Nanitealloy, 2000, silicon, 4000));

            unitType = JPUnits.Hivedefender;
            health = 6500;
            itemCapacity = 11000;
            size = 4;
            thrusterLength = 34/4f;

            unitCapModifier = 24;
            researchCostMultiplier = 0.5f;
        }};
        Hive = new CoreBlock("Hive"){{
            requirements(Category.effect, with(JPItem.Biomass, 6000, JPItem.Nanitealloy, 4000, silicon, 8000, surgeAlloy, 4000));

            unitType = JPUnits.HiveSentinel;
            health = 9500;
            itemCapacity = 15000;
            size = 5;
            thrusterLength = 34/4f;

            unitCapModifier = 40;
            researchCostMultiplier = 0.25f;
        }};
}};