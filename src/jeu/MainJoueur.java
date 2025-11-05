package jeu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import cartes.Carte;

public class MainJoueur {
	List<Carte> main;

	void prendre(Carte carte) {
		main.add(carte);
	}
	
	void jouer(Carte carte) {
		assertEquals(true, main.contains(carte));
		main.remove(carte);
	}
	

	public String toString() {
		for (Carte carte : main) {
			System.out.print(carte.toString()+" ");
			System.out.println("");
		}
		return null;
	}
}
