package testesFonctionnels;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cartes.Carte;
import cartes.JeuDeCartes;
import jeu.Sabot;

class TestSabot {
	JeuDeCartes jeu = new JeuDeCartes();
	Sabot sabot = new Sabot(jeu.donnerCartes());

	@Test
	void testPiocher() {
		Carte[] deck = jeu.donnerCartes();
		for (int i = 0; i < deck.length; i++) {
			System.out.println("Je pioche " + sabot.piocher().toString());
			
		}
	}

}
