package gui.all;
/*
 * MENU CONTROLLER 
 * 
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import all.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DrawerController implements Initializable {
	@FXML
	private VBox entervbox;

	@FXML
	private JFXButton btnenter;

	@FXML
	private JFXButton btnpageReplacement;

	@FXML
	private JFXButton btncpuScheduling;

	@FXML
	private JFXButton btndiskScheduling;

	@FXML
	private JFXButton exit;

	@FXML
	void goCpuScheduling(ActionEvent event) {
			Go("/gui/cpuscheduling/cpuScheduling.fxml");
	}

	@FXML
	void goDiskScheduling(ActionEvent event) {
			Go("/gui/diskscheduling/diskscheduling.fxml");
	}

	@FXML
	void goEnter(ActionEvent event) {
			Go("/gui/enter/enter.fxml");
	}

	@FXML
	void goPageReplacement(ActionEvent event) {
			Go("/gui/pagereplacement/PageReplacement.fxml");
	}

	@FXML
	void exitAll(ActionEvent event) {
		// get a handle to the stage
		Stage stage = (Stage) exit.getScene().getWindow();
		// do what you have to do
		stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	///this function handle all the stage changes (only getting the page path)
	private void Go(String FxmlFile) {
		Stage mainstage = new Stage();
		mainstage = MainApp.parentWindow;
		Parent pageRoot;
		try {
			pageRoot = FXMLLoader.load(getClass().getResource(FxmlFile));
			mainstage.getScene().setRoot(pageRoot);
		} catch (IOException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
	}
}
