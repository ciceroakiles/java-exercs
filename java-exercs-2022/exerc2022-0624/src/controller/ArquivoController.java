package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ArquivoController {

	private String caminho;
	private String nome;
	
	public ArquivoController(String caminho, String nome) {
		this.caminho = caminho;
		this.nome = nome;
	}
	
	public List<String> lerArquivo() throws IOException {
		List<String> lista = new ArrayList<String>();
		File arq = new File(caminho, nome);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fs = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fs);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			int cont = 0;
			while (line != null) {
				if (cont > 0 && line.contains(":")) {
					lista.add(line.split(":")[1].replace(" ", "").replace(",", ""));
				}
				line = br.readLine();
				cont++;
			}
			lista.remove(0);
			br.close();
			isr.close();
			fs.close();
		} else throw new IOException("Arquivo invalido");
		return lista;
	}
}
