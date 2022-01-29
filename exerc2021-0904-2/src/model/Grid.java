package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grid {

	private static List<Carro> grid = new ArrayList<>();

	public static List<Carro> getGrid() {
		Collections.sort(grid);
		return grid;
	}

	public static void addItem(Carro c) {
		grid.add(c);
	}
}
