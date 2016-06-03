package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class PainelMovimentosEstrelas extends PainelValorImagem {

	public PainelMovimentosEstrelas(GridPanel grelha, Jogo jogo) {
		super(grelha, "/imagens/paineis/movimentos0Estrelas.png", 0, jogo);
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
