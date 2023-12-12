import java.util.ArrayList;

public class Vertice{
    String nomeCidade;
    ArrayList<Vertice> vizinhanca = new ArrayList<Vertice>();
    ArrayList<Aresta> conexoes = new ArrayList<Aresta>();

    public void info_vizinhos(int cid){
        // int i, u;
        // for (u = conexoes.size() - 1; u > 0; u--) {
        //     for (i = 0; i < u; i++) {
        //         if (conexoes.get(i).distancia > conexoes.get(i+1).distancia) {
        //             swap(conexoes, i, i + 1);
        //         }
        //     }
        // }
        // for(i = 0; i < conexoes.size(); i++){
        //     conexoes.get(i).cidade2.info_vertice(i);
        //     if (conexoes.get(i).cidade1.nomeCidade.equals(conexoes)) {
                
        //     }
        //     System.out.println(conexoes.get(i).distancia+ "Km");
            
        // }        
    }


    public void info_conexoes(){
        // System.out.println(this.nomeCidade);

        Aresta menor;
        ArrayList<Aresta> ordenado = new ArrayList<Aresta>();

        while (conexoes.size() >= 0) {
            menor = conexoes.get(0);
            for(Aresta conexao : conexoes){
                if(conexao.distancia < menor.distancia){
                    menor = conexao;
                }
            }
            ordenado.add(menor);
            conexoes.remove(menor);
        }
        conexoes = ordenado;

        for(Aresta conexao : conexoes){
            if(this.nomeCidade.equals(conexao.cidade1))
                System.out.println(conexao.cidade2 + " - " + conexao.distancia+"km");
                else
                System.out.println(conexao.cidade1 + " - " + conexao.distancia+"km");
        }
    }

    public void info_vertice(int i){
        System.out.println("["+i + "] " + nomeCidade);
    }
}