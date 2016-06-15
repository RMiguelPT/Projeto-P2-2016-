package Poderes;

import Interfaces.Iteravel;
import Suportados.Combinavel;
import Suportados.Movivel;
import Suportados.Suportado;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.dei.puzzlepets.Sentido;
import pt.ipleiria.estg.dei.puzzlepets.TipoAnimal;

public abstract class PoderComAnimal extends Poder implements Iteravel {
	public TipoAnimal tipoAnimal;

	public PoderComAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
		
	}

	@Override
	public abstract boolean combinaCom(Combinavel combinavel);
	
	public void iterar(long millis){
		if (temporizador.getMilissegundosEmFalta() == 0) {
			temporizador.reiniciar();

			if (this.suporte.suportadoPodeCair(Sentido.S)) {
				this.suporte.fazerCairSuportado(Sentido.S);
				return;

			}		

		}
	}
	}

