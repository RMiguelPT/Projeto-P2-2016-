package Paineis;

import pt.ipleiria.estg.dei.utils.FileHandler;

import java.awt.event.MouseEvent;

import Poderes.Poder;
import Poderes.PoderArcoIris;
import Poderes.PoderCruz;
import Poderes.PoderEstrela;
import Poderes.PoderHorizontal;
import Poderes.PoderVertical;
import Suportes.Suporte;
import Suportes.SuporteAgua;
import Suportes.SuporteAr;
import Suportes.SuporteComSuportado;
import Suportes.SuporteGelo;
import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.GridPanelEventHandler;
import pt.ipleiria.estg.dei.puzzlepets.Animal;
import pt.ipleiria.estg.dei.puzzlepets.Cesto;
import pt.ipleiria.estg.dei.puzzlepets.Combinavel;
import pt.ipleiria.estg.dei.puzzlepets.Jogo;
import pt.ipleiria.estg.dei.puzzlepets.Maca;
import pt.ipleiria.estg.dei.puzzlepets.Movivel;
import pt.ipleiria.estg.dei.puzzlepets.Posicao;
import pt.ipleiria.estg.dei.puzzlepets.Sentido;
import pt.ipleiria.estg.dei.puzzlepets.Suportado;
import pt.ipleiria.estg.dei.puzzlepets.TipoAnimal;

public class PainelPrincipal extends Painel implements GridPanelEventHandler {

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

	public Jogo jogo;
	private int quantMacasNoPainel;
	private Suporte[][] matriz;
	private Posicao posicaoInicial;

	private static final int NUM_LINHAS = 8;
	private static final int NUM_COLUNAS = 8;

