package view;

import java.io.IOException;
import controller.ArquivoController;
import controller.ThreadInstance;

public class Main {

	private final static String PATH = "C:\\Temp";
	private final static String FILENAME = "config.json";
	private final static ArquivoController ac = new ArquivoController(PATH, FILENAME);
	
	public static void main(String[] args) {
		try {
			for (int i = 0; i < 5; i++) {
				ThreadInstance th = new ThreadInstance(i, ac.lerArquivo());
				th.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
