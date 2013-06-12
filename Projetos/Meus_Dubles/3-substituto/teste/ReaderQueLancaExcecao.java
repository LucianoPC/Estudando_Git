package teste;

import java.io.IOException;
import java.io.Reader;

public class ReaderQueLancaExcecao extends Reader{

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int read(char[] arg0, int arg1, int arg2) throws IOException {
		throw new IOException();
	}

	
}
