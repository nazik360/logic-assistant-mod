package ai.logicassistant;

import arc.util.Log;

public final class LogicCodeGenerator {

  private LogicCodeGenerator() {}

  /** Временная версия генератора. Позже сюда подключим Claude API. */
  public static String generate(String request) {
    if (request == null || request.trim().isEmpty()) {
      return "// Запрос пуст";
    }

    String result =
        "// Logic Assistant\n"
            + "// Запрос: "
            + request
            + "\n"
            + "// AI-генерация будет подключена следующим этапом.\n";

    Log.info("[Logic Assistant] Request: " + request);

    return result;
  }
}
