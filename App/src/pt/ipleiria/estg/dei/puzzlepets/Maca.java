package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Maca extends SuportadoPorGelo {

	public Maca(SuporteComSuportado suporte) {
		super();
		imagem = new SingleImageCellRepresentation("/imagens/objetivos/maca.png");
		this.suporte = suporte;
	}

//	@Override
//	public void iterar(long millis) {
//		if (temporizador.getMilissegundosEmFalta() == 0) {
//			temporizador.reiniciar();
//			if (this.suporte.suportadoPodeCair(Sentido.S)) {
//				this.suporte.fazerCairSuportado(Sentido.S);
//			}
//
//		}
//	}
}
