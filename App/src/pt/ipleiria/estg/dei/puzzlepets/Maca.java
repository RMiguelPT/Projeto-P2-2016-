package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Maca {
	private CellRepresentation imagem;

	public Maca() {
		super();
		imagem = new SingleImageCellRepresentation("/imagens/objetivos/maca.png");
		
	}

	public CellRepresentation getImagem() {
		return imagem;
	}
		
}