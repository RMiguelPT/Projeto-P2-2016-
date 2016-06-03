package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Animal extends SuportadoPorGelo {
	private TipoAnimal tipoAnimal;

	public Animal(TipoAnimal tipo, SuporteComSuportado suporte) {
		super();

		this.tipoAnimal = tipo;

		if (this.tipoAnimal.equals(TipoAnimal.Panda)) {
			this.imagem = new SingleImageCellRepresentation("/imagens/animais/panda.png");
		}
		if (this.tipoAnimal.equals(TipoAnimal.Peixe)) {
			this.imagem = new SingleImageCellRepresentation("/imagens/animais/peixe.png");
		}
		if (this.tipoAnimal.equals(TipoAnimal.Polvo)) {
			this.imagem = new SingleImageCellRepresentation("/imagens/animais/polvo.png");
		}
		if (this.tipoAnimal.equals(TipoAnimal.Raposa)) {
			this.imagem = new SingleImageCellRepresentation("/imagens/animais/raposa.png");
		}
		if (this.tipoAnimal.equals(TipoAnimal.Sapo)) {
			this.imagem = new SingleImageCellRepresentation("/imagens/animais/sapo.png");
		}
		this.suporte = suporte;

	}

}
