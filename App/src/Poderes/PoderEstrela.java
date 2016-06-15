package Poderes;

import Suportados.Combinavel;
import Suportados.Movivel;
import Suportados.Suportado;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.dei.puzzlepets.TipoAnimal;

public class PoderEstrela extends PoderComAnimal {

	public PoderEstrela(TipoAnimal tipoAnimal) {
		super(tipoAnimal);
		if (tipoAnimal.equals(TipoAnimal.Panda)) {
			this.imagem = new SingleImageCellRepresentation("/imagens/poderes/pandaEstrela.png");
		}
		if (tipoAnimal.equals(TipoAnimal.Peixe)) {
			this.imagem = new SingleImageCellRepresentation("/imagens/poderes/peixeEstrela.png");
		}
		if (tipoAnimal.equals(TipoAnimal.Polvo)) {
			this.imagem = new SingleImageCellRepresentation("/imagens/poderes/polvoEstrela.png");
		}
		if (tipoAnimal.equals(TipoAnimal.Raposa)) {
			this.imagem = new SingleImageCellRepresentation("/imagens/poderes/RaposaEstrela.png");
		}
		if (tipoAnimal.equals(TipoAnimal.Sapo)) {
			this.imagem = new SingleImageCellRepresentation("/imagens/poderes/sapoEstrela.png");
		}
	}

	@Override
	public boolean combinaCom(Combinavel combinavel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void iterar(long millis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void explodir() {
		// TODO Auto-generated method stub
		
	}

}
