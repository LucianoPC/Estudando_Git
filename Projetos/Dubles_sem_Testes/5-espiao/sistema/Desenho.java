package sistema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

public class Desenho extends Observable {
	private List<IFigura> figuras = new ArrayList<IFigura>();

	public void adicionaFigura(IFigura figura) {
		figuras.add(figura);
		setChanged();
		notifyObservers(figura);
	}

	public void removeFigura(IFigura figura) {
		if (figuras.remove(figura)) {
			setChanged();
			notifyObservers(figura);
		}
	}

	public List<String> getFormas() {
		return Collections.singletonList(figuras.get(0).getForma());
	}
}
