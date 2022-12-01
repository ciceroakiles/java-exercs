package model;

public class Conta {

	private String codigo;
	private double saldo;

	public Conta(String codigo, double saldo) {
		this.codigo = codigo;
		this.saldo = saldo;
	}

	public String getCodigo() {
		return codigo;
	}

	public double getSaldo() {
		return saldo;
	}

	// 0: deposito, 1: saque
	public void transacao(double valor, int i) {
		switch (i) {
			case 0: {
				this.saldo += valor;
			} break;
			case 1: {
				this.saldo -= valor;
			} break;
		}
	}
}
