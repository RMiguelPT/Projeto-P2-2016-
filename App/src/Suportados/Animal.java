package Suportados;

import Suportes.SuporteComSuportado;
import Suportes.SuporteGelo;
import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.dei.puzzlepets.Sentido;
import pt.ipleiria.estg.dei.puzzlepets.TipoAnimal;
import Interfaces.Iteravel;

public class Animal extends Combinavel {
	private TipoAnimal tipoAnimal;
	private static final int PONTOS = 25;

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

	public boolean combinaCom(Combinavel combinavel) {
		if (combinavel instanceof Animal) {
			if (this.tipoAnimal.equals(((Animal) combinavel).tipoAnimal)) {

				return true;
			}
		}
		return false;
	}

	@Override
	public void explodir() {
		this.suporte.incrementarPontuacao(PONTOS);

		if (this.suporte instanceof SuporteGelo) {
			this.suporte.painelPrincipal.substituirPorAgua(this.suporte);
		}
		this.suporte.explodir();
	}

	public void iterar(long millis) {
		if (temporizador.getMilissegundosEmFalta() == 0) {
			temporizador.reiniciar();

			if (this.suporte.suportadoPodeCair(Sentido.S)) {
				this.suporte.fazerCairSuportado(Sentido.S);
				return;

			}
			
//			 if(this.suporte.suportadoPodeCair(Sentido.SE)) {
//				this.suporte.fazerCairSuportado(Sentido.SE);
//				this.suporte.painelPrincipal.criarCombinacoes(this, Sentido.SE);
//				return;
//			}
//			 if(this.suporte.suportadoPodeCair(Sentido.SO)) {
//				this.suporte.fazerCairSuportado(Sentido.SO);
//				this.suporte.painelPrincipal.criarCombinacoes(this, Sentido.SO);
//				return;
//			}
			
			

		}
	}

}
