package jp.content;

import arc.*;
import arc.assets.*;
import arc.assets.loaders.*;
import arc.audio.*;

import mindustry.*;

public class JPSounds {
    public static Sound
            Arty = new Sound(),
            ArtyBig = new Sound();

    public static void load(){
        Arty = loadSound("Arty");
        ArtyBig = loadSound("ArtyBig");
    }

    private static Sound loadSound(String soundName){
        if(!Vars.headless) {
            String name = "sounds/" + soundName;
            String path = Vars.tree.get(name + ".ogg").exists() ? name + ".ogg" : name + ".mp3";

            Sound sound = new Sound();

            AssetDescriptor<?> desc = Core.assets.load(path, Sound.class, new SoundLoader.SoundParameter(sound));
            desc.errored = Throwable::printStackTrace;

            return sound;

        } else {
            return new Sound();
        }
    }
}