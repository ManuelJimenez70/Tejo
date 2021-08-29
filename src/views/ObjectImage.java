package views;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ObjectImage extends JPanel {

	private Image image;

	public ObjectImage(Image image) {
		this.image = image;
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image, 90, 20, 100, 100, this);
	}

}
