module fx.tablero {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens fx.tablero to javafx.fxml;
    exports fx.tablero;
}