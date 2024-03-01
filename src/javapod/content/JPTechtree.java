package jp.content;

// import arc.struct.*;
// import mindustry.content.*;
// import mindustry.ctype.*;
// import mindustry.game.Objectives.*;
// import mindustry.type.*;
// import arc.struct.Seq;
// import mindustry.game.Objectives;
// import mindustry.type.ItemStack;


// import static mindustry.content.Items.*;
// import static mindustry.content.Blocks.*;
// import static mindustry.content.TechTree.*;
// import jp.content.blocks.*;
// import jp.content.*;


// public class JPTechtree{
//     static TechTree.TechNode context = null;
//     public static void mergeNode(UnlockableContent p, Runnable c) {
//         context = TechTree.all.find(t -> t.content == p);
//         c.run();
//     }

//     public static void node(UnlockableContent content, Runnable children){
//         node(content, content.researchRequirements(), children);
//     }

//     public static void node(UnlockableContent content, ItemStack[] requirements, Runnable children){
//         node(content, requirements, null, children);
//     }

//     public static void node(UnlockableContent content, ItemStack[] requirements, Seq<Objectives.Objective> objectives, Runnable children){
//         TechNode node = new TechNode(context, content, requirements);
//         if(objectives != null){
//             node.objectives.addAll(objectives);
//         }

//         TechNode prev = context;
//         context = node;
//         children.run();
//         context = prev;
//     }

//     public static void node(UnlockableContent content, Seq<Objectives.Objective> objectives, Runnable children){
//         node(content, content.researchRequirements(), objectives, children);
//     }

//     public static void node(UnlockableContent block){
//         node(block, () -> {});
//     }

//     public static void nodeProduce(UnlockableContent content, Seq<Objectives.Objective> objectives, Runnable children){
//         node(content, content.researchRequirements(), objectives.add(new Objectives.Produce(content)), children);
//     }

//     public static void nodeProduce(UnlockableContent content, Runnable children){
//         nodeProduce(content, new Seq<>(), children);
//     }
//     public static void load(){
        


//         mergeNode(Blocks.coreNucleus, () -> {
//             node(JPOther.Sporecore, () -> {
//             });
//         });

//         }
        

//         };