package jp.content;

import arc.struct.*;
import mindustry.content.Planets;
import mindustry.content.TechTree;
import mindustry.game.Objectives.*;
import mindustry.type.ItemStack;
import jp.content.*;
import jp.content.blocks.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.*;
import static mindustry.content.UnitTypes.*;
import static mindustry.content.SectorPresets.*;

public class JPtechtree {
    public static void load(){
        nodeRoot("Spore biomechs", coreShard, false, () -> {
            //Above the skies is the currently the placeholder for now, the required sector will changes later.
            node(JPOther.Sporecore, Seq.with(new SectorComplete(JPsectors.Ski)), () -> {
                node(JPOther.Hive, () -> {
                    node(JPOther.Nydusaecore);
                });
            });
            node(JPTurret.Sporegarrison, Seq.with(new SectorComplete(JPsectors.Ski)), () -> {
                node(JPTurret.Flakaccelerator, () -> {
                    node(JPTurret.Suppressor);
                 });
                node(JPTurret.Mitocannon);
                node(JPTurret.Oarch, () -> {
                    node(JPTurret.Artilleryturret, () -> { 
                        node(JPTurret.Impalercannon);
                        node(JPTurret.Sentinel);
                    });
                    
                });
    });
            
            node(JPProduction.Nanoprocessor, Seq.with(new SectorComplete(JPsectors.Ski)), () -> {
                node(JPProduction.Vanadicarbide);
                node(JPProduction.Gaschamber);
                node(JPProduction.FR);
                node(JPProduction.Masscultivator);
                node(JPProduction.BioSynthesizer, () -> {
                    node(JPProduction.Naniteinfuser, () -> {
                        node(JPProduction.CCB, () -> {
                            node(JPProduction.Neostabilizer);
                        });
                    });
                });
            });
            node(JPUnitFactory.pool, Seq.with(new SectorComplete(JPsectors.Ski)), () -> {
                node(JPUnitFactory.Synapsetower, () -> {
                    node(JPUnitFactory.Assembler, () -> {
                        node(JPUnitAssembler.ApollyonAssembler);
                    });
                    node(JPUnitFactory.Gestator);
                });
            });
            node(JPProduction.Lotus, () -> {
                node(JPProduction.Biomassreactor, () -> { 
                    node(JPProduction.Neocell);
                });
            });
            node(JPProduction.Extractor);
            node(JPOther.VCAwall);
            node(JPsectors.Ski, Seq.with(new SectorComplete(frozenForest)), () -> {
                node(JPsectors.Frost);
            });
            
    }
);}};
