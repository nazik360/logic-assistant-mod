package ai.logicassistant;

import mindustry.mod.Mod;

public class LogicAssistantMod extends Mod {

  @Override
  public void init() {
    LogicEditorIntegration.init();
  }
}
