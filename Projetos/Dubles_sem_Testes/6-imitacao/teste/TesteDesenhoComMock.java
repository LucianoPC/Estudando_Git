package teste;

import static org.junit.Assert.*;

import java.util.Observable;
import java.util.Observer;

import org.junit.Test;

import sistema.Desenho;
import sistema.Figura;

public class TesteDesenhoComMock {
	protected int contadorNotificacoes;

	@Test
	public void deveNotificarObservadoresQuandoAdicionaFigura() throws Exception{
		final Desenho desenho = new Desenho();
		final Figura figura = new Figura("quadrado");
		
		contadorNotificacoes = 0;
		Observer observerImitacao = new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				assertEquals(desenho, o);
				assertEquals(figura, arg);
				contadorNotificacoes++;
			}
		};
		desenho.addObserver(observerImitacao);
		desenho.adicionaFigura(figura);
		
		assertEquals(1,contadorNotificacoes);
	}
}
