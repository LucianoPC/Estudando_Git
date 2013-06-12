package teste;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Observable;
import java.util.Observer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import sistema.Desenho;
import sistema.Figura;

public class TesteDesenhoComEasyMock<T> {
	private Desenho desenho;
	private Figura figura;
	private Observer mockObserver;

	@Before
	public void setUp(){
		desenho = new Desenho();
		figura = new Figura("quadrado");
		mockObserver = createMock(Observer.class);
	}
	
	@After
	public void tearDown(){
		desenho.deleteObserver(mockObserver);
	}
	
	@Test
	public void desenhoDeveNotificarObservadoresQuandoAdicionaFigura() throws Exception {
		// Gravar comportamento esperado
		mockObserver.update(desenho, figura);
		
		// "Tocar" o mock
		replay(mockObserver);
		
		desenho.addObserver(mockObserver);
		desenho.adicionaFigura(figura);
		
		verify(mockObserver);
	}
	
	@Test
	public void desenhoNaoDeveNotificarQuandoRemoveFiguraInexistente() throws Exception {
		desenho.adicionaFigura(figura);
		
		mockObserver.update(desenho, figura);
		replay(mockObserver);
		
		desenho.addObserver(mockObserver);
		desenho.removeFigura(figura);
		
		verify(mockObserver);
		/*
		Method metodos[] = Observable.class.getMethods();
		for(int i = 0; i < metodos.length; i++){
			System.out.println("\n\nMetodo: " + metodos[i].getName());Type returnType = metodos[0].getGenericReturnType();
			System.out.println("Tipo de Retorno: " + returnType);
			
			Class<?> parametros[] = metodos[i].getParameterTypes();
			
			for(int j = 0; j < parametros.length; j++){
				System.out.println("Parametro " + (j+1) + ": " + parametros[j].getName());
			}
						
		}
		*/
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
