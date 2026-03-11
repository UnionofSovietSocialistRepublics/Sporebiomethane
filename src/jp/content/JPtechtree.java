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
            node(JPOther.hatchery, Seq.with(new SectorComplete(JPsectorsHM.skiHM)), () -> {
                node(JPOther.hive, () -> {
                    node(JPOther.nydusaecore);
                });
            });
            node(JPTurret.sporeGarrison, Seq.with(new SectorComplete(JPsectorsHM.skiHM)), () -> {
                node(JPTurret.flakAccelerator, () -> {
                    node(JPTurret.suppressor);
                 });
                node(JPTurret.mitoCannon);
                node(JPTurret.Oarch, () -> {
                    node(JPTurret.artilleryTurret, () -> { 
                        node(JPTurret.impalerCannon);
                        node(JPTurret.sentinel);
                    });
                    
                });
    });
            
            node(JPProduction.nanoProcessor, Seq.with(new SectorComplete(JPsectorsHM.skiHM)), () -> {
                node(JPProduction.vanadiumCarbideAlloyer);
                node(JPProduction.Gaschamber);
                node(JPProduction.fluoresiltRefinery);
                node(JPProduction.massCultivator);
                node(JPProduction.bioSynthesizer, () -> {
                    node(JPProduction.naniteInfuser, () -> {
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
                    node(JPProduction.biomassReactor, () -> { 
                        node(JPProduction.Neocell);
                    });
                });
            });
            node(JPProduction.extractor, Seq.with(new SectorComplete(JPsectorsHM.digHM)),() -> {
                node(JPProduction.zincExtractor, Seq.with(new SectorComplete(JPsectorsHM.digHM)), () -> {
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
            nodeProduce(JPItem.biomass, () -> {
                nodeProduce(JPItem.vanadium, () -> {
                    nodeProduce(JPItem.vanadiumCarbideAlloy, () -> {});
                    nodeProduce(JPItem.azurite, () -> {});
                });
                nodeProduce(JPItem.zinc, () -> {});
                nodeProduce(JPItem.biosil, () -> {
                    nodeProduce(JPItem.naniteAlloy, () -> {
                        nodeProduce(JPItem.Carbinecomposite, () -> {
                            nodeProduce(JPItem.neocell, () -> {});
                        });
                    });
                });
                nodeProduce(JPItem.fluoresilt, () -> {
                    nodeProduce(JPItem.fluorite, () -> {});
                });
            });
            });
}else {
            nodeRoot("Spore biomechs", coreShard, false, () -> {
            //Above the skies is currently the placeholder for now, the required sector will change later.
            node(JPOther.hatchery, Seq.with(new SectorComplete(JPsectors.birth)), () -> {
                node(JPOther.hive, () -> {
                    node(JPOther.nydusaecore);
                });
            });
            node(JPTurret.sporeGarrison, Seq.with(new SectorComplete(JPsectors.ski)), () -> {
                node(JPTurret.flakAccelerator, () -> {
                    node(JPTurret.suppressor);
                 });
                node(JPTurret.mitoCannon);
                node(JPTurret.Oarch, () -> {
                    node(JPTurret.artilleryTurret, () -> { 
                        node(JPTurret.impalerCannon);
                        node(JPTurret.sentinel);
                    });
                    
                });
    });
            
            node(JPProduction.nanoProcessor, Seq.with(new SectorComplete(JPsectors.ski)), () -> {
                node(JPProduction.vanadiumCarbideAlloyer);
                node(JPProduction.Gaschamber);
                node(JPProduction.fluoresiltRefinery);
                node(JPProduction.massCultivator);
                node(JPProduction.bioSynthesizer, () -> {
                    node(JPProduction.naniteInfuser, () -> {
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
                    node(JPProduction.biomassReactor, () -> { 
                        node(JPProduction.Neocell);
                    });
                });
            });
            node(JPProduction.extractor, Seq.with(new SectorComplete(JPsectors.dig)), () -> {
                node(JPProduction.zincExtractor, Seq.with(new SectorComplete(JPsectors.dig)), () -> {
            });
            });
            node(JPOther.VCAwall);
             node(JPsectors.ski, Seq.with(new SectorComplete(frozenForest)), () -> {
                 node(JPsectors.dig, Seq.with(
                         new SectorComplete(JPsectors.ski),
                         new SectorComplete(SectorPresets.craters)
                 ), () -> {
                     node(JPsectors.birth, Seq.with(
                             new SectorComplete(JPsectors.dig),
                             new SectorComplete(fungalPass)
                     ), () -> {
                        node(JPsectors.magma, Seq.with(new SectorComplete(JPsectors.birth)), () -> {
                            node(JPsectors.frost);
                            });
                        });
                });
            });
            nodeProduce(JPItem.biomass, () -> {
                nodeProduce(JPItem.vanadium, () -> {
                    nodeProduce(JPItem.vanadiumCarbideAlloy, () -> {});
                    nodeProduce(JPItem.azurite, () -> {});
                });
                nodeProduce(JPItem.zinc, () -> {});
                nodeProduce(JPItem.biosil, () -> {
                    nodeProduce(JPItem.naniteAlloy, () -> {
                        nodeProduce(JPItem.Carbinecomposite, () -> {
                            nodeProduce(JPItem.neocell, () -> {});
                        });
                    });
                });
                nodeProduce(JPItem.fluoresilt, () -> {
                    nodeProduce(JPItem.fluorite, () -> {});
                });
            });
});}}};
