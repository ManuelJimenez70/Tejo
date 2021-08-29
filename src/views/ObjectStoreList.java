package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import models.ITejo;

public class ObjectStoreList extends JPanel{
	
	private ArrayList<ObjectStore> objects;

	public ObjectStoreList(ArrayList<ObjectStore> objects) {
		setBackground(Color.decode("#EAE0BC"));
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(1200,250));
		this.objects = objects;
		addObjects();
	}

	private void addObjects() {
		for (int i = 0; i < objects.size(); i++) {
			add(objects.get(i));
		}
	}

	public void buy(int i, ITejo gamedata) {
		objects.get(i-1).buyObject(gamedata);;
	}

}
