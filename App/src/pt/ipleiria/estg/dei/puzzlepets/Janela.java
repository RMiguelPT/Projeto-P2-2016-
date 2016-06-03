package pt.ipleiria.estg.dei.puzzlepets;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import pt.ipleiria.estg.dei.gridpanel.JBackgroundPanel;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import java.awt.Window.Type;
import javax.swing.GroupLayout;

public class Janela extends JFrame {
	
	

	private JPanel contentPane;
	private Thread threadIteracao;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela janela = new Janela();
					janela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
		
	}


	/**
	 * Create the frame.
	 */
	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		/*Criação dos paineis*/
		
		
		JBackgroundPanel backgroundPanel = new JBackgroundPanel();
		backgroundPanel.setBackgroundImage("/imagens/fundos/fundo0.png");
		contentPane.add(backgroundPanel, BorderLayout.CENTER);
		backgroundPanel.setLayout(new BorderLayout(0, 0));
		
		GridPanel gridPainelPrincipal = new GridPanel();
		GroupLayout groupLayout_2 = (GroupLayout) gridPainelPrincipal.getLayout();
		gridPainelPrincipal.setNumberOfRows(8);
		gridPainelPrincipal.setNumberOfColumns(8);
		gridPainelPrincipal.setShowGridLines(false);
		backgroundPanel.add(gridPainelPrincipal, BorderLayout.SOUTH);
		
		GridPanel gridPainelMacas = new GridPanel();
		GroupLayout groupLayout_1 = (GroupLayout) gridPainelMacas.getLayout();
		gridPainelMacas.setRowSize(153);
		gridPainelMacas.setColumnSize(230);
		gridPainelMacas.setShowGridLines(false);
		gridPainelMacas.setNumberOfRows(1);
		gridPainelMacas.setNumberOfColumns(1);
		backgroundPanel.add(gridPainelMacas, BorderLayout.WEST);
		
				
				
		
		
		
		GridPanel gridPainelMovimentosEstrelas = new GridPanel();
		GroupLayout groupLayout = (GroupLayout) gridPainelMovimentosEstrelas.getLayout();
		gridPainelMovimentosEstrelas.setRowSize(153);
		gridPainelMovimentosEstrelas.setColumnSize(230);
		gridPainelMovimentosEstrelas.setShowGridLines(false);
		gridPainelMovimentosEstrelas.setNumberOfRows(1);
		gridPainelMovimentosEstrelas.setNumberOfColumns(1);
		backgroundPanel.add(gridPainelMovimentosEstrelas, BorderLayout.CENTER);
		
		GridPanel gridPainelPontuacao = new GridPanel();
		GroupLayout groupLayout_3 = (GroupLayout) gridPainelPontuacao.getLayout();
		gridPainelPontuacao.setRowSize(153);
		gridPainelPontuacao.setColumnSize(252);
		gridPainelPontuacao.setShowGridLines(false);
		gridPainelPontuacao.setNumberOfRows(1);
		gridPainelPontuacao.setNumberOfColumns(1);
		backgroundPanel.add(gridPainelPontuacao, BorderLayout.EAST);
		
		Jogo jogo = new Jogo(gridPainelPrincipal, gridPainelMacas, gridPainelPontuacao, gridPainelMovimentosEstrelas);
		
		threadIteracao = new Thread(){			
				public void run() {					
				while (true) {
					
						try {
							jogo.iterar(System.currentTimeMillis());
							//System.out.println("ITERAÇÃO");
							sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					
				}
			}
		};
		
		threadIteracao.start();
		
	}

	

}
