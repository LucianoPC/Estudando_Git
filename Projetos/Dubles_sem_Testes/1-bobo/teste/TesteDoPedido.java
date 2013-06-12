package teste;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Test;

import sistema.Item;
import sistema.Pedido;
import sistema.Produto;

public class TesteDoPedido {

	@Test
	public void deveAdicionarUmItem() throws Exception{
		// Preparação
		Pedido pedido = new Pedido(new ClienteBobo());
		Produto produto = new Produto("Shampoo", getNumeroID());
		
		//Teste
		pedido.adicionaQuantidade(produto, 1);
		
		//Verifica
		Item itemEsperado = new Item(produto, 1);
		assertEquals(Collections.singletonList(itemEsperado), pedido.getItens());
	}
	
	private Integer getNumeroID(){
		return 3;
	}

}
