package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import models.ITejo;

public class View extends JFrame {

	private static final String TITTLE = "Titulo";
	private Body body;

	public View(ActionListener actionListener, KeyListener keyListener) {
		super();
		this.setIconImage(
				Toolkit.getDefaultToolkit().getImage(View.class.getResource("/resources/images/iconTittle.png")));
		this.setTitle(TITTLE);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		initComponents(actionListener, keyListener);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void initComponents(ActionListener actionListener, KeyListener keyListener) {
		this.body = new Body(actionListener, keyListener);
		this.add(this.body, BorderLayout.CENTER);
	}

	public CardLayout getCardLayout() {
		return body.getCardLayout();
	}

	public Body getBody() {
		return body;
	}

	public void updateGame(ITejo gameData) {
		body.updateGame(gameData);
	}

}
