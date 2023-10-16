import java.util.Scanner;
import java.util.Random;

public class GABRIELSANTOSDESOUZA_ExeVetor {
    
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
        if(value >= 20 && value < 0){
            System.out.println("Digite uma posição de 0 a 19");
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
        int num = aleatorio.nextInt(10000);
        for(int i=0; i< arrayP.length; i++){
            if(arrayP[i] == num){
                break;
            }
            
        }
    }

    public static void main(String[] args){
        Scanner tec = new Scanner(System.in);
        int array[] = new int[10000];
        String program = "rodando";
        
        while(program == "rodando"){
            System.out.println(
            "1) Zerar vetor\n" + 
            "2) Inserir valor\n" + 
            "3) Apagar valor\n" + 
            "4) Consultar valor\n" + 
            "5) Consultar valores já registrados\n" + 
            "6) Maior e menor valor\n" + 
            "7) Exibir vetor\n" + 
            "8) Encerrar programa\n" +
            "9) Gerar números aleatórios\n"+
            "10) Busca binária\n"
            );
            System.out.print("Digite o comando a ser realizado -> ");
            int task = tec.nextInt();
            switch(task){
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
                default: 
                    System.out.println("Comando invalido");
            }
        }

    }

    // public static void main(String[] args) {
    //     Scanner tec = new Scanner(System.in);
    //     int vetor[] = new int[20];
    //     int  i, valor, c;
    //     String prog = "inicio";

    //     System.out.println("1) Zerar vetor");
    //     System.out.println("2) Inserir valor");
    //     System.out.println("3) Apagar valor");
    //     System.out.println("4) Consultar valor");
    //     System.out.println("5) Consultar valores significativos");
    //     System.out.println("6) Consultar maior valor");
    //     System.out.println("7) Consultar menor valor");
    //     System.out.println("8) Exibir vetor");
    //     System.out.println("9) Encerrar programa");

    //     while (prog != "cabô") {

    //         System.out.println();
    //         System.out.print("Digite o número da tarefa desejada -> ");

    //         int comando = tec.nextInt();
    //         if (comando == 1) {
    //             for (i = 0; i < 20; i++) {
    //                 vetor[i] = 0;
    //             }
    //         }
    //         ///////////////////////////////
    //         if (comando == 2) {
    //             System.out.print("Digite o valor que deseja inserir -> ");
    //             valor = tec.nextInt();
    //             for (i = 0; i < 20; i++) {
    //                 if (vetor[i] == 0) {
    //                     vetor[i] = valor;
    //                     i = 20;
    //                 }
    //             }
    //         }
    //         ///////////////////////////////
    //         if (comando == 3) {
    //             System.out.print("Digite o valor a ser apagado -> ");
    //             valor = tec.nextInt();
    //             for (i = 0; i < 20; i++) {
    //                 if (vetor[i] == valor) {
    //                     vetor[i] = 0;
    //                 }
    //             }
    //         }
    //         ///////////////////////////////
    //         if (comando == 4) {
    //             System.out.print("Digite o valor a ser consultado -> ");
    //             valor = tec.nextInt();
    //             c = 0;
    //             for (i = 0; i < 20; i++) {
    //                 if (vetor[i] == valor) {
    //                     System.out.println("Esse valor está no elemento " + i);
    //                     c++;
    //                 }
    //             }
    //             if (c == 0) {
    //                 System.out.println("Esse valor não existe no vetor.");
    //             }
    //         }
    //         ///////////////////////////////
    //         if (comando == 5) {
    //             c = 0;
    //             for (i = 0; i < 20; i++) {
    //                 if (vetor[i] != 0) {
    //                     c++;
    //                 }
    //             }
    //             System.out.println("Existem " + c + " valores registrados");
    //         }
    //         ///////////////////////////////
    //         if(comando == 6){
    //             int maior = 0;
    //             for(i = 0; i<20; i++){
    //                 if(vetor[i] > maior){
    //                     maior = vetor[i];
    //                 }
    //             }
    //             System.out.println("O maior valor encontrado é " + maior);
    //         }

    //         ///////////////////////////////

    //         if(comando == 7){
    //             int menor = vetor[0];
    //             for(i = 0; i<20; i++){
    //                 if(vetor[i] <= menor){
    //                     menor = vetor[i];
    //                 }
    //             }
    //             System.out.println("O menor valor encontrado é " + menor);
    //         }

    //         ///////////////////////////////

    //         if(comando == 8){
    //             for(i = 0; i<20; i++){
    //                 System.out.printf(" %d ", vetor[i]);
    //             }
    //         }

    //         ///////////////////////////////

    //         if (comando == 9){
    //             prog = "cabô";
    //         }

    //     }
    // }
}