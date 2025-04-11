package jp.content;

import mindustry.content.*;
import arc.graphics.*;
import mindustry.type.StatusEffect;

public class JPStatus {
    public static StatusEffect
    dissolving, frostshield, regen, mindcontrol, reversion, reversionD, hellspawn, stunned;
    public static void load(){
        dissolving = new StatusEffect("dissolving"){{
            damage = 60f / 60f;
        }};
        regen = new StatusEffect("regen"){{
            damage = -60f / 60f;
        }};
        frostshield = new StatusEffect("frostshield"){{
            healthMultiplier = 4f;
        }};
        reversion = new StatusEffect("reversion"){{
            speedMultiplier = -1f;
        }};
        reversionD = new StatusEffect("reversionD"){{
            speedMultiplier = -1f;
            disarm = true;
        }};
        stunned = new StatusEffect("stunned"){{
            speedMultiplier = 0f;
            disarm = true;
        }};
        hellspawn = new StatusEffect("hellspawn"){{
            effect = Fx.burning;
            color = Color.valueOf("ffc455");
            damage = 6f / 60f;
            speedMultiplier = 1.25f;
            damageMultiplier = 1.25f;
        }};
    }}
