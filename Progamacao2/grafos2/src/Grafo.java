import java.util.ArrayList;
import java.util.Scanner;

public class Grafo{
    ArrayList<Vertice> cidades = new ArrayList<Vertice>();
    ArrayList<Aresta> conexoes = new ArrayList<Aresta>();
    Scanner tec = new Scanner(System.in);

    public void cadastra_cidade(){
        Vertice novaCidade = new Vertice();

        System.out.print("Digite o nome da cidade: ");
        String nome = tec.nextLine();
        System.out.println(nome);
        // novaCidade.nomeCidade = nome;

        // this.cidades.add(novaCidade);
    }

    public void cadastra_conexao(){
        Aresta novaConexao = new Aresta();
        System.out.print("Digite o número da primeira cidade: ");
        int c = tec.nextInt();
        novaConexao.cidade1 = cidades.get(c);
        System.out.print("Digite o número da segunda cidade: ");
        c = tec.nextInt();
        novaConexao.cidade2 = cidades.get(c);
        System.out.print("Digite a distância entre as cidades (Km): ");
        int dist = tec.nextInt();
        novaConexao.distancia = dist;
    }

    public void info_cidades(){
        for(int i = 0; i < cidades.size(); i++){
            System.out.println(i + "] " + cidades.get(i).nomeCidade);
        }
    }

    public void info_conexoes(){
        
    }
}
