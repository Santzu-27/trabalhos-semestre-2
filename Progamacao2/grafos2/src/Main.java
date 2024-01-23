import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception {
        Scanner tec = new Scanner(System.in);
        int comando;
        boolean rodando;
        Grafo grafo = new Grafo();
        do {
            System.out.println(
                """
                    Digite o comando desejado: 
                "1 - Cadastrar cidade. 
                "2 - Cadastrar conexão. 
                "3 - Listar cidade. 
                "4 - Listar conexões. 
                "5 - Listar cidades vizinhas
                """
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
                case 4:
                    grafo.info_conexoes();
                    break;
                case 5:
                    System.out.println("Digite o número da cidade desejada -> ");
                    int cid = tec.nextInt();
                    grafo.cidades.get(cid).info_conexoes();
                    break;
                default:
                    rodando = false;
                    break;
            }
            System.out.println();
            System.out.println();
        } while (rodando = true);
    }
}