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

    private final AnimatedTexture texture;
    private final AnimationChannel bombballChannel;
    private final AnimationChannel bombblastChannel;

    @Override
    public void onAdded() {
        entity.getViewComponent().addChild(texture);
        texture.loopAnimationChannel(bombballChannel);
        // ตั้งเวลาระเบิด (3 วินาที)
        FXGL.runOnce(this::explode, Duration.seconds(3));
    }

    public BombComponent(String bombFile) {
        // โหลดภาพลูกระเบิด
        Image bombImage = FXGL.image("bombball.png");
        bombballChannel = new AnimationChannel(bombImage, 3, 32, 32, Duration.seconds(0.75), 0, 2);

        // โหลดภาพการระเบิด
        Image explosionImage = FXGL.image("bombblast.png");
        bombblastChannel = new AnimationChannel(explosionImage, 6, 96, 96, Duration.seconds(0.5), 0, 5);

        texture = new AnimatedTexture(bombballChannel);
    }

    private void explode() {
        // เปลี่ยนเป็นอนิเมชั่นการระเบิด
        texture.playAnimationChannel(bombblastChannel);

        // ปรับตำแหน่งของ texture ให้อยู่ในตำแหน่งเดียวกับลูกระเบิด
        texture.setTranslateX(-32); // ปรับตำแหน่ง X เพื่อให้การระเบิดอยู่กึ่งกลาง
        texture.setTranslateY(-32); // ปรับตำแหน่ง Y เพื่อให้การระเบิดอยู่กึ่งกลาง

        // ใช้ขนาดและตำแหน่งของ AnimationChannel ในการตรวจสอบการชน
        double explosionX = entity.getX() + texture.getTranslateX(); // ตำแหน่ง X ที่แท้จริงของการระเบิด
        double explosionY = entity.getY() + texture.getTranslateY(); // ตำแหน่ง Y ที่แท้จริงของการระเบิด
        double explosionWidth = bombblastChannel.getFrameWidth(2); // ใช้ความกว้างของเฟรมจาก AnimationChannel
        double explosionHeight = bombblastChannel.getFrameHeight(2); // ใช้ความสูงของเฟรมจาก AnimationChannel

        // ตรวจสอบการชนกับ wall ที่อยู่ในรัศมีการระเบิด
        FXGL.getGameWorld().getEntitiesByType(Scene.wallbreak).forEach(WALL -> {
            String wallType = WALL.getString("wallType"); // ดึงค่า Property "wallType"
            if (wallType != null && wallType.startsWith("WALL")) {
                // ตรวจสอบว่ากำแพงอยู่ในพื้นที่การระเบิดหรือไม่
                double wallX = WALL.getX();
                double wallY = WALL.getY();
                double wallWidth = WALL.getWidth();
                double wallHeight = WALL.getHeight();

                // ตรวจสอบการซ้อนทับระหว่างพื้นที่การระเบิดและกำแพง
                if (explosionX < wallX + wallWidth &&
                        explosionX + explosionWidth > wallX &&
                        explosionY < wallY + wallHeight &&
                        explosionY + explosionHeight > wallY) {

                    // ลบกำแพงออกจากโลกเกม
                    WALL.removeFromWorld();

                    // ลบ tile ที่มี type ตรงกับ wallType
                    FXGL.getGameWorld().getEntitiesByType(Scene.walltile).forEach(tile -> {
                        if (tile.isColliding(WALL)) {
                            tile.removeFromWorld();
                        }
                    });
                }
            }
        });

        FXGL.runOnce(() -> {
            entity.removeFromWorld();
            ControllerPlayer.decrementBombCount(); // ลดจำนวนระเบิดเมื่อระเบิดถูกลบ
        }, Duration.seconds(0.5));
    }

}