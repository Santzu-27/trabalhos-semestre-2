package grafo;

public class Aresta {
    Vertice cidade1, cidade2;
    int distancia;

    Aresta(Vertice cidade1, Vertice cidade2, int distancia){
        this.cidade1 = cidade1;
        this.cidade2 = cidade2;
        this.distancia = distancia;
    }
    void info(){
        System.out.printf(
                "   > Conecta as cidades: %s e %s (distancia: %dkm)\n",
                cidade1.nomeCidade,
                cidade2.nomeCidade,
                distancia
        );
    }
    String cidade_conectada_com(String cidade){
        if (cidade.equals(cidade1.nomeCidade)) return cidade2.nomeCidade;
        else return cidade1.nomeCidade;
    }

}
