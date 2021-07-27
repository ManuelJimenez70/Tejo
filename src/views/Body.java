package views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import controller.Events;
import models.ITejo;

public class Body extends JPanel{
	
	private MainMenu mainMenu;
	private PauseMenu pauseMenu;
	private GameOverMenu gameOverMenu;
	private PanelGame panelGame;
	private Store store;
	private CardLayout cardLayout;
	private int maxScore;

	public Body(ActionListener actionListener, KeyListener keyListener) {
		cardLayout = new CardLayout();
		this.setLayout(cardLayout);
		setBackground(Color.WHITE);
		initComponents(actionListener, keyListener);
	}

	private void initComponents(ActionListener actionListener, KeyListener keyListener) {
		this.mainMenu = new MainMenu(actionListener);
		add(mainMenu, Events.EVENT_MAIN_MENU);
		
		this.panelGame = new PanelGame(actionListener, keyListener);
		add(panelGame, Events.EVENT_SCENARIO);
		this.panelGame.init();
		
		this.pauseMenu = new PauseMenu(actionListener, panelGame.getBackgroundGraph(), keyListener);
		add(pauseMenu, Events.EVENT_PAUSE_MENU);
		
		this.store = new Store(actionListener);
		add(store, Events.EVENT_STORE_GAME);
		
		this.gameOverMenu = new GameOverMenu(actionListener, panelGame.getBackgroundGraph());
		add(gameOverMenu, Events.EVENT_GAME_OVER);
	}
	
	public CardLayout getCardLayout() {
		return cardLayout;
	}
	
	public void updateGame(ITejo gameData) {
		updateScore(gameData);
		panelGame.updateGame(gameData);
	}
	
	private void updateScore(ITejo gameData) {
		this.maxScore = gameData.getMaxScore();
		repaint();
	}
	
	
	public void focusPanel() {
		panelGame.focusPanel();
	}
	
	public void focusPausePanel() {
		pauseMenu.focusPausePanel();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.setFont(g.getFont().deriveFont(30f));
		g.drawString("Mejor Puntuación: " + String.valueOf(this.maxScore), getWidth() - 350, Scenario.GRASS_STROKE + 60);
	}
	
}
