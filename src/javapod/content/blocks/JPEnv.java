package jp.content.blocks;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.LiquidBulletType;
import mindustry.gen.Sounds;
import mindustry.graphics.CacheLayer;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.BuildVisibility;
import jp.content.*;
import mindustry.content.*;
import static mindustry.type.ItemStack.with;

public class JPEnv {
    public static Block
	//define the block name
	//for the love of god rename those if you want to rename the block below
    ZincOre, VanadiumOre,AzuriteOre,
    Wall,
	SiltMoss,Fluoresiltile,Silt,Tile,
	Blackboulder;

    public static void load() {
	//block part
		//Official removal of zinc ore (rip bozo)
		// ZincOre = new OreBlock("ZincOre"){{
		// 	oreDefault = true;
		// 	variants = 1;
		// 	oreThreshold = 0.95F;
		// 	oreScale = 20.380953F;
		// 	itemDrop = JPItem.Zinc;
		// 	attributes.set(JPAttribute.Zinc, 1.5f);
		// 	mapColor.set(itemDrop.color);
		// 	useColor = true;
		// }};

        VanadiumOre = new OreBlock("VanadiumOre") {{
        itemDrop = JPItem.Vanadium;
		variants = 3;
        }};

        AzuriteOre = new OreBlock("AzuriteOre") {{
        itemDrop = JPItem.Azurite;
		variants = 3;
        }};

        Wall = new StaticWall("Wall"){{
			variants = 1;
		}};
        SiltMoss = new Floor("Silt-moss"){{
			variants = 3;
		}};
        Fluoresiltile = new Floor("Fluoresiltile"){{
			variants = 4;
			itemDrop = JPItem.Fluoresilt;
		}};
        Silt = new Floor("Silt"){{
			variants = 4;
		}};
        Tile = new Floor("Tile"){{
			variants = 2;
		}};
        Blackboulder = new Prop("Blackboulder"){{
			variants = 1;
		}};
    }

}