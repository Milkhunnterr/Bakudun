package me.pooh.bakudun.EntityFactory;

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
import me.pooh.bakudun.EntityType.Scene;

public class Scemap implements EntityFactory {

    @Spawns("wall")
    public Entity spawnWall(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.STATIC);

        return FXGL.entityBuilder(data)
                .type(Scene.wall)
                .at(data.getX(), data.getY())
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(physics) //
                .with(new CollidableComponent(true))
                .build();

    }

    @Spawns("WALL1")
    public Entity spawnWall1(SpawnData data) {
        return createWall(data, "WALL1");
    }

    @Spawns("WALL2")
    public Entity spawnWall2(SpawnData data) {
        return createWall(data, "WALL2");
    }

    @Spawns("WALL3")
    public Entity spawnWall3(SpawnData data) {
        return createWall(data, "WALL3");
    }

    @Spawns("WALL4")
    public Entity spawnWall4(SpawnData data) {
        return createWall(data, "WALL4");
    }

    @Spawns("WALL5")
    public Entity spawnWall5(SpawnData data) {
        return createWall(data, "WALL5");
    }

    @Spawns("WALL6")
    public Entity spawnWall6(SpawnData data) {
        return createWall(data, "WALL6");
    }

    @Spawns("WALL7")
    public Entity spawnWall7(SpawnData data) {
        return createWall(data, "WALL7");
    }

    @Spawns("WALL8")
    public Entity spawnWall8(SpawnData data) {
        return createWall(data, "WALL8");
    }

    @Spawns("WALL9")
    public Entity spawnWall9(SpawnData data) {
        return createWall(data, "WALL9");
    }

    @Spawns("WALL10")
    public Entity spawnWall10(SpawnData data) {
        return createWall(data, "WALL10");
    }

    @Spawns("WALL11")
    public Entity spawnWall11(SpawnData data) {
        return createWall(data, "WALL11");
    }

    @Spawns("WALL12")
    public Entity spawnWall12(SpawnData data) {
        return createWall(data, "WALL12");
    }

    @Spawns("WALL13")
    public Entity spawnWall13(SpawnData data) {
        return createWall(data, "WALL13");
    }

    @Spawns("WALL14")
    public Entity spawnWall14(SpawnData data) {
        return createWall(data, "WALL14");
    }

    @Spawns("WALL15")
    public Entity spawnWall15(SpawnData data) {
        return createWall(data, "WALL15");
    }

    @Spawns("WALL16")
    public Entity spawnWall16(SpawnData data) {
        return createWall(data, "WALL16");
    }

    @Spawns("WALL17")
    public Entity spawnWall17(SpawnData data) {
        return createWall(data, "WALL17");
    }

    @Spawns("WALL18")
    public Entity spawnWall18(SpawnData data) {
        return createWall(data, "WALL18");
    }

    @Spawns("WALL19")
    public Entity spawnWall19(SpawnData data) {
        return createWall(data, "WALL19");
    }

    @Spawns("WALL20")
    public Entity spawnWall20(SpawnData data) {
        return createWall(data, "WALL20");
    }

    @Spawns("WALL21")
    public Entity spawnWall21(SpawnData data) {
        return createWall(data, "WALL21");
    }

    @Spawns("WALL22")
    public Entity spawnWall22(SpawnData data) {
        return createWall(data, "WALL22");
    }

    @Spawns("WALL23")
    public Entity spawnWall23(SpawnData data) {
        return createWall(data, "WALL23");
    }

    @Spawns("WALL24")
    public Entity spawnWall24(SpawnData data) {
        return createWall(data, "WALL24");
    }

    @Spawns("WALL25")
    public Entity spawnWall25(SpawnData data) {
        return createWall(data, "WALL25");
    }

    @Spawns("WALL26")
    public Entity spawnWall26(SpawnData data) {
        return createWall(data, "WALL26");
    }

    @Spawns("WALL27")
    public Entity spawnWall27(SpawnData data) {
        return createWall(data, "WALL27");
    }

    @Spawns("WALL28")
    public Entity spawnWall28(SpawnData data) {
        return createWall(data, "WALL28");
    }

    @Spawns("WALL29")
    public Entity spawnWall29(SpawnData data) {
        return createWall(data, "WALL29");
    }

    @Spawns("WALL30")
    public Entity spawnWall30(SpawnData data) {
        return createWall(data, "WALL30");
    }

    @Spawns("WALL31")
    public Entity spawnWall31(SpawnData data) {
        return createWall(data, "WALL31");
    }

    @Spawns("WALL32")
    public Entity spawnWall32(SpawnData data) {
        return createWall(data, "WALL32");
    }

    @Spawns("WALL33")
    public Entity spawnWall33(SpawnData data) {
        return createWall(data, "WALL33");
    }

    @Spawns("WALL34")
    public Entity spawnWall34(SpawnData data) {
        return createWall(data, "WALL34");
    }

    @Spawns("WALL35")
    public Entity spawnWall35(SpawnData data) {
        return createWall(data, "WALL35");
    }

    @Spawns("WALL36")
    public Entity spawnWall36(SpawnData data) {
        return createWall(data, "WALL36");
    }

    @Spawns("WALL37")
    public Entity spawnWall37(SpawnData data) {
        return createWall(data, "WALL37");
    }

    @Spawns("WALL38")
    public Entity spawnWall38(SpawnData data) {
        return createWall(data, "WALL38");
    }

    @Spawns("WALL39")
    public Entity spawnWall39(SpawnData data) {
        return createWall(data, "WALL39");
    }

    @Spawns("WALL40")
    public Entity spawnWall40(SpawnData data) {
        return createWall(data, "WALL40");
    }

    @Spawns("WALL41")
    public Entity spawnWall41(SpawnData data) {
        return createWall(data, "WALL41");
    }

    @Spawns("WALL42")
    public Entity spawnWall42(SpawnData data) {
        return createWall(data, "WALL42");
    }

    @Spawns("WALL43")
    public Entity spawnWall43(SpawnData data) {
        return createWall(data, "WALL43");
    }

    @Spawns("WALL44")
    public Entity spawnWall44(SpawnData data) {
        return createWall(data, "WALL44");
    }

    @Spawns("WALL45")
    public Entity spawnWall45(SpawnData data) {
        return createWall(data, "WALL45");
    }

    @Spawns("WALL46")
    public Entity spawnWall46(SpawnData data) {
        return createWall(data, "WALL46");
    }

    @Spawns("WALL47")
    public Entity spawnWall47(SpawnData data) {
        return createWall(data, "WALL47");
    }

    @Spawns("WALL48")
    public Entity spawnWall48(SpawnData data) {
        return createWall(data, "WALL48");
    }

    private Entity createWall(SpawnData data, String wallType) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.STATIC);

        return FXGL.entityBuilder(data)
                .type(Scene.wallbreak)
                .at(data.getX(), data.getY())
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(physics)
                .with(new CollidableComponent(true))
                .with("wallType", wallType)
                .build();
    }

}
