package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import sistema.LeitorDeArquivoQueGravaErros;
import sistema.Logger;

public class TesteLeitorDeArquivoQueLoga {
	private String mensagemLogada;

	@Test
	public void deveLogarAExcecao() throws Exception{
		LeitorDeArquivoQueGravaErros leitor = new LeitorDeArquivoQueGravaErros();
		Logger logger = new Logger(){
			@Override
			public void log(String mensagem, Exception e){
				mensagemLogada = mensagem;
			}
		};
		leitor.setLogger(logger);
		leitor.leInformacao(new ReaderQueLancaExcecao());
		
		assertEquals("Erro lendo arquivo", mensagemLogada);
	}

}
