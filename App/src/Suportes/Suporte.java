package Suportes;


import Paineis.PainelPrincipal;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.puzzlepets.Posicao;
import pt.ipleiria.estg.dei.puzzlepets.Representavel;
import pt.ipleiria.estg.dei.puzzlepets.Sentido;
import pt.ipleiria.estg.dei.puzzlepets.Suportado;


public abstract class Suporte extends Representavel {
	public PainelPrincipal painelPrincipal;
	public Posicao posicao;
	
	
	
	
	public Suporte(PainelPrincipal painelPrincipal, Posicao posicao) {
		super();
		this.painelPrincipal = painelPrincipal;
		this.posicao = posicao;
		
	}
	
	public Posicao getPosicao(){
		return posicao;
	}

	public abstract boolean podeReceberSuportado(Suportado<?> suportado, Sentido sentido);

	public abstract void agarrar(Suportado suportado, Sentido sentido);
	
}
