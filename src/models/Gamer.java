package models;

public class Gamer {
	
    private int x;
    public static final int Y = 620;
    public static final int INITIAL_X = 300;
    public static final int SIZE = 250;
    public static final int MOVE_SIZE = 5;
    
    public Gamer() {
    	x = INITIAL_X;
	}

	public int getX() {
		return x;
	}

}
