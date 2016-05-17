package pt.ipleiria.estg.dei.puzzlepets;
import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Animal extends SuportadoPorGelo {
	private TipoAnimal tipoAnimal;

	public Animal(String tipo) {
		super();
		//this.imagem = new SingleImageCellRepresentation("/imagens/animais/panda.png");
		if (tipo.equals(PainelPrincipal.PANDA)) {
			this.imagem = new SingleImageCellRepresentation("/imagens/animais/panda.png");
			this.tipoAnimal = TipoAnimal.Panda;
		}
		if (tipo.equals(PainelPrincipal.PEIXE)) {
			this.imagem = new SingleImageCellRepresentation("/imagens/animais/peixe.png");
			this.tipoAnimal = TipoAnimal.Peixe;
		}
		if (tipo.equals(PainelPrincipal.POLVO)) {
			this.imagem = new SingleImageCellRepresentation("/imagens/animais/polvo.png");
		this.tipoAnimal = TipoAnimal.Polvo;
		}
		if (tipo.equals(PainelPrincipal.RAPOSA)){
			this.imagem = new SingleImageCellRepresentation("/imagens/animais/raposa.png");
			this.tipoAnimal = TipoAnimal.Raposa;
		}
		if (tipo.equals(PainelPrincipal.SAPO)){
			this.imagem = new SingleImageCellRepresentation("/imagens/animais/sapo.png");
			this.tipoAnimal = TipoAnimal.Sapo;
		}
		
		
		
	}
	
}
