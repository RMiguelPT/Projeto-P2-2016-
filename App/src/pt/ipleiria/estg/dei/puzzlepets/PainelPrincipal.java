package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.utils.FileHandler;
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
				Posicao posicaoAtual = new Posicao(numLinha, coluna);
				Suporte suporte = null;

				if (primeiraLetra.equals(AGUA)) {
					adicionarSuporte(new SuporteAgua(this, posicaoAtual));
					suporte = getSuporte(posicaoAtual);
				}
				if (primeiraLetra.equals(AR)) {
					adicionarSuporte(new SuporteAr(this, posicaoAtual));
					suporte = getSuporte(posicaoAtual);
				}
				if (primeiraLetra.equals(GELO)) {
					adicionarSuporte(new SuporteGelo(this, posicaoAtual));
					suporte = getSuporte(posicaoAtual);
				}

				if (!(suporte instanceof SuporteAr)) {
					adicionarSuportadoAoSuporte(((SuporteComPainel) suporte), segundaLetra);
				}
				atualizar(suporte, posicaoAtual);
			}
			numLinha++;
		}
	}

	private void adicionarSuportadoAoSuporte(SuporteComPainel suporte, String segundaLetra) {
		if (segundaLetra.equals(POLVO)) {
			suporte.colocar(new Animal(TipoAnimal.Polvo, suporte));
		}
		if (segundaLetra.equals(RAPOSA)) {
			suporte.colocar(new Animal(TipoAnimal.Raposa, suporte));

		}
		if (segundaLetra.equals(PEIXE)) {
			suporte.colocar(new Animal(TipoAnimal.Peixe, suporte));
		}
		if (segundaLetra.equals(PANDA)) {
			suporte.colocar(new Animal(TipoAnimal.Panda, suporte));
		}
		if (segundaLetra.equals(SAPO)) {
			suporte.colocar(new Animal(TipoAnimal.Sapo, suporte));
		}
		if (segundaLetra.equals(MACA)) {
			suporte.colocar(new Maca(suporte));
		}
		if (segundaLetra.equals(CESTO)) {
			suporte.colocar(new Cesto(suporte));
		}

	}

	private void adicionarSuporte(Suporte suporte) {
		matriz[suporte.getPosicao().getLinha()][suporte.getPosicao().getColuna()] = suporte;
	}
	
	

	private void substituirPorAgua(SuporteGelo gelo) {

	}

	public void iterar(long tempo) {
		for (Suporte[] linhaSuporte : matriz) {
			for (Suporte suporte : linhaSuporte) {
				if (suporte instanceof SuporteComPainel) {
					((SuporteComPainel) suporte).iterar(tempo);
				}
			}
		}
	}

	private void atualizar(Suporte suporte, Posicao posicao) {
		CellRepresentation imagemSuporte = suporte.getImagem();
		grelha.add(suporte.getPosicao().getLinha(), suporte.getPosicao().getColuna(), imagemSuporte);
		grelha.repaint();
	}

	private Suporte getSuporte(Posicao posicao) {
		return matriz[posicao.getLinha()][posicao.getColuna()];
	}

	public boolean podeCair(Suportado suportado, Posicao posicao, Sentido sentido) {
		return matriz[posicao.seguir(sentido).getLinha()][posicao.seguir(sentido).getColuna()]
				.podeReceberSuportado(suportado, sentido);
	}

	public void fazerCair(Suportado suportado, Posicao posicao, Sentido sentido) {
		// matriz[posicao.seguir(sentido).getLinha()][posicao.seguir(sentido).getColuna()].

	}
}
