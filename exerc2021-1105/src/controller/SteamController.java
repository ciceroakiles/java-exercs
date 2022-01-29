package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Map;
import javax.swing.JOptionPane;

public class SteamController {
	
	private static String hashToString(Hashtable<String, Double> tabela) {
		String res = "nome_jogo,media_jogadores\r\n";
		for (Map.Entry<String, Double> entrada : tabela.entrySet()) {
			res += entrada.getKey() + "," + entrada.getValue() + "\r\n";
		}
		return res;
	}
	
	public static void imprimirDados(String ano, String mes, double esperado) throws IOException {
		//System.out.println("Pasta do projeto: "+ System.getProperty("user.dir"));
		Hashtable<String, Double> dadosGerais = abrirArquivo(System.getProperty("user.dir"), "SteamCharts.csv", ano, mes);
		Hashtable<String, Double> dadosFiltrados = new Hashtable<String, Double>();
		System.out.print("Nome do jogo | Media jog. ativos\r\n");
		for (Map.Entry<String, Double> entrada : dadosGerais.entrySet()) {
			if (entrada.getValue() >= esperado) {
				dadosFiltrados.put(entrada.getKey(), entrada.getValue());
				System.out.println(entrada.getKey() + " | " + entrada.getValue());
			}
		}
		System.out.println();
		String nome = "";
		do {
			nome = JOptionPane.showInputDialog(null, "Nome do arquivo de destino:", "Salvar dados", JOptionPane.PLAIN_MESSAGE);
		} while (nome == null || nome.equals(""));
		salvarArquivo(System.getProperty("user.dir"), nome + ".csv", hashToString(dadosFiltrados));
		System.out.println("Dados salvos em:");
		System.out.println(System.getProperty("user.dir") + "\\" + nome + ".csv");
	}
	
	public static Hashtable<String, Double> abrirArquivo(String path, String filename, String ano, String mes) throws IOException {
		Hashtable<String, Double> jogos = new Hashtable<String, Double>();
		File arq = new File(path, filename);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fs = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fs);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			int cont = 0;
			while (line != null) {
				if (cont > 0) {
					String[] str = line.split(",");
					if (ano.equals(str[1]) && mes.equals(str[2].toUpperCase())) {
						// str[1]: ano; str[2]: mes
						jogos.put(str[0], Double.parseDouble(str[3]));
					}
				}
				line = br.readLine();
				cont++;
			}
			br.close();
			isr.close();
			fs.close();
		} else throw new IOException("Arquivo invalido");
		return jogos;
	}
	
	public static void salvarArquivo(String path, String name, String content) throws IOException {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File arq = new File(path, name);
			if (arq.exists()) System.out.println("Um arquivo com este nome foi sobrescrito.");
			FileWriter fw = new FileWriter(arq, false);
			PrintWriter pw = new PrintWriter(fw);
			pw.write(content);
			pw.flush();
			pw.close();
			fw.close();
		} else throw new IOException("Diretorio invalido");
	}
}
