package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controller.Events;

public class Store extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int SIZE_HEADER = 50;
	private JPanel header;
	private MainButton backbtn;
	
	public Store(ActionListener actionListener) {
		setBackground(Color.decode("#EAE0BC"));
		setLayout(new BorderLayout());
		header = new JPanel();
		header.setBackground(Color.decode("#EAE0BC"));
		Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		header.setSize(new Dimension(d.width,SIZE_HEADER));
		header.setPreferredSize(new Dimension(d.width,SIZE_HEADER));
		header.setLayout(new BorderLayout());
		
		backbtn = new MainButton("<-", Events.EVENT_MAIN_MENU, actionListener, Color.decode("#CE1126"));
		header.add(backbtn,BorderLayout.EAST);
		add(header,BorderLayout.NORTH);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

}
