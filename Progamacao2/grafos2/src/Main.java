import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception {
        Scanner tec = new Scanner(System.in);
        int comando;
        boolean rodando;
        Grafo grafo = new Grafo();
        do {
            System.out.println(
                "Digite o comando desejado: \n"+
                "1 - Cadastrar cidade. \n" +
                "2 - Cadastrar conexão. \n" +
                "3 - Listar cidade. \n" +
                "4 - Listar conexões. \n" +
                "5 - Listar cidades vizinhas."
            );
            System.out.print("->");
            comando = tec.nextInt();
            switch (comando) {
                case 1:
                    grafo.cadastra_cidade();
                    break;
                case 2:
                    grafo.cadastra_conexao();
                    break;
                case 3:
                    grafo.info_cidades();
                    break;
                default:
                    break;
            }
            
        } while (rodando = true);
    }
}