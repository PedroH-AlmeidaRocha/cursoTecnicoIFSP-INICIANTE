package bla;

public class Gato extends Animal {
    public Gato(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("");
    	System.out.println("e faz Miau!");
    	System.out.println("===========");
    }

    @Override
    public void comer() {
 	   System.out.println("Gato come  Peixe...*");
    }

	@Override
	protected void apresentar() {
		comer();
		emitirSom();
		
	}


}


