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
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import models.Gamer;
import models.ITejo;
import models.Mecha;
import models.Tejo;
import models.TejoBox;

public class Scenario extends JPanel {

	private static final String GAMER_IMAGE = "/resources/images/gamerImage";
	private static final String BACKGROUND_IMAGE = "/resources/images/backgroundImage";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final URL TEJO_IMAGE = View.class.getResource("/resources/images/tejoImage1.png");
	public static final int GRASS_STROKE = 200;

	public BufferedImage background;
	private  Image imgBack;
	private  Image imgTejo;
	private  Image imgGamer;
	private int scenarioNumber;
	private int gamerHat;

	public Scenario(ActionListener actionListener, KeyListener keyListener) {
		Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(new Dimension(s.width, s.height - PanelGame.SIZE_HEADER));
		setPreferredSize(new Dimension(s.width, s.height));
		setLayout(new BorderLayout());
		setFocusCycleRoot(true);
		setFocusable(true);
		setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		scenarioNumber = 1;
		gamerHat = 1;
		imgBack = new ImageIcon(Toolkit.getDefaultToolkit().getImage(View.class.getResource(BACKGROUND_IMAGE + "1.png"))).getImage();
		imgTejo = new ImageIcon(Toolkit.getDefaultToolkit().getImage(TEJO_IMAGE)).getImage();
		imgGamer = new ImageIcon(Toolkit.getDefaultToolkit().getImage(View.class.getResource(GAMER_IMAGE + ".png"))).getImage();
		addKeyListener(keyListener);
	}

	public void init(ITejo gameData) {
		paintBackground(gameData);
	}
	
	public void focusPanel() {
		setFocusable(true);
		requestFocus();
	}

	public void updateGame(ITejo gameData) {
		paintBackground(gameData);
		paintHero(gameData);
		paintTejo(gameData);
		paintTejoBox(gameData);
		paintMecha(gameData);
		paintScore(gameData);
		paintMaxScore(gameData);
		paintArrow(gameData);
		paintPower(gameData);
		paintTries(gameData);
		paintScoreToPass(gameData);
		repaint();
	}

	private void paintScoreToPass(ITejo gameData) {
		Graphics g = background.getGraphics();
		g.setColor(Color.WHITE);
		g.setFont(g.getFont().deriveFont(30f));
		g.drawString("Puntuación Para el Siguiente nivel: " + String.valueOf(gameData.getScoreToPass()), getWidth()/3, getHeight()- Scenario.GRASS_STROKE/2);		
	}

	private void paintScore(ITejo gameData) {
		Graphics g = background.getGraphics();
		g.setColor(Color.RED);
		g.setFont(g.getFont().deriveFont(30f));
		g.drawString("Puntuación: " + String.valueOf(gameData.getScore()), getWidth() - 350, Scenario.GRASS_STROKE);
	}
	
	private void paintMaxScore(ITejo gameData) {
		Graphics g = background.getGraphics();
		g.setColor(Color.RED);
		g.setFont(g.getFont().deriveFont(30f));
		g.drawString("Mejor Puntuación: " + String.valueOf(gameData.getMaxScore()), getWidth() - 350, Scenario.GRASS_STROKE + 60);
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

	private void paintBackground(ITejo gameData) {
		if (this.scenarioNumber != gameData.getScenarioNumber()) {
			this.scenarioNumber = gameData.getScenarioNumber();
			imgBack = new ImageIcon(Toolkit.getDefaultToolkit().getImage(View.class.getResource(BACKGROUND_IMAGE + "" + this.scenarioNumber + ".png"))).getImage();


		}
		if (background == null) {
			background = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		}
		Graphics g = background.getGraphics();
		g.drawImage(imgBack, 0, 0, getWidth(), getHeight() - GRASS_STROKE, this);
		g.setColor(Color.GRAY);
		g.fillRect(0, getHeight() - GRASS_STROKE, getWidth(), getHeight());
	}

	public void paintHero(ITejo gameData) {
		Graphics g = background.getGraphics();
		if (this.gamerHat != gameData.getGamerHat()) {
			this.gamerHat = gameData.getGamerHat();
			imgGamer = new ImageIcon(Toolkit.getDefaultToolkit().getImage(View.class.getResource(GAMER_IMAGE + "1.png"))).getImage();
		}
		g.drawImage(imgGamer, gameData.getGamerPosition(), Gamer.Y, Gamer.SIZE_X, Gamer.SIZE_Y, this);
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
		g.drawImage(imgTejo, gameData.getXTejoPosition(), gameData.getYTejoPosition(), Tejo.SIZE_X, Tejo.SIZE_Y, this);
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
