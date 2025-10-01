package cartes;

public class JeuDeCartes {

	private Configuration[] typesDeCartes = new Configuration[19];

	
	
	
	
	
	public JeuDeCartes() {
		typesDeCartes[0] = new Configuration(10, new Borne(25));
		typesDeCartes[1] = new Configuration(10, new Borne(50));
		typesDeCartes[2] = new Configuration(10, new Borne(75));
		typesDeCartes[3] = new Configuration(12, new Borne(100));
		typesDeCartes[4] = new Configuration(4, new Borne(200));
		typesDeCartes[5] = new Configuration(14, new Parade(Type.FEU));
		typesDeCartes[6] = new Configuration(6, new FinLimite());
		typesDeCartes[7] = new Configuration(6, new Parade(Type.ESSENCE));
		typesDeCartes[8] = new Configuration(6, new Parade(Type.CREVAISON));
		typesDeCartes[9] = new Configuration(6, new Parade(Type.ACCIDENT));
		typesDeCartes[10] = new Configuration(5, new Attaque(Type.FEU));
		typesDeCartes[11] = new Configuration(4, new DebutLimite());
		typesDeCartes[12] = new Configuration(3, new Attaque(Type.ESSENCE));
		typesDeCartes[13] = new Configuration(3, new Attaque(Type.CREVAISON));
		typesDeCartes[14] = new Configuration(3, new Attaque(Type.ACCIDENT));
		typesDeCartes[15] = new Configuration(1, new Botte(Type.FEU));
		typesDeCartes[16] = new Configuration(1, new Botte(Type.ESSENCE));
		typesDeCartes[17] = new Configuration(1, new Botte(Type.CREVAISON));
		typesDeCartes[18] = new Configuration(1, new Botte(Type.ACCIDENT));
		
	}

	public String affichageJeuDeCartes() {
		StringBuilder builder = new StringBuilder();
		builder.append("JEU : \n");
		int nbexemplaires;
		String nomCarte;
		for (Configuration configuration : typesDeCartes) {
			nbexemplaires = configuration.getNbExemplaires();
			nomCarte = configuration.getCarte().toString();
			builder.append(nbexemplaires);
			builder.append(" " + nomCarte + "\n");
		}
		return builder.toString();
	}

	public Carte[] donnerCartes() {
		Carte[] cartes = new Carte[110];
		int indice = 0;
		for (Configuration configuration : typesDeCartes) {
			if (configuration.getNbExemplaires() > 1) {
				cartes[indice] = configuration.getCarte();
				indice++;
			}
		}
		return cartes;
	}

	private static class Configuration {

		private int nbExemplaires;
		private Carte carte;

		private Configuration(int nbExemplaires, Carte carte) {
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}

		public Carte getCarte() {
			return carte;
		}

	}

}
