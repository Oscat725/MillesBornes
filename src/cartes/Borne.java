package cartes;

import java.security.PublicKey;

public class Borne extends Carte {

	public int km;

	public Borne(int km) {
		super();
		this.km = km;
	}

	@Override
	public String toString() {
		return km + "KM";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Borne carte) {
			return km == carte.km;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 13*km;
	}

}
