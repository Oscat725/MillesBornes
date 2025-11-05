package cartes;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return getType().getParade();
	}

	@Override
	public boolean equals(Object obj) {
		Type type = this.getType();
		if (obj instanceof Parade carte) {
			return type.getParade().equals(carte.getType().getParade());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 3*getType().getParade().hashCode();
	}

}
