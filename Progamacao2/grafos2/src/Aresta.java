public class Aresta {
    Vertice cidade1, cidade2;
    int distancia;

    public void info_aresta(){
        System.out.println(
            cidade1.nomeCidade + " - " + cidade2.nomeCidade + "\n" +
            distancia + "Km"
        );
    }
}