	public PainelPrincipal(GridPanel grelha, Jogo jogo) {
		super(grelha);
		this.jogo = jogo;
		matriz = new Suporte[grelha.getNumberOfRows()][grelha.getNumberOfColumns()];

		lerFicheiro();

		grelha.setEventHandler(this);

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
					adicionarSuportadoAoSuporte(((SuporteComSuportado) suporte), segundaLetra);
				}
				atualizar(suporte, posicaoAtual);
			}
			numLinha++;
		}
	}

	private void adicionarSuportadoAoSuporte(SuporteComSuportado suporte, String segundaLetra) {
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
				if (suporte instanceof SuporteComSuportado) {
					((SuporteComSuportado) suporte).iterar(tempo);
				}
			}
		}
	}

	public void atualizar(Suporte suporte, Posicao posicao) {
		CellRepresentation imagemSuporte = suporte.getImagem();
		grelha.add(suporte.getPosicao().getLinha(), suporte.getPosicao().getColuna(), imagemSuporte);
		grelha.repaint();
	}

	private Suporte getSuporte(Posicao posicao) {
		return matriz[posicao.getLinha()][posicao.getColuna()];
	}

	public boolean podeCair(Suportado suportado, Posicao posicao, Sentido sentido) {
		if (posicao.seguir(sentido).isDentro(NUM_LINHAS, NUM_COLUNAS)) {
			return matriz[posicao.seguir(sentido).getLinha()][posicao.seguir(sentido).getColuna()]
					.podeReceberSuportado(suportado, sentido);

		}
		return false;
	}

	public void fazerCair(Suportado suportado, Posicao posicao, Sentido sentido) {
		matriz[posicao.seguir(sentido).getLinha()][posicao.seguir(sentido).getColuna()].agarrar(suportado, sentido);
	}

	@Override
	public void mouseDragged(MouseEvent arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent evt, int linha, int coluna) {
		// System.out.println("Pressionado em Linha: " + linha + " Coluna: " +
		// coluna);
		posicaoInicial = new Posicao(linha, coluna);
	}

	@Override
	public void mouseReleased(MouseEvent evt, int linha, int coluna) {
		// System.out.println("Largado em Linha: " + linha + " Coluna: " +
		// coluna);
		Posicao posicaoFinal = new Posicao(linha, coluna);
		if (posicaoFinal.isDentro(NUM_LINHAS, NUM_COLUNAS)) {
			Sentido sentido = posicaoInicial.getSentido(posicaoFinal);

			trocar(posicaoInicial, sentido);
			// System.out.println(sentido.name());
		}

	}

	private void trocar(Posicao posicaoInicial, Sentido sentido) {
		// System.out.println(""+ posicaoInicial.getLinha() +
		// posicaoInicial.getColuna()+ sentido.name() );
		Posicao posicaoDestino = posicaoInicial.seguir(sentido);
		Suportado suportadoOrigem = getSuportado(posicaoInicial);
		Suportado suportadoDestino = getSuportado(posicaoDestino);

		if (!(suportadoOrigem instanceof Movivel) || !(suportadoDestino instanceof Movivel)) {

			return;

		}
		if (!(suportadoOrigem instanceof Combinavel && suportadoDestino instanceof Combinavel)) {
			System.out.println("NAO SAO COMBINAVEIS");
			return;
		}
		trocar(suportadoOrigem, suportadoDestino, sentido);
	}

	private void trocar(Suportado suportadoOrigem, Suportado suportadoDestino, Sentido sentido) {
		boolean existeCombina��oOrigem;
		boolean existeCombina��oDestino;
		existeCombina��oOrigem = suportadoOrigem instanceof Combinavel
				&& formaCombinacao((Combinavel) suportadoOrigem, sentido);
		existeCombina��oDestino = suportadoDestino instanceof Combinavel
				&& formaCombinacao((Combinavel) suportadoDestino, sentido.getInverso());

		if (existeCombina��oOrigem) {
			Poder poder = quePoderEFormado((Combinavel) suportadoOrigem, sentido);
			if (poder != null) {
				// TODO explodir o que combinou
				System.out.println("combina��o ORIGEM COM PODER");
				// colocar(poder)
				trocar((Movivel) suportadoOrigem, (Movivel) suportadoDestino);
			} else {
				System.out.println("combina��o ORIGEM sem poder");
			}
		}
		if (existeCombina��oDestino) {
			Poder poder = quePoderEFormado((Combinavel) suportadoDestino, sentido.getInverso());
			if (poder != null) {

				// TODO explodir o que combinou
				// colocar(poder)

				System.out.println("combina��o DESTINO COM PODER");
				trocar((Movivel) suportadoOrigem, (Movivel) suportadoDestino);
			} else {
				System.out.println("combina��o DESTINO sem poder");
			}
		}

	}

	private Poder quePoderEFormado(Combinavel suportado, Sentido sentido) {
		int mesmoSentido = contarCombinaveis(suportado, sentido);
		int ortogonal = contarCombinaveis(suportado, sentido.getOrtogonal());
		int inverso = contarCombinaveis(suportado, sentido.getInverso());

		if (ortogonal == 2 && inverso == 2) {
			return new PoderArcoIris();
		}

		if (mesmoSentido == 2 && ortogonal >= 1 && inverso >= 1) {
			return new PoderEstrela(TipoAnimal.Panda);
		}
		if (mesmoSentido == 2 && (ortogonal == 2 || inverso == 2)) {
			return new PoderCruz(TipoAnimal.Panda);
		}
		if ((ortogonal + inverso) == 3) {
			if (sentido.isHorizontal()) {
				return new PoderHorizontal(TipoAnimal.Panda);
			} else {
				return new PoderVertical(TipoAnimal.Panda);
			}
		}

		return null;
	}

	private void trocar(Movivel movivelOrigem, Movivel movivelDestino) {
		Suporte suporteOrigem = movivelOrigem.getSuporte();
		Suporte suporteDestino = movivelDestino.getSuporte();

		((SuporteComSuportado) suporteOrigem).colocar(movivelDestino);
		((SuporteComSuportado) suporteDestino).colocar(movivelOrigem);

	}

	private boolean formaCombinacao(Combinavel combinavel, Sentido sentido) {
		if (contarCombinaveis(combinavel, sentido) >= 2) {
			return true;
		}
		return (contarCombinaveis(combinavel, sentido.getOrtogonal())
				+ contarCombinaveis(combinavel, sentido.getOrtogonal().getInverso()) >= 2);
	}

	private int contarCombinaveis(Combinavel combinavel, Sentido sentido) {
		Posicao posicaoAtual = combinavel.getPosicao();
		int contador = 0;
		do {
			posicaoAtual = posicaoAtual.seguir(sentido);
			if (getSuportado(posicaoAtual) instanceof Combinavel) {
				if (combinavel.combinaCom(getSuportado(posicaoAtual))) {
					contador++;
				}
			}
		} while (combinavel != null);
		return contador;
	}

	private Suportado getSuportado(Posicao posicao) {
		Suporte suporte = null;
		if (posicao.isDentro(NUM_LINHAS, NUM_COLUNAS)) {
			suporte = getSuporte(posicao);

			if (suporte != null && suporte instanceof SuporteComSuportado) {
				return ((SuporteComSuportado) suporte).getSuportado();
			}
		}
		return null;
	}

}
