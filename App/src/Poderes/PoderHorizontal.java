package Poderes;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.dei.puzzlepets.Combinavel;
import pt.ipleiria.estg.dei.puzzlepets.Suportado;
import pt.ipleiria.estg.dei.puzzlepets.TipoAnimal;

public class PoderHorizontal extends PoderComAnimal {
	private TipoAnimal tipo;

	public PoderHorizontal(TipoAnimal tipoAnimal) {
		super(tipoAnimal);
		if (tipoAnimal.equals(TipoAnimal.Panda)) {
			this.imagem = new SingleImageCellRepresentation("/imagens/poderes/pandaHorizontal.png");
		}
		if (tipoAnimal.equals(TipoAnimal.Peixe)) {
			this.imagem = new SingleImageCellRepresentation("/imagens/poderes/peixeHorizontal.png");
		}
		if (tipoAnimal.equals(TipoAnimal.Polvo)) {
			this.imagem = new SingleImageCellRepresentation("/imagens/poderes/polvoHorizontal.png");
		}
		if (tipoAnimal.equals(TipoAnimal.Raposa)) {
			this.imagem = new SingleImageCellRepresentation("/imagens/poderes/RaposaHorizontal.png");
		}
		if (tipoAnimal.equals(TipoAnimal.Sapo)) {
			this.imagem = new SingleImageCellRepresentation("/imagens/poderes/sapoHorizontal.png");
		}
	}

	@Override
	public boolean combinaCom(Suportado suportado) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void iterar(long millis) {
		// TODO Auto-generated method stub
		
	}
	

}
