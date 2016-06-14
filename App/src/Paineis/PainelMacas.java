package Paineis;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.OverlayCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.TextCellRepresentation;
import pt.ipleiria.estg.dei.puzzlepets.Jogo;

public class PainelMacas extends PainelValorImagem {
	
	
	public PainelMacas(GridPanel grelha, Jogo jogo) {
		super(grelha, "/imagens/paineis/macas.png", 0, jogo);
		
		
	}

	@Override
	public void incrementarValor(int valor) {
		this.valor+=valor;
		this.atualizar();		
	}
	

}
