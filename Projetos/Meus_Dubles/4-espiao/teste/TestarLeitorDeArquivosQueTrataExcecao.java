package teste;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.classextension.EasyMock.createNiceMock;
import static org.easymock.classextension.EasyMock.verify;
import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.replay;

import sistema.LeitorDeArquivoQueTrataExcecao;

public class TestarLeitorDeArquivosQueTrataExcecao {

	private LeitorDeArquivoQueTrataExcecao leitor;
	private Reader mock;
	
	@Before
	public void setUp()
	{
		leitor = new LeitorDeArquivoQueTrataExcecao(); 
		mock = createNiceMock(Reader.class);
	}
	
	@Test
	public void TestarSeOErroFoiCapturadoNoLeitorDeArquivos() {
		
		try {
			expect(mock.read()).andThrow(new IOException());
		} catch (IOException e) {
			e.printStackTrace();
		}
		replay(mock);	
		
		leitor.leInformacao(mock);
		verify(mock);
		
		assertTrue(leitor.tratouExcecao());

	}

}
