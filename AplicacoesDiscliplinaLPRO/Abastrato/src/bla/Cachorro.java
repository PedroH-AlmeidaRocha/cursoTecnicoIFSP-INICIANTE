package bla;

public class Cachorro extends Animal {
    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("");
    	System.out.println(" e faz Au au!");
        
        
    }

    
   @Override
   public void comer() {
	   System.out.println("*Cachorro come ração*");
   }

@Override
protected void apresentar() {
	comer();
	emitirSom();
	
}

}

