import java.util.Random;
public class Vetor {
    int n;
    boolean sequencial = false;
    int[]array;

    public Vetor(int aLength){
        this.n = aLength;
        this.array = new int[n];
    }
    public void povoaVetor(){
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
        this.sequencial = true;
        povoaVetor();
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

    public void listArray(){
        for(int i = 0; i < this.array.length; i++){
            System.out.println("[" + i + "]" + this.array[i] + "");
        }
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