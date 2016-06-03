package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Cesto<SA extends SuporteAgua> extends Suportado {


	public Cesto(SuporteComSuportado suporte) {
		super();
		imagem = new SingleImageCellRepresentation("/imagens/objetivos/cesto.png");
		this.suporte = suporte;
		this.temporizador= new Temporizador(2000);
	}

	public void receberMaca(Maca maca) {
		this.imagem = new SingleImageCellRepresentation("/imagens/objetivos/cestoComMaca.png");
		this.suporte.painelPrincipal.atualizar(this.suporte, this.suporte.getPosicao());
		this.suporte.painelPrincipal.jogo.incrementarMacas();
	}
	
	@Override
	public void iterar(long millis) {
		if (temporizador.getMilissegundosEmFalta() == 0){
			temporizador.reiniciar();
				imagem = new SingleImageCellRepresentation("/imagens/objetivos/cesto.png");
				this.suporte.painelPrincipal.atualizar(this.suporte, this.suporte.getPosicao());		
			
		}
	}

}
