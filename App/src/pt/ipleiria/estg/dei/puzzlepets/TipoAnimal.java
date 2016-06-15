package pt.ipleiria.estg.dei.puzzlepets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum TipoAnimal {
	Panda, Peixe, Polvo, Raposa, Sapo;

	private static final List<TipoAnimal> listaAnimais = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int tamanho = listaAnimais.size();
	private static final Random RANDOM = new Random();
	
	public static TipoAnimal getRandomAnimal()  {
	    return listaAnimais.get(RANDOM.nextInt(tamanho));
	  }

}
