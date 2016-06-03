package pt.ipleiria.estg.dei.puzzlepets;

import java.awt.Font;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import pt.ipleiria.estg.dei.gridpanel.OverlayCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.TextCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.TextCellRepresentation.HorizontalAlignment;
import pt.ipleiria.estg.dei.gridpanel.TextCellRepresentation.VerticalAlignment;

public abstract class PainelValorImagem extends Painel {

	protected CellRepresentation imagem;
	protected TextCellRepresentation texto;
	protected int valor;
	protected Jogo jogo;
	
	public PainelValorImagem(GridPanel grelha, String imagem, int valor, Jogo jogo) {
		super(grelha);
		this.valor=valor;
		this.imagem = new SingleImageCellRepresentation(imagem);
		texto = new TextCellRepresentation("" + valor);
		texto.setVerticalAlignment(VerticalAlignment.CENTER);
		texto.setHorizontalAlignment(HorizontalAlignment.CENTER);
		texto.setTextFont(new Font("Times New Roman", 1, 80));
		this.jogo = jogo;
		
		atualizar();
	}

	public abstract void incrementarValor(int valor);

	public void decrementarValor() {
		
	}

	public int getValor() {
		return valor;
	}

	public CellRepresentation getCellRepresentation() {
		return imagem;
	}
	
	protected void atualizar() {	
		texto.setText("" + valor);
		grelha.add(0,0,new OverlayCellRepresentation(imagem, texto));
		grelha.repaint();
	}

}