class Pilha {
    No topo;

    public Pilha() {
        this.topo = null;
    }

    public void insere(int valor) {
        No novoNo = new No(valor);
        if (topo == null) {
            topo = novoNo;
        } else {
            novoNo.proximo = topo;
            topo.anterior = novoNo;
            topo = novoNo;
        }
    }

    public int remove() {
        if (topo == null) {
            System.out.println("Pilha vazia");
            return -1;
        } else {
            int valor = topo.valor;
            topo = topo.proximo;
            if (topo != null) {
                topo.anterior = null;
            }
            return valor;
        }
    }
}