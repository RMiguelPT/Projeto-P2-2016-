package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Animal extends SuportadoPorGelo {
	private TipoAnimal tipoAnimal;

	public Animal(TipoAnimal tipo, SuporteComPainel suporte) {
		super();
		// this.imagem = new
		// SingleImageCellRepresentation("/imagens/animais/panda.png");

		this.imagem = new SingleImageCellRepresentation("/imagens/animais/panda.png");
		this.tipoAnimal = tipo;
		this.suporte = suporte;

	}

}
