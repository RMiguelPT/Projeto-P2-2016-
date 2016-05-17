package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.OverlayCellRepresentation;

public class SuporteComPainel <TSuportado extends Suportado> extends Suporte {

	private TSuportado suportado;

	public SuporteComPainel(PainelPrincipal painelPrincipal, Posicao posicao, GridPanel grelha, TSuportado suportado) {
		super(painelPrincipal, posicao, grelha);
		this.suportado = suportado;
		
	}
	
	public void iterar(){
		
	}
	
	public void colocar(TSuportado suportado){
		this.suportado = suportado;
	}
	
	private void fazerCair(){
		
	}
	public void setSuportado(Suportado suportado){
		
	}
	public void libertarSuportado (){
		this.suportado = null;
	}

	public TSuportado getSuportado() {
		// TODO Auto-generated method stub
		return suportado;
	}
	
	@Override
	public CellRepresentation getImagem() {
		CellRepresentation imgSuporte= super.getImagem();
		if (suportado!=null){
			return new OverlayCellRepresentation(imgSuporte, suportado.getImagem());
		}
		return imgSuporte;
	}
}