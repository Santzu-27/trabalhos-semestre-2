package grafo;


import java.util.ArrayList;

public class Vertice {

    String nomeCidade;
    ArrayList<Vertice> vizinhos = new ArrayList<>();
    ArrayList<Aresta> conexoes = new ArrayList<>();

    Vertice(String nome){
        this.nomeCidade = nome;
    }

    void info_vizinhos(){

        System.out.printf("Vizinhos de %s: ", this.nomeCidade);

        for (Vertice cidade : vizinhos){
            System.out.printf("%s, ", cidade.nomeCidade);
        }
        System.out.println();

    }
    void info_conexoes(){

        System.out.printf("Cidade %s\n", this.nomeCidade);
        if (!conexoes.isEmpty()){

            // ordena os coisa
            ArrayList<Aresta> conexTemp = conexoes;
            ArrayList<Aresta> conexOrdenada = new ArrayList<>();
            Aresta menor;

            while (!conexTemp.isEmpty()){

                menor = conexTemp.get(0);
                for (Aresta aresta : conexTemp){
                    if (aresta.distancia<menor.distancia) {
                        menor = aresta;
                    }
                }
                conexOrdenada.add(menor);
                conexTemp.remove(menor);
            }

            // printa as coisa
            for(Aresta conexao : conexOrdenada){
                System.out.printf(" - conectada a %s por %dkm\n",
                        conexao.cidade_conectada_com(this.nomeCidade),
                        conexao.distancia
                );
            }
        }
        else System.out.print(" - não conectada");

    }

    String info(){ return String.format("nome da cidade: %s\n",nomeCidade); }
}


