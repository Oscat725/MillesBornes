package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterator<Carte> {
	private Carte[] deck;
	private int nbCartes = 110;
	
	private int indiceIterateur =0;
	private boolean nextEffectue = false;

	public Sabot(Carte[] deck) {
		super();
		this.deck = deck;
	}

	private boolean estVide() {
		return nbCartes <= 0;
	}

	private void ajouterCarte(Carte c) {
		if (nbCartes < deck.length) {
			deck[nbCartes] = c;
			nbCartes++;
		} else {
			throw new IndexOutOfBoundsException();
		}

	}	
	

	@Override
	public boolean hasNext() {
		return indiceIterateur<nbCartes;
	}

	@Override
	public Carte next() {
		if (hasNext()) {
			Carte c = deck[indiceIterateur];
			indiceIterateur++;
			nextEffectue = true;
			return c;
		} else {
			throw new NoSuchElementException();
		}
	}
	
	@Override
	public void remove() {
		if (nbCartes<1 || !nextEffectue) {
			
			throw new IllegalStateException();
			
		}
		
		for (int i = indiceIterateur-1; i < nbCartes-1; i++) {
			deck[i] =deck[i+1];
		}
		nextEffectue=false;
		indiceIterateur--;
		nbCartes--;
		
	}
	
	public Carte piocher() {
		indiceIterateur=0;
		nextEffectue=false;
		Carte cartePiocher = next();
		remove();
		return cartePiocher;
	}
	
	

}
