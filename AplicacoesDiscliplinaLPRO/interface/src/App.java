import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class App {

	public static void main(String[] args) {
		List<Personagem> personagens = new ArrayList<Personagem>();
		Mago mago = new Mago();
		Guerreiro guerreiro = new Guerreiro();
		mago.setAtaque(100);
		mago.setDefesa(30);
		mago.setNome("Caio");
		mago.setNivel(0);
		
		guerreiro.setAtaque(50);
		guerreiro.setDefesa(150);
		guerreiro.setNivel(1);
		guerreiro.setNome("Rian");
		
		personagens.add(guerreiro);
		personagens.add(mago);
		
		for(int i=0;i<personagens.size();i++) {
			Personagem p = personagens.get(i);
			System.out.println(p.apresentar());
			System.out.println(p.movimentar());
			System.out.println(p.getAtaque());
			System.out.println(p.getDefesa());
			System.out.println("-----------------");
		}
		
		
		
		
		ArrayList<Integer> numeros2 = new ArrayList<Integer>();
		int[] numeros = new int[10];
		numeros2.size(); // retorna um inteiro com a qtde de itens
		numeros2.add(10);
		numeros2.add(30);
		numeros2.add(30);
		numeros2.add(30);
		
		for(int i=0;i<numeros2.size();i++) {
			System.out.println(numeros2.get(i));
		}
		System.out.println(numeros2.get(0));
		numeros2.remove(0);
		
		
		
		numeros[0] = 10;
		numeros[2] = 30;
		
		System.out.println(numeros[0]);
		
	}
}
