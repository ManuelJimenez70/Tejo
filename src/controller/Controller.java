package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import models.Game;
import views.View;

public class Controller implements ActionListener, KeyListener {

	private View view;
	private Game game;

	public Controller() {
		this.game = new Game();
		this.view = new View(this, this);
		updateUi();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Events.EVENT_START_GAME:
			this.game = new Game();
			updateUi();
			view.getCardLayout().show(view.getBody(), Events.EVENT_SCENARIO);
			break;
		case Events.EVENT_STORE_GAME:
			view.getCardLayout().show(view.getBody(), Events.EVENT_STORE_GAME);
			break;
		case Events.EVENT_EXIT_GAME:
			view.dispose();
			break;
		case Events.EVENT_PAUSE_MENU:
			view.getCardLayout().show(view.getBody(), Events.EVENT_PAUSE_MENU);
			break;
		case Events.EVENT_RESUME_GAME:
			view.getCardLayout().show(view.getBody(), Events.EVENT_SCENARIO);
			break;
		case Events.EVENT_MAIN_MENU:
			view.getCardLayout().show(view.getBody(), Events.EVENT_MAIN_MENU);
			break;
		default:
			break;
		}
	}

	private void updateUi() {
		final Timer timerUpdater = new Timer(1, e -> {
			if (game.getShootsNumber() == Game.MAX_SHOOTS) {
				((Timer) e.getSource()).stop();
				view.getCardLayout().show(view.getBody(), Events.EVENT_GAME_OVER);

			} else {
				view.updateGame(game);
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
			game.moveArrowUp();
			break;
		case KeyEvent.VK_DOWN:
			game.moveArrowDown();
			break;
		case KeyEvent.VK_SPACE:
			updatePower();
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
