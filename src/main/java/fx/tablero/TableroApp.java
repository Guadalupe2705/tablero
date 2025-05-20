package fx.tablero;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TableroApp extends Application {
    private static final int TAM_CASILLA = 60;
    private static final int FILAS = 8;
    private static final int COLUMNAS = 8;

    private     Circle rueda;

    @Override
    public void start(Stage stage ) {
        GridPane grid = new GridPane();
        for (int fila = 0; fila < FILAS; fila++) {
            for (int col = 0; col < COLUMNAS; col++) {
                Rectangle casilla = new Rectangle(TAM_CASILLA, TAM_CASILLA);
                if ((fila + col) % 2 == 0) {
                    casilla.setFill(Color.BLACK);
                } else {
                    casilla.setFill(Color.PINK);
                }
                grid.add(casilla, col, fila);
            }
        }

        grid.setLayoutX(0);
        grid.setLayoutY(0);

        rueda = new Circle(10, Color.BLUE);
        rueda.setCenterX(30);
        rueda.setCenterY(30);
        Pane root = new Pane();
        root.getChildren().addAll(grid, rueda);

        Scene scene = new Scene(root, TAM_CASILLA * COLUMNAS, TAM_CASILLA * FILAS);
        scene.setOnKeyPressed(event -> {
            double dx = 0, dy = 0;
            if (event.getCode() == KeyCode.UP) {
                dy = -TAM_CASILLA;
            } else if (event.getCode() == KeyCode.DOWN) {
                dy = TAM_CASILLA;
            } else if (event.getCode() == KeyCode.LEFT) {
                dx = -TAM_CASILLA;
            } else if (event.getCode() == KeyCode.RIGHT) {
                dx = TAM_CASILLA;
            }
            double nuevoX = rueda.getCenterX() + dx;
            double nuevoY = rueda.getCenterY() + dy;
            if (nuevoX > -0 && nuevoX <= (COLUMNAS - 1) * TAM_CASILLA + 30 &&
                    nuevoY >= 0 && nuevoY <= (FILAS - 1) * TAM_CASILLA + 30) {
                rueda.setCenterX(nuevoX);
                rueda.setCenterY(nuevoY);
            }
        });

        stage.setTitle("Tablero De Lupita");
        stage.setScene(scene);
        stage.show();

        root.requestFocus();
    }

    public static void main(String[] args) {
        launch();
    }
}