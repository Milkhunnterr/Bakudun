package me.pooh.bakudun.Entity;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;

public abstract class Sprite extends Component {
    protected Entity entity;
    protected int hp;  // พลังชีวิต

    public Sprite(int hp) {
        this.hp = hp;
    }

    public void move(double dx, double dy) {
        entity.translateX(dx);
        entity.translateY(dy);
    }

    public int getHp() {
        return hp;
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (hp <= 0) {
            entity.removeFromWorld(); // ตัวละครตาย
        }
    }
}
