/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
//package javamatrix;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Batsheva Rich <batsheva7424@gmail.com>
 */
// FXMLQ2Controller draws a 'math notebook' with filled squares after user click.
public class FXMLQ2Controller implements Initializable {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    private final int PIXEL_SIZE = 10;
    private final int PERCENT_TO_FILL = 10;
    @FXML
    private Button button;

    @FXML
    void drawLinesButtonPressed(ActionEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // get width & height of canvas for later use
        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();

        // clear canvas on each redraw
        gc.clearRect(0, 0, canvasWidth, canvasHeight);

        // set width & height of matrix by canvas size,
        // divide by pixel size for size of squares
        int matrixWidth = (int) canvasWidth / PIXEL_SIZE;
        int matrixHeight = (int) canvasHeight / PIXEL_SIZE;

        // percentage of squares need to be filled
        int percentage = (matrixWidth * matrixHeight) / PERCENT_TO_FILL;

        // init empty matrix for 'notebook' by size of canvas
        int[][] matrix = new int[matrixWidth][matrixHeight];

        // parameter to track how many squares are filled
        int filled = 0;

        // draw notebook squares by pixel size
        for (int row = 0; row < matrixWidth; row++) {
            for (int col = 0; col < matrixHeight; col++) {
                matrix[row][col] = 0;
                gc.strokeRect(row * PIXEL_SIZE, col * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
            }
        }

        // fill defined percentage of squares in matrix
        // keep track of filled squares in order to avoid refilling a square
        while (filled < percentage) {
            Random rand = new Random();
            int randx = rand.nextInt(matrixWidth);
            int randy = rand.nextInt(matrixHeight);
            if (matrix[randx][randy] != 1) {
                matrix[randx][randy] = 1;
                filled++;
                gc.fillRect(randx * PIXEL_SIZE, randy * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        drawLinesButtonPressed(null);
    }

}
