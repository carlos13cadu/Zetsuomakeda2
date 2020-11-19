package jogo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Save {
	public static String Read(String caminho){
        String conteudo = "";
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while(linha != null){
                    conteudo += linha+"\n";
                    linha = lerArq.readLine();
                }
                lerArq.close();
            } catch (IOException e) {
                return "";
            }
            return conteudo;
        } catch (FileNotFoundException e) {
            return "";
        }
    }
	
	public static boolean Write(String caminho, String Texto){
        try {
            FileWriter arq = new FileWriter(caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.print(Texto);
            gravarArq.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
