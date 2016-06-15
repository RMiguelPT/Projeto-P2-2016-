package Suportes;

import Paineis.PainelPrincipal;
import Suportados.Maca;
import Suportados.Suportado;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.OverlayCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.dei.puzzlepets.Posicao;
import pt.ipleiria.estg.dei.puzzlepets.Sentido;

public class SuporteAr extends Suporte {
	protected Maca maca;

	public SuporteAr(PainelPrincipal painelPrincipal, Posicao posicao) {
		super(painelPrincipal, posicao);
		this.imagem = new SingleImageCellRepresentation("/imagens/suportes/ar.png");
		
	}
	

	@Override
	public boolean podeReceberSuportado(Suportado<?> suportado, Sentido sentido){
		return sentido == Sentido.S && painelPrincipal.podeCair(suportado, posicao, Sentido.S);
	}
	
	@Override
	public void agarrar(Suportado suportado, Sentido sentido) {
		painelPrincipal.fazerCair(suportado, posicao, sentido);
	}
}
