import java.util.ArrayList;

public class Vertice{
    String nomeCidade;
    ArrayList<Vertice> vizinhanca = new ArrayList<Vertice>();
    ArrayList<Aresta> conexoes = new ArrayList<Aresta>();

    public void info_vizinhos(int cid){
 
    }

    public void info_conexoes(){
        // System.out.println(this.nomeCidade);

        Aresta menor;
        ArrayList<Aresta> ordenado = new ArrayList<Aresta>();
        while (this.conexoes.size() > 0) {
            menor = this.conexoes.get(0);
            for(Aresta conexao : this.conexoes){
                if(conexao.distancia < menor.distancia){
                    menor = conexao;
                }
            }
            ordenado.add(menor);
            this.conexoes.remove(menor);
        }
        this.conexoes = ordenado;

        for(Aresta conexao : this.conexoes){
            if(this.nomeCidade.equals(conexao.cidade1))
                System.out.println(conexao.cidade2.nomeCidade + " - " + conexao.distancia+"km");
                else
                System.out.println(conexao.cidade1.nomeCidade + " - " + conexao.distancia+"km");
        }
    }

    public void info_vertice(int i){
        System.out.println("["+i + "] " + nomeCidade);
    }
}