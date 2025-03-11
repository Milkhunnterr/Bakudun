package me.pooh.bakudun.Factory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;

import me.pooh.bakudun.Entitynum.MapType;

public class Scene implements EntityFactory {
    PhysicsComponent physics = new PhysicsComponent();

    @Spawns("map")
    public Entity spawnWall(SpawnData data) {

        physics.setBodyType(BodyType.STATIC);
        return FXGL.entityBuilder(data)
                .type(MapType.wall)
                .at(data.getX(),data.getY())
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"),data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();
    }

}
