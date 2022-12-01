package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	
	// Processos em execucao
	public static void listaProcessos() {
		readProcess(list_command());
	}
	
	// Nome ou PID
	public static void nomeOuPid(String input) {
		try {
			int i = Integer.parseInt(input);
			mataPid(i);
		} catch (NumberFormatException e) {
			mataNome(input);
		}
	}
	
	private static void mataPid(int pid) {
		StringBuffer sb = new StringBuffer();
		sb.append(kill_command(true));
		sb.append(pid);
		callProcess(sb.toString());
	}
	
	private static void mataNome(String nome) {
		StringBuffer sb = new StringBuffer();
		sb.append(kill_command(false));
		sb.append(nome);
		callProcess(sb.toString());
	}
	
	// Reconhecimento do SO e comandos associados
	private static String os() {
		return System.getProperty("os.name");
	}
	
	private static String list_command() {
		if (os().contains("Windows")) return "TASKLIST /FO TABLE";
		if (os().contains("Linux")) return "ps -ef";
		return "";
	}
	
	private static String kill_command(boolean existePid) {
		if (os().contains("Windows")) {
			return (existePid ? "TASKKILL /PID " : "TASKKILL /IM ");
		}
		if (os().contains("Linux")) {
			return (existePid ? "kill -9 " : "pkill -f ");
		}
		return "";
	}
	
	// Metodos auxiliares para listar e matar processos
	private static void readProcess(String proc) {
		try {
			Process exec = Runtime.getRuntime().exec(proc);
			InputStream input = exec.getInputStream();
			InputStreamReader reader = new InputStreamReader(input);
			BufferedReader br = new BufferedReader(reader);
			// Leitura, linha por linha
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			// Fechamentos
			br.close();
			reader.close();
			input.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void callProcess(String proc) {
		try {
			Runtime.getRuntime().exec(proc);
		} catch (Exception e) {
			// Corrige erro de permissao no Windows
			if (System.getProperty("os.name").contains("Windows")) {
				if (e.getMessage().contains("740") && !proc.contains("cmd")) {
					StringBuffer sb = new StringBuffer();
					sb.append("cmd /c ");
					sb.append(proc);
					callProcess(sb.toString());
				}
			}
		}
	}
}
