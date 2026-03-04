package jp.content.blocks;

import mindustry.world.Block;
import mindustry.world.blocks.environment.*;
import jp.content.*;

public class JPEnv {
    public static Block
    vanadiumOre, azuriteOre,
    wall,
	SiltMoss,Fluoresiltile,silt,tile,
	Blackboulder;

    public static void load() {
	//block part
		//Official removal of zinc ore (rip bozo)
		// ZincOre = new OreBlock("ZincOre"){{
		// 	oreDefault = true;
		// 	variants = 1;
		// 	oreThreshold = 0.95F;
		// 	oreScale = 20.380953F;
		// 	itemDrop = JPItem.zinc;
		// 	attributes.set(JPAttribute.zinc, 1.5f);
		// 	mapColor.set(itemDrop.color);
		// 	useColor = true;
		// }};

        vanadiumOre = new OreBlock("vanadiumOre") {{
        itemDrop = JPItem.vanadium;
		variants = 3;
        }};

        azuriteOre = new OreBlock("azuriteOre") {{
        itemDrop = JPItem.azurite;
		variants = 3;
        }};

        wall = new StaticWall("wall"){{
			variants = 1;
		}};
        SiltMoss = new Floor("silt-moss"){{
			variants = 3;
		}};
        Fluoresiltile = new Floor("Fluoresiltile"){{
			variants = 4;
			itemDrop = JPItem.Fluoresilt;
		}};
        silt = new Floor("silt"){{
			variants = 4;
		}};
        tile = new Floor("tile"){{
			variants = 2;
		}};
        Blackboulder = new Prop("Blackboulder"){{
			variants = 1;
		}};
    }

}