package pt.ipleiria.estg.dei.puzzlepets;

public class Temporizador {

	private int intervalo;
	private long proximoTempo;

	public Temporizador(int intervalo) {
		this.intervalo = intervalo;
		reiniciar();
	}

	public void reiniciar() {
		proximoTempo = intervalo + System.currentTimeMillis();

	}

	public int getMilissegundosEmFalta() {
		return (int) Math.max(0, proximoTempo - System.currentTimeMillis());
	}
	
	public int getSegundowsEmFalta(){
		return (int) Math.ceil(getMilissegundosEmFalta() / 1000d);
				
	}
}
