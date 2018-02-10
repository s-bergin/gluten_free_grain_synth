package gluten_free_grain_synth;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

public class GUI_MainWindow implements I_View{

	private JFrame frame;
	private JButton btnChooseFile;   
	private JButton btnPlayFile; 
	 
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
		
		this.btnChooseFile = new JButton("Choose file");
		frame.getContentPane().add(this.btnChooseFile, BorderLayout.WEST);
		
		this.btnPlayFile = new JButton("Play");
		frame.getContentPane().add(this.btnPlayFile, BorderLayout.NORTH);

	}
	
	public void addChooseFileListener(ActionListener listener) {
		this.btnChooseFile.addActionListener(listener);
	}
	
	public void addPlayFileListener(ActionListener listener) {
		this.btnPlayFile.addActionListener(listener);
	}

	@Override
	public void setVisible(Boolean visible) {
		this.frame.setVisible(visible);
	}
	
}
