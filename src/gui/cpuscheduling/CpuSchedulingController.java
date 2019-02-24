package gui.cpuscheduling;
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

public class CpuSchedulingController implements Initializable {

    @FXML
    private AnchorPane pane1;

    @FXML
    private JFXDrawer csdrawer;

    @FXML
    private JFXHamburger cshamburger;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Helper.activeMenu(csdrawer, cshamburger);
	}

}
