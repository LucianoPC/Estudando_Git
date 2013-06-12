package test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import caelum.Candlestick;

public class CandlestickTest {

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		Candlestick candlestick = new Candlestick(10, 20, 20, 10, 10000, Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void dataNaoNula(){
		Candlestick candlestick = new Candlestick(10, 20, 20, 30, 10000, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void aberturaMenorQueZero(){
		Candlestick candlestick = new Candlestick(-10, 20, 20, 30, 10000, Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void fechamentoMenorQueZero(){
		Candlestick candlestick = new Candlestick(10, -20, 20, 30, 10000, Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void minimoMenorQueZero(){
		Candlestick candlestick = new Candlestick(10, 20, -20, 30, 10000, Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void maximoMenorQueZero(){
		Candlestick candlestick = new Candlestick(10, 20, -20, 30, 10000, Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void volumeMenorQueZero(){
		Candlestick candlestick = new Candlestick(10, 20, 20, -30, 10000, Calendar.getInstance());
	}
	

}
