package models;

import java.awt.Rectangle;
import java.awt.Toolkit;

import views.Scenario;

public class Ground {

	public static final int G_Y = Toolkit.getDefaultToolkit().getScreenSize().height - Scenario.GRASS_STROKE;
	public static final int GL_X = 0;
	public static final int GL_SIZE_X = Toolkit.getDefaultToolkit().getScreenSize().width - TejoBox.SIZE_X
			- TejoBox.INSENT_TEJOBOX - Tejo.SIZE_X;
	public static final int SIZE_Y = Scenario.GRASS_STROKE;
	public static final int GR_X = Toolkit.getDefaultToolkit().getScreenSize().width - TejoBox.INSENT_TEJOBOX
			+ Tejo.SIZE_X;
	public static final int GR_SIZE_X = Toolkit.getDefaultToolkit().getScreenSize().width - TejoBox.INSENT_TEJOBOX
			+ Tejo.SIZE_X;

	public static boolean checkTejoCollision(Tejo tejo) {
		Rectangle r1 = new Rectangle(GL_X, G_Y, GL_SIZE_X, SIZE_Y);
		Rectangle r2 = new Rectangle(GR_X, G_Y, GR_SIZE_X, SIZE_Y);

		return checkCollisionLeftGround(r1, tejo) || checkCollisionRightGround(r2, tejo);
	}

	private static boolean checkCollisionLeftGround(Rectangle r1, Tejo tejo) {
		return r1.intersects(new Rectangle(tejo.getX(), tejo.getY(), Tejo.SIZE_X, Tejo.SIZE_Y));
	}

	private static boolean checkCollisionRightGround(Rectangle r2, Tejo tejo) {
		return r2.intersects(new Rectangle(tejo.getX(), tejo.getY(), Tejo.SIZE_X, Tejo.SIZE_Y));
	}

}
