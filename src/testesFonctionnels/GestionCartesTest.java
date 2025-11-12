package testesFonctionnels;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;


public class GestionCartesTest {
	public static void main(String args[]) {
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = new LinkedList<>();
		for (Carte carte : jeu.donnerCartes()) {
			listeCarteNonMelangee.add(carte);
		}
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		listeCartes = GestionCartes.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println(
				"liste melange sans erreur ? " + GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = GestionCartes.rassemblerV2(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassembl�e sans erreur ? " + GestionCartes.verifierRassemblement(listeCartes));

	}

}