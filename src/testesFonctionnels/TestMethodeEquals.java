package testesFonctionnels;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cartes.Attaque;
import cartes.Borne;
import cartes.Carte;
import cartes.JeuDeCartes;
import cartes.Parade;
import cartes.Type;

public class TestMethodeEquals {

	Carte borne25_1 = new Borne(25);
	Carte borne25_2 = new Borne(25);

	Carte feu_rouge_1 = new Attaque(Type.FEU);
	Carte feu_rouge_2 = new Attaque(Type.FEU);

	Carte feu_vert = new Parade(Type.FEU);

	@Test
	void testMethodecartes() {
		System.out.println("Deux cartes de 25km sont identiques ?"+borne25_1.equals(borne25_2));
		
		System.out.println("Deux cartes de feux rouge sont identiques ?"+feu_rouge_1.equals(feu_rouge_2));
		
		System.out.print("La carte feu rouge et la carte feu vert sont identiques ?");
		
		System.out.println(feu_rouge_1.equals(feu_vert));

	}

}
