package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.MyModel;
import views.MyProgressBar;
import views.View;

public class Controller implements ActionListener{
	
	private View view;
	private MyModel model;
	
	public Controller() {
		this.model = new MyModel();
		this.view = new View(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case Events.EVENT_START_GAME:
			view.getCardLayout().show(view.getBody(), Events.EVENT_SCENARIO);
			break;
		case Events.EVENT_STORE_GAME:
			view.getCardLayout().show(view.getBody(), Events.EVENT_STORE_GAME);
			break;
		case Events.EVENT_EXIT_GAME:
			view.dispose();
			break;
		default:
			break;
		}
	}
}
