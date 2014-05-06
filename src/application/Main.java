package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	GraphicsContext gc;
	Scene scene;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			//FlowPane fp = new FlowPane();
			FlowPane HUD = new FlowPane();
			Canvas canvas = new Canvas(500,400);
			root.setTop(HUD);
			root.setBottom(canvas);
//			root.getChildren().add(canvas);
			gc = canvas.getGraphicsContext2D();
			scene = new Scene(root,500,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Rach's stage");
			primaryStage.setScene(scene);
			primaryStage.show();
			startTimer();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void startTimer() {
		AnimationTimer timer = new AnimationTimer() {
			
			int x1 = 10;
			int y1 = 10;
			int x2 = 490;
			int y2 = 10;
			int shapeWidth = 10;
			int shapeHeight = 10;
			boolean collisionOccured = false;
			@Override
			public void handle(long arg0) {
				
				gc.setFill(Color.BLACK); ////////////////
				gc.fillRect(0, 0, 500, 400); //////////////
				
				gc.setFill(Color.PINK);
				gc.fillOval(x1, y1, shapeWidth, shapeHeight);
				gc.setFill(Color.CHARTREUSE);
				gc.fillOval(x2, y2, shapeWidth, shapeHeight);
				x1 ++;
				x2 --;
				// check for collision on the x axis....
				if (x1 >= x2 - shapeWidth && x2 <= x2 + shapeWidth) {
					collisionOccured = true;
					System.out.println("collisionOccured " + collisionOccured);
				}
				
			}
			
		};
		timer.start();
	}
	
	public void addListeners() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode() == KeyCode.SPACE) {
					System.out.println("Space was pressed");
				} else if (ke.getCode() == KeyCode.RIGHT) {
					System.out.println("Right was pressed");
				} else if (ke.getCode() == KeyCode.LEFT) {
					System.out.println("Left was pressed");
				} else if (ke.getCode() == KeyCode.X) {
					System.out.println("x was pressed");
				} 
			}
		});
	}
}
