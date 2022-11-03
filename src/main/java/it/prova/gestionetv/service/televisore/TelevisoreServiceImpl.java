package it.prova.gestionetv.service.televisore;

import java.util.List;

import it.prova.gestionetv.dao.televisore.TelevisoreDAO;
import it.prova.gestionetv.model.Televisore;

public class TelevisoreServiceImpl implements TelevisoreService{

	private TelevisoreDAO televisoreDAO;
	
	@Override
	public void setTelevisoreDAO(TelevisoreDAO televisoreDAOInstance) {
		this.televisoreDAO = televisoreDAOInstance;
	}

	@Override
	public List<Televisore> caricaTuttaLaLista() throws Exception {
		return televisoreDAO.list();
	}

	@Override
	public Televisore caricaSingolo(Long id) throws Exception {
		return televisoreDAO.get(id);
	}

	@Override
	public int inserisciAbitante(Televisore input) throws Exception {
		return televisoreDAO.insert(input);
	}

	@Override
	public int elimina(Long id) throws Exception {
		return televisoreDAO.delete(id);
	}

	@Override
	public int aggiorna(Televisore input) throws Exception {
		return televisoreDAO.update(input);
	}

	@Override
	public List<Televisore> caricaPerMarcaEModello(String marca, String modello) throws Exception {
		return televisoreDAO.cercaPerMarcaEModello(marca, modello);
	}

}
