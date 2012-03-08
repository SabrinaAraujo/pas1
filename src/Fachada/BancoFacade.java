package Fachada;

import Banco.Banco;
import Banco.Conta;
import Excecoes.ContaInexistenteException;
import Excecoes.ContaInvalidaException;

public class BancoFacade {

	Banco banco;

	public double getSaldo(String numeroConta) throws ContaInexistenteException {
				
		return banco.getSaldo(numeroConta);

	}

}
