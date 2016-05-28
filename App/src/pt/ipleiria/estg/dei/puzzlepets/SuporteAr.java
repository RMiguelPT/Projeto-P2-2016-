package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.OverlayCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class SuporteAr extends Suporte {
	protected Maca maca;

	public SuporteAr(PainelPrincipal painelPrincipal, Posicao posicao) {
		super(painelPrincipal, posicao);
		this.imagem = new SingleImageCellRepresentation("/imagens/suportes/ar.png");
		
	}

}
