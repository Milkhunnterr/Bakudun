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

public class ControllerPlayer extends Component{

    private PhysicsComponent physics;
    private double velocityX ;
    private double velocityY ;
    private Animation animation;

    @Override
    public void onAdded() {
        // การตั้งค่า Animation และ Physics
        double width = entity.getWidth();
        double height = entity.getHeight();

        animation = new Animation("Jim1.png");
        entity.getViewComponent().addChild(animation.getTexture());

        physics = entity.getComponent(PhysicsComponent.class);

        entity.getTransformComponent().setScaleOrigin(new Point2D(width / 2, height / 2));
    }

    public void placeBomb() {
        int tileSize = 32; // ขนาดของช่องตาราง
        double x = Math.round(entity.getX() / tileSize) * tileSize;
        double y = Math.round(entity.getY() / tileSize) * tileSize;

        FXGL.spawn("Bomb", new Point2D(x, y));
    }

    @Override
    public void onUpdate(double tpf) {
        physics.setLinearVelocity(velocityX, velocityY);

        // ✅ จำกัดการเคลื่อนที่ไม่ให้หลุดออกจากหน้าจอ
        float screenWidth = (float) FXGL.getAppWidth();
        float screenHeight = (float) FXGL.getAppHeight();

        float newX = FXGLMath.clamp((float) entity.getX(), 0f, screenWidth - (float) entity.getWidth());
        float newY = FXGLMath.clamp((float) entity.getY(), 0f, screenHeight - (float) entity.getHeight());

        entity.setPosition(newX, newY);

    }


    public void moveLeft() {
        velocityX = -200;
        velocityY = 0; // รีเซ็ตค่าแนวตั้ง
        entity.setScaleX(1);
        animation.walkLeft();
    }

    public void moveRight() {
        velocityX = 200;
        velocityY = 0; // รีเซ็ตค่าแนวตั้ง
        entity.setScaleX(1);
        animation.walkRight();
    }

    public void moveUp() {
        velocityY = -200;
        velocityX = 0; // รีเซ็ตค่าทางแนวนอน
        entity.setScaleX(1);
        animation.walkUp();
    }

    public void moveDown() {
        velocityY = 200;
        velocityX = 0; // รีเซ็ตค่าทางแนวนอน
        entity.setScaleX(1);
        animation.walkDown();
    }

    public void stop() {
        velocityX = 0;
        velocityY = 0;

        String state = animation.checkwalk();

        if ("walkUp".equals(state)) {
            animation.idleUp();
        } else if ("walkDown".equals(state)) {
            animation.idleDown();
        } else if ("walkRight".equals(state)) {
            animation.idleRight();
        } else if ("walkLeft".equals(state)) {
            animation.idleLeft();
        } else {
            animation.idleDown(); // fallback
        }
    }


}

