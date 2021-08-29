package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.ITejo;

public class ObjectStore extends JPanel {

	private JButton buyBtn;
	private JLabel lbName;
	private ObjectImage imgObject;
	private boolean isBought;
	private int prize;

	public ObjectStore(Image image, String name, int prize, ActionListener actionListener, String objectNumber) {
		this.prize = prize;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(280, 180));
		this.lbName = new JLabel(name);
		this.lbName.setHorizontalAlignment(JLabel.CENTER);
		add(lbName, BorderLayout.NORTH);

		this.imgObject = new ObjectImage(image);
		add(imgObject, BorderLayout.CENTER);

		this.buyBtn = new JButton("$ " + String.valueOf(prize));
		this.buyBtn.addActionListener(actionListener);
		this.buyBtn.setActionCommand(objectNumber);
		this.buyBtn.setBackground(new Color(24, 213, 12));
		this.buyBtn.setFocusable(false);
		add(buyBtn, BorderLayout.SOUTH);
	}

	public void setBought(boolean b) {
		this.isBought = b;
	}
	
	public void buyObject(ITejo gamedata) {
		if (gamedata.getMoney() >= prize) {
			isBought = true;
			repaint();
			gamedata.setMoneyByStore(gamedata.getMoney() - prize);
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (isBought) {
			this.buyBtn.setEnabled(false);
			g.setColor(new Color(87, 96, 86, 100));
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}

}
