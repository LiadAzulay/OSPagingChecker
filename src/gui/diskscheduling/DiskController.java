package gui.diskscheduling;
/*
 * only template, need to implement
 * all the pic and etc can be deleted through scene builder  
 */
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;

import all.Helper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class DiskController implements Initializable{

	@FXML
	private AnchorPane dspane;

	@FXML
	private JFXDrawer dsdrawer;

	@FXML
	private JFXHamburger dshamburger;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Helper.activeMenu(dsdrawer, dshamburger);

	}
}