import java.util.ArrayList;
import java.util.Scanner;

public class Grafo{
    ArrayList<Vertice> cidades = new ArrayList<Vertice>();
    ArrayList<Aresta> conexoes = new ArrayList<Aresta>();
    Scanner tec = new Scanner(System.in);

    public void cadastra_cidade(){
        Vertice novaCidade = new Vertice();

        System.out.print("Digite o nome da cidade: ");
        novaCidade.nomeCidade = tec.nextLine();

        this.cidades.add(novaCidade);
    }

    public void cadastra_conexao(){
        Aresta novaConexao = new Aresta();

        System.out.print("Digite o número da primeira cidade: ");
        int c1 = tec.nextInt();
        novaConexao.cidade1 = cidades.get(c1);
        
        System.out.print("Digite o número da segunda cidade: ");
        int c2 = tec.nextInt();
        novaConexao.cidade2 = cidades.get(c2);
        

        cidades.get(c1).vizinhanca.add(cidades.get(c2));
        cidades.get(c2).vizinhanca.add(cidades.get(c1));
        
        cidades.get(c2).conexoes.add(novaConexao);
        cidades.get(c1).conexoes.add(novaConexao);

        System.out.print("Digite a distância entre as cidades (Km): ");
        int dist = tec.nextInt();
        novaConexao.distancia = dist;

        this.conexoes.add(novaConexao);

    }

    public void info_cidades(){
        for(int i = 0; i < this.cidades.size(); i++){
            cidades.get(i).info_vertice(i);
        }
    }

    public void info_conexoes(){
        for(int i = 0; i < this.conexoes.size(); i++){
            conexoes.get(i).info_aresta();
        }
    }
}
