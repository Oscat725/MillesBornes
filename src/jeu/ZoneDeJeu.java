package jeu;

import java.util.List;

import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;

public class ZoneDeJeu {
	private List<Limite> pileLimite;
	private List<Bataille> pileBataille;
	public List<Borne> pileBorne;
	
	public int donnerLimitationVitesse() {
		int finPile = pileLimite.size();
		if (finPile==0) {
			return 200;
		}
		Carte carte = pileLimite.get(finPile-1);
		if (carte.equals(new FinLimite())) {
			return 200;
		}
		return 50;
	}
	
	private int donnerKmParcourus() {
		int km =0;
		for (Borne borne : pileBorne) {
			
			km+=borne.km;
		}
		return km;
	}
	
	private void deposer(Carte c) {
		if (c instanceof Borne b) {
			pileBorne.add(b);
		}
		if (c instanceof Limite l) {
			pileLimite.add(l);
		}
		if (c instanceof Bataille bat) {
			pileBataille.add(bat);
		}
	}

	private boolean peutAvancer() {
		int finPile = pileLimite.size();
		if (finPile==0) {
			return false;
		}
		Carte carte = pileLimite.get(finPile-1);
		if (carte.equals(new Parade(Type.FEU))) {
			return true;
		}
		return false;
	}
	
	private boolean estDepotFeuVertAutirise() {
		return !peutAvancer();
	}
	
	private boolean estDepotBorneAutorise(Borne borne) {
		if (peutAvancer() && borne.km<=donnerLimitationVitesse() ) {
			if (donnerKmParcourus()+borne.km<1000) {
				return true;
			}
			
		}
		return false;
	}
	
	private void estDepotLimiteAutorise(Limite limite) {
		
	}
}
