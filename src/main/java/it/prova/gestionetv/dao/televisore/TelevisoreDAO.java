package it.prova.gestionetv.dao.televisore;

import java.sql.Connection;
import java.util.List;

import it.prova.gestionetv.dao.IBaseDAO;
import it.prova.gestionetv.model.Televisore;

public interface TelevisoreDAO extends IBaseDAO<Televisore>{
	public void setConnection(Connection connection);
	
	public List<Televisore> cercaPerMarcaEModello(String marca, String modello);
}
