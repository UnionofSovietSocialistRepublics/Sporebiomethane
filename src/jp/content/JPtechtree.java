package jp.content;

import arc.*;
import arc.struct.*;
import mindustry.content.SectorPresets;
import mindustry.game.Objectives.*;
import jp.content.blocks.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.*;
import static mindustry.content.SectorPresets.*;

public class JPtechtree {
    public static void load(){
        if(Core.settings.getBool("HM")){
        nodeRoot("Spore biomechs Hardmode", coreShard, false, () -> {
            //Above the skies is currently the placeholder for now, the required sector will change later.
            node(JPOther.Sporecore, Seq.with(new SectorComplete(JPsectorsHM.skiHM)), () -> {
                node(JPOther.Hive, () -> {
                    node(JPOther.Nydusaecore);
                });
            });
            node(JPTurret.Sporegarrison, Seq.with(new SectorComplete(JPsectorsHM.skiHM)), () -> {
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
            
            node(JPProduction.Nanoprocessor, Seq.with(new SectorComplete(JPsectorsHM.skiHM)), () -> {
                node(JPProduction.Vanadicarbide);
                node(JPProduction.Gaschamber);
                node(JPProduction.FR);
                node(JPProduction.Masscultivator);
                node(JPProduction.BioSynthesizer, () -> {
                    node(JPProduction.Naniteinfuser, () -> {
                        node(JPProduction.CCB, () -> {
                            node(JPProduction.neostabilizer);
                        });
                    });
                });
            });
            node(JPUnitFactory.pool, Seq.with(new SectorComplete(JPsectorsHM.skiHM)), () -> {
                node(JPUnitFactory.synapseTower, () -> {
                    node(JPUnitFactory.assembler, () -> {
                        node(JPUnitAssembler.apollyonAssembler);
                    });
                    node(JPUnitFactory.gestator);
                });
            });
            node(JPProduction.Oilburner, () -> {
                node(JPProduction.Lotus);
                node(JPProduction.Voltaicburner, () -> {
                    node(JPProduction.Biomassreactor, () -> { 
                        node(JPProduction.Neocell);
                    });
                });
            });
            node(JPProduction.Extractor, Seq.with(new SectorComplete(JPsectorsHM.digHM)),() -> {
                node(JPProduction.ZincExtractor, Seq.with(new SectorComplete(JPsectorsHM.digHM)), () -> {
            });
            });
            node(JPOther.VCAwall);
             node(JPsectorsHM.skiHM, Seq.with(new SectorComplete(frozenForest)), () -> {
                node(JPsectorsHM.digHM, Seq.with(
                        new SectorComplete(JPsectorsHM.skiHM),
                        new SectorComplete(SectorPresets.craters)
                ), () -> {
                    node(JPsectorsHM.birthHM, Seq.with(
                            new SectorComplete(JPsectorsHM.digHM),
                            new SectorComplete(fungalPass)
                    ), () -> {
                        node(JPsectorsHM.magmaHM, Seq.with(new SectorComplete(JPsectorsHM.birthHM)), () -> {
                            node(JPsectorsHM.Frosted);
                            });
                        });
                });
            });
            nodeProduce(JPItem.Biomass, () -> {
                nodeProduce(JPItem.Vanadium, () -> {
                    nodeProduce(JPItem.VCA, () -> {});
                    nodeProduce(JPItem.Azurite, () -> {});
                });
                nodeProduce(JPItem.Zinc, () -> {});
                nodeProduce(JPItem.BioSil, () -> {
                    nodeProduce(JPItem.Nanitealloy, () -> {
                        nodeProduce(JPItem.Carbinecomposite, () -> {
                            nodeProduce(JPItem.Neocells, () -> {});
                        });
                    });
                });
                nodeProduce(JPItem.Fluoresilt, () -> {
                    nodeProduce(JPItem.Fluorite, () -> {});
                });
            });
            });
}else {
            nodeRoot("Spore biomechs", coreShard, false, () -> {
            //Above the skies is currently the placeholder for now, the required sector will change later.
            node(JPOther.Sporecore, Seq.with(new SectorComplete(JPsectors.Birth)), () -> {
                node(JPOther.Hive, () -> {
                    node(JPOther.Nydusaecore);
                });
            });
            node(JPTurret.Sporegarrison, Seq.with(new SectorComplete(JPsectors.ski)), () -> {
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
            
            node(JPProduction.Nanoprocessor, Seq.with(new SectorComplete(JPsectors.ski)), () -> {
                node(JPProduction.Vanadicarbide);
                node(JPProduction.Gaschamber);
                node(JPProduction.FR);
                node(JPProduction.Masscultivator);
                node(JPProduction.BioSynthesizer, () -> {
                    node(JPProduction.Naniteinfuser, () -> {
                        node(JPProduction.CCB, () -> {
                            node(JPProduction.neostabilizer);
                        });
                    });
                });
            });
            node(JPUnitFactory.pool, Seq.with(new SectorComplete(JPsectors.ski)), () -> {
                node(JPUnitFactory.synapseTower, () -> {
                    node(JPUnitFactory.assembler, () -> {
                        node(JPUnitAssembler.apollyonAssembler);
                    });
                    node(JPUnitFactory.gestator);
                });
            });
            node(JPProduction.Oilburner, () -> {
                node(JPProduction.Lotus);
                node(JPProduction.Voltaicburner, () -> {
                    node(JPProduction.Biomassreactor, () -> { 
                        node(JPProduction.Neocell);
                    });
                });
            });
            node(JPProduction.Extractor, Seq.with(new SectorComplete(JPsectors.dig)), () -> {
                node(JPProduction.ZincExtractor, Seq.with(new SectorComplete(JPsectors.dig)), () -> {
            });
            });
            node(JPOther.VCAwall);
             node(JPsectors.ski, Seq.with(new SectorComplete(frozenForest)), () -> {
                 node(JPsectors.dig, Seq.with(
                         new SectorComplete(JPsectors.ski),
                         new SectorComplete(SectorPresets.craters)
                 ), () -> {
                     node(JPsectors.Birth, Seq.with(
                             new SectorComplete(JPsectors.dig),
                             new SectorComplete(fungalPass)
                     ), () -> {
                        node(JPsectors.magma, Seq.with(new SectorComplete(JPsectors.Birth)), () -> {
                            node(JPsectors.frost);
                            });
                        });
                });
            });
            nodeProduce(JPItem.Biomass, () -> {
                nodeProduce(JPItem.Vanadium, () -> {
                    nodeProduce(JPItem.VCA, () -> {});
                    nodeProduce(JPItem.Azurite, () -> {});
                });
                nodeProduce(JPItem.Zinc, () -> {});
                nodeProduce(JPItem.BioSil, () -> {
                    nodeProduce(JPItem.Nanitealloy, () -> {
                        nodeProduce(JPItem.Carbinecomposite, () -> {
                            nodeProduce(JPItem.Neocells, () -> {});
                        });
                    });
                });
                nodeProduce(JPItem.Fluoresilt, () -> {
                    nodeProduce(JPItem.Fluorite, () -> {});
                });
            });
});}}};
