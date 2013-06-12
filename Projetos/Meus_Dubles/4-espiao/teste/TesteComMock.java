package teste;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import sistema.LeitorDeArquivoQueGravaErros;
import sistema.Logger;

public class TesteComMock<T> {

	private LeitorDeArquivoQueGravaErros leitor;
	private ReaderQueLancaExcecao reader;
	private String mensagemLogada;
	private IOException exception;	
	private ReaderQueLancaExcecao mockLog;
	
	
	@Before
	public void setUp(){
		leitor = new LeitorDeArquivoQueGravaErros();
		reader = new ReaderQueLancaExcecao();
		mensagemLogada = "Erro lendo arquivo";
		exception = new IOException();
	}
	
	@Test
	public void deveLogarAExcecao() throws Exception {
		mockLog = createNiceMock(ReaderQueLancaExcecao.class);
		
	}

}
