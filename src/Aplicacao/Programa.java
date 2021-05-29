package Aplicacao;

import java.util.Scanner;
import Entidades.Cliente;
import Entidades.servico.LeituraGravacao;
import Entidades.servico.Menus;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Cliente c = new Cliente();
		Integer opcao;
		
		LeituraGravacao.LeituraCliente(c.getAgencia());
		do {
			Menus.menus();
			opcao = sc.nextInt();
			switch (opcao) {

			// FAZ O CADASTRO DE UMA NOVA CONTA
			case 1:
				System.out.print("Nome: ");
				String nome = sc.next();
				System.out.print("Digite o cpf: ");
				Integer cpf = sc.nextInt();
				System.out.print("Senha: ");
				Integer senha = sc.nextInt();
				c.CadastrarCliente(nome, cpf, senha, c.getAgencia());
				break;
			// REMOVE UMA CONTA
			case 2:
				System.out.print("Agência: ");
				Integer agencia0 = sc.nextInt();
				System.out.print("Conta: ");
				Integer conta0 = sc.nextInt();
				System.out.print("Senha: ");
				Integer senha0 = sc.nextInt();

				boolean ver = c.verificacao(senha0, agencia0, conta0);
				if (ver == true) {
					c.getAgencia().remove(senha0);
					System.out.println("Removido com sucesso!");
				} else {
					System.out.println("Conta inexistente!");
				}
				break;
			// CONSULTA OS DADOS DE UMA CONTA
			case 3:
				System.out.print("Agência: ");
				Integer agencia00 = sc.nextInt();
				System.out.print("Conta: ");
				Integer conta00 = sc.nextInt();
				System.out.print("Senha: ");
				Integer senha00 = sc.nextInt();

				ver = c.verificacao(senha00, agencia00, conta00);
				if (ver == true) {
					c.impressaoDeDados(senha00);
				} else {
					System.out.println("Conta inexistente!");
				}
				break;
			}

		} while (opcao != 0);

		sc.close();
	}
}
