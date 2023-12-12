import java.util.ArrayList;

public class Vertice{
    String nomeCidade;
    ArrayList<Vertice> vizinhanca = new ArrayList<Vertice>();
    ArrayList<Aresta> conexoes = new ArrayList<Aresta>();

    public void info_vizinhos(){
        int i, u;
        for (u = conexoes.size() - 1; u > 0; u--) {
            for (i = 0; i < u; i++) {
                if (conexoes.get(i).distancia > conexoes.get(i+1).distancia) {
                    swap(conexoes, i, i + 1);
                }
            }
        }
        for(i = 0; i < conexoes.size(); i++){
            conexoes.get(i).cidade2.info_vertice(i);
            System.out.println(conexoes.get(i).distancia);
            
        }        
    }

    public static void swap(ArrayList<Aresta> array, int i, int i2) {
        Aresta ast = new Aresta();

        ast.cidade1 = array.get(i).cidade1;
        ast.cidade2 = array.get(i).cidade2;
        ast.distancia = array.get(i).distancia;
        
        array.set(i, array.get(i2));
        array.set(i2, ast);
    }

    public void info_conexoes(){
        for(int i = 0; i < conexoes.size(); i++){
            conexoes.get(i).info_aresta();
        }
    }

    public void info_vertice(int i){
        System.out.println("["+i + "] " + nomeCidade);
    }
}