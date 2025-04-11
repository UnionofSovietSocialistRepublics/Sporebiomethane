package jp.content;

import mindustry.content.*;
import arc.graphics.*;
import mindustry.type.StatusEffect;

public class JPStatus {
    public static StatusEffect
    Dissolving, Frostshield, Regen, Mindcontrol, Reversion, ReversionD, Hellspawn;
    public static void load(){
        Dissolving = new StatusEffect("Dissolving"){{
            damage = 60f / 60f;
        }};
        Regen = new StatusEffect("Regen"){{
            damage = -60f / 60f;
        }};
        Frostshield = new StatusEffect("Frostshield"){{
            healthMultiplier = 4f;
        }};
        Reversion = new StatusEffect("Reversion"){{
            speedMultiplier = -1f;
        }};
        ReversionD = new StatusEffect("ReversionD"){{
            speedMultiplier = -1f;
            disarm = true;
        }};
        Hellspawn = new StatusEffect("Hellspawn"){{
            effect = Fx.burning;
            color = Color.valueOf("ffc455");
            damage = 6f / 60f;
            speedMultiplier = 1.25f;
            damageMultiplier = 1.25f;
        }};
    }}
