package caelum;

import java.util.Calendar;

public final class Candlestick {
	
	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;

	public Candlestick(double abertura,double fechamento,double minimo,
			double maximo, double volume, Calendar data) {
		//validarCandlestick(abertura, fechamento, minimo, maximo, volume, data);
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
		validarCandlestick(this);
	}

	private void validarNumeroPositivo(double numero, String campo){
		if(numero < 0){
			throw new IllegalArgumentException("Erro, o " + campo + " o nao pode ser nulo");
		}
	}
	
	private void validarCandlestick(Candlestick candlestick){
		validarCandlestick(candlestick.getAbertura(), candlestick.getFechamento(),
				candlestick.getMinimo(), candlestick.getMaximo(), candlestick.getVolume(),
				candlestick.getData());
	}
	
	private void validarCandlestick(double abertura,double fechamento,double minimo,
			double maximo, double volume, Calendar data){
		validarAbertura(abertura);
		validarFechamento(fechamento);
		validarMaximo(maximo);
		validarMinimo(minimo);
		validarVolume(volume);
		validarData(data);
		validarMaximoMaiorQueMinimo(maximo, minimo);
	}
	
	private void validarMaximoMaiorQueMinimo(double maximo, double minimo){
		if(maximo < minimo)
			throw new IllegalArgumentException("Erro, o preço minimo esta maior que o maximo!");
		
	}
	
	private void validarData(Calendar data){
		if(data == null)
			throw new IllegalArgumentException("Erro, a data nao pode ser nula!");
	}
	
	private void validarAbertura(double numero){
		validarNumeroPositivo(numero, "Campo abertura");
	}
	
	private void validarFechamento(double numero){
		validarNumeroPositivo(numero, "Campo abertura");
	}
	
	private void validarMinimo(double numero){
		validarNumeroPositivo(numero, "Campo minimo");
	}
	
	private void validarMaximo(double numero){
		validarNumeroPositivo(numero, "Campo maximo");
	}
	
	private void validarVolume(double numero){
		validarNumeroPositivo(numero, "Campo volume");
	}
	
	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}
	
	public boolean isAlta() {
		return this.abertura < this.fechamento;
	}

	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}

}
