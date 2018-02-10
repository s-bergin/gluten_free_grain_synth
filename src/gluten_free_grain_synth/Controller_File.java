package gluten_free_grain_synth;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

public class Controller_File {
	
	private java.io.File userFile; 
	
	public Controller_File() {
		
	}
	
	public void setUserFile(java.io.File file) {
		this.userFile = file; 
	}
	
	public java.io.File getUserFile(File file) {
		return this.userFile; 
	}
	
	public void onClickOpenFile(ActionEvent e) {
		JFileChooser input = new JFileChooser();
		int result = input.showOpenDialog((Component) e.getSource());
		
		// if the user chooses a file we want to set that as the userFile 
		if(result == JFileChooser.APPROVE_OPTION) {
			setUserFile(input.getSelectedFile());
		}
	}
}
