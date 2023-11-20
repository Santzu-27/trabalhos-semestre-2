import java.util.Random;
import java.util.Scanner;
public class Vetor {
    Scanner tec = new Scanner(System.in);
    int n, valor, posicao, menor, maior;
    int[]array;
    
    public Vetor(int aLength){
        this.n = aLength;
        this.array = new int[n];
    }
    
    public void povoaVetor(boolean sequencial){
        Random random = new Random();
        int n = random.nextInt(this.array.length) + 1;
        for (int i = 0; i < this.array.length; i++){
                this.array[i] = n;
                if(sequencial == false)
                    n = random.nextInt(this.array.length) + 1;
                else
                    n = random.nextInt(this.array.length) + this.array[i] +1;
        }

    }

    public void povoaVetorSequencial(){
        povoaVetor(true);
    }

    public void informaQuantosOcupados(){
        int cont = 0;
        for(int i=0; i<this.array.length; i++){
            if(this.array[i] != 0){
                cont++;
            }
        }
        System.out.println("Valores válidos: " + cont);
    }

    public void maiorMenor(){
        maior = this.array[0];
        menor = this.array[0];

        for(int i=0; i<this.array.length; i++){
            if(this.array[i]<menor){
                menor = this.array[i];
            }
            if(this.array[i]>maior){
                maior = this.array[i];
            }
        }
        System.out.println("Maior= "+maior);
        System.out.println("Menor= "+menor);
    }

    public void atribuiValor(){
        System.out.print("Digite o valor a ser adicionado: ");
        valor = tec.nextInt();
        System.out.print("Digite a posição a ser adicionada: ");
        posicao = tec.nextInt();
        array[posicao] = valor;
    }
    
    public void removeValor(Boolean posicaoOuValor){
        if (posicaoOuValor = true) {
            System.out.print("Digite o valor a ser apagado: ");
            valor = tec.nextInt();
            for(int i = 0; i < this.array.length; i++){
                if(this.array[i] == valor){
                    this.array[i] = 0;
                }
            }
        }else{
            System.out.print("Digite a posicao a ser apagada: ");
            posicao = tec.nextInt();
            this.array[posicao] = 0;
        }
    }

    public void listArray(){
        for(int i = 0; i < this.array.length; i++){
            System.out.println("[" + i + "]" + this.array[i] + "");
        }
    }
    
    public void buscaSequencial(){
        System.out.print("Digite o valor a ser buscado: ");
        valor = tec.nextInt();
        for(int i=0; i<this.array.length; i++){
            if(this.array[i] == valor){
                System.out.println("Valor " + valor + " na posição " + i);
            }
        }
    }

    public int buscaBinaria(int inicio, int fim, int cont, int valor){
        int meio;
        meio = (inicio+fim+1)/2;
        if(inicio <= fim) {
            cont++;
            meio = (inicio+fim+1)/2;
            if(valor == array[meio]) {
                System.out.println("O valor " + valor + " foi encontrado na posição: " + meio);
                return -1;
            }

            if (valor < array[meio]) {
                fim = meio - 1;
            }
            if (valor > array[meio]) {
                inicio = meio +1;
            }
            return buscaBinaria(inicio, fim, cont, valor);
        }
        System.out.println("Valor não encontrado");
        return -1;
    }

    public void ordenaBubble() {
        int i, u;
        for (u = this.array.length - 1; u > 0; u--) {
            for (i = 0; i < u; i++) {
                if (array[i] > array[i + 1]) {
                    troca(array, i, i + 1);
                }
            }
        }
    }

    public void ordenaInsert() {
        int x, i, u;
        for (i = 1; i < array.length; i++) {
            x = array[i];
            u = i - 1;
            while ((u >= 0) && array[u] > x) {
                array[u + 1] = array[u];
                u--;
            }
            array[u + 1] = x;
        }
    }


    public void ordenaSelect(){
        for(int i = 0; i < array.length; i++){
            int menor = i;
            for(int u = i+1; u < array.length; u++){
                if(array[u] < array[menor]){
                    menor = u;
                    
                    //
                }
            }
            troca(array, i, menor);
        }
    }


    //10 5 11 7 3 8 13 9
    public int particao(int[] array, int esquerda, int direita){
        int meio = (int) (esquerda + direita)/2;
        int pivo = array[meio];
        int i = esquerda - 1;
        int j = direita + 1;
        while (true) {
            do{
                i++;
                // System.out.println(i);
                // System.out.println(array[i]);
                // System.out.println("_______________________________");
            }while(array[i] < pivo);
            do{
                j--;
                // System.out.pri"_______________________________");
            }while (array[j] > pivo);
            if(i>= j){
                return j;
            }
            int aux = array[i];
            array[i] = array[j];
            array[j] = aux;
        }
    }

    public void ordenaQuick(int[] array, int esquerda, int direita){
        if(esquerda < direita){
            int p = particao(array, esquerda, direita);
            ordenaQuick(array, esquerda, p);
            ordenaQuick(array, p+1, direita);
        }
    }

    public void troca(int[] arrayP, int i, int i1) {
        int ast = arrayP[i];
        arrayP[i] = arrayP[i1];
        arrayP[i1] = ast;
    }
}    

/*Classe que define o Objeto desta aplicação:

=> Atributos

   Um vetor de N elementos  - sendo que N é informado na instanciação deste;

   Sugestão de atributos auxiliares para registrar, entre outros dados:

    . Total de elementos válidos/ocupados

    . Próximo elemento a ser utilizado numa inserção

=> Métodos

    Construtor : instancia o objeto com o vetor e atribui valores iniciais ao vetor e aos outros atributos da classe

    ** Podem haver mais construtores (sobrecarga!)

    povoaVetor : atribui valores pseudo-randômicos a todos os elementos do vetor

    povoaVetorSequencial : atribui em ordem crescente, valores pseudo-randômicos a todos os elementos do vetor (este método pode ser somente uma sobrecarga do anterior!)

    atribuiValor : atribui um valor a um elemento do vetor

    retornaValor : informa o valor existente em determinado elemento do vetor 

    informaTamanho : informa o "length" do vetor

    informaQuantosOcupados : informa quantos dos elementos do vetor possuem valor válido (diferente do valor referência para vazio)

    adicionaValor : insere um valor no próximo elemento livre do vetor - de acordo com alguma estratégia adotada pelo programador (pode fazer uso do método atribuiValor)

    removeValor : remove um valor (atribuindo o valor referência para vazio) em um determinado elemento do vetor

    removeValor : remove um valor informado (atribuindo o valor referência para vazio), caso ele exista no vetor

    menorValor : informa o menor valor válido armazenado no vetor;

    maiorValor : informa o maior valor válido armazenado no vetor;

    buscaSequencial : executa uma busca sequencial de um determinado valor, para verificar se existe um elemento com este valor no vetor e retorna a posição em que foi encontrado.    

     buscaBinária : executa uma busca binária RECURSIVA de um determinado valor, para verificar se existe um elemento com este valor no vetor e retorna a posição em que foi encontrado.    

    ordenaBubble : executa uma ordenação no vetor desordenado (povoado com valores não sequenciais) utilizando o método bubblesort;

    ordenaInsert : executa uma ordenação no vetor desordenado (povoado com valores não sequenciais) utilizando o método insertionsort;

    ordenaSelect : executa uma ordenação no vetor desordenado (povoado com valores não sequenciais) utilizando o método selectionsort; */