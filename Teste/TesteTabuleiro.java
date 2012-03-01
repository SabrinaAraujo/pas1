import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import Execoes.BarcoInvalidoException;
import Execoes.TamanhoInvalidoException;
import Jogo.Barco;
import Jogo.Tabuleiro;

public class TesteTabuleiro {

	Tabuleiro t;
	int[][] tabuleiro = new int[0][0];

	@Before
	public void setUp() {
		t = new Tabuleiro();
	}

	@Test
	public void testQuantidadebarcos() {
		t.setQuantidadeBarcos(0);
		assertEquals(0, t.getQuantidadebarcos());
	}

	@Test
	public void testCriarJogo1() throws TamanhoInvalidoException {
		t.criarJogo(20, 10);
		assertEquals(20, t.getLarguraTabuleiro());
		assertEquals(10, t.getAlturaTabuleiro());
		tabuleiro = new int[20][10];
	}

	@Test
	public void testeCriarJogo2() {

		try {
			t.criarJogo(2, 3);
			fail("Deveria ter lancado uma execao");
		} catch (TamanhoInvalidoException e) {
			assertEquals("Largura e Altura devem ser maiores que 2", e
					.getMessage());
		}

		try {
			t.criarJogo(3, 2);
			fail("Deveria ter lancado uma execao");
		} catch (TamanhoInvalidoException e) {
			assertEquals("Largura e Altura devem ser maiores que 2", e
					.getMessage());
		}

		try {
			t.criarJogo(-1, 15);
			fail("Deveria ter lancado uma execao");
		} catch (TamanhoInvalidoException e) {
			assertEquals("Largura invalida: ", e.getMessage());
		}

		try {
			t.criarJogo(0, 15);
			fail("Deveria ter lancado uma execao");
		} catch (TamanhoInvalidoException e) {
			assertEquals("Largura invalida: ", e.getMessage());
		}

		try {
			t.criarJogo(15, -1);
			fail("Deveria ter lancado uma execao");
		} catch (TamanhoInvalidoException e) {
			assertEquals("Altura invalida: ", e.getMessage());
		}

		try {
			t.criarJogo(15, 0);
			fail("Deveria ter lancado uma execao");
		} catch (TamanhoInvalidoException e) {
			assertEquals("Altura invalida: ", e.getMessage());
		}

		try {
			t.criarJogo(-1, -1);
			fail("Deveria ter lancado uma execao");
		} catch (TamanhoInvalidoException e) {
			assertEquals("Largura invalida: ", e.getMessage());
		}

	}

	@Test
	public void testeAddBarcoNoJogo1() {
		try {
			t.addBarcoNoJogo("", 3);
			fail("Deveria ter lancado uma execao");
		} catch (BarcoInvalidoException e) {
			assertEquals("Nome invalido", e.getMessage());
		}

		try {
			t.addBarcoNoJogo("BARCO_GRANDE", 21);
			fail("Deveria ter lancado uma execao");
		} catch (BarcoInvalidoException e) {
			assertEquals("Barco nao cabe no tabuleiro", e.getMessage());
		}

		try {
			t.addBarcoNoJogo("BARCO_GRANDE", 15);
			t.addBarcoNoJogo("BARCO_GRANDE", 15);
			assertEquals(2, t.getQuantidadebarcos());
		} catch (BarcoInvalidoException e) {
			assertEquals("Ja existe uma barco com nome este nome no jogo", e
					.getMessage());
		}

		try {
			t.addBarcoNoJogo("BARCO_GRANDE", 0);
			fail("Deveria ter lancado uma execao");
		} catch (BarcoInvalidoException e) {
			assertEquals("Tamanho de embarcacao invalido", e.getMessage());
		}

		try {
			t.addBarcoNoJogo("BARCO_GRANDE", -1);
			fail("Deveria ter lancado uma execao");
		} catch (BarcoInvalidoException e) {
			assertEquals("Tamanho de embarcacao invalido", e.getMessage());
		}
	}

	@Test
	public void testeAddBarcoNoJogo2() {
		try {
			t.addBarcoNoJogo("BARCO_GRANDE", 15);
			t.addBarcoNoJogo("LANCHA", 3);
			assertEquals(2, t.getQuantidadebarcos());
		} catch (BarcoInvalidoException e) {
			assertEquals("Ja existe uma barco com nome este nome no jogo", e.getMessage());
		}
	}

	// addBarcoNoTabuleiro tabuleiro=1 nome="PORTA_AVIOES" l1=7 c1=4 l2=11 c2=4
	@Ignore
	public void addBarcoNoTabuleiro() throws BarcoInvalidoException {

		int tab = 1;
		t.addBarcoNoJogo("PORTA_AVIOES", 4);
		int tabuleiro[][] = { { 7, 4 }, { 11, 4 } };
		//assertEquals(7, t.getLinha() );
	}

}
