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
					GUI_MainWindow guiMainWindow = new GUI_MainWindow();
					AudioContext audioContext = new AudioContext(); 
					
					String sampleFile = "res/audio/pummeled.wav"; 
					
					GranularSamplePlayer grainPlayer =  new GranularSamplePlayer(audioContext, 
							SampleManager.sample(sampleFile)); 
					
					Controller_Play controllerPlay = new Controller_Play(guiMainWindow, audioContext, grainPlayer);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
