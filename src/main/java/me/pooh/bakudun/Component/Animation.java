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


        // คำนวณ index แบบ Row-Major Order
        int leftStart  = (2 * rows) + 1;  // Column 2, Row 1
        int leftEnd    = (3 * rows) + 1;  // Column 3, Row 1

        int rightStart = (2 * rows) + 0;  // Column 2, Row 0
        int rightEnd   = (3 * rows) + 0;  // Column 3, Row 0

        int upStart    = (2 * rows) + 3;  // Column 2, Row 3
        int upEnd      = (3 * rows) + 3;  // Column 3, Row 3

        int downStart  = (2 * rows) + 2;  // Column 2, Row 2
        int downEnd    = (3 * rows) + 2;  // Column 3, Row 2

        int Down      = (0 * rows) + 2;  // Column 0, Row 2
        int DownEnd   = (1 * rows) + 2;  // Column 1, Row 2

        int Up        = (0 * rows) + 3;  // Column 0, Row 3
        int UpEnd     = (1 * rows) + 3;  // Column 1, Row 3

        int Right     = (0 * rows) + 0;  // Column 0, Row 0
        int RightEnd  = (1 * rows) + 0;  // Column 1, Row 0

        int Left      = (0 * rows) + 1;  // Column 0, Row 1
        int LeftEnd   = (1 * rows) + 1;  // Column 1, Row 1

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

    public String checkwalk(){

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



    // public void attack() {
    //     texture.playAnimationChannel(animAttack);
    // }

    // public void stop() {
    //     texture.loopAnimationChannel(animIdle);
    // }

    //  public void respawn() {
    //     entity.removeFromWorld();
    //     FXGL.spawn("Player", new SpawnData(x, y));
    // }

}
