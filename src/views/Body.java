package views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controller.Events;
import models.ITejo;

public class Body extends JPanel{
	
	private MainMenu mainMenu;
	private Scenario scenario;
	private Store store;
	private CardLayout cardLayout;
	

	public Body(ActionListener actionListener) {
		cardLayout = new CardLayout();
		this.setLayout(cardLayout);
		setBackground(Color.WHITE);
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.mainMenu = new MainMenu(actionListener);
		add(mainMenu, Events.EVENT_MAIN_MENU);
		
		this.scenario = new Scenario();
		add(scenario, Events.EVENT_SCENARIO);
		
		this.store = new Store();
		add(store, Events.EVENT_STORE_GAME);

	}
	
	public CardLayout getCardLayout() {
		return cardLayout;
	}
	
    public void refreshGame(ITejo gameData) {
    	scenario.updateGame(gameData);
    }
	

}
