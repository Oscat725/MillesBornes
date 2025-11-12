package jeu;

import cartes.Attaque;
import cartes.Carte;
import cartes.Limite;

public class Coup {
	private Joueur joueurCourant;
	private Carte carte;
	private Joueur joueurCible;
	
	
	public boolean estValide() {
		if (carte instanceof Attaque || carte instanceof Limite) {
			return joueurCible!=joueurCourant;
		}
		return joueurCible==joueurCourant;
	}


	public Coup(Joueur joueurCourant, Carte carte, Joueur joueurCible) {
		super();
		this.joueurCourant = joueurCourant;
		this.carte = carte;
		this.joueurCible = joueurCible;
	}

}
