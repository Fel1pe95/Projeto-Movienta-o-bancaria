package model.Dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import model.Dao.ClienteDao;
import model.entidades.Cliente;
import model.entidades.Conta;

public class ClienteAcess implements ClienteDao {

	@Override
	public void LeituraCliente(Map<Integer, Cliente> map) {
		String caminho = "C:\\Users\\Andressa\\Desktop\\Programação\\Projeto movientacao bancaria\\Clientes\\Clientes.csv";
		try (BufferedReader brr = new BufferedReader(new FileReader(caminho))) {
			String linha = brr.readLine();
			while (linha != null) {

				String[] campos = linha.split(",");
				String nome = campos[0];
				Integer agencia = Integer.parseInt(campos[1]);
				Integer conta = Integer.parseInt(campos[2]);
				Integer cpf = Integer.parseInt(campos[3]);
				Integer senha = Integer.parseInt(campos[4]);
				Double saldo = Double.parseDouble(campos[5]);

				Cliente c = new Cliente(nome, cpf, new Conta(agencia, conta, senha, saldo));

				map.put(senha, c);

				linha = brr.readLine();

			}

			System.out.println("Programa carregado!");

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

	@Override
	public void gravacaoCLiente(String caminho, Map<Integer, Cliente>map) {

		try (BufferedWriter br = new BufferedWriter(new FileWriter(caminho))) {
			for(Object obj : map.values()) {
				br.write(obj.toString());
				br.newLine();	
			}
			
			
			System.out.println("Cliente cadastrado com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

	@Override
	public String caminho() {
	return "C:\\Users\\Andressa\\Desktop\\Programação\\Projeto movientacao bancaria\\Clientes\\Clientes.csv";
	}

	@Override
	public void inserirCliente(Map<Integer, Cliente>map) {
		
		try (BufferedWriter br = new BufferedWriter(new FileWriter(caminho(), true))) {	
				br.write(map.toString());
				br.newLine();	
			System.out.println("Cliente cadastrado com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
	}

}
