package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.utils.FileHandler;

import java.awt.event.MouseEvent;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.GridPanelEventHandler;

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
		Sentido sentido = posicaoInicial.getSentido(posicaoFinal);
		trocar(posicaoInicial, sentido);
		// System.out.println(sentido.name());

	}

	private void trocar(Posicao posicaoInicial, Sentido sentido) {
		// System.out.println(""+ posicaoInicial.getLinha() +
		// posicaoInicial.getColuna()+ sentido.name() );
		Posicao posicaoDestino = posicaoInicial.seguir(sentido);
		Suportado suportadoOrigem = getSuportado(posicaoInicial);
		Suportado suportadoDestino = getSuportado(posicaoDestino);
		
		if (!(suportadoOrigem instanceof Movivel) || !(suportadoDestino instanceof Movivel)){
			return;
		}
		if (!(suportadoOrigem instanceof Combinavel && suportadoDestino instanceof Combinavel)){
			return;
		}
		trocar(suportadoOrigem, suportadoDestino, sentido);
	}
	

	private void trocar(Suportado suportadoOrigem, Suportado suportadoDestino, Sentido sentido) {
		boolean existeCombinaçãoOrigem;
		boolean existeCombinaçãoDestino;
		existeCombinaçãoOrigem = suportadoOrigem instanceof Combinavel 
				&& formaCombinacao(suportadoOrigem, sentido);
		existeCombinaçãoDestino = suportadoDestino instanceof Combinavel 
				&& formaCombinacao(suportadoDestino, sentido.getInverso());
		
		if (existeCombinaçãoOrigem){
			//TODO poder que se forma
		}
		
		
	}

	private boolean formaCombinacao(Suportado suportadoOrigem, Sentido sentido) {
		// TODO Auto-generated method stub
		return false;
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
