package models;

import java.awt.Rectangle;

public class Mecha {
	
	public static final int SIZE_X = 30;
	public static final int SIZE_Y = 10;
	public static final int SCORE_MECHA = 200;
	
	private int x;

	public Mecha(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
    public boolean checkMechaCollision(Tejo tejo){
        Rectangle mechaRec = new Rectangle(x, TejoBox.Y, SIZE_X, SIZE_Y);
        return mechaRec.intersects(new Rectangle(tejo.getX(), tejo.getY(), Tejo.SIZE, Tejo.SIZE));
    }
}
