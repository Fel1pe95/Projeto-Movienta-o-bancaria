package Entidades.servico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import Entidades.Cliente;
import Entidades.Conta;

public class LeituraGravacao {

	public static void LeituraCliente(Map<Integer, Cliente>map) {

		String caminho = "C:\\Users\\Andressa\\Desktop\\Programação\\Projeto movientacao bancaria\\Clientes\\Clientes.csv";
		try (BufferedReader brr = new BufferedReader(new FileReader(caminho))) {
			String linha = brr.readLine();
			while (linha != null) {

				String[] campos = linha.split(",");
				String nome = campos[0];
				Integer agencia= Integer.parseInt(campos[1]);
				Integer conta = Integer.parseInt(campos[2]);
				Integer cpf= Integer.parseInt(campos[3]);
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
	public void gravacaoCLiente(String caminho, Cliente c) {
		try (BufferedWriter br = new BufferedWriter(new FileWriter(caminho, true))) {
			br.write(c.toString());
			br.newLine();
			System.out.println("Cliente cadastrado com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
