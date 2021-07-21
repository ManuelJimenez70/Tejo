package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Events;

public class GameOverMenu extends JPanel{
	
	private static final URL MENU_HEADER = View.class.getResource("/resources/images/tejoHeader.png");
	private static final URL GAME_OVER_HEADER = View.class.getResource("/resources/images/gameOverHeader.png");
	private static final String RESTART_GAME_TEXT = "Reintentar";
	private static final String MAIN_MENU_TEXT = "Menu Principal";
	public static final Color BACKGROUND_COLOR = new Color(255, 239, 185, 100);
	
	private MainButton btnRestart, btnMainMenu;
	private JLabel menuMessage, gameOverMessage;
	private BufferedImage image;

	public GameOverMenu(ActionListener actionListener, BufferedImage image) {
		this.image = image;
		setLayout(new GridBagLayout());
		initComponents(actionListener);
	}
	
	private void initComponents(ActionListener actionListener) {
		this.menuMessage = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MENU_HEADER)));
		this.gameOverMessage = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(GAME_OVER_HEADER)));
		this.btnRestart = new MainButton(RESTART_GAME_TEXT, Events.EVENT_START_GAME, actionListener,
				Color.decode("#003893"));
		this.btnMainMenu = new MainButton(MAIN_MENU_TEXT, Events.EVENT_MAIN_MENU, actionListener,
				Color.decode("#CE1126"));
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets.set(25, 5, 5, 25);
		this.add(menuMessage,c);
		c.gridy = 1;
		this.add(gameOverMessage,c);
		c.gridy = 2;
		this.add(btnRestart, c);
		c.gridy = 3;
		this.add(btnMainMenu, c);

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
