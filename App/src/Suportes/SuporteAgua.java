package Suportes;

import Paineis.PainelPrincipal;
import Suportados.Cesto;
import Suportados.Suportado;
import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.OverlayCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.dei.puzzlepets.Posicao;

public class SuporteAgua extends SuporteComSuportado<Suportado> {
	

	
	public SuporteAgua(PainelPrincipal painelPrincipal, Posicao posicao) {
		super(painelPrincipal, posicao);
		this.imagem = new SingleImageCellRepresentation("/imagens/suportes/agua.png");
	}
	
	public void colocarCesto(Cesto cesto){
		
	}
	
//	@Override
//	public boolean podeReceberSuportado(Suportado<?> suportado, Sentido sentido) {
//		if (this.suportado == null){
//			return true;
//		}
//		else if (this.suportado instanceof Cesto){
//			return ((Cesto)this.suportado).podeReceberMaca();
//		}
//		return false;
//	}
	
//	@Override
//	public void agarrar(Suportado suportado, Sentido sentido) {
//		if (suportado instanceof Maca && this.suportado instanceof Cesto){
//			((Cesto)suportado).receberMaca((Maca)suportado);
//		}
//	}
	

}
