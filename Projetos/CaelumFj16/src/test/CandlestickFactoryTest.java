	package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import caelum.Candlestick;
import caelum.CandlestickFactory;
import caelum.Negocio;


public class CandlestickFactoryTest {

	@Test
	public void sequenciaSimplesDeNegocios() {
		Calendar hoje = Calendar.getInstance();

		Negocio negocio1 = new Negocio(40.5,100,hoje);		
		Negocio negocio2 = new Negocio(45.0,100,hoje);
		Negocio negocio3 = new Negocio(39.8,100,hoje);
		Negocio negocio4 = new Negocio(42.3,100,hoje);
		
		List<Negocio> negocios = Arrays.asList(negocio1, negocio2, negocio3,
		negocio4);
		
		
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);
		
		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(42.3, candle.getFechamento(), 0.00001);
		Assert.assertEquals(39.8, candle.getMinimo(), 0.00001);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(16760.0, candle.getVolume(), 0.00001);
		
	}
	
	@Test
	public void semNegociosGeraCandleComZeros() {
		Calendar hoje = Calendar.getInstance();
		
		List<Negocio> negocios = Arrays.asList();
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);
		
		Assert.assertEquals(0.0, candle.getVolume(), 0.00001);
		Assert.assertEquals(0.0, candle.getAbertura(), 0.00001);
		Assert.assertEquals(0.0, candle.getFechamento(), 0.00001);
		Assert.assertEquals(0.0, candle.getMinimo(), 0.00001);
		Assert.assertEquals(0.0, candle.getMaximo(), 0.00001);
	}
		
	@Test
	public void apenasUmNegocioGeraCandleComValoresIguais(){
		Calendar hoje = Calendar.getInstance();
		
		Negocio negocio1 = new Negocio(40.5, 100, hoje);
		
		List<Negocio> negocios = Arrays.asList(negocio1);
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);
		
		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(40.5, candle.getFechamento(), 0.00001);
		Assert.assertEquals(40.5, candle.getMinimo(), 0.00001);
		Assert.assertEquals(40.5, candle.getMaximo(), 0.00001);
		Assert.assertEquals(4050.0, candle.getVolume(), 0.00001);

	}
	
	@Test
	public void negocioEmOrdemCrestenteDeValor(){
		Calendar hoje = Calendar.getInstance();
		
		Negocio negocio1 = new Negocio(40.5,100,hoje);		
		Negocio negocio2 = new Negocio(45.0,100,hoje);
		Negocio negocio3 = new Negocio(39.8,100,hoje);
		Negocio negocio4 = new Negocio(42.3,100,hoje);
		
		ArrayList<Negocio> negocios = new ArrayList<Negocio>();
		
		negocios.add(negocio1);
		negocios.add(negocio2);
		negocios.add(negocio3);
		negocios.add(negocio4);
		
		ArrayList<Negocio> negocios_crescente = new ArrayList<Negocio>();
		
		negocios_crescente.add(negocio3);
		negocios_crescente.add(negocio1);
		negocios_crescente.add(negocio4);
		negocios_crescente.add(negocio2);
		
		CandlestickFactory.negocioEmOrdemCrestenteDeValor(negocios);
		
		assertEquals(negocios_crescente, negocios);
	}
	
	@Test
	public void negocioEmOrdemDecrescenteDeValor(){
		Calendar hoje = Calendar.getInstance();
		
		Negocio negocio1 = new Negocio(40.5,100,hoje);		
		Negocio negocio2 = new Negocio(45.0,100,hoje);
		Negocio negocio3 = new Negocio(39.8,100,hoje);
		Negocio negocio4 = new Negocio(42.3,100,hoje);
		
		ArrayList<Negocio> negocios = new ArrayList<Negocio>();
		
		negocios.add(negocio1);
		negocios.add(negocio2);
		negocios.add(negocio3);
		negocios.add(negocio4);
		
		ArrayList<Negocio> negocios_decrescente = new ArrayList<Negocio>();
		
		negocios_decrescente.add(negocio2);
		negocios_decrescente.add(negocio4);
		negocios_decrescente.add(negocio1);
		negocios_decrescente.add(negocio3);
		
		CandlestickFactory.negocioEmOrdemDecrescenteDeValor(negocios);
		
		assertEquals(negocios_decrescente, negocios);
	}
		
}
