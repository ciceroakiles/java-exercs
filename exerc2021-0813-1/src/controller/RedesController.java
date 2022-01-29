package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
	}
	
	public void ip() {
		// Execucao
		String command = ip_command();
		System.out.println("Executando '" + command + "'...");
		String[] result = readProcess(command).toString().split("\n");
		// Tratamento da saida
		StringBuffer out = new StringBuffer();
		String iface = "", ip = "";
		for (String line : result) {
			boolean temIp = false;
			if (os().contains("Windows")) {
				if (line.contains("Adaptador")) iface = line.split(":")[0];
				if (line.contains("IPv4")) {
					ip = line.split(":")[1].trim();
					temIp = true;
				}
			}
			if (os().contains("Linux")) {
				if (line.contains("flags")) iface = line.split(":")[0];
				if (line.contains("netmask")) {
					ip = line.split("inet")[1].split("netmask")[0].trim();
					temIp = true;
				}
			}
			if (temIp) {
				// Verifica se realmente se trata de um IPv4 (precisa obedecer a uma expressao regular)
				if (ip.matches("^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)(\\.(?!$)|$)){4}$")) {
					out.append(iface + " - " + ip + "\n");
				}
				temIp = false;
			}
		}
		// Resultados
		System.out.println("Interface - IPv4");
		System.out.print(out.toString());
		System.out.println("-------");
	}
	
	public void ping() {
		// Execucao
		String command = ping_command();
		System.out.println("Executando '" + command + "'...");
		String[] result = readProcess(command).toString().split("\n");
		// Tratamento da saida
		String line = result[result.length-1];
		if (os().contains("Windows")) {
			if (line.contains("dia")) {
				System.out.println("Media: " + line.split(",")[2].split("=")[1].trim());
			}
		}
		if (os().contains("Linux")) {
			if (line.contains("avg")) {
				System.out.println("Media: " + line.split("/")[4] + "ms");
			}
		}
		System.out.println("-------");
	}
	
	// Metodo auxiliar para ambos os comandos
	private StringBuffer readProcess(String command) {
		//String comando = ip_command();
		StringBuffer sb = new StringBuffer();
		try {
			Process exec = Runtime.getRuntime().exec(command);
			// Saida de um processo
			InputStream input = exec.getInputStream();
			InputStreamReader reader = new InputStreamReader(input);
			BufferedReader br = new BufferedReader(reader);
			// Leitura, linha por linha
			String line = "";
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			// Fechamentos
			br.close();
			reader.close();
			input.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return sb;
	}
	
	// Reconhecimento do SO e comandos associados
	private String os() {
		return System.getProperty("os.name");
	}
	
	private String ip_command() {
		if (os().contains("Windows")) return "ipconfig";
		if (os().contains("Linux")) return "ifconfig";
		return "";
	}
	
	private String ping_command() {
		if (os().contains("Windows")) return "ping -4 -n 10 www.google.com.br";
		if (os().contains("Linux")) return "ping -4 -c 10 www.google.com.br";
		return "";
	}
}
