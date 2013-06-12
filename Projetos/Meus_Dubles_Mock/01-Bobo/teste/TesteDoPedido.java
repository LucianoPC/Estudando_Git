package teste;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;


import org.junit.Test;


public class TesteDoPedido {
	
	private Cliente cliente;
	
	@Test
	public void deveAdicionarUmItem() {
		
		cliente = createNiceMock(Cliente.class);
		
	}

}
