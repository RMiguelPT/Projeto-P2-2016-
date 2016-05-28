package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Cesto<SA extends SuporteAgua> extends Suportado {

	public Cesto(SuporteComPainel suporte) {
		super();
		imagem = new SingleImageCellRepresentation("/imagens/objetivos/cesto.png");
		this.suporte = suporte;
	}
	
	public void receberMaca(Maca maca){
		
	}

}
