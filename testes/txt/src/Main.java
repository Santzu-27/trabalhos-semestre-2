import java.io.FileInputStream;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        FileInputStream arquivo = new FileInputStream("txt/src/arquivo.txt");
        Scanner entradaTexto = new Scanner(arquivo);
        String linha;
        String [] SL;

        while (entradaTexto.hasNextLine()){
            linha = entradaTexto.nextLine();
            System.out.println(linha);
            SL = linha.split(",");
            System.out.println(SL[0]);
            System.out.println(SL[1]);
            System.out.println(SL[2]);
            SL[2] = "AKDSKO,DKOAKDSOK,DKAODWAO";
            System.out.println(SL[2]);
        }
    }
}