package model.Dao;

import java.util.Map;

import model.entidades.Cliente;

public interface ClienteDao {

	void LeituraCliente(Map<Integer, Cliente> map);
	void gravacaoCLiente(String caminho, Map<Integer, Cliente>map);
	void inserirCliente(Map<Integer, Cliente> map);
	String caminho();
}
