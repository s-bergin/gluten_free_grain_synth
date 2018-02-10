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
	
	private float loopStartVal = 0; 
	
	public Controller_Grain(AudioContext audioContext) {
		this.audioContext = audioContext; 
				
	}
	
	public void setLoopStartVal(float val) {
		this.loopStartVal = val; 
	}
	
	public void onChangeStartPos(float val) {
		this.loopStartVal = val; 
		this.grainPlayer.getLoopStartUGen().setValue(val);
	}
	
	public void setFile(File file) {
		this.file = file; 
	}
	
	public void onPlay() {
		
		if(this.file != null) {
			String audioFile = this.file.getPath();
			this.grainPlayer = new GranularSamplePlayer(this.audioContext,
					SampleManager.sample(audioFile));
			/*
			 * Have some fun with the controls.
			 */
			// loop the sample at its end points
			this.grainPlayer.setLoopType(SamplePlayer.LoopType.LOOP_ALTERNATING);
			this.grainPlayer.getLoopStartUGen().setValue(0);
			this.grainPlayer.getLoopEndUGen().setValue(
					(float)SampleManager.sample(audioFile).getLength());
			// control the rate of grain firing
			Envelope grainIntervalEnvelope = new Envelope(this.audioContext, 100);
			grainIntervalEnvelope.addSegment(20, 10000);
			this.grainPlayer.setGrainInterval(grainIntervalEnvelope);
			// control the playback rate
			Envelope rateEnvelope = new Envelope(this.audioContext, 1);
			rateEnvelope.addSegment(1, 5000);
			rateEnvelope.addSegment(0, 5000);
			rateEnvelope.addSegment(0, 2000);
			rateEnvelope.addSegment(-0.1f, 2000);
			this.grainPlayer.setRate(rateEnvelope);
			// a bit of noise can be nice
			this.grainPlayer.getRandomnessUGen().setValue(0.01f);
			/*
			 * And as before...
			 */
			Gain g = new Gain(this.audioContext, 2, 0.2f);
			g.addInput(this.grainPlayer);
			this.audioContext.out.addInput(g);
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
