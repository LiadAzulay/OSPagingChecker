package all;

/*for any question about the implementation feel free-0523293590 liad
 * 
 * 
 * in order to make new pages work with scene builder
 * every page in gui has css file fxml and java file
 * java file - the controller of the page
 * fxml file - scene builder product (java attributes needs to be equal to scene builder attributes)
 * css file - javafx css
 *
*/
import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class MainApp extends Application{
	//	parentWindow is holding the stage to reload other pages in the same window 
	//	(otherwise the window is reopen when changing stages)
	public static Stage parentWindow;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		parentWindow = primaryStage;
		try {
			///enter page is the first page 
			Parent root = FXMLLoader.load(getClass().getResource("/gui/enter/enter.fxml"));
			Scene scene = new Scene(root, 600, 450);

			primaryStage.setScene(scene);
			primaryStage.show();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}




// pages = 7 0 1 2 0 3 0 4 2 3 0 3 2 1 2 0 1 7 0 1
//frames = 3
















