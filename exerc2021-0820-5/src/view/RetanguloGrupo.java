package view;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class RetanguloGrupo extends JPanel {

	private List<Retangulo> rects;
	
	public RetanguloGrupo() {
		this.rects = new ArrayList<>();
	}
	
	public void addRect(Retangulo r) {
		rects.add(r);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		for (Retangulo r : rects) {
			g.setColor(r.getColor());
			g.fillRect(r.getX(), r.getY(), r.getWidth(), r.getHeight());
		}
	}
}
