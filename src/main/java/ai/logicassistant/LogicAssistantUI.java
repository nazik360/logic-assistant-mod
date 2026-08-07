package ai.logicassistant;

import arc.scene.ui.Dialog;
import arc.scene.ui.TextArea;
import arc.scene.ui.TextButton;
import arc.scene.ui.layout.Table;
import mindustry.ui.Styles;

public final class LogicAssistantUI {

    private LogicAssistantUI() {
    }

    public static void show() {
        Dialog dialog = new Dialog("Logic Assistant");

        TextArea request = new TextArea("");
        request.setMessageText("Например: сделай процессор, который сортирует медь...");

        dialog.cont.add(request).growX().height(120f).row();

        Table buttons = new Table();

        TextButton generate = new TextButton("Сгенерировать", Styles.tbutton);
        TextButton close = new TextButton("Закрыть", Styles.tbutton);

        buttons.add(generate).pad(5f);
        buttons.add(close).pad(5f);

        dialog.cont.add(buttons).row();

        generate.clicked(() -> {
            String result = LogicCodeGenerator.generate(request.getText());

            Dialog resultDialog = new Dialog("Результат");
            TextArea output = new TextArea(result);

            resultDialog.cont.add(output)
                    .grow()
                    .minWidth(500f)
                    .minHeight(300f);

            resultDialog.addCloseButton();
            resultDialog.show();
        });

        close.clicked(dialog::hide);

        dialog.addCloseButton();
        dialog.show();
    }
}
