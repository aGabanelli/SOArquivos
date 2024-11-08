package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivoController {

	public void abrirArquivo() throws IOException {
		String diretorio = "C:\\TEMP\\";
		String arquivo = "generic_food.csv";
		File arq = new File(diretorio, arquivo);
		if(arq.exists()) {
			try {
				StringBuffer sb = new StringBuffer();
				FileInputStream fis = new FileInputStream(arq);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);
				String linha = br.readLine();
				while(linha != null) {
					if(linha.contains("Fruit") || linha.contains("FOOD NAME")) {
						String[] vetLinha = linha.split(",");
						for(String dado : vetLinha){
							if (dado.length() > 15) {
					            System.out.print(dado + "\t");
					        } else if (dado.length() > 7) {
					            System.out.print(dado + "\t\t");
					        } else {
					            System.out.print(dado + "\t\t\t");
					        }
						}
						System.out.println("\n");
					}
					linha = br.readLine();
				}
				fis.close();
				isr.close();
				br.close();
				System.out.println(sb.toString());
				
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Arquivo não encontrado");
			return;
		}
	}
	
}
