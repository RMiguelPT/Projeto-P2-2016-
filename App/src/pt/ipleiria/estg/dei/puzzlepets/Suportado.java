package pt.ipleiria.estg.dei.puzzlepets;

public abstract class Suportado<TSuporte extends SuporteComSuportado> extends Representavel {
	
	protected TSuporte suporte;
	protected Temporizador temporizador;
	
	public Suportado() {
		super();		
		this.temporizador = new Temporizador(100);
	}
	
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
}
