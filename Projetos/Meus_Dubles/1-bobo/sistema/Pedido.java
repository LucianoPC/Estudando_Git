package sistema;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	@SuppressWarnings("unused")
	private Cliente cliente;
	private List<Item> itens;

	public Pedido(Cliente cliente) {
		if (cliente == null)
			throw new NullPointerException();
		this.cliente = cliente;
		this.itens = new ArrayList<Item>();
	}

	public void adicionaQuantidade(Produto produto, int quantidade) {
		itens.add(new Item(produto, quantidade));
	}

	public List<Item> getItens() {
		return itens;
	}

	// Mais código que usa o cliente para outras coisas

}
