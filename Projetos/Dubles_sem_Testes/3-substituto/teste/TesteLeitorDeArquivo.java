package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import sistema.LeitorDeArquivoQueTrataExcecao;

public class TesteLeitorDeArquivo {

	@Test
	public void testaFluxoExcepcional() throws Exception{
		LeitorDeArquivoQueTrataExcecao leitor = new LeitorDeArquivoQueTrataExcecao();
		leitor.leInformacao(new ReaderQueLancaExcecao());
		assertTrue(leitor.tratouExcecao());
	}

}
