package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.ITejo;

public class Scenario extends JPanel {

	private static final URL BACKGROUND_IMAGE = View.class.getResource("/resources/images/backgroundImage.png");
	private static final int GRASS_STROKE = 200;

	public BufferedImage background;
	private final Image imgBack;

	public Scenario() {
		setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		imgBack = new ImageIcon(Toolkit.getDefaultToolkit().getImage(BACKGROUND_IMAGE)).getImage();
		init();
	}

	public void init() {
		paintBackground();
		requestFocus();
		requestFocusInWindow();
	}

	public void updateGame(ITejo gameData) {
		paintBackground();

	}

	private void paintBackground() {
		if (background == null) {
			background = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		}
		Graphics g = background.getGraphics();
		g.drawImage(imgBack, 0, 0, getWidth(), getHeight() - GRASS_STROKE, this);
		g.setColor(Color.decode("#77A06A"));
		g.fillRect(0, getHeight()-GRASS_STROKE, getWidth(), getHeight());
	}
	
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, this);
    }

}
