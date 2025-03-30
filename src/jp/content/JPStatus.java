package jp.content;

import mindustry.type.StatusEffect;

public class JPStatus {
    public static StatusEffect
    Dissolving, Frostshield, Regen, Mindcontrol, Reversion;
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
    }};
