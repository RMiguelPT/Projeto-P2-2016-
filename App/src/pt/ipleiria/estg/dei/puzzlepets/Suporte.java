package pt.ipleiria.estg.dei.puzzlepets;


import pt.ipleiria.estg.dei.gridpanel.GridPanel;


public class Suporte extends Representavel {
	protected PainelPrincipal painelPrincipal;
	protected Posicao posicao;
	
	
	
	
	public Suporte(PainelPrincipal painelPrincipal, Posicao posicao) {
		super();
		this.painelPrincipal = painelPrincipal;
		this.posicao = posicao;
		
	}
	
	public Posicao getPosicao(){
		return posicao;
	}

	public boolean podeReceberSuportado(Suportado<?> suportado, Sentido sentido){
		return true;
	}
	
}
