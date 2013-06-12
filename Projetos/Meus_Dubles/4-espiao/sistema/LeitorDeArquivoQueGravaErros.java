package sistema;

import java.io.IOException;
import java.io.Reader;

public class LeitorDeArquivoQueGravaErros {
	private Logger logger = new Logger();

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public void leInformacao(Reader reader) {
		try {
			while (reader.read() != 0) {
				// Processa informação lida e armazena de alguma forma
				// ...
			}
		} catch (IOException e) {
			logger.log("Erro lendo arquivo", e);
		}
	}
}
