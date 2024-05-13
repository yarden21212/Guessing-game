/*
 * RandomShapesController class is the core of the program which generates 10 different shapes with different colors.
 * The shapes are lines, squares and ellipses
 */

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class RandomShapesController {

    @FXML
    private Canvas canv;
    
  	//A random number between 0 to 2 to stroke the random shape
  	private Random random;
  	int _red, _green, _blue;//Represents the colors in the RGB
  	//The coordinates, height and width of the shapes
  	double _x, _y, _w, _h;
  	//The sizes of the canvas (height and width)
  	private double MAX_HEIGHT;
  	private double MAX_WIDTH;
  	private int MAX_SHAPES = 10;
  	private final int MAX_RGB = 255;
  	private final int DEVIDE_HEIGHT_SIZE = 4;
  	//The graphic context of the canvas
  	private GraphicsContext gc;

  	public void initialize() {
  		gc = canv.getGraphicsContext2D();
  		MAX_HEIGHT = canv.getHeight();
  		MAX_WIDTH = canv.getWidth();
  		random = new Random();
  	}
  	
    @FXML
    void btnPressed(ActionEvent event) {
    	
    	gc.clearRect(0, 0, MAX_WIDTH, MAX_HEIGHT);
    	generateShapes();
    	//Reset the RGB values
       	
    }
   
    //This function creates the 10 shapes
	private void generateShapes() {
    	
  		//Generate 10 shapes
  		for(int i = 0; i < MAX_SHAPES; i++) {
  			int shape = random.nextInt(3);
  			
  			//0 represents line
  			if(shape == 0) {
  				
  				getCoordinate("line");
  				
  				gc.strokeLine(_x, _y, _w, _h);
  			}
  			//1 represents a square
  			else if(shape == 1) {

  				getCoordinate("square");
  				
  				//RGB shades
  				generateColor();
  				
  				gc.fillRect(_x, _y, _w, _h);
  				gc.setFill(Color.rgb(_red, _green, _blue));
  				
  				
  			}
  			//2 represents an ellipse
  			else{
  				
  				getCoordinate("ellipse");
  				
  				//RGB shades
  				generateColor();
  				
  				gc.fillOval(_x, _y, _w, _h);
  				gc.setFill(Color.rgb(_red, _green, _blue));
  				
  				
  			}
  		}
  	}
	
	//Generate coordinates, height and width for the shapes
	private void getCoordinate(String str) {
		if(str == "line") {
			_x = random.nextDouble() * MAX_WIDTH;
			_y = random.nextDouble() * MAX_HEIGHT;
			_w = random.nextDouble() * MAX_WIDTH;//Represents the second x value
			_h = random.nextDouble() * MAX_HEIGHT;//Represents the second y value
		}
		else if(str == "square") {
			_x = random.nextDouble() * MAX_WIDTH;
			_y = random.nextDouble() * MAX_HEIGHT;
			_w = random.nextDouble() * MAX_HEIGHT/DEVIDE_HEIGHT_SIZE;
			_h = random.nextDouble() * MAX_HEIGHT/DEVIDE_HEIGHT_SIZE;
			
		}else {
			_x = random.nextDouble() * MAX_WIDTH;
			_y = random.nextDouble() * MAX_HEIGHT;
			_w = random.nextDouble() * MAX_WIDTH/DEVIDE_HEIGHT_SIZE;
			_h = random.nextDouble() * MAX_HEIGHT/DEVIDE_HEIGHT_SIZE;
		}
		
	}
	
	//Generate RGB shades, between 0 to 255
	private void generateColor() {
		_red = random.nextInt(MAX_RGB);
		_green = random.nextInt(MAX_RGB);
		_blue = random.nextInt(MAX_RGB);
	}
}