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
    private final AnimationChannel left;
    private final AnimationChannel right;
    private final AnimationChannel up;
    private final AnimationChannel down;
    private final AnimationChannel idleDown;
    private final AnimationChannel idleRight;
    private final AnimationChannel idleUp;
    private final AnimationChannel idleLeft;

    public Animation (String nameFile) {

        Image image = FXGL.image(nameFile);

        int columns = 4;
        int rows = 4;

        int frameW = (int) image.getWidth() / columns;
        int frameH = (int) image.getHeight() / rows;

        // คำนวณ index แบบ Column-Major Order
        int leftStart  = (1 * columns) + 2;  // Row 1, Column 2
        int leftEnd    = (1 * columns) + 3;  // Row 1, Column 3

        int rightStart = (0 * columns) + 2;  // Row 0, Column 2
        int rightEnd   = (0 * columns) + 3;  // Row 0, Column 3

        int upStart    = (3 * columns) + 2;  // Row 3, Column 2
        int upEnd      = (3 * columns) + 3;  // Row 3, Column 3

        int downStart  = (2 * columns) + 2;  // Row 2, Column 2
        int downEnd    = (2 * columns) + 3;  // Row 2, Column 3

        int Down      = (2 * columns) + 0;  // Row 2, Column 0
        int DownEnd   = (2 * columns) + 1;  // Row 2, Column 1

        int Up        = (3 * columns) + 0;  // Row 3, Column 0
        int UpEnd     = (3 * columns) + 1;  // Row 3, Column 1

        int Right     = (0 * columns) + 0;  // Row 0, Column 0
        int RightEnd  = (0 * columns) + 1;  // Row 0, Column 1

        int Left      = (1 * columns) + 0;  // Row 1, Column 0
        int LeftEnd   = (1 * columns) + 1;  // Row 1, Column 1

        left = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(0.75), leftStart, leftEnd);
        right = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(0.75), rightStart, rightEnd);
        up = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(0.75), upStart, upEnd);
        down = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(0.75), downStart, downEnd);

        idleDown = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(0.75), Down, Down);
        idleUp = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(0.75), Up, Up);
        idleRight = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(0.75), Right, Right);
        idleLeft = new AnimationChannel(image, columns, frameW, frameH, Duration.seconds(0.75), Left, Left);

        texture = new AnimatedTexture(idleDown);
        texture.loopAnimationChannel(idleDown);
    }

    public AnimatedTexture getTexture() {
        return texture;
    }

    public void walkUp() {
        if (texture.getAnimationChannel() != up) {
            texture.playAnimationChannel(up);
            texture.loopAnimationChannel(up);
        }
        currentAnimationState = "walkUp";
    }

    public void walkDown() {
        if (texture.getAnimationChannel() != down) {
            texture.playAnimationChannel(down);
            texture.loopAnimationChannel(down);
        }
        currentAnimationState = "walkDown";
    }

    public void walkLeft() {
        if (texture.getAnimationChannel() != left) {
            texture.playAnimationChannel(left);
            texture.loopAnimationChannel(left);
        }
        currentAnimationState = "walkLeft";
    }

    public void walkRight() {
        if (texture.getAnimationChannel() != right) {
            texture.playAnimationChannel(right);
            texture.loopAnimationChannel(right);
        }
        currentAnimationState = "walkRight";
    }

    public String checkwalk() {
        return currentAnimationState;
    }

    public void idleDown() {
        texture.loopAnimationChannel(idleDown);
    }
    public void idleUp() {
        texture.loopAnimationChannel(idleUp);
    }

    public void idleRight() {
        texture.loopAnimationChannel(idleRight);
    }

    public void idleLeft() {
        texture.loopAnimationChannel(idleLeft);
    }
}
