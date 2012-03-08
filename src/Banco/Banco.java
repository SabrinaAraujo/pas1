package Banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Excecoes.ContaInexistenteException;
import Excecoes.ContaInvalidaException;

public class Banco {

	Conta conta;
	List<Conta> contas;

	public Banco() {
		contas = new ArrayList<Conta>();

	}

	public void addConta(Conta conta) {
		this.contas.add(conta);
	}

	public String getConta(String numConta) throws ContaInexistenteException {
		String conta = null;
		for (Conta c : contas) {
			if (!c.getConta().equals(numConta))
				throw new ContaInexistenteException("Conta Invalida.");
			else {
				conta = c.getConta();
			}
		}
		return conta;

	}
	
	public double getSaldo(String numConta) throws ContaInexistenteException {
		double saldo = 0;
		for (Conta c : contas) {
			if (!c.getConta().equals(numConta))
				throw new ContaInexistenteException("Conta Invalida.");
			else {
				saldo = c.getSaldo();
			}
		}
		return saldo;

	}
	
	
	 public int getQnt(){
         return contas.size();
     }
	

}

