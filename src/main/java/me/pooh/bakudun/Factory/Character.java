package me.pooh.bakudun.Factory;

import me.pooh.bakudun.Component.Animation;
import me.pooh.bakudun.Component.ControllerPlayer;
import me.pooh.bakudun.Entitynum.Player;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;

public class Character implements EntityFactory {
    @Spawns("spawn point")
    public Entity newPlayerCharacter(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent(); // Create new one each time
        physics.setBodyType(BodyType.DYNAMIC);

        return FXGL.entityBuilder(data)
                .type(Player.Jim)
                .bbox(new HitBox(BoundingShape.box(8, 8)))
                .with(physics)
                .with(new CollidableComponent(true))
                .with(new ControllerPlayer())
                .with(new Animation("Jim.png"))
                .build();
    }

}
