package jp.content;

import arc.graphics.Color;
import arc.graphics.g2d.Lines;
import mindustry.entities.Effect;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.stroke;

public class JPFx {
    public static Effect
    purpleLaserChargeSmall = new Effect(40f, 100f, e -> {
        color(Color.valueOf("8B73C7"));
        stroke(e.fin() * 2f);
        Lines.circle(e.x, e.y, e.fout() * 50f);
    }).followParent(true).rotWithParent(true);

}
