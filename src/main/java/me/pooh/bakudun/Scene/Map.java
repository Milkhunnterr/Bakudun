package me.pooh.bakudun.Scene;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.HashSet;
import java.util.Set;

public class Map {
//    private static final int TILE_SIZE = 40;
//    private static final int ROWS = 15, COLS = 20;
//    private static final int WIDTH = COLS * TILE_SIZE, HEIGHT = ROWS * TILE_SIZE;
//
//    private int[][] mapLayout = {
//            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1},
//            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1},
//            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
//    };
//
//    private Image groundImage, wallImage;
//
//    public Map() {
//        groundImage = new Image("ground.png"); // ใส่รูปพื้น
//        wallImage = new Image("wall.png"); // ใส่รูปกำแพง
//    }
//
//    public void render(GraphicsContext gc) {
//        for (int row = 0; row < ROWS; row++) {
//            for (int col = 0; col < COLS; col++) {
//                if (mapLayout[row][col] == 1) {
//                    gc.drawImage(wallImage, col * TILE_SIZE, row * TILE_SIZE);
//                } else {
//                    gc.drawImage(groundImage, col * TILE_SIZE, row * TILE_SIZE);
//                }
//            }
//        }
//    }
//
//    public boolean isWall(int x, int y) {
//        int col = x / TILE_SIZE;
//        int row = y / TILE_SIZE;
//        return mapLayout[row][col] == 1;
//    }
}

