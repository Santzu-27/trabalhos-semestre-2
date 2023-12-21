import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Pilha pilha = new Pilha();
        Fila fila = new Fila();
        Lista lista = new Lista();
        Scanner scanner = new Scanner(System.in);

        int escolha;
        do {
            System.out.println("1. Inserir na pilha");
            System.out.println("2. Remover da pilha");
            System.out.println("3. Enfileirar");
            System.out.println("4. Desenfileirar");
            System.out.println("5. Inserir na lista");
            System.out.println("6. Remover da lista");
            System.out.println("7. Imprimir lista");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o valor para inserir na pilha: ");
                    int valorPilha = scanner.nextInt();
                    pilha.insere(valorPilha);
                    break;
                case 2:
                    int valorRemovidoPilha = pilha.remove();
                    if (valorRemovidoPilha != -1) {
                        System.out.println("Valor removido da pilha: " + valorRemovidoPilha);
                    }
                    break;
                case 3:
                    System.out.print("Digite o valor para enfileirar: ");
                    int valorFila = scanner.nextInt();
                    fila.enfileirar(valorFila);
                    break;
                case 4:
                    int valorDesenfileirado = fila.desenfileirar();
                    if (valorDesenfileirado != -1) {
                        System.out.println("Valor desenfileirado: " + valorDesenfileirado);
                    }
                    break;
                case 5:
                    System.out.print("Digite o valor para inserir na lista: ");
                    int valorLista = scanner.nextInt();
                    lista.inserirInicio(valorLista);
                    break;
                case 6:
                    lista.removerInicio();
                    break;
                case 7:
                    lista.imprimirLista();
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (escolha != 0);

        scanner.close();
    }
}