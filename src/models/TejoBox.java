package models;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;

import views.Scenario;

public class TejoBox {

	public static final int SIZE_X = 250;
	public static final int SIZE_Y = 100;
	public static final int SCORE_TEJOBOX = 100;
	public static final int INSENT_TEJOBOX = 150;
	public static final int X = Toolkit.getDefaultToolkit().getScreenSize().width - SIZE_X - INSENT_TEJOBOX;
	public static final int Y = Toolkit.getDefaultToolkit().getScreenSize().height - Scenario.GRASS_STROKE;

	private Mecha mecha;
	private Random random;

	public TejoBox() {
		this.random = new Random();
		this.mecha = new Mecha(generateRandomPos());
	}
	
	public int getMechaX() {
		return mecha.getX();
	}
	
	public void generateNewMecha() {
		this.mecha = new Mecha(generateRandomPos());
	}
	
	private int generateRandomPos() {
		int pos = X + random.nextInt(SIZE_X);
		if (pos + Mecha.SIZE_X > X + SIZE_X) {
			pos -= Mecha.SIZE_X;
		}
		return pos;
	}
	
    public boolean checkTejoBoxCollision(Tejo tejo){
        Rectangle boxRec = new Rectangle(X, Y, SIZE_X, SIZE_Y);
        return boxRec.intersects(new Rectangle(tejo.getX(), tejo.getY(), Tejo.SIZE_X, Tejo.SIZE_Y));
    }
    
    public boolean checkMechaCollision(Tejo tejo) {
    	return mecha.checkMechaCollision(tejo);
    }
}
