package jogodavelha;

import java.util.Scanner;

public class JogoDaVelha {
	private char[][] jogo;
	private char round;
	private char pop = 'a';
	Scanner s = new Scanner(System.in);

	JogoDaVelha() {
		jogo = new char[3][3];

		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				jogo[linha][coluna] = pop;
				pop++;
			}
		}
	}

	public void mostraMatriz() {
		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {

				if (coluna <= 1) {
					System.out.print("\t" + jogo[linha][coluna] + " \t | ");
				} else {
					System.out.print("\t" + jogo[linha][coluna] + "\t");
				}

				if (coluna == 2 && linha < 2) {
					System.out.print("\n__________|_________|__________\n");
				}
			}
		}
		System.out.println("\n\n");
	}

	private boolean verificarLinhas(char c) {
		int coluna = 0;
		for (int linha = 0; linha < 3; linha++) {
			if (jogo[linha][coluna] == c && jogo[linha][coluna + 1] == c && jogo[linha][coluna + 2] == c) {
				return true;
			}
		}
		return false;
	}

	private boolean verificarColunas(char c) {
		int linha = 0;
		for (int coluna = 0; coluna < 3; coluna++) {
			if (jogo[linha][coluna] == c && jogo[linha + 1][coluna] == c && jogo[linha + 2][coluna] == c) {
				return true;
			}
		}
		return false;
	}

	private boolean verificarDiagonais(char c) {
		if ((jogo[0][0] == c && jogo[1][1] == c && jogo[2][2] == c)
				|| (jogo[0][2] == c) && jogo[1][1] == c && jogo[2][0] == c) {
			return true;
		}
		return false;
	}

	private boolean verificarPosicao(int linha, int coluna) {
		if (jogo[linha][coluna] == 'x' || jogo[linha][coluna] == 'o') {
			return false;
		}
		return true;
	}

	private boolean jogada(char c, char jogada) {
		char opcao = Character.toLowerCase(c);
		switch (opcao) {
		case 'a':
			if (verificarPosicao(0, 0)) {
				jogo[0][0] = jogada;
			} else {
				return false;
			}
			break;

		case 'b':

			if (verificarPosicao(0, 1)) {
				jogo[0][1] = jogada;
			} else {
				return false;
			}
			break;

		case 'c':

			if (verificarPosicao(0, 2)) {
				jogo[0][2] = jogada;
			} else {
				return false;
			}
			break;

		case 'd':

			if (verificarPosicao(1, 0)) {
				jogo[1][0] = jogada;
			} else {
				return false;
			}
			break;

		case 'e':

			if (verificarPosicao(1, 1))
				jogo[1][1] = jogada;
			else {
				return false;
			}
			break;

		case 'f':
			if (verificarPosicao(1, 2)) {
				jogo[1][2] = jogada;
			} else {
				return false;
			}
			break;

		case 'g':

			if (verificarPosicao(2, 0)) {
				jogo[2][0] = jogada;
			} else {
				return false;
			}
			break;

		case 'h':
			if (verificarPosicao(2, 1)) {

				jogo[2][1] = jogada;
			} else {
				return false;
			}
			break;

		case 'i':
			if (verificarPosicao(2, 2)) {
				jogo[2][2] = jogada;
			} else {
				return false;
			}
			break;
		default:
			return false;
		}
		return true;
	}

	public void jogo() {

		System.out.println("JOGO DA VELHA\n\n\n");
		char op;
		int chaveador = 1;
		boolean x = true, o = true,velha=true;
		while (x && o&&velha) {
			if (chaveador % 2 == 0) {
				round = 'o';
			} else {
				round = 'x';
			}
			mostraMatriz();
			System.out.print("\nJogador " + Character.toUpperCase(round) + "\nDigite a posição que deseja jogar: ");
			op = s.next().charAt(0);
			while (jogada(op, round) == false) {
				System.out.println("Posição inválida!!");
				mostraMatriz();
				System.out.print("\nJogador " + Character.toUpperCase(round) + "\nDigite a posição que deseja jogar: ");
				op = s.next().charAt(0);
			}
			chaveador++;
			x = verificarGanhador('x');
			o = verificarGanhador('o');
			velha=verificarVelha();
			limpaTela();

		}
		retirarLetras();
		if (verificarGanhador('x') == false) {
			System.out.println("\nX ganhou!!!\n");
			mostraMatriz();
			System.exit(0);
		} else if (verificarGanhador('o') == false) {
			System.out.println("\nO ganhou!!!\n");
		mostraMatriz();
		System.exit(0);}else {	System.out.println("\nDeu velha, ninguém ganhou!!!\n");
		mostraMatriz();}
	}

	private boolean verificarGanhador(char c) {

		if (verificarLinhas(c) || verificarColunas(c) || verificarDiagonais(c)) {
			return false;

		}
		return true;

	}
	
	private  void retirarLetras() {

		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				if( jogo[linha][coluna]!='x' && jogo[linha][coluna]!='o' ) {
					jogo[linha][coluna]=' ';
					
				}
			}
		}
	
		}
	
	private boolean verificarVelha() {
		int	contador=0;
			for (int linha = 0; linha < 3; linha++) {
				for (int coluna = 0; coluna < 3; coluna++) {
					if( jogo[linha][coluna]=='x' ||jogo[linha][coluna]=='o' ) {
						contador++;
						
					}
				}
			}
			if(contador>=9) {
				return false;
			}
			return true;
			
		}

public void limpaTela() {
for(int i = 0; i < 100; i++)
{
       System.out.println("");
}
}

	
	
}
