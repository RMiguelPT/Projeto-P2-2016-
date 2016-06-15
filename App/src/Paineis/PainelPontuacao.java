package Paineis;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.puzzlepets.Jogo;

public class PainelPontuacao extends PainelValorImagem {
		
		
	public PainelPontuacao(GridPanel grelha, Jogo jogo) {
		super(grelha, "/imagens/paineis/pontuacao.png", 0, jogo);
		
	}

	@Override
	public void incrementarValor(int valor) {
		//System.out.println(this.valor);
		this.valor += valor;
		this.atualizar();		
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
