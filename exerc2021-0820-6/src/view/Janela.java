package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.Listener;

public class Janela {
	
	private int largura;
	private int altura;
	private static JTextField n1;
	private static JTextField n2;
	private static JTextField n3;
	
	public Janela() {
		// Dimensoes da janela
		this.largura = 400;
		this.altura = 300;
		
		// Botao e JPanel especifico
		JButton btnRun = new JButton("Jogar");
		btnRun.setBounds(0, 0, 100, 30);
		Listener.addClick(btnRun);
		JPanel panelBtn = new JPanel(new FlowLayout());
		//panelBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panelBtn.add(btnRun);
		
		// Numeros que giram
		n1 = new JTextField("0");
		n2 = new JTextField("0");
		n3 = new JTextField("0");
		n1.setEnabled(false);
		n2.setEnabled(false);
		n3.setEnabled(false);
		
		// JPanel principal
		JPanel panelPrincipal = new JPanel();
		//panelPrincipal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panelPrincipal.setLayout(new GridLayout(1, 4));
		panelPrincipal.add(n1);
		panelPrincipal.add(n2);
		panelPrincipal.add(n3);
		
		// Criacao da janela
		JFrame frame = new JFrame("Caca-niquel");
		frame.add(panelBtn, BorderLayout.SOUTH);
		frame.add(panelPrincipal);
		frame.setSize(largura, altura);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public static JTextField getN1() {
		return n1;
	}
	
	public static JTextField getN2() {
		return n2;
	}
	
	public static JTextField getN3() {
		return n3;
	}
	
	public void setN1(String s) {
		n1.setText(s);
	}
	
	public void setN2(String s) {
		n2.setText(s);
	}
	
	public void setN3(String s) {
		n3.setText(s);
	}
}
