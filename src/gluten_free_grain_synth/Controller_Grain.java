package gluten_free_grain_synth;

import java.io.File;

import net.beadsproject.beads.core.AudioContext;
import net.beadsproject.beads.data.SampleManager;
import net.beadsproject.beads.ugens.Envelope;
import net.beadsproject.beads.ugens.Gain;
import net.beadsproject.beads.ugens.GranularSamplePlayer;
import net.beadsproject.beads.ugens.SamplePlayer;

public class Controller_Grain {
	
	private File file; 
	
	private AudioContext audioContext; 
	private GranularSamplePlayer grainPlayer;
	private Gain grainGain;

	public Controller_Grain(AudioContext audioContext) {
		this.audioContext = audioContext;			
	}
	
	public void onChangePitch(float val) {
		System.out.println("Changing pitch...");
		this.grainPlayer.getPitchUGen().setValue(val);
	}
	
	public void onChangeGrainInterval(float val) {		
		this.grainPlayer.getGrainIntervalUGen().setValue(val);
	}
	
	public void setFile(File file) {
		this.file = file; 
	}
	
	public void onPlay() {
		
		if(this.file != null) {
			String audioFile = this.file.getPath();
			this.grainPlayer = new GranularSamplePlayer(this.audioContext,
					SampleManager.sample(audioFile));

			this.grainPlayer.setLoopType(SamplePlayer.LoopType.LOOP_ALTERNATING);
			this.grainPlayer.getLoopStartUGen().setValue(0);
			this.grainPlayer.getLoopEndUGen().setValue(
					(float)SampleManager.sample(audioFile).getLength());
			
			this.grainGain = new Gain(this.audioContext, 2, 1.0f);

			this.grainGain.addInput(this.grainPlayer);
			this.audioContext.out.addInput(this.grainGain);
			this.audioContext.start();
						
		}else {
			// TODO - Add prompt functionality to GUI 
			System.out.println("Please choose a file");
		}
	}
	
	public void onStop() {
		this.audioContext.stop(); 
	}
}
