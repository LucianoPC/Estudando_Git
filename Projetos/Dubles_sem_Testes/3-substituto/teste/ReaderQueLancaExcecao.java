package teste;

import java.io.IOException;
import java.io.Reader;

public class ReaderQueLancaExcecao extends Reader{

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		throw new IOException();
	}	
	
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
