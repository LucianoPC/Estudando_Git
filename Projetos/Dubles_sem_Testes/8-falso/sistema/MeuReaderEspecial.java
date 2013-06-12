package sistema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class MeuReaderEspecial extends BufferedReader {
    private String linhaAnterior;

    public MeuReaderEspecial(Reader in) {
        super(in);
    }

    @Override
    public String readLine() throws IOException {
    	String resultado;
        if (linhaAnterior != null) {
        	resultado = linhaAnterior;
        	linhaAnterior = null;
        }
        else
            resultado = super.readLine();
        return resultado;
    }

    public String readParagraph() throws IOException {
        StringBuffer buffer = new StringBuffer();
        String linha = readLine();
        while (linha != null && !linha.trim().isEmpty()) {
            buffer.append(linha);
            buffer.append("\n");
            linha = readLine();
        }
        linhaAnterior = linha;
        return buffer.length() == 0 ? null : buffer.toString();
    }

    public boolean isOver() throws IOException {
    	String linha = readLine();
        if (linha == null)
            return true;
        linhaAnterior = linha;
        return false;
    }
}
