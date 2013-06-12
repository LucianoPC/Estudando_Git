package teste;

import static org.junit.Assert.*;

import java.util.Observable;
import java.util.Observer;

import org.junit.Test;

import sistema.Desenho;
import sistema.Figura;

public class TesteDesenhoComSpy {
	protected Observable observaleRecebido;
	protected Object argumentoRecebido;
	protected int contadorNotificaoes;

	@Test
	public void deveNotificarObeservadoresQuandoAdicionaFigura() throws Exception {
		Desenho desenho = new Desenho();
		Figura figura = new Figura("quadrado");
		contadorNotificaoes = 0;
		Observer observerEspiao = new Observer() {
			
			@Override
			public void update(Observable o, Object arg) {
				observaleRecebido = o;
				argumentoRecebido = arg;
				contadorNotificaoes++;
			}
		};
		
		desenho.addObserver(observerEspiao);
		desenho.adicionaFigura(figura);
		
		assertEquals(1, contadorNotificaoes);
		assertEquals(desenho, observaleRecebido);
		assertEquals(figura, argumentoRecebido);
	}

}
