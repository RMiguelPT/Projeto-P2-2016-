package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.OverlayCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class SuporteAgua extends SuporteComPainel<Suportado> {
	

	
	public SuporteAgua(PainelPrincipal painelPrincipal, Posicao posicao, GridPanel grelha, Suportado suportado) {
		super(painelPrincipal, posicao, grelha, suportado);
		this.imagem = new SingleImageCellRepresentation("/imagens/suportes/agua.png");
	}
	

}
