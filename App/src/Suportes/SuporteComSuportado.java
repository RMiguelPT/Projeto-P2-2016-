package Suportes;

import Paineis.PainelPrincipal;
import Suportados.Animal;
import Suportados.Cesto;
import Suportados.Combinavel;
import Suportados.Maca;
import Suportados.Suportado;
import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.OverlayCellRepresentation;
import pt.ipleiria.estg.dei.puzzlepets.Posicao;
import pt.ipleiria.estg.dei.puzzlepets.Sentido;
import pt.ipleiria.estg.dei.puzzlepets.Temporizador;

public class SuporteComSuportado<TSuportado extends Suportado> extends Suporte {

	protected TSuportado suportado;
	protected Temporizador temporizador;

	public SuporteComSuportado(PainelPrincipal painelPrincipal, Posicao posicao) {
		super(painelPrincipal, posicao);
		this.temporizador = new Temporizador(1000);
	}

	public void iterar(long tempo) {
		if (this.suportado != null) {
			this.suportado.iterar(tempo);
		}

	}

	public void colocar(TSuportado suportado) {
		this.suportado = suportado;
		this.suportado.setSuporte(this);
		painelPrincipal.atualizar(this, this.posicao);
	}

	public void fazerCairSuportado(Sentido sentido) {

		painelPrincipal.fazerCair(suportado, this.posicao, sentido);
		libertarSuportado();
		painelPrincipal.atualizar(this, this.posicao);

	}

	public void libertarSuportado() {
		this.suportado = null;
	}

	@Override
	public CellRepresentation getImagem() {
		CellRepresentation imgSuporte = super.getImagem();
		if (suportado != null) {
			return new OverlayCellRepresentation(imgSuporte, suportado.getImagem());
		}
		return imgSuporte;
	}

	public boolean suportadoPodeCair(Sentido sentido) {
		return painelPrincipal.podeCair(this.suportado, this.posicao, sentido);
	}

	@Override
	public boolean podeReceberSuportado(Suportado<?> suportado, Sentido sentido) {
		if (this.suportado == null || (this.suportado instanceof Cesto && suportado instanceof Maca)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void agarrar(Suportado suportado, Sentido sentido) {

		if (suportado instanceof Maca && this.suportado instanceof Cesto) {
			((Cesto) this.suportado).receberMaca((Maca) suportado);

		} else {
			colocar((TSuportado) suportado);
			if (suportado instanceof Combinavel){
				painelPrincipal.criarCombinacoes((Combinavel)suportado, sentido);
			}
			
		}
	}
	
	public Suportado getSuportado(){
		return this.suportado;
	}

	public void explodir() {
		this.suportado = null;
		this.painelPrincipal.atualizar(this, this.posicao);
		
	}

	public void incrementarPontuacao(int pontos) {
		this.painelPrincipal.incrementarPontuacao(pontos);
		
	}

}