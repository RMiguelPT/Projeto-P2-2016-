package Suportados;

import Interfaces.Iteravel;
import Suportes.SuporteComSuportado;
import pt.ipleiria.estg.dei.puzzlepets.Posicao;
import pt.ipleiria.estg.dei.puzzlepets.Sentido;
import pt.ipleiria.estg.dei.puzzlepets.Temporizador;

public abstract class Suportado<TSuporte extends SuporteComSuportado> extends Representavel implements Iteravel {
	
	protected TSuporte suporte;
	protected Temporizador temporizador;
	
	public Suportado() {
		super();		
		this.temporizador = new Temporizador(100);
	}
	
	@Override
	public void iterar(long millis){
		if (temporizador.getMilissegundosEmFalta() == 0){
			temporizador.reiniciar();
			if(this.suporte.suportadoPodeCair(Sentido.S)){
				this.suporte.fazerCairSuportado(Sentido.S);
			}
			
			
		}
	}
	
	public void setSuporte(TSuporte suporte){
		this.suporte = suporte;
	}
	
	public Posicao getPosicao()
	{
		return this.suporte.posicao;
	}

	public TSuporte getSuporte() {
		return suporte;
	}
	
	
}
