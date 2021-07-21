package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MainButton extends JButton{
	
	
	
	public MainButton(String text, String command, ActionListener actionListener, Color color) {
		setPreferredSize(new Dimension(100,60));
		setText(text);
		addActionListener(actionListener);
		setActionCommand(command);
		setForeground(Color.WHITE);
		setFont(new Font("arial", Font.BOLD,30));
		setUI(new MainButtonStyle(color));
		setPreferredSize(new Dimension(300,100));
	}
	
}
