package bla;

public class App {

	public static void main(String[] args) {
		Animal [] vetor = new Animal [2];
		vetor [0] = new Gato(null);
		vetor [1] = new Cachorro(null);
		apresentar(vetor);
	
	
	}
	public static void apresentar(Animal[]animais) {
		for (int i=0;i<animais.length;i++)
		animais[i].apresentar();
	
	}
	


}
