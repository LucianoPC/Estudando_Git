package sistema;

public class Figura implements IFigura {

	private String forma;

	public Figura(String forma) {
		this.forma = forma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((forma == null) ? 0 : forma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figura other = (Figura) obj;
		if (forma == null) {
			if (other.forma != null)
				return false;
		} else if (!forma.equals(other.forma))
			return false;
		return true;
	}

	@Override
	public String getForma() {
		return forma;
	}
	
	
}
