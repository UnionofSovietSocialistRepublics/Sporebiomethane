package jp.content;

import mindustry.world.blocks.production.*;

/** Factory with explodeOnFull because Anuke haven't added explodeonfull to factories yet */
public class JPELF extends GenericCrafter{
    public boolean explodeOnFull = false;

    public JPELF(String name) {
        super(name);
    }
}