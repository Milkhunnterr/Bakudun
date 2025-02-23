package me.pooh.bakudun;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CollisionExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // สร้างสองรูปสี่เหลี่ยม
        Rectangle rect1 = new Rectangle(50, 50, 100, 100);
        rect1.setFill(Color.RED);

        Rectangle rect2 = new Rectangle(200, 50, 100, 100);
        rect2.setFill(Color.BLUE);

        // สร้าง StackPane และเพิ่มสี่เหลี่ยมทั้งสองเข้าไป
        StackPane root = new StackPane();
        root.getChildren().addAll(rect1, rect2);

        // การตรวจสอบการชน
        rect1.setOnMouseDragged(event -> {
            rect1.setX(event.getSceneX() - rect1.getWidth() / 2);
            rect1.setY(event.getSceneY() - rect1.getHeight() / 2);

            if (rect1.getBoundsInParent().intersects(rect2.getBoundsInParent())) {
                System.out.println("Collision detected!");
                rect1.setFill(Color.GREEN); // เปลี่ยนสีถ้ามีการชน
            } else {
                rect1.setFill(Color.RED); // ถ้าไม่มีการชน กลับเป็นสีแดง
            }
        });

        // สร้าง Scene
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Collision Detection in JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
