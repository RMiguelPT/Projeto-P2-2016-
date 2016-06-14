package Poderes;

import Interfaces.Combinavel;
import Interfaces.Iteravel;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.dei.puzzlepets.Suportado;
import pt.ipleiria.estg.dei.puzzlepets.TipoAnimal;

public abstract class PoderComAnimal extends Poder implements Combinavel, Iteravel {
	public TipoAnimal tipoAnimal;

	public PoderComAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
		
	}

	@Override
	public abstract boolean combinaCom(Suportado suportado);

}
