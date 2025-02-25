module me.pooh.bakudun {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens me.pooh.bakudun to javafx.fxml;
    exports me.pooh.bakudun;
    exports me.pooh.bakudun.Entity;
    opens me.pooh.bakudun.Entity to javafx.fxml;
    exports me.pooh.bakudun.Scene;
    opens me.pooh.bakudun.Scene to javafx.fxml;
}