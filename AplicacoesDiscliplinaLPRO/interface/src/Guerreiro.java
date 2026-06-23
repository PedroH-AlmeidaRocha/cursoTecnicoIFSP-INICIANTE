import java.util.Random;

public class Guerreiro extends Personagem{

	@Override 
	public int atacar() {
		return new Random().nextInt(20)+super.ataque;
	}

	@Override
	public int defeder() {
		return new Random().nextInt(35)+super.defesa;
	}

	
}
