package Suportes;

import Paineis.PainelPrincipal;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.OverlayCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.dei.puzzlepets.Posicao;
import pt.ipleiria.estg.dei.puzzlepets.SuportadoPorGelo;

public class SuporteGelo extends SuporteComSuportado<SuportadoPorGelo> {
	

	
	public SuporteGelo(PainelPrincipal painelPrincipal, Posicao posicao) {
		super(painelPrincipal, posicao);
		this.imagem = new SingleImageCellRepresentation("/imagens/suportes/gelo.png");
				
//		if (this.maca != null)
//		{
//			grelha.add(this.posicao.getLinha(), this.posicao.getColuna(), 
//					new OverlayCellRepresentation(imagem, maca.getImagem()));
//		}
		//grelha.repaint();
		//atualizar();
		//System.out.println("created suporteAgua coluna: " + posicao.getColuna() + "linha: " + posicao.getLinha() + "\n");
		// TODO Auto-generated constructor stub
	}


}
