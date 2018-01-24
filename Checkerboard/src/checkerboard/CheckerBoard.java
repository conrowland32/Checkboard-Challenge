/*  Created by Connor Rowland
    Jan 22, 2018
*/

package checkerboard;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CheckerBoard {
    
    private int numRows;
    private int numCols;
    private double rectangleWidth;
    private double rectangleHeight;
    private double boardWidth;
    private double boardHeight;
    private Color lightColor;
    private Color darkColor;
    private AnchorPane boardPane;
    
    public CheckerBoard (int numRows, int numCols, double boardWidth, double boardHeight) {
        this(numRows, numCols, boardWidth, boardHeight, Color.RED, Color.BLACK);
    }
    
    public CheckerBoard (int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
        
        this.rectangleWidth = Math.ceil(boardWidth/numCols);
        this.rectangleHeight = Math.ceil(boardHeight/numRows);
    }
    
    public AnchorPane build() {
        GridPane gridPane = new GridPane();
        for(int i = 0; i < this.numRows; i++) {
            for(int j = 0; j < this.numCols; j++) {
                Rectangle rect = new Rectangle(rectangleWidth, rectangleHeight, (i + j)%2 == 0 ? this.lightColor : this.darkColor);
                gridPane.add(rect, j, i);
            }
        }
        boardPane = new AnchorPane(gridPane);
        return boardPane;
    }
    
    public AnchorPane getBoard() {
        return boardPane;
    }
    
    public int getNumRows() {
        return numRows;
    }
    
    public int getNumCols() {
        return numCols;
    }
    
    public double getWidth() {
        return boardWidth;
    }
    
    public double getHeight() {
        return boardHeight;
    }
    
    public Color getLightColor() {
        return lightColor;
    }
    
    public Color getDarkColor() {
        return darkColor;
    }
    
    public double getRectangleWidth() {
        return rectangleWidth;
    }
    
    public double getRectangleHeight() {
        return rectangleHeight;
    }

}
