package teste;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import sistema.FormatadorDeTempo;
import sistema.Relogio;

public class testeFormatadorDeTempo {

	@Test
	public void deveDizerMeiaNoiteQuandoForMeiaNoite() throws Exception {
		FormatadorDeTempo formatadorDeTempo = new FormatadorDeTempo();
		
		formatadorDeTempo.setRelogio(new Relogio() {
			
			@Override
			public Calendar agora() {
				Calendar meiaNoite = Calendar.getInstance();
				meiaNoite.set(Calendar.HOUR_OF_DAY, 0);
				return meiaNoite;
			}
		});
		
		String hora = formatadorDeTempo.horaAtualPorEscrito();
		assertEquals("Meia-noite", hora);
	}

}
