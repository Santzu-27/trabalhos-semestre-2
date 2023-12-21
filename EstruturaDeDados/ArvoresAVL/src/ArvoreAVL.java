import java.util.Scanner;

public class ArvoreAVL {
    No raiz;

    public void inserir(int chave) {
        raiz = inserir(raiz, null, chave);
    }

    No inserir(No atual, No paiAtual, int chave) {
        if (atual == null) {
            No novoNo = new No(chave);
            novoNo.pai = paiAtual;
            return novoNo;
        }

        if (chave < atual.chave)
            atual.esquerda = inserir(atual.esquerda, atual, chave);
        else if (chave > atual.chave)
            atual.direita = inserir(atual.direita, atual, chave);

        atual.altura = 1 + Math.max(obterAltura(atual.esquerda), obterAltura(atual.direita));

        int balanceamento = obterBalanceamento(atual);
        return balancear(atual);
    }

    public void remover(int chave) {
        raiz = remover(raiz, chave);
    }

    No remover(No atual, int chave) {
        if (atual == null)
            return null;

        if (chave < atual.chave)
            atual.esquerda = remover(atual.esquerda, chave);
        else if (chave > atual.chave)
            atual.direita = remover(atual.direita, chave);
        else {
            if (atual.esquerda == null)
                return atual.direita;
            else if (atual.direita == null)
                return atual.esquerda;

            atual.chave = encontrarMinimo(atual.direita).chave;
            atual.direita = remover(atual.direita, atual.chave);
        }

        atual.altura = 1 + Math.max(obterAltura(atual.esquerda), obterAltura(atual.direita));

        int balanceamento = obterBalanceamento(atual);
        return balancear(atual);
    }

    No encontrarMinimo(No atual) {
        while (atual.esquerda != null)
            atual = atual.esquerda;
        return atual;
    }

    public void imprimirArvore() {
        imprimirArvore(raiz, 0);
    }

    void imprimirArvore(No atual, int nivel) {
        if (atual != null) {
            imprimirArvore(atual.direita, nivel + 1);
            for (int i = 0; i < nivel; i++)
                System.out.print("\t");
            System.out.println(atual.chave);
            imprimirArvore(atual.esquerda, nivel + 1);
        }
    }

    int obterAltura(No atual) {
        if (atual == null) return 0;
        return atual.altura;
    }

    int obterBalanceamento(No atual) {
        if (atual == null) return 0;
        return obterAltura(atual.esquerda) - obterAltura(atual.direita);
    }

    No rotacaoDireita(No a) {
        No b = a.esquerda;
        No T2 = b.direita;

        b.direita = a;
        a.esquerda = T2;

        a.altura = Math.max(obterAltura(a.esquerda), obterAltura(a.direita)) + 1;
        b.altura = Math.max(obterAltura(b.esquerda), obterAltura(b.direita)) + 1;

        return b;
    }

    No rotacaoEsquerda(No a) {
        No b = a.direita;
        No T2 = b.esquerda;

        b.esquerda = a;
        a.direita = T2;

        a.altura = Math.max(obterAltura(a.esquerda), obterAltura(a.direita)) + 1;
        b.altura = Math.max(obterAltura(b.esquerda), obterAltura(b.direita)) + 1;

        return b;
    }

    No rotacaoDuplaDireitaEsquerda(No c) {
        c.esquerda = rotacaoEsquerda(c.esquerda);
        return rotacaoDireita(c);
    }

    No rotacaoDuplaEsquerdaDireita(No c) {
        c.direita = rotacaoDireita(c.direita);
        return rotacaoEsquerda(c);
    }

    No balancear(No atual) {
        int balanceamento = obterBalanceamento(atual);

        if (balanceamento > 1) {
            if (obterBalanceamento(atual.esquerda) >= 0) {
                return rotacaoDireita(atual);
            } else {
                return rotacaoDuplaEsquerdaDireita(atual);
            }
        }

        if (balanceamento < -1) {
            if (obterBalanceamento(atual.direita) <= 0) {
                return rotacaoEsquerda(atual);
            } else {
                return rotacaoDuplaDireitaEsquerda(atual);
            }
        }

        return atual;
    }
}