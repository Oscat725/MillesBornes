package testesFonctionnels;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cartes.Carte;
import cartes.JeuDeCartes;


public class TestJeuDeCartes {
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		System.out.println("JEU:\n" + jeu.affichageJeuCartes());
		
        if (!jeu.checkCount()) {
            System.out.println("erreur de nombre");
        }

	}

