package models;

import java.util.Random;

public class Game extends Thread implements ITejo {

	private Tejo tejo;
	private Gamer gamer;
	private Arrow arrow;
	private TejoBox box; 
	private boolean play;
	private int shoots;
	private int score;
	private Random random;

	public Game() {
		this.random = new Random();
		score = 0;
		tejo = new Tejo();
		gamer = new Gamer();
		box = new TejoBox();
		arrow = new Arrow(Gamer.INITIAL_X + Gamer.SIZE, random.nextInt(Arrow.MAX_ANGLE));
		play = true;
		shoots = 1;
		start();
	}

	@Override
	public void run() {
		while (play) {
			checkCollisions();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void checkCollisions() {
		generateNewTejo();
		if (box.checkMechaCollision(tejo)) {
			score += Mecha.SCORE_MECHA;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Mecha: " + score);

		}
		if (box.checkTejoBoxCollision(tejo)) {
			score += TejoBox.SCORE_TEJOBOX;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Arena: " + score);
		}

	}

	private void generateNewTejo() {
		if (tejo.isShooted()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tejo = new Tejo(); 
			box.generateNewMecha();
			shoots++;
		}
	}

	@Override
	public int getGamerPosition() {
		return gamer.getX();
	}

	@Override
	public int getActualScore() {
		return score;
	}

	@Override
	public int getXTejoPosition() {
		return tejo.getX();
	}

	public int getShootsNumber() {
		return this.shoots;
	}

	@Override
	public int[] getArrowPoints() {
		return arrow.getPoints();
	}

	public void moveArrowUp() {
		this.arrow.moveUp();
	}

	public void moveArrowDown() {
		this.arrow.moveDown();
	}

	public void tejoShoot(int angle, int velocity) {
		tejo.setVelocity(velocity);
		tejo.setAngle(angle);
		tejo.setIsShooting(true);
	}

	public int getAngle() {
		return arrow.getAngle();
	}

	public int getVelocity() {
		return arrow.getPower();
	}

	@Override
	public int getYTejoPosition() {
		return tejo.getY();
	}

	public boolean isShooting() {
		return tejo.IsShooting();
	}
	
	public boolean isUpPower() {
		return arrow.isUpPower();
	}

	public void updatePower() {
		arrow.updatePower();
	}

	public void setArrow() {
		this.arrow = new Arrow(Gamer.INITIAL_X + Gamer.SIZE, random.nextInt(Arrow.MAX_ANGLE));
	}

	@Override
	public int[] getPowerLine() {
		return arrow.getPowerLine();
	}

	@Override
	public int getMechaX() {
		return box.getMechaX();
	}

	@Override
	public int getScore() {
		return score;
	}


}
