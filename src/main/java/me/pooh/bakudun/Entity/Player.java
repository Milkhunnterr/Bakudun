package me.pooh.bakudun.Entity;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.AnimationChannel;
import com.almasb.fxgl.texture.AnimatedTexture;
import javafx.util.Duration;
import javafx.scene.image.Image;

public class Player extends Sprite {
    private AnimatedTexture texture;
    private AnimationChannel animIdle, animWalkUp, animWalkDown, animWalkLeft, animWalkRight;

    public Player(double x, double y, int hp) {
        super(hp);

        // โหลดรูปตัวละครจาก assets/textures/
        Image image = FXGL.image("animation_characters.png");

        // สร้างอนิเมชัน (เฟรมขนาด 48x48)
        animIdle = new AnimationChannel(image, 4, 48, 48, Duration.seconds(0.5), 0, 0);
        animWalkDown = new AnimationChannel(image, 4, 48, 48, Duration.seconds(0.5), 0, 3);
        animWalkUp = new AnimationChannel(image, 4, 48, 48, Duration.seconds(0.5), 4, 7);
        animWalkLeft = new AnimationChannel(image, 4, 48, 48, Duration.seconds(0.5), 8, 11);
        animWalkRight = new AnimationChannel(image, 4, 48, 48, Duration.seconds(0.5), 12, 15);

        texture = new AnimatedTexture(animIdle);

        entity = FXGL.entityBuilder()
                .at(x, y)
                .viewWithBBox(texture)
                .buildAndAttach();
    }

    public void movePlayer(String direction) {
        switch (direction) {
            case "UP":
                move(0, -5);
                texture.loopAnimationChannel(animWalkUp);
                break;
            case "DOWN":
                move(0, 5);
                texture.loopAnimationChannel(animWalkDown);
                break;
            case "LEFT":
                move(-5, 0);
                texture.loopAnimationChannel(animWalkLeft);
                break;
            case "RIGHT":
                move(5, 0);
                texture.loopAnimationChannel(animWalkRight);
                break;
            default:
                texture.loopAnimationChannel(animIdle);
        }
    }
}
