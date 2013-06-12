package sistema;

import java.util.Calendar;

public class FormatadorDeTempo implements Relogio {
	private Relogio relogio;

	public FormatadorDeTempo() {
		relogio = this;
	}

	public void setRelogio(Relogio relogio) {
		this.relogio = relogio;
	}

	public String horaAtualPorEscrito() {
		Calendar agora = relogio.agora();
		String resultado;
		if (agora.get(Calendar.HOUR_OF_DAY) == 0)
			resultado = "Meia-noite";
		else if (agora.get(Calendar.HOUR_OF_DAY) == 12)
			resultado = "Meio-dia";
		else
			resultado = agora.get(Calendar.HOUR_OF_DAY) + " horas";

		return resultado;
	}

	@Override
	public Calendar agora() {
		return Calendar.getInstance();
	}
}
