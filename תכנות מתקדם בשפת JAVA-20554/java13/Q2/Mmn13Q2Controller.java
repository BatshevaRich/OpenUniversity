/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */

import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Batsheva Rich <batsheva7424@gmail.com>
 */
public class Mmn13Q2Controller implements Initializable {

    @FXML
    private GridPane gridPane;

    private int[][] gameBoard;

    private final int GRID_WIDTH = 7;
    private final int GRID_HEIGHT = 5;

    private final int player1 = 1;
    private final int player2 = 2;
    private boolean currentPlayer = true;
    @FXML
    private ButtonBar btnGroup;
    @FXML
    private Label lblP1;
    @FXML
    private Label lblP2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initBoard();
    }

    private void initBoard() {
        // start game- clear grid and helper matrix, and reset winner text
        gridPane.getChildren().clear();
        for (int i = 0; i < GRID_WIDTH; i++) {
            for (int j = 0; j < GRID_HEIGHT; j++) {
                gridPane.add(new Rectangle(50, 50, Color.BLACK), i, j);
            }
        }
        lblP1.setText("Player 1");
        lblP2.setText("Player 2");
        lblP1.setFont(Font.font("System Regular", FontWeight.NORMAL, 14));
        lblP2.setFont(Font.font("System Regular", FontWeight.NORMAL, 14));

        gameBoard = new int[GRID_HEIGHT][GRID_WIDTH];

    }

    @FXML
    private void clearBoard(MouseEvent event) {
        // reset game on user click- enable all buttons and reset to first player
        initBoard();
        for (int i = 0; i < GRID_WIDTH; i++) {
            btnGroup.getButtons().get(i).setDisable(false);
        }
        currentPlayer = true;
    }

    @FXML
    private void playerDiscInsert(MouseEvent event) {
        int colNumber = Integer.parseInt(((Button) event.getSource()).getText()); // col user chose to insert on
        int i = 0;
        while (gameBoard[i][colNumber - 1] != 0 && i < GRID_HEIGHT) { // find top of col
            i++;
        }

        if (i + 1 == GRID_HEIGHT) { // disable button if reached the top
            btnGroup.getButtons().get(colNumber - 1).setDisable(true);
        }

        // insert disk by proper player
        if (currentPlayer) { // player 1
            gameBoard[i][colNumber - 1] = player1;
            gridPane.add(new Circle(10, Color.RED), colNumber - 1, GRID_HEIGHT - i - 1);
        } else { // player 2
            gameBoard[i][colNumber - 1] = player2;
            gridPane.add(new Circle(10, Color.BLUE), colNumber - 1, GRID_HEIGHT - i - 1);
        }
        
        // change player turn
        currentPlayer = !currentPlayer;
        
        // check winner
        int winner = checkWin();
        if (winner != 0) { // if there is a winner, disable continue game and display message
            for (int x = 0; x < GRID_WIDTH; x++) {
                btnGroup.getButtons().get(x).setDisable(true);
            }
            if (winner == player1) {
                lblP1.setText("Player 1\n is the winner!");
                lblP1.setFont(Font.font("System Bold", FontWeight.BOLD, 14));
            } else if (winner == player2) {
                lblP2.setText("Player 2\n is the winner!");
                lblP2.setFont(Font.font("System Bold", FontWeight.BOLD, 14));
            }
        }

    }

    private int checkWin() {
        if (checkRow(player1) || checkColumn(player1) || checkDiagonal(player1)) {
            return player1;
        } else if (checkRow(player2) || checkColumn(player2) || checkDiagonal(player2)) {
            return player2;
        }
        return 0;
    }

    private boolean checkDiagonal(int curPlayer) {
        // ascendingDiagonalCheck 
        for (int i = 3; i < GRID_HEIGHT; i++) {
            for (int j = 0; j < GRID_WIDTH - 3; j++) {
                if (gameBoard[i][j] == curPlayer && gameBoard[i - 1][j + 1] == curPlayer && gameBoard[i - 2][j + 2] == curPlayer && gameBoard[i - 3][j + 3] == curPlayer) {
                    return true;
                }
            }
        }
        // descendingDiagonalCheck
        for (int i = 3; i < GRID_HEIGHT; i++) {
            for (int j = 3; j < GRID_WIDTH; j++) {
                if (gameBoard[i][j] == curPlayer && gameBoard[i - 1][j - 1] == curPlayer && gameBoard[i - 2][j - 2] == curPlayer && gameBoard[i - 3][j - 3] == curPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkColumn(int curPlayer) {
        for (int i = 0; i < GRID_HEIGHT - 3; i++) {
            for (int j = 0; j < GRID_WIDTH; j++) {
                if (gameBoard[i][j] == curPlayer && gameBoard[i + 1][j] == curPlayer && gameBoard[i + 2][j] == curPlayer && gameBoard[i + 3][j] == curPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkRow(int curPlayer) {
        for (int j = 0; j < GRID_WIDTH - 3; j++) {
            for (int i = 0; i < GRID_HEIGHT; i++) {
                if (gameBoard[i][j] == curPlayer && gameBoard[i][j + 1] == curPlayer && gameBoard[i][j + 2] == curPlayer && gameBoard[i][j + 3] == curPlayer) {
                    return true;
                }
            }
        }
        return false;
    }
}
