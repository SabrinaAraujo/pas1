package Jogo;

import java.util.Scanner;

import Execoes.BarcoInvalidoException;
import Execoes.TamanhoInvalidoException;

public class Main {

	public static void main(String[] args) {
		Tabuleiro t = new Tabuleiro();

		Scanner s = new Scanner(System.in);
//		System.out.println("largura");
//		int l = s.nextInt();
//		System.out.println("altura");
//		int a = s.nextInt();
//
//		try {
//			t.criarJogo(l, a);
//		} catch (TamanhoInvalidoException e) {
//			System.out.println(e.getMessage());
//		}
		
		for (int i = 0; i < 3; i++) {
			System.out.println("nome do barco");
			String n = s.nextLine();
			try {
				t.addBarcoNoJogo(n, 3);
			} catch (BarcoInvalidoException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
