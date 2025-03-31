package me.pooh.bakudun;

import java.util.Map;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.level.Level;
import com.almasb.fxgl.entity.level.tiled.TMXLevelLoader;


import static com.almasb.fxgl.dsl.FXGL.*;

import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.PhysicsWorld;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import me.pooh.bakudun.Component.ControllerPlayer;
import me.pooh.bakudun.EntityFactory.Bombba;
import me.pooh.bakudun.EntityFactory.Scemap;
import me.pooh.bakudun.EntityFactory.Character;
import me.pooh.bakudun.EntityType.Player;


public class App extends GameApplication {
    public Entity player;
    public Level map;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(640);
        settings.setHeight(480);
        settings.setTitle("BomberMan");
        settings.setVersion("0.1");
        settings.setDeveloperMenuEnabled(true);

    }

    @Override
    protected void initPhysics() {
        PhysicsWorld gamephysic = FXGL.getPhysicsWorld();
        gamephysic.setGravity(0,0 );
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {

        vars.put("map0", "Map.tmx");
    }

    @Override
    protected void initGame() {
        getGameScene().setBackgroundColor(Color.BLACK);
        FXGL.getGameWorld().addEntityFactory(new Scemap());
        FXGL.getGameWorld().addEntityFactory(new Character());
        FXGL.getGameWorld().addEntityFactory(new Bombba());

        map = FXGL.getAssetLoader().loadLevel(FXGL.gets("map0"), new TMXLevelLoader());
        FXGL.setLevelFromMap("Map.tmx");

        player = FXGL.getGameWorld().getEntitiesByType(Player.Jimmu).getFirst();

    }



    @Override
    protected void initInput() {

        FXGL.getInput().addAction(new UserAction("Right") {
            @Override
            protected void onAction() {
                player.getComponent(ControllerPlayer.class).moveRight();
            }

            @Override
            protected void onActionEnd() {
                player.getComponent(ControllerPlayer.class).stop();
            }
        }, KeyCode.D);

        FXGL.getInput().addAction(new UserAction("Left") {
            @Override
            protected void onAction() {
                player.getComponent(ControllerPlayer.class).moveLeft();
            }

            @Override
            protected void onActionEnd() {
                player.getComponent(ControllerPlayer.class).stop();
            }
        }, KeyCode.A);

        FXGL.getInput().addAction(new UserAction("Up") {
            @Override
            protected void onAction() {
                player.getComponent(ControllerPlayer.class).moveUp();
            }

            @Override
            protected void onActionEnd() {
                player.getComponent(ControllerPlayer.class).stop();
            }
        }, KeyCode.W);

        FXGL.getInput().addAction(new UserAction("Down") {
            @Override
            protected void onAction() {
                player.getComponent(ControllerPlayer.class).moveDown();
            }

            @Override
            protected void onActionEnd() {
                player.getComponent(ControllerPlayer.class).stop();
            }
        }, KeyCode.S);

        FXGL.getInput().addAction(new UserAction("Place Bomb") {
            @Override
            protected void onActionBegin() {
                player.getComponent(ControllerPlayer.class).placeBomb();
            }
        }, KeyCode.SPACE);

    }


    @Override
    protected void initUI() {
     /*   Text textLabel = new Text("Moved: ");
        Text textPixels = new Text();

        textLabel.setTranslateX(50);
        textLabel.setTranslateY(100);
        textPixels.setTranslateX(100);
        textPixels.setTranslateY(100);

        // Bind the text to the game variable
        textPixels.textProperty().bind(FXGL.getWorldProperties().intProperty("pixelsMoved").asString());

        // Add the text elements to the scene graph
        FXGL.getGameScene().addUINode(textLabel);
        FXGL.getGameScene().addUINode(textPixels);*/
    }
}