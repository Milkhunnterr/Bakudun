package me.pooh.bakudun.Component;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;

import javafx.scene.image.Image;
import javafx.util.Duration;

public class Animation extends Component {

    private String currentAnimationState = "idleDown";
    private final AnimatedTexture texture;
    private final AnimationChannel left, right, up, down;
    private final AnimationChannel idleDown, idleRight, idleUp, idleLeft;

    public Animation (String nameFile) {
        Image image = FXGL.image(nameFile);

        int columns = 4;
        int rows = 4;
        int frameW = (int) image.getWidth() / columns;
        int frameH = (int) image.getHeight() / rows;

        left = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(0.75), 6, 7);
        right = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(0.75), 2, 3);
        up = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(0.75), 10, 11);
        down = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(0.75), 14, 15);

        idleDown = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(0.75), 12, 12);
        idleUp = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(0.75), 8, 8);
        idleRight = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(0.75), 0, 0);
        idleLeft = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(0.75), 4, 4);

        texture = new AnimatedTexture(idleDown);
        texture.loopAnimationChannel(idleDown);
    }

    public AnimatedTexture getTexture() {
        return texture;
    }

    public void walkUp() {
        if (!currentAnimationState.equals("walkUp")) {
            texture.loopAnimationChannel(up);
            currentAnimationState = "walkUp";
        }
    }

    public void walkDown() {
        if (!currentAnimationState.equals("walkDown")) {
            texture.loopAnimationChannel(down);
            currentAnimationState = "walkDown";
        }
    }

    public void walkLeft() {
        if (!currentAnimationState.equals("walkLeft")) {
            texture.loopAnimationChannel(left);
            currentAnimationState = "walkLeft";
        }
    }

    public void walkRight() {
        if (!currentAnimationState.equals("walkRight")) {
            texture.loopAnimationChannel(right);
            currentAnimationState = "walkRight";
        }
    }

    public String checkwalk() {
        return currentAnimationState;
    }

    public void idleDown() {
        if (!currentAnimationState.equals("idleDown")) {
            texture.loopAnimationChannel(idleDown);
            currentAnimationState = "idleDown";
        }
    }

    public void idleUp() {
        if (!currentAnimationState.equals("idleUp")) {
            texture.loopAnimationChannel(idleUp);
            currentAnimationState = "idleUp";
        }
    }

    public void idleRight() {
        if (!currentAnimationState.equals("idleRight")) {
            texture.loopAnimationChannel(idleRight);
            currentAnimationState = "idleRight";
        }
    }

    public void idleLeft() {
        if (!currentAnimationState.equals("idleLeft")) {
            texture.loopAnimationChannel(idleLeft);
            currentAnimationState = "idleLeft";
        }
    }
}
