package polimorfismo.ifsp;



public class App {

	public static void main(String[] args) {
		Animal[] vetor = new Animal[4];
		vetor[0]= new Cachorro();
		vetor[1]= new Gato();		
		vetor[2]= new Vaca();
		vetor[3]= new Animal();
		emitirSom(vetor);
	}
	public static void emitirSom(Animal[] animais) {
		for (int i = 0; i <animais.length;i++)
			animais[i].emitirSom();	
	}
	
}
