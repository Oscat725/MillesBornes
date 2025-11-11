package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;

public class ZoneDeJeu {
	private List<Limite> pileLimite = new ArrayList<>();
	private List<Bataille> pileBataille = new ArrayList<>();
	private List<Borne> pileBorne = new ArrayList<>();

	public int donnerLimitationVitesse() {
		int finPile = pileLimite.size();
		if (finPile == 0) {
			return 200;
		}
		Carte carte = pileLimite.get(finPile - 1);
		if (carte.equals(new FinLimite())) {
			return 200;
		}
		return 50;
	}

	public int donnerKmParcourus() {
		int km = 0;
		for (Borne borne : pileBorne) {

			km += borne.km;
		}
		return km;
	}

	private void deposer(Carte c) {
		if (c instanceof Borne b) {
			pileBorne.add(0, b);
		} else if (c instanceof Limite l) {
			pileLimite.add(0, l);
		} else if (c instanceof Bataille bat) {
			pileBataille.add(0, bat);
		} else {
			throw new IllegalArgumentException("On depose une carte non valide");
		}
	}

	private boolean peutAvancer() {
		int finPile = pileLimite.size();
		if (finPile == 0) {
			return false;
		}
		Carte carte = pileLimite.get(finPile - 1);
		if (carte.equals(new Parade(Type.FEU))) {
			return true;
		}
		return false;
	}

	private boolean estDepotFeuVertAutirise() {
		if (pileBataille.isEmpty()) {
			return true;
		}
		Bataille bat = pileBataille.get(0);
		if (bat instanceof Attaque att) {
			if (att.getType().equals(Type.FEU)) {
				return true;
			}
		}
		if (bat instanceof Parade p) {
			if (!p.getType().equals(Type.FEU)) {
				return true;
			}
		}
		return false;
	}

	private boolean estDepotBorneAutorise(Borne borne) {
		if (peutAvancer() && borne.km <= donnerLimitationVitesse()) {
			if (donnerKmParcourus() + borne.km < 1000) {
				return true;
			}

		}
		return false;
	}

	private boolean estDepotLimiteAutorise(Limite limite) {
		if (limite instanceof DebutLimite debut) {
			if (pileLimite.isEmpty()) {
				return true;
			}
			if (pileLimite.get(0) instanceof FinLimite) {
				return true;
			}
		} else if (limite instanceof FinLimite fin) {
			if (!pileLimite.isEmpty()) {
				if (pileLimite.get(0) instanceof DebutLimite) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean estDepotBatailleAutorise(Bataille bataille) {
		if (bataille instanceof Attaque att) {
			if (peutAvancer()) {
				return true;
			}
			return false;
		}

		if (bataille instanceof Parade parade) {
			
			Type paradeType = parade.getType();
			if (paradeType == null) {
				throw new IllegalArgumentException("Paradetype est null\n");
			}
			if (paradeType.equals(Type.FEU)) {
				return estDepotFeuVertAutirise();
			}
			if (pileBataille.isEmpty()) {
				return false;
			}
			if (pileBataille.get(0) instanceof Attaque att) {
				if (att.getType().equals(paradeType)) {
					return true;
				}

				return false;
			}
		}
		return false;
	}
	
	public boolean estDepotAutorise(Carte carte) {
		if (carte instanceof Bataille bat) {
			return estDepotBatailleAutorise(bat);
		}
		if (carte instanceof Limite l) {
			return estDepotLimiteAutorise(l);
		}
		if (carte instanceof Borne bor) {
			return estDepotBorneAutorise(bor);
		}
		return true; 
	}

}
