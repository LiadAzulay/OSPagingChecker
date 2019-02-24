package gui.enter;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;

import all.Helper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
/*
 * 
 * Enter controller, holding all the gui fx variables.
 * 
 * 
 */
public class DrawerEnter implements Initializable{


    @FXML
    private AnchorPane enter_pane;

    @FXML
    private JFXDrawer drawerEnter;

    @FXML
    private JFXHamburger hamburgerEnter;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Helper.activeMenu(drawerEnter, hamburgerEnter);

	}

}
