package caelum;

import java.util.Calendar;

public class Negocio implements Comparable<Negocio>{
	
	private final Double preco;
	private final int quantidade;
	private final Calendar data;
	
	public Negocio(double preco, int quantidade, Calendar data) {
		if (data == null) {
			throw new IllegalArgumentException("data nao pode ser nula");
		}
	this.preco = preco;
	this.quantidade = quantidade;
	this.data = data;
	}
	
	public Double getPreco() {
	return preco;
	}
	
	public int getQuantidade() {
	return quantidade;
	}
	
	public Calendar getData() {
		return (Calendar) this.data.clone();
	}
	
	public double getVolume(){
		return preco * quantidade;
	}

	@Override
	public int compareTo(Negocio negocio) {
		return this.getPreco().compareTo(negocio.getPreco());
	}
	
}
