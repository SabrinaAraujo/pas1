package Jogo;

import java.util.ArrayList;
import Execoes.BarcoInvalidoException;
import Execoes.NomeInvalidoException;
import Execoes.TamanhoInvalidoException;

public class Tabuleiro {

	public static final int LARG_MIN = 3;
	public static final int ALT_MIN = 3;
	private ArrayList<Barco> barcos;
	private int largura;
	private int altura;
	private int quantidadeBarcos = 0;
	private int tabuleiro[][];
	

	public Tabuleiro() {
		barcos = new ArrayList<Barco>();
	}

	public int getLarguraTabuleiro() {
		return largura;
	}

	public int getAlturaTabuleiro() {
		return altura;
	}

	public void setQuantidadeBarcos(int qnt) {
		this.quantidadeBarcos = qnt;

	}

	public int getQuantidadebarcos() {
		return quantidadeBarcos;
	}

	
	public void criarJogo(int larg, int alt) throws TamanhoInvalidoException {
		if (larg <= 0)
			throw new TamanhoInvalidoException("Largura invalida: ");
		if (alt <= 0)
			throw new TamanhoInvalidoException("Altura invalida: ");
		if (larg < LARG_MIN || alt < ALT_MIN)
			throw new TamanhoInvalidoException(
					"Largura e Altura devem ser maiores que 2");

		this.largura = larg;
		this.altura = alt;
		tabuleiro = new int[largura][altura];
		System.out.println("LARGURA: " + largura + " ALTURA: " + altura);
	}

	
	
	public void addBarcoNoJogo(String nome, int tamanho)
			throws BarcoInvalidoException {
		if (tamanho > 15) {
			throw new BarcoInvalidoException("Barco nao cabe no tabuleiro");
		}
		if (tamanho <= 0)
			throw new BarcoInvalidoException("Tamanho de embarcacao invalido");

		if (nome.equals("")) {
			throw new BarcoInvalidoException("Nome invalido");
		}
		
		if (!(nome.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$") || (nome.matches("^[0-9]*$")))){ 
			throw new BarcoInvalidoException("Nome deve conter apenas (A..Z), (0..9) e (_-.)");
		}
		
		for (Barco b : barcos) {
			if (nome.equals(b.getNome())) {
				throw new BarcoInvalidoException("Ja existe uma barco com este nome");
			}
		}

		      
		Barco b1 = new Barco(nome, tamanho);
		barcos.add(b1);
		quantidadeBarcos++;

	}

	
	
	
}
