package it.prova.gestionetv.service;

import it.prova.gestionetv.dao.MyDaoFactory;
import it.prova.gestionetv.service.televisore.TelevisoreService;
import it.prova.gestionetv.service.televisore.TelevisoreServiceImpl;

public class MyServiceFactory {
	private static TelevisoreService TELEVISORE_SERVICE_INSTANCE;

	public static TelevisoreService getTelevisoreServiceInstance() {
		if (TELEVISORE_SERVICE_INSTANCE == null)
			TELEVISORE_SERVICE_INSTANCE = new TelevisoreServiceImpl();

		TELEVISORE_SERVICE_INSTANCE.setTelevisoreDAO(MyDaoFactory.getTelevisoreDAOInstance());

		return TELEVISORE_SERVICE_INSTANCE;
	}
}
