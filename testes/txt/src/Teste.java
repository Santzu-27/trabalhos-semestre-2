import java.io.FileInputStream;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) throws Exception {
        FileInputStream arquivo = new FileInputStream("/src/teste.txt");
        Scanner entradaTexto = new Scanner(arquivo);
        String linha;
        String [] SL;
        Imovel imovel1, imovel2;

        linha = entradaTexto.nextLine();
        System.out.println(linha);
        SL = linha.split(",");
        imovel1 = new Imovel(SL[0], SL[1], Double.parseDouble(SL[2]));
        imovel1.info();

        linha = entradaTexto.nextLine();
        System.out.println(linha);
        SL = linha.split(",");
        imovel2 = new Imovel(SL[0], SL[1], Double.parseDouble(SL[2]));
        imovel2.info();

        /*while(entradaTexto.hasNextLine()){
            linha = entradaTexto.nextLine();
            System.out.println(linha);
            SL = linha.split(",");
            for(int i = 0; i < SL.length; i++){
                System.out.println(SL[i]);
            }
        }*/
    }
}
