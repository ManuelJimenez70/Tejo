package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import models.ITejo;

public class ObjectStorePanel extends JPanel{
	
	private static final String BACKGROUND_COLOR = "#EAE0BC";
	private static final String AGENCY_FONT_TYPE = "Agency FB";
	private JLabel title;
	private ObjectStoreList objectStoreList;
	
	public ObjectStorePanel(Color color, String title, ArrayList<ObjectStore> objects) {
		setBackground(Color.decode(BACKGROUND_COLOR));
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(1200,250));
		setBackground(Color.decode("#F5EBC4"));
		this.title = new JLabel(title);
		this.title.setPreferredSize(new Dimension(1200,50));
		this.title.setFont(new Font(AGENCY_FONT_TYPE, Font.BOLD, 30));
		this.title.setHorizontalAlignment(JLabel.CENTER);
        Border border = BorderFactory.createLineBorder(color, 5);
        setBorder(border);
        this.title.setBorder(border);
        add(this.title, BorderLayout.NORTH);
        this.objectStoreList = new ObjectStoreList(objects);
        add(objectStoreList,BorderLayout.CENTER);
	}

	public void buy(int i, ITejo gamedata) {
		objectStoreList.buy(2,  gamedata);
	}

}
