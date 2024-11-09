package controller;

import java.io.IOException;
import java.util.Scanner;

public class view {

	public static void main(String[] args) throws IOException {
		SteamController ac = new SteamController();
		Scanner scanner = new Scanner(System.in);
		int opcao = 0;
		
		while(opcao != 9) {
			System.out.println("Escolha uma opção: \n"
					+ "1 - Verificar jogadores ativos por jogo de um mês/ano\n"
					+ "2 - Salvar jogadores ativos por jogo de um mês/ano em um arquivo\n"
					+ "9 - Sair");
			opcao = scanner.nextInt();
			
			switch(opcao) {
			case 1: 
				System.out.print("Digite o ano para a busca: ");
				String ano = scanner.next();
				System.out.print("\nDigite o mês (em inglês, por extenso) para a busca: ");
				String mes = scanner.next();
				System.out.print("\nQual a média de jogadores ativos (maior ou igual) você quer pesquisar? ");
				double media = scanner.nextDouble();
				ac.jogadoresAtivos(ano, mes, media);
				break;
			case 2:
				System.out.print("Digite o ano para a busca: ");
				String ano2 = scanner.next();
				System.out.print("\nDigite o mês (em inglês, por extenso) para a busca: ");
				String mes2 = scanner.next();
				System.out.print("\nDigite o diretório para salvar: ");
				String dir = scanner.next();
				System.out.print("\nDigite o nome que deseja no arquivo: ");
				String arq = scanner.next() + ".csv";
				ac.gerarArquivo(ano2, mes2, dir, arq);
				break;
			case 9:System.out.println("Software fechado.");
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		}
	}
}
