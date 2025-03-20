package me.pooh.bakudun.Component;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import static com.almasb.fxgl.dsl.FXGL.*;

public class Monster extends Sprite {
    public Monster(double x, double y, int hp) {
        super(hp);
        entity = entityBuilder()
                .at(x, y)
                .viewWithBBox(new Rectangle(40, 40, Color.RED)) // มอนสเตอร์สีแดง
                .buildAndAttach();
    }

    public void moveRandomly() {
        int dx = (int) (Math.random() * 11 - 5); // เลื่อนไปทางซ้าย/ขวาแบบสุ่ม
        int dy = (int) (Math.random() * 11 - 5); // เลื่อนไปข้างหน้า/หลังแบบสุ่ม
        move(dx, dy);
    }
}

