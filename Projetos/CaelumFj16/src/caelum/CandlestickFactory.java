package caelum;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class CandlestickFactory {
	
	public Candlestick constroiCandleParaData(Calendar data,
									List<Negocio> negocios) {
		if(negocios.isEmpty())
			return new Candlestick(0,0,0,0,0,data);
		
		double maximo = negocios.get(0).getPreco();
		double minimo = negocios.get(0).getPreco();
		double volume = 0;
		
		for (Negocio negocio : negocios) {
			volume += negocio.getVolume();
			if (negocio.getPreco() > maximo) {
				maximo = negocio.getPreco();
			} else if (negocio.getPreco() < minimo) {
				minimo = negocio.getPreco();
			}
		}
		
		double abertura = negocios.get(0).getPreco();
		double fechamento = negocios.get(negocios.size()-1).getPreco();

		return new Candlestick(abertura, fechamento, minimo, maximo,
				volume, data);

	}
	
	public static void negocioEmOrdemCrestenteDeValor(ArrayList<Negocio> negocios){
		Collections.sort(negocios);
	}
	
	public static void negocioEmOrdemDecrescenteDeValor(ArrayList<Negocio> negocios){
		Collections.sort(negocios);
		Collections.reverse(negocios);
	}
	
}
