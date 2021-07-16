package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

public class MainButtonStyle extends BasicButtonUI{
	
	private static final int ARC_SIZE = 10;
	private static final int STROKE = 8;
	private static final EmptyBorder EMPTY_BORDER = new EmptyBorder(5, 15, 5, 15);
	private Color color;
	
	public MainButtonStyle(Color background) {
		this.color = background;
	}
	
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorder(EMPTY_BORDER);
	}
	
	@Override
    public void paint (Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, b.getModel().isPressed() ? STROKE : 0);
        super.paint(g, c);
    }

    private void paintBackground (Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(this.color.darker());
        g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, ARC_SIZE, ARC_SIZE);
        g.setColor(this.color);
        g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - STROKE, ARC_SIZE, ARC_SIZE);
    }


}
