import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreB arvoreBConsole = new ArvoreB();

        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Inserir elemento");
            System.out.println("2 - Imprimir árvore");
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor a ser inserido:");
                    int valorInserir = scanner.nextInt();
                    arvoreBConsole.inserir(valorInserir);
                    break;
                case 2:
                    System.out.println("Árvore B:");
                    arvoreBConsole.imprimirArvore();
                    break;
            }

        } while (opcao != 0);
    }
}
