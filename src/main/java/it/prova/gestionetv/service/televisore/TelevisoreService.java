package it.prova.gestionetv.service.televisore;

import java.util.List;

import it.prova.gestionetv.dao.televisore.TelevisoreDAO;
import it.prova.gestionetv.model.Televisore;

public interface TelevisoreService {

	public void setTelevisoreDAO(TelevisoreDAO televisoreDAOInstance);

	public List<Televisore> caricaTuttaLaLista() throws Exception;
	
	public Televisore caricaSingolo(Long id) throws Exception;
	
	public int inserisciAbitante(Televisore input) throws Exception;
	
	public int elimina(Long id) throws Exception;
	
	public int aggiorna(Televisore input) throws Exception;
	
	public List<Televisore> caricaPerMarcaEModello(String marca,String modello) throws Exception;

}
