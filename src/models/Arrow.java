package models;

public class Arrow {
	
    private static final int INITIAL_POWER = 5;
	public static final int START_Y = 750;
    public static final int START_X = Tejo.INITIAL_X + Tejo.SIZE;
    public static final int MAX_ANGLE = 50;
    public static final int MOVE_ARROW_SIZE = 3;
    public static final int LONG = 100;
    public static final int MAX_POWER = 100;
    public static final int MIN_POWER = 10;
    public static final int POWER_SPEED = 10;

    private int angle, x, power;
    private boolean isUpPower;
    
    public Arrow(int x, int angle) {
		this.angle = angle;
		this.x = x;
		this.power = INITIAL_POWER;
	}


	
	private int generateB() {
		int b = 0;//y = mx + b, b = y - mx, m = tan(angle)
		b = (int) Math.round(-START_Y - (Math.tan(Math.toRadians(angle)))*x);
		return b;
	}


	public int[] getPoints() {
		int[] points = new int[4];
		points[0] = x;
		points[1] = START_Y;
		points[2] = x+LONG;
		points[3] = (int) Math.abs(Math.round(((Math.tan(Math.toRadians(angle)))*(x+LONG)) + generateB())) ;
		return points;
	}


	public void moveDown() {
		if (angle>0) {
			angle -= MOVE_ARROW_SIZE;
		}else {
			angle = MAX_ANGLE;
		}
	}


	public void moveUp() {
		if (angle < MAX_ANGLE) {
			angle += MOVE_ARROW_SIZE;
		}else {
			angle = 0;
		}
	}



	public int getAngle() {
		return angle;
	}
	
	public int getPower() {
		return power;
	}

	public void updatePower() {
		if (power<MAX_POWER) {
			power += POWER_SPEED;
		}else {
			isUpPower = true;
		}
	}
	
	public boolean isUpPower() {
		return isUpPower;
	}



	public int[] getPowerLine() {
		int[] points = new int[4];
		points[0] = x;
		points[1] = START_Y;
		points[2] = x+power;
		points[3] = (int) Math.abs(Math.round(((Math.tan(Math.toRadians(angle)))*(x+power)) + generateB())) ;
		return points;
	}
}
