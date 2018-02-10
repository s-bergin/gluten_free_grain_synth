package gluten_free_grain_synth;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

public class Controller_MainWindow {
	
	private GUI_MainWindow mainWindow; 
	
	private Controller_File controllerFile; 
	private Controller_Grain controllerGrain;
	
	public Controller_MainWindow(GUI_MainWindow mainWindow, Controller_File controllerFile, Controller_Grain controllerGrain) {
		this.mainWindow = mainWindow; 
		this.controllerFile = controllerFile;
		this.controllerGrain = controllerGrain; 
		
		this.mainWindow.addChooseFileListener(new ChooseFileListener());
		this.mainWindow.addPlayFileListener(new PlayListener());
		this.mainWindow.addStopFileListener(new StopListener());
	}
	
	private class ChooseFileListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			controllerFile.onClickOpenFile(e);			
			controllerGrain.setFile(controllerFile.getUserFile());
		}
	}
	
	private class PlayListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			controllerGrain.onPlay();	
		}
	}
	
	private class StopListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			controllerGrain.onStop(); 
		}
	}
}
