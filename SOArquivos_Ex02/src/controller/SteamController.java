package controller;

import java.io.*;

public class SteamController {

	public void jogadoresAtivos(String ano, String mes, double mediaDeJogadores) throws IOException {
		String diretorio = "C:\\TEMP\\";
		String arquivo = "SteamCharts.csv";
		File arq = new File(diretorio, arquivo);
		if(arq.exists()) {
			try {
				FileInputStream fis = new FileInputStream(arq);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);
				String linha = br.readLine();
				System.out.println("Nome do jogo \t\t\t\t\t | Média de jogadores ativos");
				linha = br.readLine();
				while(linha != null) {
					String[] vetLinha = linha.split(",");
					double mediaDeJogadoresCSV = Double.parseDouble(vetLinha[3]);
					String anoCSV = vetLinha[1];
					String mesCSV = vetLinha[2];
					if(mediaDeJogadoresCSV >= mediaDeJogadores && anoCSV.equals(ano) && mesCSV.equals(mes)) {
						for(int i = 0 ; i < 5 ; i += 3) {
							if (vetLinha[i].length() > 20) {
					            System.out.print(vetLinha[i] + "\t\t");
					        } else if (vetLinha[i].length() > 15) {
					            System.out.print(vetLinha[i] + "\t\t\t");
					        } else {
					            System.out.print(vetLinha[i] + "\t\t\t\t\t");
					        }
						}
						System.out.println("\n");
					}
					
					
					linha = br.readLine();
				}
				fis.close();
				isr.close();
				br.close();
//				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Arquivo não encontrado");
			return;
		}
	}
	
	public void gerarArquivo(String ano, String mes, String diretorio, String nomeDoArquivo) throws IOException {
		File newDir = new File(diretorio);
		File arq = new File(newDir, nomeDoArquivo);
		
		String diretorioDados = "C:\\TEMP\\";
		String arquivoDados = "SteamCharts.csv";
		File arqDados = new File(diretorioDados, arquivoDados);
		
		if(!arq.exists()) {
			try {
				arq.createNewFile();
				System.out.println("Arquivo Gerado!");
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			FileWriter fw = new FileWriter(arq);
			PrintWriter pw = new PrintWriter(fw);
			FileInputStream fis = new FileInputStream(arqDados);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String linha = br.readLine();
			pw.println("Nome do jogo;Media dos jogadores ativos");
			while(linha != null) {
				String[] vetLinha = linha.split(",");
				String anoCSV = vetLinha[1];
				String mesCSV = vetLinha[2];
				if(anoCSV.equals(ano) && mesCSV.equals(mes)) {
					pw.println(vetLinha[0] + ";" + vetLinha[3]);
				}
				linha = br.readLine();
			}
			pw.close();
			fis.close();
			isr.close();
			br.close();
			System.out.println("Arquivo pronto com dados completos!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
//	public void abrirArquivo() throws IOException {
//		String diretorio = "C:\\TEMP\\";
//		String arquivo = "generic_food.csv";
//		File arq = new File(diretorio, arquivo);
//		if(arq.exists()) {
//			try {
//				StringBuffer sb = new StringBuffer();
//				FileInputStream fis = new FileInputStream(arq);
//				InputStreamReader isr = new InputStreamReader(fis);
//				BufferedReader br = new BufferedReader(isr);
//				String linha = br.readLine();
//				while(linha != null) {
//					if(linha.contains("Fruit") || linha.contains("FOOD NAME")) {
//						String[] vetLinha = linha.split(",");
//						for(String dado : vetLinha){
//							if (dado.length() > 15) {
//					            System.out.print(dado + "\t");
//					        } else if (dado.length() > 7) {
//					            System.out.print(dado + "\t\t");
//					        } else {
//					            System.out.print(dado + "\t\t\t");
//					        }
//						}
//						System.out.println("\n");
//					}
//					linha = br.readLine();
//				}
//				fis.close();
//				isr.close();
//				br.close();
//				System.out.println(sb.toString());
//				
//			}
//			catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
//		}else {
//			System.out.println("Arquivo não encontrado");
//			return;
//		}
//	}
	
}
