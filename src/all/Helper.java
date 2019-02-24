package all;


import java.io.IOException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
/*
 * this class centralize all functions  
 * 
 */
public class Helper {
	private static Alert alert = new Alert(null);
	
	
	//this function splits the string from gui to backend
	public static int[] PagesToArray(String pages) {
		String[] splited = pages.split(" ");
		int [] arr=new int[splited.length];
		for(int i =0;i<arr.length;i++) {
			try {
				arr[i] = Integer.parseInt(splited[i]);
			} catch (Exception e) {
			}
		}
		return arr;
	}
	
	//activate menu in all stages
	public static void activeMenu(JFXDrawer drawer,JFXHamburger hamburger) {
		try {
			VBox dsvbox1 = FXMLLoader.load(drawer.getClass().getResource("/gui/all/drawer.fxml"));
			drawer.setSidePane(dsvbox1);
			HamburgerBackArrowBasicTransition dsburgerTask2 = new HamburgerBackArrowBasicTransition(hamburger);
			dsburgerTask2.setRate(-1);
			hamburger.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_PRESSED, (e)->{

				dsburgerTask2.setRate(dsburgerTask2.getRate() *-1);
				dsburgerTask2.play();
				if(drawer.isOpened())
					drawer.close();
				else
					drawer.open();
			});
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	///this three function are the algorithm for paging, can reuse

	public static StringBuffer fifo(int[] pages,int pagesArrayLength, int frames) {
		StringBuffer sbfIFO = new StringBuffer();

		int pointer = 0, hit = 0, fault = 0,ref_len;
		int buffer[];
		int reference[];
		int mem_layout[][];

		ref_len =pagesArrayLength;

		reference = new int[ref_len];
		mem_layout = new int[ref_len][frames];
		buffer = new int[frames];
		for(int j = 0; j < frames; j++)
			buffer[j] = -1;


		for(int i = 0; i < ref_len; i++)
		{
			reference[i] = pages[i];
		}
		for(int i = 0; i < ref_len; i++)
		{
			int search = -1;
			for(int j = 0; j < frames; j++)
			{
				if(buffer[j] == reference[i])
				{
					search = j;
					hit++;
					break;
				} 
			}
			if(search == -1)
			{
				buffer[pointer] = reference[i];
				fault++;
				pointer++;
				if(pointer == frames)
					pointer = 0;
			}
			for(int j = 0; j < frames; j++)
				mem_layout[i][j] = buffer[j];
		}

		for(int i = 0; i < frames; i++)
		{
			for(int j = 0; j < ref_len; j++)
				sbfIFO .append(String.format("%3d ",mem_layout[j][i]));

			sbfIFO.append("\n");

		}

		sbfIFO.append("The number of Hits: " + hit+"\n");
		sbfIFO.append("Hit Ratio: " + (float)((float)hit/ref_len)+"\n");
		sbfIFO.append("The number of Faults: " + fault+"\n");
		return sbfIFO;
	}

	public static StringBuffer Lru(int[] pages,int pagesArrayLength, int frames)  {
		StringBuffer sbLRU = new StringBuffer(); 
		int pointer = 0, hit = 0, fault = 0,ref_len;
		Boolean isFull = false;
		int buffer[];
		ArrayList<Integer> stack = new ArrayList<Integer>();
		int reference[];
		int mem_layout[][];

		ref_len = pagesArrayLength;

		reference = new int[ref_len];
		mem_layout = new int[ref_len][frames];
		buffer = new int[frames];
		for(int j = 0; j < frames; j++)
			buffer[j] = -1;


		for(int i = 0; i < ref_len; i++)
		{
			reference[i] = pages[i];
		}
		System.out.println();
		for(int i = 0; i < ref_len; i++)
		{
			if(stack.contains(reference[i]))
			{
				stack.remove(stack.indexOf(reference[i]));
			}
			stack.add(reference[i]);
			int search = -1;
			for(int j = 0; j < frames; j++)
			{
				if(buffer[j] == reference[i])
				{
					search = j;
					hit++;
					break;
				}
			}
			if(search == -1)
			{
				if(isFull)
				{
					int min_loc = ref_len;
					for(int j = 0; j < frames; j++)
					{
						if(stack.contains(buffer[j]))
						{
							int temp = stack.indexOf(buffer[j]);
							if(temp < min_loc)
							{
								min_loc = temp;
								pointer = j;
							}
						}
					}
				}
				buffer[pointer] = reference[i];
				fault++;
				pointer++;
				if(pointer == frames)
				{
					pointer = 0;
					isFull = true;
				}
			}
			for(int j = 0; j < frames; j++)
				mem_layout[i][j] = buffer[j];
		}

		for(int i = 0; i < frames; i++)
		{
			for(int j = 0; j < ref_len; j++)
				sbLRU .append(String.format("%3d ",mem_layout[j][i]));

			sbLRU.append("\n");

		}


		sbLRU.append("The number of Hits: " + hit+"\n");
		sbLRU.append("Hit Ratio: " + (float)((float)hit/ref_len)+"\n");
		sbLRU.append("The number of Faults: " + fault+"\n");
		return sbLRU;

	}

	public static StringBuffer Optimal(int[] pages,int pagesArrayLength, int frames)  {
		StringBuffer sbOptimal = new StringBuffer(); 
		int pointer = 0, hit = 0, fault = 0,ref_len;
		boolean isFull = false;
		int buffer[];
		int reference[];
		int mem_layout[][];

		ref_len = pagesArrayLength;

		reference = new int[ref_len];
		mem_layout = new int[ref_len][frames];
		buffer = new int[frames];
		for(int j = 0; j < frames; j++)
			buffer[j] = -1;

		for(int i = 0; i < ref_len; i++)
		{
			reference[i] = pages[i];
		}
		System.out.println();
		for(int i = 0; i < ref_len; i++)
		{
			int search = -1;
			for(int j = 0; j < frames; j++)
			{
				if(buffer[j] == reference[i])
				{
					search = j;
					hit++;
					break;
				} 
			}
			if(search == -1)
			{
				if(isFull)
				{
					int index[] = new int[frames];
					boolean index_flag[] = new boolean[frames];
					for(int j = i + 1; j < ref_len; j++)
					{
						for(int k = 0; k < frames; k++)
						{
							if((reference[j] == buffer[k]) && (index_flag[k] == false))
							{
								index[k] = j;
								index_flag[k] = true;
								break;
							}
						}
					}
					int max = index[0];
					pointer = 0;
					if(max == 0)
						max = 200;
					for(int j = 0; j < frames; j++)
					{
						if(index[j] == 0)
							index[j] = 200;
						if(index[j] > max)
						{
							max = index[j];
							pointer = j;
						}
					}
				}
				buffer[pointer] = reference[i];
				fault++;
				if(!isFull)
				{
					pointer++;
					if(pointer == frames)
					{
						pointer = 0;
						isFull = true;
					}
				}
			}
			for(int j = 0; j < frames; j++)
				mem_layout[i][j] = buffer[j];
		}

		for(int i = 0; i < frames; i++)
		{
			for(int j = 0; j < ref_len; j++)
				sbOptimal .append(String.format("%3d ",mem_layout[j][i]));

			sbOptimal.append("\n");

		}


		sbOptimal.append("The number of Hits: " + hit+"\n");
		sbOptimal.append("Hit Ratio: " + (float)((float)hit/ref_len)+"\n");
		sbOptimal.append("The number of Faults: " + fault+"\n");
		return sbOptimal;

	}

	///showing all alerts 
public static void AlertOut(AlertType alertType, String title, String header, String content) {
	alert.setAlertType(alertType);
	alert.setTitle(title);
	alert.setHeaderText(header);
	alert.setContentText(content);

	alert.showAndWait();
}

}


