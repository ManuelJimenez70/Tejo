package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class View extends JFrame{

	private static final String TITTLE = "Titulo";
	private Body body;
	
	
	public View(ActionListener actionListener) {
		super();
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(View.class.getResource("/resources/images/iconTittle.png")));
		this.setTitle(TITTLE);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		initComponents(actionListener);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void initComponents(ActionListener actionListener) {
		this.body = new Body(actionListener);
		this.add(this.body,BorderLayout.CENTER);
	}
	
	public CardLayout getCardLayout() {
		return body.getCardLayout();
	}

	public Body getBody() {
		return body;
	}
	
	
}
