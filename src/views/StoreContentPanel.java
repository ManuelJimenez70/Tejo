package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.ITejo;

public class StoreContentPanel extends JPanel {

	private static final String BACKGROUND_COLOR = "#EAE0BC";
	private static final URL STORE_IMAGES = View.class.getResource("/resources/images/");

	private ObjectStorePanel ruanas, tejos, hats;

	public StoreContentPanel(ActionListener actionListener) {
		setBackground(Color.decode(BACKGROUND_COLOR));
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(1200, 900));

		ruanas = new ObjectStorePanel(Color.decode("#FCD116"), "Ruanas" , createRuanas(actionListener));
		add(ruanas);

		hats = new ObjectStorePanel(Color.decode("#CE1126"), "Sombreros" , createHats(actionListener));
		add(hats);

		tejos = new ObjectStorePanel(Color.decode("#003893"), "Tejos" , createTejos(actionListener));
		add(tejos);
	}

	private ArrayList<ObjectStore> createTejos(ActionListener actionListener) {
		ArrayList<ObjectStore> tejos = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			ObjectStore tejo = new ObjectStore(Toolkit.getDefaultToolkit().getImage(View.class.getResource("/resources/images/tejoImage" + (i+1) +".png")), getTejoName(i), getTejoPrize(i), actionListener, "tejo"+i);
			if (i == 0) {
				tejo.setBought(true);
			}
			tejos.add(tejo);
		}
		return tejos;
	}

	private int getTejoPrize(int i) {
		switch (i) {
		case 0:
			return 0;
		case 1:
			return 30000;
		case 2:
			return 60000;
		case 3:
			return 100000;
		default:
			break;
		}
		return 0;	
	}

	private String getTejoName(int i) {
		switch (i) {
		case 0:
			return "Tejo de Acero";
		case 1:
			return "Tejo Ruby";
		case 2:
			return "Tejo Emeralda";
		case 3:
			return "Tejo de Oro";
		default:
			break;
		}
		return "";
	}

	private ArrayList<ObjectStore> createHats(ActionListener actionListener) {
		ArrayList<ObjectStore> hats = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			ObjectStore hat = new ObjectStore(Toolkit.getDefaultToolkit().getImage(View.class.getResource("/resources/images/gamerHat" + (i+1) +".png")), getHatName(i), getHatPrize(i), actionListener, "hat"+(i+1));
			if (i == 0) {
				hat.setBought(true);
			}
			hats.add(hat);
		}
		return hats;
	}

	private int getHatPrize(int i) {
		switch (i) {
		case 0:
			return 0;
		case 1:
			return 500;
		case 2:
			return 45000;
		case 3:
			return 80000;
		default:
			break;
		}
		return 0;
	}

	private String getHatName(int i) {
		switch (i) {
		case 0:
			return "Sombrero Básico";
		case 1:
			return "Sombrero de Cuero";
		case 2:
			return "Sombrero Elegante";
		case 3:
			return "Sombrero Tradicional";
		default:
			break;
		}
		return "";
	}

	private ArrayList<ObjectStore> createRuanas(ActionListener actionListener) {
		ArrayList<ObjectStore> ruanas = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().getImage(View.class.getResource("/resources/images/gamerRuana" + (i+1) +".png")));
			ObjectStore ruana = new ObjectStore(image.getImage(), getRuanaName(i), getRuanaPrize(i), actionListener, "ruana"+(i+1));
			if (i == 0) {
				ruana.setBought(true);
			}
			ruanas.add(ruana);
		}
		return ruanas;
	}

	private int getRuanaPrize(int i) {
		switch (i) {
		case 0:
			return 0;
		case 1:
			return 20000;
		case 2:
			return 50000;
		case 3:
			return 100000;
		default:
			break;
		}
		return 0;
	}

	private String getRuanaName(int i) {
		switch (i) {
		case 0:
			return "Ruana Basica";
		case 1:
			return "Ruana de Lana Marron";
		case 2:
			return "Ruana Patriotica";
		case 3:
			return "Ruana Tradicional";
		default:
			break;
		}
		return "";
	}

	public void buyHat(int i, ITejo gamedata) {
		hats.buy(2, gamedata);
	}

}
