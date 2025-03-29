package me.pooh.bakudun.Component;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.scene.image.Image;
import javafx.util.Duration;
import me.pooh.bakudun.EntityType.Scene;

import java.util.ArrayList;
import java.util.List;

public class BombComponent extends Component {

    private AnimatedTexture texture;

    @Override
    public void onAdded() {
        // สร้างแอนิเมชันระเบิด
        createExplosionAnimation();

        // ตั้งเวลาระเบิด (3 วินาที)
        FXGL.runOnce(this::explode, Duration.seconds(3));
    }

    private void createExplosionAnimation() {
        // โหลดภาพแต่ละเฟรม
        List<Image> frames = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            frames.add(FXGL.image("explosion" + i + ".png")); // explosion1.png, explosion2.png, ...
        }

        // สร้าง AnimationChannel
        AnimationChannel explosionChannel = new AnimationChannel(frames, Duration.seconds(1));

        // สร้าง AnimatedTexture
        texture = new AnimatedTexture(explosionChannel);
    }

    private void explode() {
        // เพิ่มแอนิเมชันระเบิดให้กับเอนทิตี
        entity.getViewComponent().addChild(texture);
        texture.play();

        // ตรวจสอบการชนกับ wall
        FXGL.getGameWorld().getEntitiesByType(Scene.WALL).forEach(WALL -> {
            if (entity.isColliding(WALL)) {
                WALL.removeFromWorld(); // ลบ wall ที่ถูกชนออก
            }
        });

        // ลบระเบิดออกจากแมพหลังแอนิเมชันจบ
        FXGL.runOnce(() -> entity.removeFromWorld(), Duration.seconds(1));
    }
}