package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class PainelPontuacao extends PainelValorImagem {
		
		
	public PainelPontuacao(GridPanel grelha, Jogo jogo) {
		super(grelha, "/imagens/paineis/pontuacao.png", 0, jogo);
		
	}

	public void incrementarValor(int valor)
	{
		
	}
	
	public void decrementarValor()
	{
		
	}
	
	public int getValor()
	{
		return valor;
	}
	
	public CellRepresentation getCellRepresentation()
	{
		return imagem;
	}
}
