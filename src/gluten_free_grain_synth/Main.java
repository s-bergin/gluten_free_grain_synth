package gluten_free_grain_synth;


import java.awt.EventQueue;

import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.data.SampleManager;
import net.beadsproject.beads.ugens.Envelope;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.GranularSamplePlayer;
import net.beadsproject.beads.ugens.SamplePlayer;


public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					// init our gui 
					GUI_MainWindow guiMainWindow = new GUI_MainWindow();
					
					// controllers 
					Controller_File controllerFile = new Controller_File();
					Controller_Grain controllerGrain = new Controller_Grain(); 
					
					Controller_MainWindow controllerMainWindow = 
							new Controller_MainWindow(guiMainWindow, controllerFile, controllerGrain);
					
					// start app 
					guiMainWindow.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
