package cartes;

public class Attaque extends Bataille {

	public Attaque(Type type) {
		super(type);
		// TODO Auto-generated constructor st
	}

	@Override
	public String toString() {
		return getType().getAttaque();
	}

	@Override
	public boolean equals(Object obj) {
		Type type = this.getType();
		if (obj instanceof Attaque carte) {
			return type.getAttaque().equals(carte.getType().getAttaque());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 3*getType().getAttaque().hashCode();
	}

}
