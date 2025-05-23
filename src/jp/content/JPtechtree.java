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
            node(JPOther.Sporecore, Seq.with(new SectorComplete(JPsectorsHM.SkiHM)), () -> {
                node(JPOther.Hive, () -> {
                    node(JPOther.Nydusaecore);
                });
            });
            node(JPTurret.Sporegarrison, Seq.with(new SectorComplete(JPsectorsHM.SkiHM)), () -> {
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
            
            node(JPProduction.Nanoprocessor, Seq.with(new SectorComplete(JPsectorsHM.SkiHM)), () -> {
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
            node(JPUnitFactory.pool, Seq.with(new SectorComplete(JPsectorsHM.SkiHM)), () -> {
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
            node(JPProduction.Extractor, Seq.with(new SectorComplete(JPsectorsHM.DigHM)),() -> {
                node(JPProduction.ZincExtractor, Seq.with(new SectorComplete(JPsectorsHM.DigHM)), () -> {
            });
            });
            node(JPOther.VCAwall);
             node(JPsectorsHM.SkiHM, Seq.with(new SectorComplete(frozenForest)), () -> {
                node(JPsectorsHM.DigHM, Seq.with(
                        new SectorComplete(JPsectorsHM.SkiHM),
                        new SectorComplete(SectorPresets.craters)
                ), () -> {
                    node(JPsectorsHM.BirthHM, Seq.with(
                            new SectorComplete(JPsectorsHM.DigHM),
                            new SectorComplete(fungalPass)
                    ), () -> {
                        node(JPsectorsHM.MagmaHM, Seq.with(new SectorComplete(JPsectorsHM.BirthHM)), () -> {
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
                            node(JPProduction.neostabilizer);
                        });
                    });
                });
            });
            node(JPUnitFactory.pool, Seq.with(new SectorComplete(JPsectors.Ski)), () -> {
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
            node(JPProduction.Extractor, Seq.with(new SectorComplete(JPsectors.Dig)), () -> {
                node(JPProduction.ZincExtractor, Seq.with(new SectorComplete(JPsectors.Dig)), () -> {
            });
            });
            node(JPOther.VCAwall);
             node(JPsectors.Ski, Seq.with(new SectorComplete(frozenForest)), () -> {
                 node(JPsectors.Dig, Seq.with(
                         new SectorComplete(JPsectors.Ski),
                         new SectorComplete(SectorPresets.craters)
                 ), () -> {
                     node(JPsectors.Birth, Seq.with(
                             new SectorComplete(JPsectors.Dig),
                             new SectorComplete(fungalPass)
                     ), () -> {
                        node(JPsectors.Magma, Seq.with(new SectorComplete(JPsectors.Birth)), () -> {
                            node(JPsectors.Frost);
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
