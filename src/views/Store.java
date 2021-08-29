package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Events;
import models.ITejo;

public class Store extends JPanel {

	private static final String BACKGROUND_COLOR = "#EAE0BC";
	private static final URL STORE_HEADER = View.class.getResource("/resources/images/storeHeader.png");
	private static final URL MONEY_BILLS = View.class.getResource("/resources/images/moneyIcon.png");
	private static final String AGENCY_FONT_TYPE = "Agency FB";


	private static final long serialVersionUID = 1L;
	private static final int SIZE_HEADER = 150;
	private JPanel header;
	private StoreContentPanel content;
	private MainButton backbtn;
	private JLabel titlelbl;
	private JLabel moneylbl;
	private int money;

	public Store(ActionListener actionListener) {
		setBackground(Color.decode(BACKGROUND_COLOR));
		setLayout(new BorderLayout());
		header = new JPanel();
		content = new StoreContentPanel(actionListener);
		titlelbl = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(STORE_HEADER)));
		moneylbl = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(MONEY_BILLS)));
		moneylbl.setText(String.valueOf(money));
		moneylbl.setHorizontalTextPosition(SwingConstants.RIGHT);
		moneylbl.setForeground(Color.decode("#D1AE15"));
		moneylbl.setFont(new Font(AGENCY_FONT_TYPE, Font.BOLD, 40));
		content.setBackground(Color.decode(BACKGROUND_COLOR));
		header.setBackground(Color.decode(BACKGROUND_COLOR));
		Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		header.setSize(new Dimension(d.width, SIZE_HEADER));
		header.setPreferredSize(new Dimension(d.width, SIZE_HEADER));
		header.setLayout(new BorderLayout());
		backbtn = new MainButton("Volver", Events.EVENT_MAIN_MENU, actionListener, Color.decode("#CE1126"));
		header.add(backbtn, BorderLayout.EAST);
		header.add(titlelbl, BorderLayout.CENTER);
		header.add(moneylbl, BorderLayout.WEST);
		add(header, BorderLayout.NORTH);
		add(content, BorderLayout.CENTER);
	}

	public void updateGame(ITejo gameData) {
		money = gameData.getMoney();
		moneylbl.setText(String.valueOf(money));
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	public void buyHat(int i, ITejo gamedata) {
		content.buyHat(2, gamedata);
	}

}
