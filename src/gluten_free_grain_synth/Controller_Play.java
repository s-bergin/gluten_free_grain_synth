package gluten_free_grain_synth;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.data.SampleManager;
import net.beadsproject.beads.ugens.Envelope;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.GranularSamplePlayer;
import net.beadsproject.beads.ugens.SamplePlayer;

public class Controller_Play {
	
	private GUI_MainWindow mainWindow;
	private AudioContext audioContext; 
	private GranularSamplePlayer grainPlayer;  
	
	public Controller_Play(GUI_MainWindow mainWindow, AudioContext audioContext, GranularSamplePlayer grainPlayer) {
		this.mainWindow = mainWindow; 
		this.grainPlayer = grainPlayer; 
		this.audioContext = audioContext; 
		
		this.mainWindow.AddPlayLister(new SubmitListener());
	}
	
	private class SubmitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
}
