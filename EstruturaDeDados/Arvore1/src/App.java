import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Inserir elemento");
            System.out.println("2 - Remover elemento");
            System.out.println("3 - Imprimir árvore");
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor a ser inserido:");
                    int valorInserir = scanner.nextInt();
                    arvore.inserir(valorInserir);
                    break;
                case 2:
                    System.out.println("Digite o valor a ser removido:");
                    int valorRemover = scanner.nextInt();
                    arvore.remover(valorRemover);
                    break;
                case 3:
                    System.out.println("Árvore AVL:");
                    arvore.imprimirArvore();
                    break;
            }

        } while (opcao != 0);
    }
}