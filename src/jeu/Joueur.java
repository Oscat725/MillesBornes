package jeu;

import java.util.HashSet;
import java.util.Set;

import cartes.Borne;
import cartes.Carte;

public class Joueur {
	private String nom;
	private ZoneDeJeu zone;
	private MainJoueur main;

	public Joueur(String nom, ZoneDeJeu zone) {
		this.nom = nom;
		this.zone = zone;
	}

	private void donner(Carte carte) {
		main.prendre(carte);

	}

	private Carte prendreCarte(Sabot sabot) {
		Carte carte = sabot.piocher();
		if (carte != null) {
			donner(carte);
			return carte;
		}
		return null;
	}

	private int donnerKmParcourus() {
		return zone.donnerKmParcourus();
	}

	public boolean estDepotAutorise(Carte carte) {
		return zone.estDepotAutorise(carte);
	}

	private Set<Coup> coupsPossibles(Set<Joueur> participants) {
		Set<Coup> coups = new HashSet<Coup>();

		for (Carte carte : main.main) {
			for (Joueur joueur : participants) {
				Coup coup = new Coup(this, carte, joueur);
				if (coup.estValide()) {
					coups.add(coup);
				}
			}
		}

		return coups;
	}

	private Set<Coup> coupsDefausse() {
		Set<Coup> coups = new HashSet<Coup>();
		for (Carte carte : main.main) {
			Coup coup = new Coup(this, carte, null);
				coups.add(coup);
		}
		return coups;
	}

	@Override
	public String toString() {
		return nom;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Joueur joueur) {
			return nom.equals(joueur.nom);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 31 * nom.hashCode();
	}

}
