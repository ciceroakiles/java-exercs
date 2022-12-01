package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FifaController implements IFifaController {

	@Override
	public Stack<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
		Stack<String> pilha = new Stack<>();
		File arq = new File(caminho, nome);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fs = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fs);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			int cont = 0;
			while (line != null) {
				if (cont > 0) {
					String[] str = line.split(",");
					// str[5]: Nationality
					if (str[5].equals("Brazil")) {
						pilha.push(line);
					}
				}
				line = br.readLine();
				cont++;
			}
			br.close();
			isr.close();
			fs.close();
		} else throw new IOException("Arquivo invalido");
		return pilha;
	}

	@Override
	public void desempilhaBonsBrasileiros(Stack<String> pilha) throws IOException {
		int tam = pilha.size();
		for (int i = 0; i < tam; i++) {
			String str = pilha.pop();
			// str[7]: Overall
			if (Integer.parseInt(str.split(",")[7]) > 80) {
				System.out.println(str.split(",")[2] + "," + str.split(",")[7]);
			}
		}
	}

	@Override
	public List<String> listaRevelacoes(String caminho, String nome) throws IOException {
		List<String> lista = new LinkedList<String>();
		File arq = new File(caminho, nome);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fs = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fs);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			int cont = 0;
			while (line != null) {
				if (cont > 0) {
					String[] str = line.split(",");
					// str[3]: Age (idade)
					if (Integer.parseInt(str[3]) <= 20) {
						lista.add(line);
					}
				}
				line = br.readLine();
				cont++;
			}
			br.close();
			isr.close();
			fs.close();
		} else throw new IOException("Arquivo invalido");
		return lista;
	}

	@Override
	public void buscaListaBonsJovens(List<String> lista) throws IOException {
		for (int i = lista.size()-1; i >= 0; i--) {
			String str = lista.get(i);
			if (Integer.parseInt(str.split(",")[7]) > 80) {
				// Nome, idade e overall
				System.out.println(str.split(",")[2] + "," + str.split(",")[3] + "," + str.split(",")[7]);
			}
		}
	}

}
