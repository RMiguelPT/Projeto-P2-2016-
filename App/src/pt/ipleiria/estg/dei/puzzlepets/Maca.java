package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Maca extends SuportadoPorGelo {


	public Maca(SuporteComPainel suporte) {
		super();
		imagem = new SingleImageCellRepresentation("/imagens/objetivos/maca.png");
		this.suporte = suporte;
	}

		
}
