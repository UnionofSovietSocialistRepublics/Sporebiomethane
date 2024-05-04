Events.on(EventType.ClientLoadEvent, () => {
if (Core.settings.getInt("HM")!=1|Core.settings.getInt("HM")!=2){
const Diffsett = new BaseDialog("Choose your difficulty");
Diffsett.cont.add("Do you want to enable Hardmode?").row();
Diffsett.cont.add("Remember, this choice is [#f0]Permanent.").row();
Diffsett.cont.button("Nuh uh", () => {
    Diffsett.hide();
    Core.settings.put("HM",1);
    Core.settings.forceSave();
    const Enddia = new BaseDialog("Difficulty chosen.");
    Enddia.cont.add("You may restart now if you want.").row();
    Enddia.cont.button("OK", () => {
        Enddia.hide();
    });
    Enddia.show();
})
Diffsett.cont.button("To hell with the zerg!", () => {
    Diffsett.hide();
    Core.settings.put("HM",2);
    Core.settings.forceSave();
    const Enddia = new BaseDialog("Fate chosen.");
    Enddia.cont.add("You may restart now if you want.").row();
    Enddia.cont.button("OK", () => {
        Enddia.hide();
    });
    Enddia.show();
})
Diffsett.show();
}

});


