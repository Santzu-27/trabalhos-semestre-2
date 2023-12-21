
import java.util.ArrayList;

class NoB {
    static int ORDEM = 3; // Ordem da árvore B
    ArrayList<Integer> chaves;
    ArrayList<NoB> filhos;
    boolean folha;

    public NoB() {
        this.chaves = new ArrayList<>();
        this.filhos = new ArrayList<>();
        this.folha = true;
    }
}
