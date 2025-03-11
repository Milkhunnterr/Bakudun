package me.pooh.bakudun.Entity;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGL.*;

public class Player extends Sprite {
    public Player(double x, double y, int hp) {
        super(hp);
        entity = entityBuilder()
                .at(x, y)
                .viewWithBBox(new Rectangle(40, 40, Color.BLUE)) // ตัวละครสีฟ้า
                .with(new CollidableComponent(true)) // ตรวจจับการชน
                .buildAndAttach();
    }
}

