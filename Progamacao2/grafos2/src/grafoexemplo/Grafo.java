package grafo;

import java.util.ArrayList;
import java.util.Scanner;

public class Grafo {

    static ArrayList<Vertice> cidades = new ArrayList<>();
    static ArrayList<Aresta> conexoes = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        cidades.add(new Vertice("poa"));
        cidades.add(new Vertice("canoas"));
        cidades.add(new Vertice("viamao"));
        cadastraConexao("poa", "canoas", 20);
        cadastraConexao("poa", "viamao", 30);
        cadastraConexao("canoas", "viamao", 50);

        opcoes();
    }

    static void opcoes(){
        System.out.println(
                """
                
                ============ MENU =============
                   1- Cadastra cidade
                   2- Cadastra conexao
                   3- Cidades cadastradas
                   4- Conexoes cadastradas
                   5- Conexoes de uma cidade
                   0- Sair
                """
        );
        System.out.print(" > digite: ");
        String opt = input.next();
        switch (opt){

            case "1" ->cadastraCidade();

            case "2" ->cadastraConexao();

            case "3" ->info_cidades();

            case "4" ->info_conexoes();

            case "5" ->conexoes_cidade();

            case "0" -> {}
            default -> System.out.println("opcao invalida. ");
        }

        if (!opt.equals("0")) opcoes();
    }


    static void cadastraCidade(){

        input.nextLine();
        System.out.print("Nome: ");
        cidades.add(new Vertice(input.nextLine()));
    }
    
    static void cadastraConexao(){

        input.nextLine();
        int[] indexes = new int[2];

        System.out.print("Cidade 1: ");
        String cidade1 = input.nextLine();

        System.out.print("Cidade 2: ");
        String cidade2 = input.nextLine();

        System.out.print("Distancia: ");
        int distancia = input.nextInt();
        input.nextLine();

        for (int i = 0; i<cidades.size(); i++){
            if (cidades.get(i).nomeCidade.equals(cidade1)){
                indexes[0] = i;
                break;
            }
        }
        for (int i = 0; i<cidades.size(); i++){
            if (cidades.get(i).nomeCidade.equals(cidade2)){
                indexes[1] = i;
                break;
            }
        }

        conexoes.add( new Aresta(
                cidades.get(indexes[0]),
                cidades.get(indexes[1]),
                distancia
        ));

        cidades.get(indexes[0]).vizinhos.add(cidades.get(indexes[1]));
        cidades.get(indexes[0]).conexoes.add(conexoes.get( conexoes.size()-1 ));

        cidades.get(indexes[1]).vizinhos.add(cidades.get(indexes[0]));
        cidades.get(indexes[1]).conexoes.add(conexoes.get( conexoes.size()-1 ));

    }
    static void cadastraConexao(String cidade1, String cidade2, int distancia){

        int[] indexes = new int[2];

        for (int i = 0; i<cidades.size(); i++){
            if (cidades.get(i).nomeCidade.equals(cidade1)){
                indexes[0] = i;
                break;
            }
        }
        for (int i = 0; i<cidades.size(); i++){
            if (cidades.get(i).nomeCidade.equals(cidade2)){
                indexes[1] = i;
                break;
            }
        }

        conexoes.add( new Aresta(
                cidades.get(indexes[0]),
                cidades.get(indexes[1]),
                distancia
        ));

        cidades.get(indexes[0]).vizinhos.add(cidades.get(indexes[1]));
        cidades.get(indexes[0]).conexoes.add(conexoes.get( conexoes.size()-1 ));

        cidades.get(indexes[1]).vizinhos.add(cidades.get(indexes[0]));
        cidades.get(indexes[1]).conexoes.add(conexoes.get( conexoes.size()-1 ));
    }

    static ArrayList<String> nomesOrdenados() {

        ArrayList<String> nomes = new ArrayList<>();

        for (Vertice cidade : cidades){
            nomes.add(cidade.info());
        }

        for (int i = 0; i < nomes.size() - 1; i++) {

            for (int j = 0; j < nomes.size() - i - 1; j++) {

                if (nomes.get(j).compareTo(nomes.get(j + 1)) > 0) {

                    String temp = nomes.get(j);
                    nomes.set(j, nomes.get(j + 1));
                    nomes.set(j + 1, temp);
                }
            }
        }
        return nomes;

    }

    static void info_cidades(){

        System.out.print("Cidades: \n");
        for(String cidade : nomesOrdenados()){
            System.out.print(cidade);
        }
    }

    static void info_conexoes(){
        for (int i = 0; i<conexoes.size(); i++){
            System.out.printf("Conexao %d: \n", i+1);
            conexoes.get(i).info();
        }
    }

    static void conexoes_cidade(){
        input.nextLine();
        System.out.print("Cidade: "); String cidade = input.nextLine();
        for(Vertice vertice : cidades){
            if (vertice.nomeCidade.equals(cidade)) vertice.info_conexoes();
        }

    }

}
