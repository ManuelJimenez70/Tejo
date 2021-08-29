package models;

import java.awt.Toolkit;

import views.Scenario;

public class Gamer {
	
	private int x;
    public static final int SIZE_X = 300;
    public static final int SIZE_Y = 340;
    public static final int Y = Toolkit.getDefaultToolkit().getScreenSize().height-Scenario.GRASS_STROKE-SIZE_X;
    public static final int INITIAL_X = 350;
    public static final int MOVE_SIZE = 5;
    private int hat;
    private int ruana;
    
    
    public Gamer() {
    	x = INITIAL_X;
	}

	public int getX() {
		return x;
	}

	public int getHat() {
		return hat;
	}

	public void setHat(int hat) {
		this.hat = hat;
	}

	public int getRuana() {
		return ruana;
	}

	public void setRuana(int ruana) {
		this.ruana = ruana;
	}
	
	

}
