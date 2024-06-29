Events.on(EventType.ClientLoadEvent, () => {
  let a = Core.settings.getBool("NoJp")
  if (a !== true) {
    const Diffsett = new BaseDialog("Choose your difficulty");
    Diffsett.cont.add("Do you want to enable Hardmode? (please restart if you choose to not enable hardmode, the techtree and map are defaults to hardmode.)").row();
    //Diffsett.cont.add("Remember, this choice is [#f0]Permanent.").row();
    Diffsett.cont.button("Nuh uh", () => {
      Diffsett.hide();
      Core.settings.put("HM", false);
      Core.settings.put("NoJp", true);
      Core.settings.forceSave();
      const Enddia = new BaseDialog("Difficulty chosen.");
      Enddia.cont.add("Please restart, the game defaults the techtree and map to hardmode.").row();
      Enddia.cont.button("OK", () => {
      Enddia.hide();
      }).size(250,50);;
      Enddia.show();
    }).size(200,50);
    Diffsett.cont.button("To hell with the zerg!", () => {
      Diffsett.hide();
      Core.settings.put("HM", true);
      Core.settings.put("NoJp", true);
      Core.settings.forceSave();
      // const Enddia = new BaseDialog("Fate chosen.");
      // Enddia.cont.add("You may restart now if you want.").row();
      // Enddia.cont.button("OK", () => {
      //   Enddia.hide();
      // }).size(200,50);
      // Enddia.show();
    }).size(200,50);
    Diffsett.show();
  }
});
