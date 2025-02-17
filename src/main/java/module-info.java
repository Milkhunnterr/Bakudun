module me.pooh.bakudun {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens me.pooh.bakudun to javafx.fxml;
    exports me.pooh.bakudun;
}