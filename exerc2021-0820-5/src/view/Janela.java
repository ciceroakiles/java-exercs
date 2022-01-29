package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Listener;

public class Janela {
	
	private int largura;
	private int altura;
	private static JPanel panelPrincipal;
	private static Retangulo r1;
	private static Retangulo r2;
	private static JTextField txt1;
	private static JTextField txt2;
	private static StringBuffer pos = new StringBuffer();
	
	public Janela() {
		// Dimensoes da janela
		this.largura = 700;
		this.altura = 300;
		
		// Retangulos
		r1 = new Retangulo(5, 20, 40, 20, Color.BLUE);
		r2 = new Retangulo(5, 80, 40, 20, Color.RED);
		RetanguloGrupo group = new RetanguloGrupo();
		group.addRect(r1);
		group.addRect(r2);
		
		// Botao e JPanel especifico
		JButton btnRun = new JButton("Correr");
		btnRun.setBounds(0, 0, 100, 30);
		Listener.addClick(btnRun);
		JPanel panelBtn = new JPanel(new FlowLayout());
		//panelBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panelBtn.add(btnRun);
		
		// Label(s), textfield(s) e JPanel especifico
		txt1 = new JTextField();
		txt2 = new JTextField();
		txt1.setEnabled(false);
		txt2.setEnabled(false);
		JLabel label1 = new JLabel("  Vencedor: ");
		JLabel label2 = new JLabel("  Perdedor: ");
		JPanel panelLbl = new JPanel(new GridLayout(2, 1));
		//panelLbl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panelLbl.add(label1);
		panelLbl.add(txt1);
		panelLbl.add(label2);
		panelLbl.add(txt2);
		
		// JPanel principal
		panelPrincipal = new JPanel();
		//panelPrincipal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panelPrincipal.setLayout(new GridLayout(2, 1));
		panelPrincipal.add(group);
		panelPrincipal.add(panelLbl);
		
		// Criacao da janela
		JFrame frame = new JFrame("Corrida");
		frame.add(panelBtn, BorderLayout.SOUTH);
		frame.add(panelPrincipal);
		frame.setSize(largura, altura);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public static Retangulo getRetangulo1() {
		return r1;
	}
	
	public static Retangulo getRetangulo2() {
		return r2;
	}
	
	public static void addToBuffer(String s) {
		try {
			pos.append(s);
			//System.out.println(pos.toString().split("\n")[0]);
			txt1.setText(pos.toString().split("\n")[0]);
			txt2.setText(pos.toString().split("\n")[1]);
		} catch (Exception e) { }
	}
	
	public static void update() {
		panelPrincipal.revalidate();
		panelPrincipal.repaint();
	}
}
