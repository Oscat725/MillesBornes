package cartes;

public abstract class Limite extends Carte {

	public Limite() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DebutLimite ) {
			return (this instanceof DebutLimite);
		}
		if (obj instanceof FinLimite ) {
			return (this instanceof FinLimite);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		if (this instanceof DebutLimite) {
			return 89;
		}
		return 33;
	}

}
