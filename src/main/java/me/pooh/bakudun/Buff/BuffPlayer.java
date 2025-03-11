package me.pooh.bakudun.Buff;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BuffPlayer {
//    private double x, y;
//    private boolean active;
//    private Image buffImage;
//    private static final int TILE_SIZE = 40;
//    private static final long BUFF_DURATION = 10000; // บัฟมีผล 10 วินาที
//    private long activationTime;
//
//    public BuffPlayer(double x, double y) {
//        this.x = x;
//        this.y = y;
//        this.active = true;
//        this.buffImage = new Image("buff_player.png"); // ใส่รูป Buff Player
//    }
//
//    public void render(GraphicsContext gc) {
//        if (active) {
//            gc.drawImage(buffImage, x, y);
//        }
//    }
//
//    public boolean checkCollision(double playerX, double playerY) {
//        if (active && Math.abs(playerX - x) < TILE_SIZE && Math.abs(playerY - y) < TILE_SIZE) {
//            active = false;
//            activationTime = System.currentTimeMillis();
//            return true;
//        }
//        return false;
//    }
//
//    public boolean isBuffActive() {
//        return !active && (System.currentTimeMillis() - activationTime < BUFF_DURATION);
//    }
//
//    public boolean isActive() {
//        return active;
//    }
}
