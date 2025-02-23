package me.pooh.bakudun;

import java.util.Map;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class App extends GameApplication {
    private Entity player;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(600);
        settings.setHeight(600);
        settings.setTitle("Basic Game App");
        settings.setVersion("0.1");
    }

    @Override
    protected void initGame() {
        player = FXGL.entityBuilder()
                .at(300, 300)
                .view("ship.png")
                .buildAndAttach();
    }

    @Override
    protected void initInput() {
        FXGL.onKey(KeyCode.A, () -> {
            // ตรวจสอบว่า player จะไม่เคลื่อนที่ไปนอกขอบซ้าย
            if (player.getX() > 0) {
                player.translateX(-5);
                FXGL.inc("pixelsMoved", 5);
            }
        });

        FXGL.onKey(KeyCode.D, () -> {
            // ตรวจสอบว่า player จะไม่เคลื่อนที่ไปนอกขอบขวา
            if (player.getX() + player.getWidth() < FXGL.getAppWidth()) {
                player.translateX(5);
                FXGL.inc("pixelsMoved", 5);
            }
        });

        FXGL.onKey(KeyCode.W, () -> {
            // ตรวจสอบว่า player จะไม่เคลื่อนที่ไปนอกขอบบน
            if (player.getY() > 0) {
                player.translateY(-5);
                FXGL.inc("pixelsMoved", 5);
            }
        });

        FXGL.onKey(KeyCode.S, () -> {
            // ตรวจสอบว่า player จะไม่เคลื่อนที่ไปนอกขอบล่าง
            if (player.getY() + player.getHeight() < FXGL.getAppHeight()) {
                player.translateY(5);
                FXGL.inc("pixelsMoved", 5);
            }
        });
    }


    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("pixelsMoved", 0);
    }

    @Override
    protected void initUI() {
        Text textLabel = new Text("Moved: ");
        Text textPixels = new Text();

        textLabel.setTranslateX(50);
        textLabel.setTranslateY(100);
        textPixels.setTranslateX(100);
        textPixels.setTranslateY(100);

        // Bind the text to the game variable
        textPixels.textProperty().bind(FXGL.getWorldProperties().intProperty("pixelsMoved").asString());

        // Add the text elements to the scene graph
        FXGL.getGameScene().addUINode(textLabel);
        FXGL.getGameScene().addUINode(textPixels);
    }
}