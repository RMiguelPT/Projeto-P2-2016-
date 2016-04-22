package pt.ipleiria.estg.dei.puzzlepets;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import pt.ipleiria.estg.dei.gridpanel.JBackgroundPanel;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;
import java.awt.Window.Type;

public class Janela extends JFrame {
	
	private PainelMovimentos painelMovimentos;

	private JPanel contentPane;
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
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		/*Criação dos paineis*/
		
		painelMovimentos = new PainelMovimentos();
		
		JBackgroundPanel backgroundPanel = new JBackgroundPanel();
		backgroundPanel.setBackgroundImage("/imagens/fundos/fundo0.png");
		contentPane.add(backgroundPanel, BorderLayout.CENTER);
		backgroundPanel.setLayout(new BorderLayout(0, 0));
		
		GridPanel gridPainelPrincipal = new GridPanel();
		gridPainelPrincipal.setNumberOfRows(8);
		gridPainelPrincipal.setNumberOfColumns(8);
		gridPainelPrincipal.setShowGridLines(true);
		backgroundPanel.add(gridPainelPrincipal, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		backgroundPanel.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		panel.setOpaque(false);
		
		GridPanel gridPainelMacas = new GridPanel();
		gridPainelMacas.setNumberOfRows(1);
		gridPainelMacas.setNumberOfColumns(1);
		gridPainelMacas.setShowGridLines(true);
		panel.add(gridPainelMacas, BorderLayout.WEST);
		
		GridPanel gridPainelMovimentosComEstrelas = new GridPanel();
		gridPainelMovimentosComEstrelas.setNumberOfRows(1);
		gridPainelMovimentosComEstrelas.setNumberOfColumns(1);
		gridPainelMovimentosComEstrelas.setShowGridLines(true);		
		panel.add(gridPainelMovimentosComEstrelas, BorderLayout.CENTER);
		
		adicionarPainelMovimentos(painelMovimentos);
		
		GridPanel gridPainelPontuacao = new GridPanel();
		gridPainelPontuacao.setNumberOfRows(1);
		gridPainelPontuacao.setNumberOfColumns(1);
		gridPainelPontuacao.setShowGridLines(true);
		panel.add(gridPainelPontuacao, BorderLayout.EAST);
		
	}


	private void adicionarPainelMovimentos(PainelMovimentos painelMovimentos2) {
		// TODO Auto-generated method stub
		
	}
	
	

}
