public class ArvoreB {
    private NoB raiz;

    public ArvoreB() {
        this.raiz = new NoB();
    }

    public void inserir(int chave) {
        NoB r = this.raiz;
        if (r.chaves.size() == 2 * NoB.ORDEM - 1) {
            NoB s = new NoB();
            this.raiz = s;
            s.filhos.add(r);
            dividirNo(s, 0);
            inserirNo(s, chave);
        } else {
            inserirNo(r, chave);
        }
    }

    public void imprimirArvore() {
        imprimirArvore(this.raiz, 0);
    }

    private void inserirNo(NoB no, int chave) {
        int i = no.chaves.size() - 1;
        if (no.folha) {
            while (i >= 0 && chave < no.chaves.get(i)) {
                i--;
            }
            i++;
            no.chaves.add(i, chave);
        } else {
            while (i >= 0 && chave < no.chaves.get(i)) {
                i--;
            }
            i++;
            NoB filho = no.filhos.get(i);
            if (filho.chaves.size() == 2 * NoB.ORDEM - 1) {
                dividirNo(no, i);
                if (chave > no.chaves.get(i)) {
                    i++;
                }
            }
            inserirNo(no.filhos.get(i), chave);
        }
    }


    private void dividirNo(NoB pai, int indiceFilho) {
        NoB filho = pai.filhos.get(indiceFilho);
        NoB novoNo = new NoB();
        int indiceInsercao = NoB.ORDEM - 1;
    
        pai.chaves.add(indiceFilho, filho.chaves.get(indiceInsercao));
    
        for (int i = 0; i < NoB.ORDEM - 1; i++) {
            novoNo.chaves.add(filho.chaves.remove(indiceInsercao));
        }
    
        if (!filho.folha) {
            for (int i = 0; i < NoB.ORDEM; i++) {
                novoNo.filhos.add(filho.filhos.remove(indiceInsercao + 1));
            }
        }
        pai.filhos.add(indiceFilho + 1, novoNo);
    }

    private void imprimirArvore(NoB no, int nivel) {
        if (no != null) {
            int i;
            for (i = no.chaves.size() - 1; i >= 0; i--) {
                if (i + 1 < no.filhos.size()) {
                    imprimirArvore(no.filhos.get(i + 1), nivel + 1);
                }
    
                for (int j = 0; j < nivel; j++) {
                    System.out.print("\t\t");
                }
    
                System.out.println(no.chaves.get(i));
    
                if (i - 1 >= 0) {
                    for (int j = 0; j < nivel; j++) {
                        System.out.print("\t\t");
                    }
                    System.out.println("-----");
                }
            }
    
            if (i + 1 < no.filhos.size()) {
                imprimirArvore(no.filhos.get(0), nivel + 1);
            }
        }
    }
}