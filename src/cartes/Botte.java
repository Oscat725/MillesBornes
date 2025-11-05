package cartes;

public class Botte extends Probleme {

	public Botte(Type type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return getType().getBotte() ;
	}

	@Override
	public boolean equals(Object obj) {
		Type type = this.getType();
		if (obj instanceof Botte carte) {
			return type.getBotte().equals(carte.getType().getBotte());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 3*getType().getBotte().hashCode();
	}

}
