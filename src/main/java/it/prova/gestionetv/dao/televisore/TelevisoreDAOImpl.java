package it.prova.gestionetv.dao.televisore;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import it.prova.gestionetv.dao.DB_Mock;
import it.prova.gestionetv.model.Televisore;

public class TelevisoreDAOImpl implements TelevisoreDAO{

	private Connection connection;
	
	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Televisore> list() throws Exception {
		return DB_Mock.LISTA_TELEVISORI;
	}

	@Override
	public Televisore get(Long id) throws Exception {
		Televisore result = null;
		for(Televisore televisore : DB_Mock.LISTA_TELEVISORI) {
			if(televisore.getId() == id) {
				result = televisore;
			}
		}
		return result;
	}

	@Override
	public int update(Televisore input) throws Exception {
		for(int i = 0; i < DB_Mock.LISTA_TELEVISORI.size(); i++) {
			if(input.getId() == DB_Mock.LISTA_TELEVISORI.get(i).getId()) {
				DB_Mock.LISTA_TELEVISORI.set(i,input);
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int insert(Televisore input) throws Exception {
		input.setId(DB_Mock.getNexIdAvailable());
		return DB_Mock.LISTA_TELEVISORI.add(input)?1:0;
	}

	@Override
	public int delete(Long input) throws Exception {
		Televisore televisoreDaEliminare = null;
		for (Televisore televisore : DB_Mock.LISTA_TELEVISORI) {
			if(televisore.getId() == input) {
				televisoreDaEliminare = televisore;
			}
		}
		return DB_Mock.LISTA_TELEVISORI.remove(televisoreDaEliminare)?1:0;
	}

	@Override
	public List<Televisore> cercaPerMarcaEModello(String marca, String modello) {
		List<Televisore> result = new ArrayList<>();
		
		for (Televisore televisore : DB_Mock.LISTA_TELEVISORI) {
			if(televisore.getMarca().toLowerCase().startsWith(marca.toLowerCase()) && televisore.getModello().startsWith(modello)) {
				result.add(televisore);
			}
		}
		
		return result;
	}

}
