package jp.content;

import arc.graphics.Color;
import arc.graphics.g2d.Fill;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.type.StatusEffect;
import mindustry.game.Team;

public class JPStatus {
    public static StatusEffect
    Dissolving, Frostshield, Regen, Mindcontrol;
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
    }};
