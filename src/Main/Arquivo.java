/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
 
public class Arquivo {
    
    public Arquivo(){
        
    }
 
    public void reader(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                System.out.println(linha);
 
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }
 
    public void writer(String conteudo) throws IOException {
        File arquivo = new File("/Users/jeffersonmantovani/Desktop/ConsuTran/scheduled.txt");
        if (!arquivo.exists())
            arquivo.createNewFile();
        
        File[] arquivos = arquivo.listFiles();
        
        FileWriter fw = new FileWriter(arquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(conteudo);
        bw.newLine();
        bw.close();
        fw.close();
        /*BufferedWriter buffWrite = new BufferedWriter(new FileWriter("/Users/jeffersonmantovani/Desktop/ConsuTran/scheduled.txt"));
        buffWrite.newLine();
        buffWrite.append(conteudo);
        buffWrite.close();*/
        
    }
 
}
