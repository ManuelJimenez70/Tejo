package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.Events;
import models.Gamer;
import models.ITejo;
import models.Mecha;
import models.Tejo;
import models.TejoBox;

public class Scenario extends JPanel {

	private static final URL BACKGROUND_IMAGE = View.class.getResource("/resources/images/backgroundImage.png");
	private static final URL TEJO_IMAGE = View.class.getResource("/resources/images/tejoImage.png");
	private static final URL GAMER_IMAGE = View.class.getResource("/resources/images/gamerImage.png");
	public static final int GRASS_STROKE = 200;

	public BufferedImage background;
	private final Image imgBack;
	private final Image imgTejo;
	private final Image imgGamer;

	public Scenario(ActionListener actionListener, KeyListener keyListener) {
		Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(new Dimension(s.width, s.height - PanelGame.SIZE_HEADER));
		setPreferredSize(new Dimension(s.width, s.height));
		setLayout(new BorderLayout());
		setFocusCycleRoot(true);
		setFocusable(true);
		setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		imgBack = new ImageIcon(Toolkit.getDefaultToolkit().getImage(BACKGROUND_IMAGE)).getImage();
		imgTejo = new ImageIcon(Toolkit.getDefaultToolkit().getImage(TEJO_IMAGE)).getImage();
		imgGamer = new ImageIcon(Toolkit.getDefaultToolkit().getImage(GAMER_IMAGE)).getImage();
		addKeyListener(keyListener);
	}

	public void init() {
		paintBackground();
	}

	public void updateGame(ITejo gameData) {
		paintBackground();
		paintHero(gameData);
		paintTejo(gameData);
		paintTejoBox(gameData);
		paintMecha(gameData);
		paintScore(gameData);
		paintArrow(gameData);
		paintPower(gameData);
		paintTries(gameData);
		repaint();
	}

	private void paintScore(ITejo gameData) {
		Graphics g = background.getGraphics();
		g.setColor(Color.RED);
		g.setFont(g.getFont().deriveFont(30f));
		g.drawString("Puntuación: " + String.valueOf(gameData.getScore()), getWidth() - 350, Scenario.GRASS_STROKE);
	}
	
	private void paintTries(ITejo gameData) {
		Graphics g = background.getGraphics();
		g.setColor(Color.RED);
		g.setFont(g.getFont().deriveFont(30f));
		g.drawString("Intentos: " + String.valueOf(gameData.getTries()), getWidth() - 350, Scenario.GRASS_STROKE + 30);
	}

	public BufferedImage getBackgroundGraph() {
		return background;
	}

	private void paintBackground() {
		if (background == null) {
			background = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		}
		Graphics g = background.getGraphics();
		g.drawImage(imgBack, 0, 0, getWidth(), getHeight() - GRASS_STROKE, this);
		g.setColor(Color.decode("#77A06A"));
		g.fillRect(0, getHeight() - GRASS_STROKE, getWidth(), getHeight());
	}

	public void paintHero(ITejo gameData) {
		Graphics g = background.getGraphics();
		g.drawImage(imgGamer, gameData.getGamerPosition(), Gamer.Y, Gamer.SIZE, Gamer.SIZE, this);
	}

	public void paintArrow(ITejo gameData) {
		Graphics g = background.getGraphics();
		int[] points = gameData.getArrowPoints();
		g.setColor(Color.WHITE);
		g.drawLine(points[0], points[1], points[2], points[3]);
	}

	public void paintPower(ITejo gameData) {
		Graphics g = background.getGraphics();
		int[] points = gameData.getPowerLine();
		g.setColor(Color.GREEN);
		g.drawLine(points[0], points[1], points[2], points[3]);
	}

	public void paintTejo(ITejo gameData) {
		Graphics g = background.getGraphics();
		g.drawImage(imgTejo, gameData.getXTejoPosition(), gameData.getYTejoPosition(), Tejo.SIZE, Tejo.SIZE, this);
	}

	public void paintTejoBox(ITejo gameData) {
		Graphics g = background.getGraphics();
		g.setColor(Color.decode("#68401D"));
		g.fillRect(TejoBox.X - 10, TejoBox.Y, TejoBox.SIZE_X + 20, TejoBox.SIZE_Y + 10);
		g.setColor(Color.decode("#E0C444"));
		g.fillRect(TejoBox.X, TejoBox.Y, TejoBox.SIZE_X, TejoBox.SIZE_Y);
	}

	public void paintMecha(ITejo gameData) {
		Graphics g = background.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(gameData.getMechaX(), TejoBox.Y, Mecha.SIZE_X, Mecha.SIZE_Y);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background, 0, 0, this);
	}

}
