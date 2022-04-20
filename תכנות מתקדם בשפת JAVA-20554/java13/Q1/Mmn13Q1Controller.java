/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */

import static java.lang.Math.abs;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author Batsheva Rich <batsheva7424@gmail.com>
 */
public class Mmn13Q1Controller implements Initializable {

    private enum Shape {
        LINE, RECTANGLE, ELLIPSE
    }

    private Shape currentShape = Shape.LINE;
    private boolean fill = true;

    private double startX;
    private double startY;
    @FXML
    private ComboBox<Shape> comboBox;
    @FXML
    private ComboBox<String> comboBoxStroke;
    @FXML
    private ColorPicker ColorPickerP;
    @FXML
    private Button BtnUndo;
    @FXML
    private Button BtnClear;
    @FXML
    private Pane paneP;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // reset combo box for shapes options
        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().add(Shape.LINE);
        comboBox.getItems().add(Shape.RECTANGLE);
        comboBox.getItems().add(Shape.ELLIPSE);
        comboBox.getSelectionModel().select(Shape.LINE);

        // reset combo box for stroke types
        comboBoxStroke.getItems().removeAll(comboBoxStroke.getItems());
        comboBoxStroke.getItems().add("Fill");
        comboBoxStroke.getItems().add("Stroke");
        comboBoxStroke.getSelectionModel().select("Fill");
    }

    @FXML
    public void shapeChosen(ActionEvent event) {
        // set chosen shape from user (default is line)
        currentShape = (Shape) ((ComboBox) event.getSource()).getValue();
    }

    @FXML
    public void strokeOrFill(ActionEvent event) {
        // set fill type from user (default is fill)
        fill = "FILL".equals(((ComboBox) event.getSource()).getValue().toString().toUpperCase());
    }

    @FXML
    public void paneDragStarted(MouseEvent event) {
        // get start x,y coordinates from mouse click
        startX = event.getSceneX();
        startY = event.getSceneY();
    }

    @FXML
    public void undoShapes(ActionEvent event) {
        // undo drawings one by one. need to catch exception if pane is empty
        try {
            paneP.getChildren().remove(paneP.getChildren().get(paneP.getChildren().size() - 1));
        } catch (Exception e) {
            System.out.println("no shapes left to remove");
        }
    }

    @FXML
    public void clearShapes(ActionEvent event) {
        // clear all shapes- empty pane
        paneP.getChildren().clear();
    }

    private void drawLine(MouseEvent event) {
        // line only has stroke
        Line l = new Line(startX, startY, event.getSceneX(), event.getSceneY());
        l.setStroke(ColorPickerP.getValue());
        paneP.getChildren().add(l);
    }

    private void drawRectangle(MouseEvent event) {
        double width = event.getSceneX() - startX;
        double height = event.getSceneY() - startY;
        Rectangle r;
        if (width < 0) {
            if (height < 0) {
                r = new Rectangle(event.getSceneX(), event.getSceneY() - 35, abs(width), abs(height));
            } else {
                r = new Rectangle(event.getSceneX(), startY - 35, abs(width), abs(height));
            }
        } else {
            if (height < 0) {
                r = new Rectangle(startX, event.getSceneY() - 35, abs(width), abs(height));
            } else {
                r = new Rectangle(startX, startY - 35, abs(width), abs(height));
            }
        }
        if (fill) {
            r.setFill(ColorPickerP.getValue());
        } else {
            r.setFill(Color.TRANSPARENT);
            r.setStroke(ColorPickerP.getValue());
        }
        paneP.getChildren().add(r);
    }

    private void drawEllipse(MouseEvent event) {
        Ellipse e = new Ellipse((startX + event.getSceneX()) / 2, 0, 0, 0);
        e.setCenterY(abs(startY - 35 + event.getSceneY()) / 2);
        e.setRadiusX(abs(event.getSceneX() - startX) / 2);
        e.setRadiusY(abs(event.getSceneY() - startY - 35) / 2);
        if (fill) {
            e.setFill(ColorPickerP.getValue());
        } else {
            e.setFill(Color.TRANSPARENT);
            e.setStroke(ColorPickerP.getValue());
        }
        paneP.getChildren().add(e);
    }

    @FXML
    public void paneDragEnded(MouseEvent event) {
        switch (currentShape) {
            case LINE:
                drawLine(event);
                break;
            case RECTANGLE:
                drawRectangle(event);
                break;
            case ELLIPSE:
                drawEllipse(event);
                break;
            default:
                drawLine(event);
        }
    }

}
