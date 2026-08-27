package jp.content.blocks;

import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.environment.*;
import jp.content.*;
import mindustry.world.meta.BuildVisibility;

import static mindustry.content.Items.silicon;
import static mindustry.type.ItemStack.with;

public class JPEnv {
    public static Block
    vanadiumOre, azuriteOre,
    wall,
	SiltMoss,fluoresiltTile,silt,tile,
	blackBoulder;

    public static void load() {
	//block part

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
        SiltMoss = new Floor("siltMoss"){{
			variants = 3;
		}};
        fluoresiltTile = new Floor("fluoresiltTile"){{
			variants = 4;
			itemDrop = JPItem.fluoresilt;
		}};
        silt = new Floor("silt"){{
			variants = 4;
		}};
        tile = new Floor("tile"){{
			variants = 2;
		}};
        blackBoulder = new Wall("blackBoulder"){{
            requirements(Category.effect, BuildVisibility.editorOnly, with(silicon, 270));
            size = 2;
            health = 2000;
		}};
    }

}