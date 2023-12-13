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
        
        //Registro automatico pra teste
        Vertice novaCidade1 = new Vertice();
        this.cidades.add(novaCidade1);
        novaCidade1.nomeCidade = "esteio";
        Vertice novaCidade2 = new Vertice();
        this.cidades.add(novaCidade2);
        novaCidade2.nomeCidade = "viamao";
        Vertice novaCidade3 = new Vertice();
        this.cidades.add(novaCidade3);
        novaCidade3.nomeCidade = "canoas";
        Vertice novaCidade4 = new Vertice();
        this.cidades.add(novaCidade4);
        novaCidade4.nomeCidade = "lajeado";
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
        
        
        System.out.print("Digite a distância entre as cidades (Km): ");
        int dist = tec.nextInt();
        novaConexao.distancia = dist;

        cidades.get(c1).conexoes.add(novaConexao);
        cidades.get(c2).conexoes.add(novaConexao);

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
