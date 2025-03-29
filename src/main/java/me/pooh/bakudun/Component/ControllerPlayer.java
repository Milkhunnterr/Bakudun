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
        Point2D bombPosition = entity.getCenter().subtract(16, 16); // ปรับตำแหน่งให้ตรงกลาง (สมมติระเบิดมีขนาด 32x32)
        FXGL.spawn("Bomb", bombPosition);
    }

    @Override
    public void onUpdate(double tpf) {
        physics.setVelocityX(velocityX);
        physics.setVelocityY(velocityY);

        if (FXGLMath.abs(velocityX) < 1) {
            velocityX = 0;
        }

        if (FXGLMath.abs(velocityY) < 1) {
            velocityY = 0;
        }

        // ✅ จำกัดการเคลื่อนที่ไม่ให้หลุดออกจากหน้าจอ
        float screenWidth = (float) FXGL.getAppWidth();
        float screenHeight = (float) FXGL.getAppHeight();

        float newX = FXGLMath.clamp((float) entity.getX(), 0f, screenWidth - (float) entity.getWidth());
        float newY = FXGLMath.clamp((float) entity.getY(), 0f, screenHeight - (float) entity.getHeight());

        entity.setPosition(newX, newY);

    }


    public void moveLeft() {

        velocityX = -200;
        entity.setScaleX(1);

        animation.walkLeft();


    }

    public void moveRight() {

        velocityX = 200;
        entity.setScaleX(1);
        animation.walkRight();
    }

    public void moveUp() {

        velocityY = -200;
        entity.setScaleX(1);
        animation.walkUp();
    }

    public void moveDown() {

        velocityY = 200;
        entity.setScaleX(1);
        animation.walkDown();
    }

    public void stop() {
        velocityX = 0;
        velocityY = 0;

        if(animation.checkwalk() == "walkUp"){

            animation.idleUp();

        }else if (animation.checkwalk() == "walkDown"){

            animation.idleDown();

        }else if (animation.checkwalk() == "walkRight"){

            animation.idleRight();

        }else if(animation.checkwalk() == "walkLeft"){

            animation.idleLeft();
        }else{

            animation.idleDown();
        }
    }


}

