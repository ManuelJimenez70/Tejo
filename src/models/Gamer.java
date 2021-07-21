package models;

import java.awt.Toolkit;

import views.Scenario;

public class Gamer {
	
    private static final int SHOES_SIZE = 15;
	private int x;
    public static final int SIZE = 300;
    public static final int Y = Toolkit.getDefaultToolkit().getScreenSize().height-Scenario.GRASS_STROKE-SIZE + SHOES_SIZE;
    public static final int INITIAL_X = 350;
    public static final int MOVE_SIZE = 5;
    
    public Gamer() {
    	x = INITIAL_X;
	}

	public int getX() {
		return x;
	}

}
