package me.pooh.bakudun.Component;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;
import me.pooh.bakudun.EntityType.Scene;

public class BombCompo extends Component {

  /*  @Override
    public void onAdded() {
        // ตั้งเวลาระเบิด (3 วินาที)
        FXGL.runOnce(() -> explode(), Duration.seconds(3));
    }

    private void explode() {
        // สร้างแอนิเมชันระเบิด
        FXGL.animationBuilder()
                .duration(Duration.seconds(1))
                .onFinished(() -> entity.removeFromWorld()) // ลบระเบิดออกจากแมพหลังระเบิด
                .buildAndPlay();

        // ตรวจสอบการชนกับ wall
        FXGL.getGameWorld().getEntitiesByType(Scene.WALL).forEach(WALL -> {
            if (entity.isColliding(WALL)) {
                WALL.removeFromWorld(); // ลบ wall ที่ถูกชนออก
            }
        });
    }
    private void exploded() {
        AnimationChannel explosion = new AnimationChannel(
                FXGL.image("explosion.png"), 4, 32, 32, Duration.seconds(1), 0, 3
        );

        AnimatedTexture texture = new AnimatedTexture(explosion);
        entity.getViewComponent().addChild(texture);
    }*/
}