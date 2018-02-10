package gluten_free_grain_synth;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

public class Controller_MainWindow {
	
	private GUI_MainWindow mainWindow; 
	
	private Controller_File controllerFile; 
	
	public Controller_MainWindow(GUI_MainWindow mainWindow, Controller_File controllerFile) {
		this.mainWindow = mainWindow; 
		this.controllerFile = controllerFile;
		
		this.mainWindow.addChooseFileListener(new ChooseFileListener());
	}
	
	private class ChooseFileListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			controllerFile.onClickOpenFile(e);
		}
	}
}
