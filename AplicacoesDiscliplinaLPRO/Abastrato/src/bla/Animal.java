package bla;

public abstract class Animal {
    private String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract void emitirSom(); // Método abstrato

    public void comer() { // Método concreto
        System.out.println("Comendo...");
    }

	protected abstract void apresentar();
	

}