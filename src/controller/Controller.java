package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.Timer;

import models.FileManager;
import models.Game;
import views.View;

public class Controller implements ActionListener, KeyListener {

	private View view;
	private Game game;
	private FileManager manager;

	public Controller() {
		this.manager = new FileManager();
		this.game = new Game();
		this.game.setInitialMoney(manager.getMoney());
		this.game.setMaxScore(manager.getMaxScore());
		this.view = new View(this, this, game);
		updateUi();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Events.EVENT_START_GAME:
			this.game = new Game();
			updateUi();
			view.getCardLayout().show(view.getBody(), Events.EVENT_SCENARIO);
			view.focusPanel();
			break;
		case Events.EVENT_STORE_GAME:
			view.getCardLayout().show(view.getBody(), Events.EVENT_STORE_GAME);
			view.focusPausePanel();
			break;
		case Events.EVENT_EXIT_GAME:
			view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
			break;
		case Events.EVENT_PAUSE_MENU:
			view.setPaused(true);
			view.getCardLayout().show(view.getBody(), Events.EVENT_PAUSE_MENU);
			view.focusPausePanel();
			break;
		case Events.EVENT_RESUME_GAME:
			view.setPaused(false);
			view.focusPausePanel();
			view.getCardLayout().show(view.getBody(), Events.EVENT_SCENARIO);
			view.focusPanel();
			break;
		case Events.EVENT_MAIN_MENU:
			view.getCardLayout().show(view.getBody(), Events.EVENT_MAIN_MENU);
			view.focusPausePanel();
			break;
		case Events.BUY_HAT:
			System.out.println("llega");
			game.setGamerHat(2);
			view.buyHat(2, this.game);
		default:
			break;
		}
	}

	private void updateUi() {
		final Timer timerUpdater = new Timer(1, e -> {
			if (game.getShootsNumber() == Game.MAX_SHOOTS || game.getScenarioNumber() == Game.MAX_SCENARIOS) {
				((Timer) e.getSource()).stop();
				view.getCardLayout().show(view.getBody(), Events.EVENT_GAME_OVER);
				game.setMoney(game.getScore());
				manager.setMoney(game.getMoney());
				view.updateGame(game);
			} else {
				view.updateGame(game);
				if (manager.checkMaxScore(game.getScore())) {
					game.setMaxScore(manager.getMaxScore());

				}
			}
		});
		timerUpdater.start();
	}

	public void updatePower() {
		final Timer timerUpdater = new Timer(1, e -> {
			if (game.isShooting()) {
				this.game.setArrow();
				((Timer) e.getSource()).stop();
			} else {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				game.updatePower();
				view.updateGame(game);
			}
		});
		timerUpdater.start();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getExtendedKeyCode();
		switch (code) {
		case KeyEvent.VK_UP:
			if (!game.isShooting() && !view.isPaused()) {
				game.moveArrowUp();

			}
			break;
		case KeyEvent.VK_DOWN:
			if (!game.isShooting() && !view.isPaused()) {
				game.moveArrowDown();

			}
			break;
		case KeyEvent.VK_SPACE:
			if (!game.isShooting() && !view.isPaused()) {
				updatePower();
			}
			break;

		case KeyEvent.VK_ESCAPE:
			if (view.isPaused()) {
				view.setPaused(false);
				view.getCardLayout().show(view.getBody(), Events.EVENT_SCENARIO);
				view.focusPanel();
			} else if (!view.isPaused()) {
				view.setPaused(true);
				view.getCardLayout().show(view.getBody(), Events.EVENT_PAUSE_MENU);
				view.focusPausePanel();
			}
			break;
		default:
			;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getExtendedKeyCode();

		switch (code) {
		case KeyEvent.VK_SPACE:
			game.tejoShoot(game.getAngle(), game.getVelocity());
			break;

		default:
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
