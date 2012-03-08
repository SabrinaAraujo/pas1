package Banco;

import Excecoes.ContaInvalidaException;

public class Conta {

	private double saldo;
	private String numConta;


	public Conta(String nConta){
		
			this.numConta = nConta;
			this.saldo = 0.0;
	}

	
	public Conta(String nConta, double valor) throws ContaInvalidaException {
		
			this.numConta = nConta;
			this.saldo = valor;
	}
	
	
	public Conta() throws ContaInvalidaException {
			this.numConta = "000";
			this.saldo = 0.0;
	}
	
	
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo(double valor){
		this.saldo = valor;
	}

	public String getConta() {
		return this.numConta;
	}
	
	public void setConta(String nConta){
		this.numConta = nConta;
	}

	
}
