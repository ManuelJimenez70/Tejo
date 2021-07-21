package models;

import java.awt.Toolkit;

import views.Scenario;

public class Tejo extends Thread {

	public static final int SIZE = 30;
	public static final int INITIAL_Y = 750;
	public static final int INITIAL_X = Gamer.INITIAL_X + Gamer.SIZE - SIZE;
	public static final int MOVE_SIZE = 5;
	public static final double GRAVITY = 9.81;
	public static final int FLOOR = Toolkit.getDefaultToolkit().getScreenSize().height - Scenario.GRASS_STROKE;
	private int x, y, angle;
	private boolean isShooting, isShooted;
	private double time, velocity, xVelocity, yVelocity;

	public Tejo() {
		this.x = INITIAL_X;
		this.y = INITIAL_Y;
		this.angle = 0;
		this.velocity = 0;
		this.xVelocity = velocity * Math.cos(Math.toRadians(angle));
		this.yVelocity = velocity * Math.sin(Math.toRadians(angle));
		start();
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public void setAngle(int angle) {
		this.angle = angle;
		this.xVelocity = velocity * Math.cos(Math.toRadians(angle));
		this.yVelocity = velocity * Math.sin(Math.toRadians(angle));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public void run() {
		super.run();
		while (y <= FLOOR - SIZE + 15) {
			if (isShooting) {
				time += 0.1;
				x = (int) (INITIAL_X + xVelocity * time);
				y = (int) (INITIAL_Y - (yVelocity * time - (GRAVITY / 2) * time * time));
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isShooted = true;
	}

	public void setIsShooting(boolean isShooting) {
		this.isShooting = isShooting;
	}

	public boolean IsShooting() {
		return isShooting;
	}
	public boolean isShooted() {
		return isShooted;
	}

}
