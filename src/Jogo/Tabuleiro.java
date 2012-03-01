package Jogo;

import java.util.ArrayList;
import Execoes.BarcoInvalidoException;
import Execoes.TamanhoInvalidoException;

public class Tabuleiro {

	public static final int LARG_MIN = 3;
	public static final int ALT_MIN = 3;
	private ArrayList<Barco> barcos;
	private int largura;
	private int altura;
	private int quantidadeBarcos = 0;
	private int tabuleiro[][];
	private int tab;
	private char a,b,c,d,e,f,g,h,i,f,g,h,i;
	

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
		for (Barco b : barcos) {
			if (nome.equals(b.getNome())) {
				throw new BarcoInvalidoException(
						"Ja existe uma barco com nome este nome no jogo");
			}
		}

		Barco b1 = new Barco(nome, tamanho);
		barcos.add(b1);
		quantidadeBarcos++;

	}

	// addBarcoNoTabuleiro tabuleiro=1 nome="PORTA_AVIOES" l1=7 c1=4 l2=11 c2=4
	public void addBarcoNoTabuleiro(int tab, String nomeBarco, int l1, int c1,int  l2,int c2){
		this.tab = tab;
		String nome = nomeBarco;
		int tabuleiro[][] = { { l1, c1 }, { l2, c2 } };
		
		
	}
	
	
	
	// public void criarJogo(int larg, int alt) throws TamanhoInvalidoException
	// {
	// if ((largura > 0 && largura < 2) || (altura > 0 && altura < 2))
	// //System.out.println("Largura e Altura devem ser maiores que 2");
	// throw new
	// TamanhoInvalidoException("Largura e Altura devem ser maiores que 2");
	//	
	// if ((largura > 0 && largura < 2) && (altura > 0 && altura < 2))
	// //System.out.println("Largura e Altura devem ser maiores que 2");
	// throw new
	// TamanhoInvalidoException("Largura e Altura devem ser maiores que 2");
	//		
	// if ((largura == -1) || (altura < 2))
	// //System.out.println("Largura invalida: -1");
	// throw new TamanhoInvalidoException("Largura invalida: -1");
	//			
	// if ((largura == 0) || (altura < 2))
	// //System.out.println("Largura invalida: 0");
	// throw new TamanhoInvalidoException("Largura invalida: 0");
	//				
	// if ((largura < 2) && (altura == -1))
	// //System.out.println("Altura invalida: -1");
	// throw new TamanhoInvalidoException("Altura invalida: -1");
	//					
	// if ((largura < 2) && (altura == 0))
	// //System.out.println("Altura invalida: 0");
	// throw new TamanhoInvalidoException("Altura invalida: 0");
	//						
	// if ((largura == -1) && (altura == -1))
	// throw new TamanhoInvalidoException("Altura invalida: -1");
	//	
	// }



}
