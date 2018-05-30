package gluten_free_grain_synth;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class GUI_MainWindow implements I_View{

	private JFrame frame;
	private JButton btnChooseFile;   
	private JButton btnPlayFile; 
	private JButton btnStopFile;
	
	private JLabel lblPitch; 
	private JSlider sldPitch; 
	private JSlider sldGrainInterval;
	private JLabel lblGrainInterval;
	private JSlider sldGrainSize;
	private JLabel lblGrainSize;
	private JSpinner spnLoopType;
	private JLabel lblLoopType;
	 
	/**
	 * Create the application.
	 */
	public GUI_MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frame = new JFrame();
		
		this.frame.setBounds(100, 100, 450, 300);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		this.btnChooseFile = new JButton("Choose file");
		btnChooseFile.setBounds(0, 209, 85, 53);
		this.frame.getContentPane().add(this.btnChooseFile);
		
		this.btnPlayFile = new JButton("Play");
		btnPlayFile.setBounds(0, 11, 85, 65);
		this.frame.getContentPane().add(this.btnPlayFile);
		
		this.btnStopFile = new JButton("Stop");
		btnStopFile.setBounds(0, 87, 85, 65);
		this.frame.getContentPane().add(this.btnStopFile);
		
		this.sldPitch = new JSlider();
		sldPitch.setMaximum(5);
		this.sldPitch.setBounds(137, 22, 200, 23);
		this.frame.getContentPane().add(this.sldPitch);
		
		this.lblPitch = new JLabel("Pitch");
		lblPitch.setEnabled(false);
		this.lblPitch.setBounds(213, 11, 46, 14);
		this.frame.getContentPane().add(this.lblPitch);
		
		this.sldGrainInterval = new JSlider();
		this.sldGrainInterval.setBounds(137, 71, 200, 23);
		this.frame.getContentPane().add(this.sldGrainInterval);
		
		this.lblGrainInterval = new JLabel("Grain Interval");
		this.lblGrainInterval.setBounds(213, 46, 46, 14);
		this.frame.getContentPane().add(this.lblGrainInterval);
		
		this.sldGrainSize = new JSlider();
		this.sldGrainSize.setBounds(137, 123, 200, 23);
		this.frame.getContentPane().add(this.sldGrainSize);
		
		this.lblGrainSize = new JLabel("Grain Size");
		this.lblGrainSize.setBounds(213, 105, 46, 14);
		this.frame.getContentPane().add(this.lblGrainSize);
		
		this.spnLoopType = new JSpinner();
		this.spnLoopType.setBounds(213, 182, 29, 20);
		this.frame.getContentPane().add(this.spnLoopType);
		
		this.lblLoopType = new JLabel("Loop Type");
		this.lblLoopType.setBounds(213, 157, 46, 14);
		this.frame.getContentPane().add(this.lblLoopType);

	}
	
	public void addChooseFileListener(ActionListener listener) {
		this.btnChooseFile.addActionListener(listener);
	}
	
	public void addPlayFileListener(ActionListener listener) {
		this.btnPlayFile.addActionListener(listener);
	}
	
	public void addStopFileListener(ActionListener listener) {
		this.btnStopFile.addActionListener(listener);
	}
	
	public void addPitchListener(ChangeListener listener) {
		this.sldPitch.addChangeListener(listener);
	}
	
	public void addGrainIntervalListener(ChangeListener listener) {
		this.sldGrainInterval.addChangeListener(listener);
	}
	
	public void addGrainSizeListener(ChangeListener listener) {
		this.sldGrainSize.addChangeListener(listener);
	}
	
	public void addLoopTypeListener(ChangeListener listener){
		this.spnLoopType.addChangeListener(listener);
	}
	
	public float getGrainInterval() {
		return (float)this.sldGrainInterval.getValue();
	}
	
	public int getPitch() {
		return this.sldPitch.getValue(); 
	}
	
	public int getGrainSize(){
		return this.sldGrainSize.getValue();
	}
	
	public int getLoopType(){
		return (int) this.spnLoopType.getValue();
	}
	
	@Override
	public void setVisible(Boolean visible) {
		this.frame.setVisible(visible);
	}
}
