package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;

public class ZoneDeJeu {
	private List<Limite> pileLimite = new LinkedList<>();
	private List<Bataille> pileBataille = new LinkedList<>();
	private List<Borne> pileBorne = new LinkedList<>();

	private Set<Botte> bottes = new HashSet<>();

	private boolean estPrioritaire() {
		return bottes.contains(new Botte(Type.FEU));
	}

	public int donnerLimitationVitesse() {
		if (pileLimite.isEmpty()) {
			return 200;
		}
		Carte carte = pileLimite.getLast();
		if (carte.equals(new FinLimite()) && !estPrioritaire()) {
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

	private void deposerCarte(Carte carte) {
		if (carte instanceof Borne borne) {
			pileBorne.add(0, borne);;
		} else if (carte instanceof Limite limite) {
			pileLimite.add(0, limite);
		} else if (carte instanceof Bataille bataille) {
			pileBataille.add(0, bataille);
		} else if (carte instanceof Botte botte) {
			bottes.add(botte);
		} else {
			throw new IllegalArgumentException("On depose une carte non valide");
		}
	}

	private boolean peutAvancer() {
		if (pileLimite.isEmpty()) {
			return false;
		}
		Carte carte = pileLimite.getFirst();
		if (carte.equals(new Parade(Type.FEU))) {
			return true;
		}
		return false;
	}

	private boolean estDepotFeuVertAutirise() {
		if (bottes.isEmpty()) {
			return false;
		}
		
		if (pileBataille.isEmpty()) {
			return true;
		}
		Bataille bat = pileBataille.getFirst();
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
		if (estPrioritaire()) {
			return false;
		}
		
		if (limite instanceof DebutLimite debut) {
			if (pileLimite.isEmpty()) {
				return true;
			}
			if (pileLimite.getFirst() instanceof FinLimite) {
				return true;
			}
		} else if (limite instanceof FinLimite fin) {
			if (!pileLimite.isEmpty()) {
				if (pileLimite.getFirst() instanceof DebutLimite) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean estDepotBatailleAutorise(Bataille bataille) {
		if (bataille instanceof Attaque att) {
			if (bottes.contains(new Botte(att.getType()))) {
				return false;
			}
			
			if (peutAvancer()) {
				return true;
			}
			return false;
		}

		if (bataille instanceof Parade parade) {
			
			if (bottes.contains(new Botte(parade.getType()))) {
				return false;
			}

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
			if (pileBataille.getFirst() instanceof Attaque att) {
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
		if (carte instanceof Botte) {
			return true;
		}
		return false;
	}

}
