package pt.ipleiria.estg.dei.puzzlepets;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class PainelPrincipal extends Painel {
	
	private Jogo jogo;
	private int quantMacasNoPainel;
	private Suporte[][] matriz;
	
	public PainelPrincipal(GridPanel grelha) {
		super(grelha);
		matriz = new Suporte [grelha.getNumberOfRows()] [grelha.getNumberOfColumns()];
		
		for (int i = 0; i< this.grelha.getNumberOfRows(); i++)
		{
			for (int j = 0; j < this.grelha.getNumberOfColumns(); j++)
			{
				
				adicionar(new SuporteAgua(this, new Posicao(i, j), grelha, new Maca()));
			}
			
		}
		
	}

	private void adicionar(Suporte suporte) {
		// TODO Auto-generated method stub
		
	}

	public void incrementarQuantMacasPainel(int quant)
	{
		
	}
	
	public void decrementarQuantMacasPainel()
	{
		
	}
	
	public void iterar(long tempo) {
		
			
		
	}
}
