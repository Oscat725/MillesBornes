package jeu;

import cartes.Attaque;
import cartes.Botte;
import cartes.Carte;
import cartes.Parade;
import cartes.Type;

public interface Cartes {
	Carte Prioritaire = new Botte(Type.FEU);
	Carte FeuRouge = new Attaque(Type.FEU);
	Carte FeuVert = new Parade(Type.FEU);
}
