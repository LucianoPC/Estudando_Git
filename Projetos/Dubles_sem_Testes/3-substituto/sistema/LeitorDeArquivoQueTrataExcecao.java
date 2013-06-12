package sistema;

import java.io.IOException;
import java.io.Reader;

public class LeitorDeArquivoQueTrataExcecao {
	private boolean tratouExcecao = false;

	public void leInformacao(Reader reader) {
		try {
			while (reader.read() != 0) {
				// Processa informação lida e armazena de alguma forma
				// ...
			}
		} catch (IOException e) {
			trataExcecao();
		}
	}

	private void trataExcecao() {
		// Faz alguma coisa, por exemplo logging
		tratouExcecao = true;
	}
	
	public boolean tratouExcecao() {
		return tratouExcecao;
	}
}
