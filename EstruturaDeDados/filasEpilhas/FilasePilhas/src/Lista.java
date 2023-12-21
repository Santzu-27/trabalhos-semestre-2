class Lista {
    private No inicio;
    private No fim;

    public Lista() {
        this.inicio = null;
        this.fim = null;
    }

    public void inserirInicio(int valor) {
        No novoNo = new No(valor);
        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }
    }

    public void removerInicio() {
        if (inicio == null) {
            System.out.println("Lista vazia");
        } else {
            inicio = inicio.proximo;
            if (inicio != null) {
                inicio.anterior = null;
            } else {
                fim = null;
            }
        }
    }

    public void imprimirLista() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}
