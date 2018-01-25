/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Connor Rowland
 */
public class CheckerboardUIController implements Initializable {
    
    private CheckerBoard board;
    private Stage stage;
    
    @FXML
    private VBox rootBox;
    
    @FXML
    private MenuBar menuBar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void createInitialBoard(Stage stage) {
        this.stage = stage;
        board = new CheckerBoard(8, 8, rootBox.getWidth(), (rootBox.getHeight() - menuBar.getHeight()));
        board.build();
        rootBox.getChildren().add(board.getBoard());
        
        this.stage.widthProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldWidth, Number newWidth) -> {
            this.resizeBoard();
        });
        
        this.stage.heightProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldHeight, Number newHeight) -> {
            this.resizeBoard();
        });
    }
    
    @FXML
    private void changeColorBlue() {
        CheckerBoard newBlueBoard = new CheckerBoard(board.getNumRows(), board.getNumCols(), board.getWidth(), board.getHeight(), Color.SKYBLUE, Color.DARKBLUE);
        board = newBlueBoard;
        board.build();
        rootBox.getChildren().remove(1);
        rootBox.getChildren().add(board.getBoard());
    }
    
    @FXML
    private void changeColorDefault() {
        CheckerBoard newDefaultBoard = new CheckerBoard(board.getNumRows(), board.getNumCols(), board.getWidth(), board.getHeight());
        board = newDefaultBoard;
        board.build();
        rootBox.getChildren().remove(1);
        rootBox.getChildren().add(board.getBoard());
    }
    
    @FXML
    private void changeSize16x16() {
        this.newBoardGrid(16, 16);
    }
    
    @FXML
    private void changeSize10x10() {
        this.newBoardGrid(10, 10);
    }
    
    @FXML
    private void changeSize8x8() {
        this.newBoardGrid(8, 8);
    }
    
    @FXML
    private void changeSize3x3() {
        this.newBoardGrid(3, 3);
    }
    
    private void newBoardGrid(int newNumRows, int newNumCols) {
        CheckerBoard newGridBoard = new CheckerBoard(newNumRows, newNumCols, board.getWidth(), board.getHeight(), board.getLightColor(), board.getDarkColor());
        board = newGridBoard;
        board.build();
        rootBox.getChildren().remove(1);
        rootBox.getChildren().add(board.getBoard());
    }
    
    private void resizeBoard() {
        CheckerBoard newSizeBoard = new CheckerBoard(board.getNumRows(), board.getNumCols(), rootBox.getWidth(), (rootBox.getHeight() - menuBar.getHeight()), board.getLightColor(), board.getDarkColor());
        board = newSizeBoard;
        board.build();
        rootBox.getChildren().remove(1);
        rootBox.getChildren().add(board.getBoard());
    }
    
}
