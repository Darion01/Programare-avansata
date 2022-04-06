package app;

import components.Grid;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Button exitButton;
    @FXML
    private Pane gameCanvas;
    @FXML
    private Button saveButton;
    @FXML
    private Button loadButton;
    @FXML
    private Button createButton;
    @FXML
    private Spinner<Integer> rowsSpinner;
    @FXML
    private Spinner<Integer> columnsSpinner;


    int currentRowsValue;
    int currentColumnsValue;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        SpinnerValueFactory<Integer> rowsValueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);

        SpinnerValueFactory<Integer> columnsValueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);

        rowsSpinner.setValueFactory(rowsValueFactory);
        columnsSpinner.setValueFactory(columnsValueFactory);

        currentRowsValue = rowsSpinner.getValue();
        currentColumnsValue = columnsSpinner.getValue();


        rowsSpinner.valueProperty().addListener((observableValue, integer, t1) -> currentRowsValue = rowsSpinner.getValue());

        columnsSpinner.valueProperty().addListener((observableValue, integer, t1) -> currentColumnsValue = columnsSpinner.getValue());
    }

    public void clearGameCanvas() {
        ObservableList<Node> list = gameCanvas.getChildren();
        for (int i = list.size() - 1; i >= 0; i--) {
            Node c = list.get(i);
            gameCanvas.getChildren().remove(c);
        }
    }

    public void createGrid() {

        clearGameCanvas();
        Grid mainGrid = new Grid(gameCanvas, gameCanvas.getWidth(), gameCanvas.getHeight(), currentRowsValue, currentColumnsValue);
        mainGrid.draw();
    }

    public void quitGame() {
        Platform.exit();
    }
}