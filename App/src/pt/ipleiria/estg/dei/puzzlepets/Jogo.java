package pt.ipleiria.estg.dei.puzzlepets;

import java.awt.EventQueue;

import Paineis.Painel;
import Paineis.PainelMacas;
import Paineis.PainelMovimentosEstrelas;
import Paineis.PainelPontuacao;
import Paineis.PainelPrincipal;
import Paineis.PainelValorImagem;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class Jogo {
	private Painel painelPrincipal;
	private PainelValorImagem painelMacas;
	private PainelPontuacao painelPontuacao;
	private PainelMovimentosEstrelas painelMovimentosEstrelas;
	

	
	public Jogo(GridPanel gridPainelPrincipal, GridPanel gridPainelMacas, GridPanel gridPainelPontuacao,
			GridPanel gridPainelMovimentosEstrelas) {
		super();
		 painelPrincipal =  new PainelPrincipal(gridPainelPrincipal, this);
		 painelMacas = new PainelMacas(gridPainelMacas, this);
		 painelPontuacao = new PainelPontuacao(gridPainelPontuacao, this);
		 painelMovimentosEstrelas = new PainelMovimentosEstrelas(gridPainelMovimentosEstrelas, this);
	}

	public void incrementarPontuacao(int pontos)
	{
		this.painelPontuacao.incrementarValor(pontos);
	}
	
	public void decrementarMacas()
	{
		// 1 em 1
	}
	
	public void incrementarMacas()
	{
		this.painelMacas.incrementarValor(1);
	}
	
	public void incrementarMovimentos(int quant)
	{
		
	}
	
	public void decrementarMovimentos()
	{
		
	}

	public void iterar(long tempo) {
		((PainelPrincipal) painelPrincipal).iterar(tempo);
		
	}
}
