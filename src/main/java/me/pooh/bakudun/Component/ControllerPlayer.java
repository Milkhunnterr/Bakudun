package me.pooh.bakudun.Component;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimationChannel;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.entity.component.Component;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import javafx.scene.image.Image;

public class ControllerPlayer extends Component {

    private PhysicsComponent physics;
    private final double SPEED = 150; // กำหนดความเร็วคงที่
    private double velocityX = 0;
    private double velocityY = 0;
    private Animation animation;
    private static int bombCount = 0; // ตัวแปรนับจำนวนระเบิดในแมพ
    private static final int MAX_BOMBS = 3; // จำนวนระเบิดสูงสุดที่อนุญาต

    @Override
    public void onAdded() {
        // การตั้งค่า Animation และ Physics
        double width = entity.getWidth();
        double height = entity.getHeight();

        animation = new Animation("Jim2.png");
        entity.getViewComponent().addChild(animation.getTexture());

        physics = entity.getComponent(PhysicsComponent.class);

        entity.getTransformComponent().setScaleOrigin(new Point2D(width / 2, height / 2));
    }

    public void placeBomb() {
        if (bombCount < MAX_BOMBS) {
            Point2D bombPosition = entity.getCenter().subtract(16, 16); // ปรับตำแหน่งให้ตรงกลาง (สมมติระเบิดมีขนาด
                                                                        // 32x32)
            FXGL.spawn("Bomb", bombPosition);
            bombCount++; // เพิ่มจำนวนระเบิดเมื่อวางระเบิดใหม่
        }
    }

    @Override
    public void onUpdate(double tpf) {
        physics.setVelocityX(velocityX);
        physics.setVelocityY(velocityY);

        // ไม่ต้องรีเซ็ต velocityX และ velocityY เป็น 0 ใน onUpdate
    }

    public void moveLeft() {
        velocityX = -SPEED; // ใช้ SPEED ที่กำหนดไว้
        entity.setScaleX(1);
        animation.walkLeft();
    }

    public void moveRight() {
        velocityX = SPEED; // ใช้ SPEED ที่กำหนดไว้
        entity.setScaleX(1);
        animation.walkRight();
    }

    public void moveUp() {
        velocityY = -SPEED; // ใช้ SPEED ที่กำหนดไว้
        entity.setScaleX(1);
        animation.walkUp();
    }

    public void moveDown() {
        velocityY = SPEED; // ใช้ SPEED ที่กำหนดไว้
        entity.setScaleX(1);
        animation.walkDown();
    }

    public void stop() {
        velocityX = 0;
        velocityY = 0;

        if (animation.checkwalk().equals("walkUp")) {
            animation.idleUp();
        } else if (animation.checkwalk().equals("walkDown")) {
            animation.idleDown();
        } else if (animation.checkwalk().equals("walkRight")) {
            animation.idleRight();
        } else if (animation.checkwalk().equals("walkLeft")) {
            animation.idleLeft();
        } else {
            animation.idleDown();
        }
    }

    public static void decrementBombCount() {
        if (bombCount > 0) {
            bombCount--;
        }
    }
}