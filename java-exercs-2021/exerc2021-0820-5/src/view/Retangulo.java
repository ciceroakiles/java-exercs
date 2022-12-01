package view;

import java.awt.Color;

public class Retangulo {
	
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	
	// Construtor
	public Retangulo(int x, int y, int w, int h, Color c) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.color = c;
	}

	// Setters
	public void setX(int x) {
		this.x = x;
	}
	
	// Getters
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Color getColor() {
		return color;
	}
}
