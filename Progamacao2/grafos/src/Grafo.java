import java.util.ArrayList;
import java.util.Scanner;

public class Grafo {
    ArrayList<Vertice> cidades;
    ArrayList<Aresta> conexoes;
    Scanner tec = new Scanner(System.in);
    public void cadastra_cidade(){
        Vertice novaCidade = new Vertice();

        System.out.print("Digite o nome da cidade: ");
        novaCidade.nomeCidade = tec.nextLine();
        cidades.add(novaCidade);
    }

    public void cadastra_conexao(){
        Aresta novaConexao = new Aresta();
        System.out.print("Digite o número da primeira cidade: ");
        int c1 = tec.nextInt();
        novaConexao.cidade1 = cidades.get(c1);
        System.out.print("Digite o número da segunda cidade: ");
    }

    public void info_cidades(){
        for(int i = 0; i < cidades.size(); i++){
            System.out.println(i + "] " + cidades.get(i).nomeCidade);
        }
    }

    public void info_conexoes(){
        
    }
}
