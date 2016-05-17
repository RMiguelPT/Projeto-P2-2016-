package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.utils.FileHandler;

import java.util.LinkedList;

import javax.print.DocFlavor.STRING;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class PainelPrincipal extends Painel {

	/*---------SUPORTES-----------*/
	private static final String AGUA = "A";
	private static final String AR = "a";
	private static final String GELO = "G";

	/*---------ANIMAIS-----------*/
	public static final String POLVO = "O";
	public static final String RAPOSA = "R";
	public static final String PEIXE = "F";
	public static final String PANDA = "P";
	public static final String SAPO = "S";

	/*--------MACAS & CESTOS---------*/

	public static final String MACA = "M";
	public static final String CESTO = "C";

	private Jogo jogo;
	private int quantMacasNoPainel;
	private Suporte[][] matriz;

	public PainelPrincipal(GridPanel grelha) {
		super(grelha);

		matriz = new Suporte[grelha.getNumberOfRows()][grelha.getNumberOfColumns()];

		lerFicheiro();

	}

	private void lerFicheiro() {
		FileHandler handler = new FileHandler("/ficheiroNivel.txt");
		String conteudo = handler.readFile();

		String colunas[];
		int numLinha = 0;
		for (String linha : conteudo.split("\n")) {
			colunas = linha.split(" ");
			for (int coluna = 0; coluna < colunas.length; coluna++) {
				String primeiraLetra = colunas[coluna].substring(0, 1);
				String segundaLetra = colunas[coluna].substring(1, 2);

				if (primeiraLetra.equals(AGUA)) {
					if (segundaLetra.equals(MACA)) {
						adicionar(new SuporteAgua(this, new Posicao(numLinha, coluna), grelha, new Maca()));
					} else if (segundaLetra.equals(CESTO)) {
						adicionar(new SuporteAgua(this, new Posicao(numLinha, coluna), grelha, new Cesto()));
					} else {
						adicionar(
								new SuporteAgua(this, new Posicao(numLinha, coluna), grelha, 
										new Animal(segundaLetra)));
					}

				}
				if (primeiraLetra.equals(AR)) {
					adicionar(new SuporteAr(this, new Posicao(numLinha, coluna), grelha, null));
				}
				if (primeiraLetra.equals(GELO)) {
					if (segundaLetra.equals(MACA)) {
						adicionar(new SuporteGelo(this, new Posicao(numLinha, coluna), grelha, new Maca()));
					}

					else {
						adicionar(
								new SuporteGelo(this, new Posicao(numLinha, coluna), grelha, 
										new Animal(segundaLetra)));
					}
				}
			}
			numLinha++;
		}
	}

	private void adicionar(Suporte suporte) {
		
		matriz[suporte.getPosicao().getLinha()][suporte.getPosicao().getColuna()] = suporte;
		CellRepresentation imagemSuporte = suporte.getImagem();
		grelha.add(suporte.getPosicao().getLinha(), suporte.getPosicao().getColuna(), imagemSuporte);
		grelha.repaint();
	}

	private void atualizar(Posicao posicao) {

	}

	private void substituirPorAgua(SuporteGelo gelo) {

	}

	public void iterar(long tempo) {
		
	}

	private Suporte getSuporte(Posicao posicao) {
		return null;
	}
	

}
