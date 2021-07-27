package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import controller.Events;
import models.ITejo;

public class PanelGame extends JPanel{
	
	public static final int SIZE_HEADER = 50;
	private MainButton pausebtn;
	private Scenario scenario;
	
	public PanelGame(ActionListener actionListener, KeyListener keyListener) {
		setLayout(new BorderLayout());
		pausebtn = new MainButton("l l", Events.EVENT_PAUSE_MENU, actionListener, Color.decode("#CE1126"));
		scenario = new Scenario(actionListener, keyListener);
		scenario.add(pausebtn,BorderLayout.NORTH);
		add(scenario,BorderLayout.CENTER);
		
	}
	
	public void updateGame(ITejo gameData) {
		scenario.updateGame(gameData);
	}

	public void init() {
		scenario.init();
	}

	public BufferedImage getBackgroundGraph() {
		return scenario.background;
	}

	public void focusPanel() {
		scenario.focusPanel();
	}
	
}
