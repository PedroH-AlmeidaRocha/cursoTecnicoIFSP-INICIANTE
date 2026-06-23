import java.util.Random;

public abstract class Personagem implements IAcao{

	private String nome;
	private int nivel;
	protected int ataque;
	protected int defesa;
	
	@Override
	public int movimentar() {
		return new Random().nextInt(3);
	}
	
	@Override
	public String apresentar() {
		return "Nome :"+nome+" nivel:"+nivel+" ataque:"+ataque+" defesa:"+defesa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDefesa() {
		return defesa;
	}
	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}
	
}
