package model.Dao;

import model.Dao.impl.ClienteAcess;

public class InstanciaDao {

	public static ClienteAcess instanciaCliente() {
		
		return new ClienteAcess();
		
	}
	
}
