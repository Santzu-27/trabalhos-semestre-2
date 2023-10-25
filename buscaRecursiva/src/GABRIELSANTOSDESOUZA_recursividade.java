import java.util.Scanner;
import java.util.Random;

public class GABRIELSANTOSDESOUZA_recursividade {
    
    public static void addValue(int[] arrayP){
        Scanner tec = new Scanner(System.in);
        System.out.println("Digite o valor a ser inserido -> ");
        int value = tec.nextInt();
        for(int i = 0; i < arrayP.length; i++){
            if(arrayP[i] == 0){
                arrayP[i] = value;
                break;
            }
        }
    }
    
    public static void deleteValue(int[] arrayP){
        Scanner tec = new Scanner(System.in);
        System.out.println("Digite a posição do valor a ser apagado -> ");
        int value = tec.nextInt();
        System.out.println("Valor '" + arrayP[value] + "' deletado.");
        arrayP[value] = 0;
    }
    
    public static void searchValue(int[] arrayP){
        Scanner tec = new Scanner(System.in);
        System.out.println("Digite a posição do valor a ser consultado -> ");
        int value = tec.nextInt();
        if(value > 10000 || value < 0){
            System.out.println("Digite uma posição de 0 a 10000");
            searchValue(arrayP);
            return;
        }
        System.out.printf("O valor da posição %d é: %d \n", value, arrayP[value]);
    }

    public static void consultValues(int[] arrayP){
        for(int i=0; i< arrayP.length; i++){
            if(arrayP[i] != 0){
                System.out.printf(" %d ,", arrayP[i] );
            }
        }
        System.out.println();
    }

    public static void biggerLower(int[] arrayP){
        int bigger, lower; bigger = arrayP[0]; lower = arrayP[0];
        for(int i=0; i< arrayP.length; i++){
            if(arrayP[i] > bigger){
                bigger = arrayP[i];
            }
            if(arrayP[i] < lower){
                lower = arrayP[i];
            }
        }
        System.out.printf("Maior: %d \n Menor: %d \n ", bigger, lower);
    }
    
    public static void showArray(int[] arrayP){
        for(int i=0; i< arrayP.length; i++){
            System.out.printf("%d) %d   ", i, arrayP[i]);
        }
        System.out.println();
    }
    
    public static void clearArray(int[] arrayP){
        for(int i=0; i< arrayP.length; i++){
            arrayP[i] = 0;
        }
    }
    
    public static void randomNumbers(int arrayP[]){
        Random aleatorio = new Random();
        int num = aleatorio.nextInt(49) +1;
        for(int i=0; i< arrayP.length; i++){
            arrayP[i] = num;
            num = aleatorio.nextInt(49) + arrayP[i];
        }
    }

    public static int recursive(int value, int counting, int start, int end, int arrayP[]){
        int middle = (start + end)/2;
        if(start <= end){
            counting++;
            if(value == arrayP[middle]){
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
                            "10) Busca binária recursiva");
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
                default:
                    System.out.println("Comando invalido");
            }
        }
    }
}
