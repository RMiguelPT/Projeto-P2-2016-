package pt.ipleiria.estg.dei.puzzlepets;

public abstract class Suportado<TSuporte extends SuporteComPainel> extends Representavel {
	
	protected TSuporte suporte;
	protected Temporizador temporizador;
	
	public Suportado() {
		super();		
		this.temporizador = new Temporizador(3000);
	}
	
	public void iterar(long millis){
		if (temporizador.getSegundowsEmFalta() == 0){
			temporizador.reiniciar();
			if(this.suporte.suportadoPodeCair(Sentido.S)){
				this.suporte.fazerCairSuportado(Sentido.S);
			}
		}
	}
	
	public void setSuporte(TSuporte suporte){
		this.suporte = suporte;
	}
}
