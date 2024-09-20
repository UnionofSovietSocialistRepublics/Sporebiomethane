package jp.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import mindustry.entities.*;
import mindustry.graphics.*;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;


public class JPFx {
    public static final Rand rand = new Rand();
    public static Effect

    purpleLaserChargeSmall = new Effect(40f, 100f, e -> {
        color(Color.valueOf("8B73C7"));
        stroke(e.fin() * 2f);
        Lines.circle(e.x, e.y, e.fout() * 50f);
    }).followParent(true).rotWithParent(true),
            bulletExplosion = new Effect(30, 500f, b -> {
                float intensity = 6.8f;
                float baseLifetime = 25f + intensity * 11f;
                b.lifetime = 50f + intensity * 65f;

                color(Color.valueOf("87ceeb"));
                alpha(0.7f);
                for(int i = 0; i < 4; i++){
                    rand.setSeed(b.id*2 + i);
                    float lenScl = rand.random(0.4f, 1f);
                    int fi = i;
                    b.scaled(b.lifetime * lenScl, e -> {
                        randLenVectors(e.id + fi - 1, e.fin(Interp.pow10Out), (int)(2.9f * intensity), 22f * intensity, (x, y, in, out) -> {
                            float fout = e.fout(Interp.pow5Out) * rand.random(0.5f, 1f);
                            float rad = fout * ((2f + intensity) * 2.35f);

                            Fill.circle(e.x + x, e.y + y, rad);
                            Drawf.light(e.x + x, e.y + y, rad * 2.5f, Color.valueOf("87ceeb"), 0.5f);
                        });
                    });
                }

                b.scaled(baseLifetime, e -> {
                    Draw.color();
                    e.scaled(5 + intensity * 2f, i -> {
                        stroke((3.1f + intensity/5f) * i.fout());
                        Lines.circle(e.x, e.y, (3f + i.fin() * 14f) * intensity);
                        Drawf.light(e.x, e.y, i.fin() * 14f * 2f * intensity, Color.white, 0.9f * e.fout());
                    });

                    color(Pal.lighterOrange, Color.valueOf("87ceeb"), e.fin());
                    stroke((2f * e.fout()));

                    Draw.z(Layer.effect + 0.001f);
                    randLenVectors(e.id + 1, e.finpow() + 0.001f, (int)(8 * intensity), 28f * intensity, (x, y, in, out) -> {
                        lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + out * 4 * (4f + intensity));
                        Drawf.light(e.x + x, e.y + y, (out * 4 * (3f + intensity)) * 3.5f, Draw.getColor(), 0.8f);
                    });
                });
            });
}