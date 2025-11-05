package testesFonctionnels;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cartes.Carte;
import cartes.JeuDeCartes;

class TestJeuDeCartes {
	JeuDeCartes jeu;

	@BeforeEach
	void setUp() throws Exception {
		jeu = new JeuDeCartes();
	}

	@Test
	void testAffichageJeuDeCartes() {
		System.out.println(jeu.affichageJeuDeCartes());
	}
	
	@Test
	void testcheckCount() {
		Carte[] deck = jeu.donnerCartes();
		System.out.println(jeu.checkCount(deck));
	}
	
	

}
