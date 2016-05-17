package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.OverlayCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class SuporteAr extends Suporte {
	protected Maca maca;

	public SuporteAr(PainelPrincipal painelPrincipal, Posicao posicao, GridPanel grelha, Maca maca) {
		super(painelPrincipal, posicao, grelha);
		this.imagem = new SingleImageCellRepresentation("/imagens/suportes/ar.png");
		this.maca = maca;
		
		if (this.maca != null)
		{
			grelha.add(this.posicao.getLinha(), this.posicao.getColuna(), 
					new OverlayCellRepresentation(imagem, maca.getImagem()));
			
		}
		
	}

}
