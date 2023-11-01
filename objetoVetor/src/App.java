import java.util.Scanner;
import java.util.Random;

public class App {
    static int scanInt(){
        Scanner tec = new Scanner(System.in);
        int n = tec.nextInt();
        return n;
    }

    public static int menu(){
        System.out.println(
                "01. Preencher o vetor do objeto com números pseudo-randômicos, em uma distribuição que minimize a possibilidade de valores duplicados.\n" +
                "\n" +
                "02. Preencher o vetor do objeto com números pseudo-randômicos em ordem crescente;\n" +
                "\n" +
                "03. Informar o total de elementos válidos no vetor do objeto;\n" +
                "\n" +
                "04. Informar o maior e o menor valores existentes no vetor do objeto;\n" +
                "\n" +
                "05. Listar todo o conteúdo do vetor do objeto;\n" +
                "\n" +
                "11. Inserir um valor no vetor do objeto em uma determinada posição.\n" +
                "\n" +
                "12. Apagar um valor do vetor do objeto, informando o valor a ser removido;\n" +
                "\n" +
                "13. Apagar um valor do vetor do objeto, informando a posição do valor a ser removido.\n" +
                "\n" +
                "21. Consultar a existência de um valor no vetor do objeto, utilizando busca sequencial;\n" +
                "\n" +
                "22. Consultar a existência de um valor no vetor do objeto, utilizando busca binária;\n" +
                "\n" +
                "31. Ordenar o vetor do objeto, utilizando o método Bubblesort;\n" +
                "\n" +
                "32. Ordenar o vetor do objeto, utilizando o método Insertionsort;\n" +
                "\n" +
                "33. Ordenar o vetor do objeto, utilizando o método Selectionsort.\n" +
                "\n" +
                "34. Ordenar o vetor do objeto, utilizando o método Quicksort.\n" +
                "\n" +
                "Classe que define o Objeto desta aplicação:");
                System.out.println("Digite um comando -> ");
                int taskNumber = scanInt();
                return taskNumber;
    }

    public static void doTask(int taskN){

    }

    public static void main(String[] args){
        Scanner tec = new Scanner(System.in);
        System.out.print("Digite o tamanho do vetor ->");
        Vetor array = new Vetor(scanInt());
        String prog = "running";
        do{
            int taskNumber = menu();
            switch(taskNumber) {
                case 01:
                    array.povoaVetor();
                    break;
                case 02:
                    array.povoaVetorSequencial();
                    break;
                case 03:
                    array.informaQuantosOcupados();
                    break;
                case 05:
                    array.listArray();
                    break;
                default: 
                    System.out.println("Comando inválido: '" + taskNumber + "' tente outro comando presente no menu");
                    break;    
            }
            System.out.println("Digite para continuar:");
            tec.nextLine();
            
        }while(prog == "running");
        // doTask(taskNumber);
    }
}
