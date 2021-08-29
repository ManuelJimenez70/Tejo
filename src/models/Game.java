package models;

import java.applet.AudioClip;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import views.MyAudio;

public class Game extends Thread implements ITejo {

	public static final int MAX_SHOOTS = 5;

	public static final int MAX_SCENARIOS = 6;

	private Tejo tejo;
	private Gamer gamer;
	private Arrow arrow;
	private TejoBox box;
	private boolean play;
	private int shoots;
	private int score;
	private Random random;
	private int money;
	private int maxScore;
	private MyAudio sandScore;
	private MyAudio mechaScore;
	private MyAudio groundScore;
	private int scenarioNumber;
	private int scoreToPassScenario;
	private int gamerHat;


	public Game() {
		this.sandScore = new MyAudio(getClass().getResource("/resources/audios/sandScore.wav"));
		this.mechaScore = new MyAudio(getClass().getResource("/resources/audios/mechaScore.wav"));
		this.groundScore = new MyAudio(getClass().getResource("/resources/audios/groundScore.wav"));
		this.random = new Random();
		scenarioNumber = 1;
		gamerHat = 1;
		scoreToPassScenario = 300;
		score = 0;
		tejo = new Tejo();
		gamer = new Gamer();
		box = new TejoBox();
		arrow = new Arrow(Gamer.INITIAL_X + Gamer.SIZE_X, random.nextInt(Arrow.MAX_ANGLE));
		play = true;
		shoots = 0;
		maxScore = 0;
		money = 0;
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

	public void playSound(AudioClip sound) {
		new Thread() {
			@Override
			public void run() {
				sound.play();
			}
		}.start();
	}

	private void checkCollisions() {
		generateNewTejo();
		if (box.checkMechaCollision(tejo)) {
			score += Mecha.SCORE_MECHA;
			playSound(this.mechaScore.getAudio());
			checkScore();
			try {
				Thread.sleep(TimeUnit.SECONDS.toMillis(1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (box.checkTejoBoxCollision(tejo)) {
			playSound(this.sandScore.getAudio());
			score += TejoBox.SCORE_TEJOBOX;
			checkScore();
			try {
				Thread.sleep(TimeUnit.SECONDS.toMillis(1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else if(Ground.checkTejoCollision(tejo)){
			playSound(this.groundScore.getAudio());
			try {
				Thread.sleep(TimeUnit.SECONDS.toMillis(1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private void checkScore() {
		switch (scenarioNumber) {
		case 1:
			if (score>=scoreToPassScenario) {
				shoots = 0;
				scenarioNumber++;
				scoreToPassScenario = 900;
			}
			break;
		case 2:
			if (score>=scoreToPassScenario) {
				shoots = 0;
				scenarioNumber++;
				scoreToPassScenario = 1500;
			}
			break;
		case 3:
			if (score>=scoreToPassScenario) {
				shoots = 0;
				scenarioNumber++;
				scoreToPassScenario = 2200;
			}
			break;
		case 4:
			if (score>=scoreToPassScenario) {
				shoots = 0;
				scenarioNumber++;
				scoreToPassScenario = 3100;
			}
			break;
		case 5:
			if (score>=scoreToPassScenario) {
				shoots = 0;
				scenarioNumber++;
				scoreToPassScenario = 4200;
			}
		case 6:

			break;
		default:
			break;
		}
	}

	private void generateNewTejo() {
		if (tejo.isShooted()) {
			try {
				Thread.sleep(TimeUnit.SECONDS.toMillis(1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tejo = new Tejo();
			box.generateNewMecha();
			shoots++;
		}
	}
	
	public void setMoney(int score) {
		this.money += score*2;
	}
	
	public int getMoney() {
		return money;
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
		this.arrow = new Arrow(Gamer.INITIAL_X + Gamer.SIZE_X, random.nextInt(Arrow.MAX_ANGLE));
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

	@Override
	public int getTries() {
		return 5 - shoots;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	@Override
	public int getMaxScore() {
		return this.maxScore;
	}

	public boolean isShooted() {
		return tejo.isShooted();
	}

	@Override
	public int getScoreToPass() {
		return this.scoreToPassScenario;
	}

	@Override
	public int getScenarioNumber() {
		return this.scenarioNumber;
	}

	public void setInitialMoney(int money) {
		this.money = money;
	}

	@Override
	public int getGamerHat() {
		return this.gamerHat;
	}

	public void setGamerHat(int hat) {
		this.gamerHat = hat;
	}

	@Override
	public void setMoneyByStore(int money) {
		this.money = money;
	}

}
