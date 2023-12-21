class Fila {
    private No frente;
    private No ultimo;

    public Fila() {
        this.frente = null;
        this.ultimo = null;
    }

    public void enfileirar(int valor) {
        No novoNo = new No(valor);
        if (ultimo == null) {
            frente = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.proximo = novoNo;
            novoNo.anterior = ultimo;
            ultimo = novoNo;
        }
    }

    public int desenfileirar() {
        if (frente == null) {
            System.out.println("Fila vazia");
            return -1;
        } else {
            int valor = frente.valor;
            frente = frente.proximo;
            if (frente != null) {
                frente.anterior = null;
            } else {
                ultimo = null;
            }
            return valor;
        }
    }
}