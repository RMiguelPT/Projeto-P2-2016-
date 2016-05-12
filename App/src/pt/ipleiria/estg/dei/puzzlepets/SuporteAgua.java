package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.OverlayCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class SuporteAgua extends Suporte {
	protected Maca maca;

	
	
	public SuporteAgua(PainelPrincipal painelPrincipal, Posicao posicao, GridPanel grelha, Maca maca) {
		super(painelPrincipal, posicao, grelha);
		this.imagem = new SingleImageCellRepresentation("/imagens/suportes/agua.png");
		this.maca = maca;
		
		if (this.maca != null)
		{
			grelha.add(this.posicao.getColuna(), this.posicao.getLinha(), 
					new OverlayCellRepresentation(imagem, maca.getImagem()));
		}
		//grelha.repaint();
		atualizar();
		//System.out.println("created suporteAgua coluna: " + posicao.getColuna() + "linha: " + posicao.getLinha() + "\n");
		// TODO Auto-generated constructor stub
		
	}
	

}
