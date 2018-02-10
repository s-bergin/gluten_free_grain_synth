package gluten_free_grain_synth;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class GUI_MainWindow {

	private JFrame frame;
	
	private JButton btnPlay; 
	

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
		
		this.btnPlay = new JButton("Play");
		this.frame.getContentPane().add(btnPlay, BorderLayout.WEST);
		
		this.frame.setVisible(true);
	}
	
	public void AddPlayLister(ActionListener listener){
		this.btnPlay.addActionListener(listener);
	}
}
