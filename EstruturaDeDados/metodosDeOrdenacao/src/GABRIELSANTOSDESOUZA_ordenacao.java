import java.util.Scanner;
import java.util.Random;

public class GABRIELSANTOSDESOUZA_ordenacao {

    public static void addValue(int[] arrayP) {
        Scanner tec = new Scanner(System.in);
        System.out.println("Digite o valor a ser inserido -> ");
        int value = tec.nextInt();
        for (int i = 0; i < arrayP.length; i++) {
            if (arrayP[i] == 0) {
                arrayP[i] = value;
                break;
            }
        }
    }

    public static void deleteValue(int[] arrayP) {
        Scanner tec = new Scanner(System.in);
        System.out.println("Digite a posição do valor a ser apagado -> ");
        int value = tec.nextInt();
        System.out.println("Valor '" + arrayP[value] + "' deletado.");
        arrayP[value] = 0;
    }

    public static void searchValue(int[] arrayP) {
        Scanner tec = new Scanner(System.in);
        System.out.println("Digite a posição do valor a ser consultado -> ");
        int value = tec.nextInt();
        if (value > 10000 || value < 0) {
            System.out.println("Digite uma posição de 0 a 10000");
            searchValue(arrayP);
            return;
        }
        System.out.printf("O valor da posição %d é: %d \n", value, arrayP[value]);
    }

    public static void consultValues(int[] arrayP) {
        for (int i = 0; i < arrayP.length; i++) {
            if (arrayP[i] != 0) {
                System.out.printf(" %d ,", arrayP[i]);
            }
        }
        System.out.println();
    }

    public static void biggerLower(int[] arrayP) {
        int bigger, lower;
        bigger = arrayP[0];
        lower = arrayP[0];
        for (int i = 0; i < arrayP.length; i++) {
            if (arrayP[i] > bigger) {
                bigger = arrayP[i];
            }
            if (arrayP[i] < lower) {
                lower = arrayP[i];
            }
        }
        System.out.printf("Maior: %d \n Menor: %d \n ", bigger, lower);
    }

    public static void showArray(int[] arrayP) {
        for (int i = 0; i < arrayP.length; i++) {
            System.out.printf("%d) %d   ", i, arrayP[i]);
        }
        System.out.println();
    }

    public static void clearArray(int[] arrayP) {
        for (int i = 0; i < arrayP.length; i++) {
            arrayP[i] = 0;
        }
    }

    public static void randomNumbers(int arrayP[]) {
        Random aleatorio = new Random();
        int num = aleatorio.nextInt(9999) + 1;
        for (int i = 0; i < arrayP.length; i++) {
            arrayP[i] = num;
            num = aleatorio.nextInt(9999) + 1;
        }
    }

    public static void bubbleSort(int[] arrayP) {
        int i, u;
        for (u = arrayP.length - 1; u > 0; u--) {
            for (i = 0; i < u; i++) {
                if (arrayP[i] > arrayP[i + 1]) {
                    swap(arrayP, i, i + 1);
                }
            }
        }
    }

    public static void insertionSort(int[] arrayP) {
        int x, i, u;
        for (i = 1; i < arrayP.length; i++) {
            x = arrayP[i];
            u = i - 1;
            while ((u >= 0) && arrayP[u] > x) {
                arrayP[u + 1] = arrayP[u];
                u--;
            }
            arrayP[u + 1] = x;
        }
    }


    public static void selectionSort(int[] arrayP){
        for(int i = 0; i < arrayP.length; i++){
            int menor = i;
            for(int u = i+1; u < arrayP.length; u++){
                if(arrayP[u] < arrayP[menor]){
                    menor = u;
                    
                    //
                }
            }
            swap(arrayP, i, menor);
        }
    }


    //10 5 11 7 3 8 13 9
    static int particao(int[] vetor, int esquerda, int direita){
        int meio = (int) (esquerda + direita)/2;
        int pivo = vetor[meio];
        int i = esquerda - 1;
        int j = direita + 1;
        while (true) {
            do{
                i++;
                // System.out.println(i);
                // System.out.println(vetor[i]);
                // System.out.println("_______________________________");
            }while(vetor[i] < pivo);
            do{
                j--;
                // System.out.pri"_______________________________");
            }while (vetor[j] > pivo);
            if(i>= j){
                return j;
            }
            int aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }
    }

    static void quickSort(int[] vetor, int esquerda, int direita){
        if(esquerda < direita){
            int p = particao(vetor, esquerda, direita);
            quickSort(vetor, esquerda, p);
            quickSort(vetor, p+1, direita);
        }
    }

    public static void swap(int[] arrayP, int i, int i1) {
        int ast = arrayP[i];
        arrayP[i] = arrayP[i1];
        arrayP[i1] = ast;
    }

    public static int recursive(int value, int counting, int start, int end, int arrayP[]) {
        int middle = (start + end) / 2;
        if (start <= end) {
            counting++;
            if (value == arrayP[middle]) {
                System.out.println("O valor " + value + " foi encontrado na posição: " + middle);
                return -1;
            }
            if (value < arrayP[middle]) {
                end = middle - 1;
            }
            if (value > arrayP[middle]) {
                start = middle + 1;
            }
            return recursive(value, counting, start, end, arrayP);
        }
        System.out.println("O valor não existe no vetor");
        return -1;
    }

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int array[] = new int[10000];
        String program = "rodando";
        int value, counting, start, end;

        while (program == "rodando") {
            System.out.println(
                    "1) Zerar vetor\n" +
                            "2) Inserir valor\n" +
                            "3) Apagar valor\n" +
                            "4) Consultar valor\n" +
                            "5) Consultar valores já registrados\n" +
                            "6) Maior e menor valor\n" +
                            "7) Exibir vetor\n" +
                            "8) Encerrar programa\n" +
                            "9) Gerar números aleatórios\n" +
                            "10) Busca binária recursiva \n" +
                            "11) Ordenar valores");
            System.out.print("Digite o comando a ser realizado -> ");
            int task = tec.nextInt();
            switch (task) {
                case 1:
                    clearArray(array);
                    break;
                case 2:
                    addValue(array);
                    break;
                case 3:
                    deleteValue(array);
                    break;
                case 4:
                    searchValue(array);
                    break;
                case 5:
                    consultValues(array);
                    break;
                case 6:
                    biggerLower(array);
                    break;
                case 7:
                    showArray(array);
                    break;
                case 8:
                    program = "cabô";
                    break;
                case 9:
                    randomNumbers(array);
                    break;
                case 10:
                    System.out.println("Digite o valor a ser procurado: ");
                    value = tec.nextInt();
                    counting = 0;
                    start = 0;
                    end = array.length - 1;
                    recursive(value, counting, start, end, array);
                    break;
                case 11:
                    System.out.println(
                            "Selecione o método de ordenação: \n" +
                                    "1) BubbleSort \n" +
                                    "2) SelectionSort \n" +
                                    "3) InsertionSort \n" +
                                    "4) QuickSort");
                    int chosen = tec.nextInt();
                    switch (chosen) {
                        case 1:
                            bubbleSort(array);
                            break;
                        case 2:
                            selectionSort(array);
                            break;
                        case 3:
                            insertionSort(array);
                            break;
                        case 4:
                            quickSort(array, 0, array.length-1);
                            break;
                        default:
                            break;
                    }
                default:
                    System.out.println("Comando invalido");
            }
        }
    }
}
