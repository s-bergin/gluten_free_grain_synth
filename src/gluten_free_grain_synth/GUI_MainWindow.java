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

public class GUI_MainWindow implements I_View{

	private JFrame frame;
	private JButton btnChooseFile;   
	private JButton btnPlayFile; 
	private JButton btnStopFile;
	
	private JLabel lblStartPos; 
	private JSlider sldStartPos; 
	 
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
		
		this.sldStartPos = new JSlider();
		this.sldStartPos.setBounds(137, 47, 200, 23);
		this.frame.getContentPane().add(this.sldStartPos);
		
		this.lblStartPos = new JLabel("Start Pos");
		this.lblStartPos.setBounds(213, 22, 46, 14);
		this.frame.getContentPane().add(this.lblStartPos);

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
	
	public void addStartPosListener(ChangeListener listener) {
		this.sldStartPos.addChangeListener(listener);
	}
	
	public int getStartPosValue() {
		return this.sldStartPos.getValue(); 
	}
	
	@Override
	public void setVisible(Boolean visible) {
		this.frame.setVisible(visible);
	}
}
