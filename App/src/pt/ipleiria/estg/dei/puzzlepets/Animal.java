package pt.ipleiria.estg.dei.puzzlepets;

import Suportes.SuporteComSuportado;
import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import Interfaces.Combinavel;
import Interfaces.Iteravel;

public class Animal extends SuportadoPorGelo  {
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
	public boolean combinaCom(Suportado suportado){
		if (suportado instanceof Animal){
			if (this.tipoAnimal.equals(((Animal)suportado).tipoAnimal)){
				return true;
			}
		}
		return false;
		
	}

}
