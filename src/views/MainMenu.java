package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.Events;
import models.ITejo;

public class MainMenu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String START_GAME_TEXT = "Comenzar Juego";
	private static final String EXIT_GAME_TEXT = "Salir";
	private static final String STORE_GAME_TEXT = "Tienda";
	private static final URL MENU_HEADER = View.class.getResource("/resources/images/tejoHeader.png");
	private static final URL MONEY_IMAGE = View.class.getResource("/resources/images/money.png");

	private MainButton btnStart, btnStore, btnExit;
	private JLabel menuMessage;
	private int maxScore;
	private int money;

	public MainMenu(ActionListener actionListener) {
		setLayout(new GridBagLayout());
		setBackground(Color.decode("#FFEFB9"));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		this.menuMessage = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MENU_HEADER)));
		this.btnStart = new MainButton(START_GAME_TEXT, Events.EVENT_START_GAME, actionListener,
				Color.decode("#FCD116"));
		this.btnStore = new MainButton(STORE_GAME_TEXT, Events.EVENT_STORE_GAME, actionListener,
				Color.decode("#003893"));
		this.btnExit = new MainButton(EXIT_GAME_TEXT, Events.EVENT_EXIT_GAME, actionListener, Color.decode("#CE1126"));
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets.set(25, 5, 5, 25);
		this.add(menuMessage, c);
		c.gridy = 1;
		this.add(btnStart, c);
		c.gridy = 2;
		this.add(btnStore, c);
		c.gridy = 3;
		this.add(btnExit, c);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.setFont(g.getFont().deriveFont(30f));
		g.drawString("Mejor Puntuación: " + String.valueOf(this.maxScore), getWidth() - 350,
				Scenario.GRASS_STROKE + 60);
		g.setColor(Color.decode("#0A9301"));
		g.drawString("" + String.valueOf(this.money), getWidth() - 250,
				Scenario.GRASS_STROKE/2 + 80);
		g.drawImage(Toolkit.getDefaultToolkit().getImage(MONEY_IMAGE), getWidth() - 200 + String.valueOf(this.money).length()*8, Scenario.GRASS_STROKE/2 + 30, 100, 100, this);
	}

	public void updateGame(ITejo gameData) {
		this.maxScore = gameData.getMaxScore();
		this.money = gameData.getMoney();
		repaint();
	}
}
