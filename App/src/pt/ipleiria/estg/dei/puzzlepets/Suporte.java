package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.OverlayCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Suporte extends Representavel {
	protected PainelPrincipal painelPrincipal;
	protected Posicao posicao;
	protected GridPanel grelha;
	
	
	
	public Suporte(PainelPrincipal painelPrincipal, Posicao posicao, GridPanel grelha) {
		super();
		this.painelPrincipal = painelPrincipal;
		this.posicao = posicao;
		this.grelha = grelha;
		
	}
	
	public Posicao getPosicao(){
		return posicao;
	}

	
}
