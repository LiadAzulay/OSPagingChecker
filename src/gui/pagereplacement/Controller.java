package gui.pagereplacement;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import all.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
/*
 * 
 * Page Replacement controller, holding all the gui fx variables
 * and the control over the algorithm choice.
 * 
 */

public class Controller implements Initializable {
	private int numOfAlgoChoice = 1;

	@FXML
	private AnchorPane pane;

	@FXML
	private JFXTextArea result;

	@FXML
	private JFXTextField pageEnter;

	@FXML
	private JFXButton calculate;

	@FXML
	private JFXTextField framesEnter;

	@FXML
	private JFXHamburger prhamburger;

	@FXML
	private JFXDrawer prdrawer;

	@FXML
	private MenuButton algoButton;

	@FXML
	private MenuItem Fifo;

	@FXML
	private MenuItem LRU;

	@FXML
	private MenuItem Optimal;

	@FXML
	void setChoiceToFifo(ActionEvent event) {
		numOfAlgoChoice = 1;
	}

	@FXML
	void setChoiceToLRU(ActionEvent event) {
		numOfAlgoChoice = 2;
	}

	@FXML
	void setChoiceToOptimal(ActionEvent event) {
		numOfAlgoChoice = 3;
	}

	/// calculating faults base of number of algorithm
	@FXML
	void calculateFaults(ActionEvent event) {
		result.setText("");

		int frames = 0;

		/// getting all args for page algorithms
		String pages = pageEnter.getText();
		int[] intPages = Helper.PagesToArray(pages);
		try {
			frames = Integer.parseInt(framesEnter.getText());
			/// if frames greater than 0
			if (frames > 0) {
				switch (numOfAlgoChoice) {
				case 1:
					result.appendText((Helper.fifo(intPages, intPages.length, frames)).toString());
					break;
				case 2:
					result.appendText((Helper.Lru(intPages, intPages.length, frames)).toString());
					break;
				case 3:
					result.appendText((Helper.Optimal(intPages, intPages.length, frames)).toString());
					break;
				default:
					break;
				}
			} else {
				//INVOKING ALERT OF NUMBER OF FRAMES
				Helper.AlertOut(AlertType.ERROR, "Error Dialog", "invalid number of frames",
						"Please Enter Number Greater Then 0");

			}
		} catch (Exception e) {
			//invoking alert of invalid input
			Helper.AlertOut(AlertType.ERROR, "Error Dialog", "invalid number of frames", "Invalid Input");

		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/// hovering over page & frames textfields
		framesEnter.setTooltip(new Tooltip("Please enter number greater then 0"));
		pageEnter.setTooltip(new Tooltip("Enter the number of pages with spaces between them"));

		Helper.activeMenu(prdrawer, prhamburger);
	}
}