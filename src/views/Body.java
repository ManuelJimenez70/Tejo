package views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

import controller.Events;
import models.ITejo;

public class Body extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainMenu mainMenu;
	private PauseMenu pauseMenu;
	private GameOverMenu gameOverMenu;
	private PanelGame panelGame;
	private Store store;
	private CardLayout cardLayout;

	public Body(ActionListener actionListener, KeyListener keyListener, ITejo gameData) {
		cardLayout = new CardLayout();
		this.setLayout(cardLayout);
		setBackground(Color.WHITE);
		initComponents(actionListener, keyListener, gameData);
	}

	private void initComponents(ActionListener actionListener, KeyListener keyListener, ITejo gameData) {
		this.mainMenu = new MainMenu(actionListener);
		add(mainMenu, Events.EVENT_MAIN_MENU);

		this.panelGame = new PanelGame(actionListener, keyListener);
		add(panelGame, Events.EVENT_SCENARIO);
		this.panelGame.init(gameData);

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
		mainMenu.updateGame(gameData);
		panelGame.updateGame(gameData);
		store.updateGame(gameData);
	}

	public void focusPanel() {
		panelGame.focusPanel();
	}

	public void focusPausePanel() {
		pauseMenu.focusPausePanel();
	}

	public void buyHat(int i, ITejo gamedata) {
		store.buyHat(2, gamedata);
	}

}
