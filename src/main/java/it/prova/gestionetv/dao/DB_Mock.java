package it.prova.gestionetv.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import it.prova.gestionetv.model.Televisore;

public class DB_Mock {
	public static final List<Televisore> LISTA_TELEVISORI = new ArrayList<>();

	static {
		LISTA_TELEVISORI.add(new Televisore(1l, "marca1", "modello1", 1000, 35, "codice1"));
		LISTA_TELEVISORI.add(new Televisore(2l, "marca2", "modello2", 1100, 40, "codice2"));
		LISTA_TELEVISORI.add(new Televisore(3l, "marca3", "modello3", 900, 29, "codice3"));
		LISTA_TELEVISORI.add(new Televisore(4l, "lg", "st-232", 1400, 50, "lgCodice"));
		LISTA_TELEVISORI.add(new Televisore(5l, "samsung", "tt-2", 500, 17, "samsungCodice"));
	}

	public static Long getNexIdAvailable() {
		Long resultId = null;
		if (LISTA_TELEVISORI == null || LISTA_TELEVISORI.isEmpty()) {
			resultId = 1L;
		}
		resultId=LISTA_TELEVISORI.stream().max(Comparator.comparing(Televisore::getId)).get().getId();
		return ++resultId;
	}

}
