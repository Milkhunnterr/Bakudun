package me.pooh.bakudun.EntityFactory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import me.pooh.bakudun.EntityType.Bomb;

public class Bombba implements EntityFactory {

   /* @Spawns("Bomb")
    public Entity newBomb(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(Bomb.bomba)
                .bbox(new HitBox(BoundingShape.box(32, 32))) // ขนาดของระเบิด
                .with(new CollidableComponent(true))
                .with(new BombComponent()) // เพิ่มคอมโพเนนต์สำหรับการทำงานของระเบิด
                .build();
    }*/
}