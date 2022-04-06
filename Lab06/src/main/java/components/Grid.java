package components;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Translate;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    Pane pane;
    double width;
    double height;
    double padding = 50;
    int columns;
    int rows;
    int circleRadius = 10;
    List<Line> lines;
    List<Circle> circles;

    public Grid(Pane pane, double width, double height, int rows, int columns) {
        this.pane = pane;
        this.width = width - padding * 2;
        this.height = height - padding * 2;
        this.columns = columns;
        this.rows = rows;
        lines = new ArrayList<>();
        circles = new ArrayList<>();
        this.createGrid();
    }

    void createGrid() {

        double squareSize = Math.min(width / rows, height / columns);

        double newWidth = squareSize * rows;
        double newHeight = squareSize * columns;


        double heightPadding = (pane.getHeight() - newHeight) / 2;
        double widthPadding = (pane.getWidth() - newWidth) / 2;


        Translate centerTranslate = new Translate();

        centerTranslate.setX(widthPadding);
        centerTranslate.setY(heightPadding);

        for (int i = 0; i <= rows; i++)
            for (int j = 0; j < columns; j++) {
                Line l = new Line(i * squareSize, j * squareSize, i * squareSize, j * squareSize + squareSize);
                l.setStroke(Color.BLACK);
                l.getTransforms().addAll(centerTranslate);
                lines.add(l);
            }

        for (int i = 0; i < rows; i++)
            for (int j = 0; j <= columns; j++) {
                Line l = new Line(i * squareSize, j * squareSize, i * squareSize + squareSize, j * squareSize);
                l.setStroke(Color.BLACK);
                l.getTransforms().addAll(centerTranslate);
                lines.add(l);
            }

        for (int i = 0; i <= rows; i++)
            for (int j = 0; j <= columns; j++) {
                Circle c = new Circle(i * squareSize, j * squareSize, circleRadius);
                c.setFill(Color.WHITE);
                c.setStroke(Color.BLACK);
                c.getTransforms().addAll(centerTranslate);
                circles.add(c);
            }
    }

    public void draw() {
        circles.forEach(c -> pane.getChildren().add(c));
        lines.forEach(l -> pane.getChildren().add(l));
    }
}
