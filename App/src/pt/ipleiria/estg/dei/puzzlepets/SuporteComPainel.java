package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.OverlayCellRepresentation;

public class SuporteComPainel <TSuportado extends Suportado> extends Suporte {

	private TSuportado suportado;
	private Temporizador temporizador;

	public SuporteComPainel(PainelPrincipal painelPrincipal, Posicao posicao) {
		super(painelPrincipal, posicao);
		this.temporizador = new Temporizador(1000);
	}
	
	public void iterar(long tempo){
		if (this.suportado != null){
			this.suportado.iterar(tempo);
		}
		
	}
	
	public void colocar(TSuportado suportado){
		this.suportado = suportado;
	}
	
	public void fazerCairSuportado(Sentido sentido){
		//System.out.println("Cair");
		
		painelPrincipal.fazerCair(suportado, this.posicao, sentido);
		libertarSuportado();
		painelPrincipal.atualizar(this, this.posicao);
		
	}

	public void libertarSuportado (){
		this.suportado = null;
	}

	@Override
	public CellRepresentation getImagem() {
		CellRepresentation imgSuporte= super.getImagem();
		if (suportado!=null){
			return new OverlayCellRepresentation(imgSuporte, suportado.getImagem());
		}
		return imgSuporte;
	}
	
	public boolean suportadoPodeCair(Sentido sentido){
		return painelPrincipal.podeCair(this.suportado,this.posicao,sentido);
	}

	@Override
	public boolean podeReceberSuportado(Suportado<?> suportado, Sentido sentido){
		return this.suportado == null ? true : false;
	}
	
	
}