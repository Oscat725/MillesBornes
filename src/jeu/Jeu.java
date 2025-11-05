package jeu;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;

public class Jeu {
	public Sabot sabot;

	public Jeu() {
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		List<Carte> listeCartes = new LinkedList<>();
		Collections.addAll(listeCartes, jeuDeCartes.donnerCartes());
		this.sabot = new Sabot((Carte[]) listeCartes.toArray()) ;
	}
	
	
}
