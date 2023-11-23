import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static int register(Livro livro) {
        Scanner tec = new Scanner(System.in);
        int filial;
        
        System.out.print("Código da filial a ser cadastrada -> ");
        System.out.print("#FL");
        filial = tec.nextInt();

        System.out.print("Titulo do Livro -> ");
        livro.titulo = tec.next();

        System.out.print("Código -> ");
        livro.codigo = tec.next();

        System.out.print("Editora -> ");
        livro.editora = tec.next();

        System.out.print("Categoria -> ");
        livro.area = tec.next();

        System.out.print("Ano -> ");
        livro.ano = tec.nextInt();
        
        System.out.print("Valor -> ");
        livro.valor = tec.nextDouble();

        System.out.print("Quantidade em estoque -> ");
        livro.estoque = tec.nextInt();
    }
    
    public static Filial criarFilial(int quantFiliais){
        Scanner tec = new Scanner(System.in);
        Filial fl = new Filial();
        fl.codigo = quantFiliais;
        System.out.print("Digite o nome da Filial: ");
        fl.nome = tec.nextLine();
        System.out.print("Digite o endereço da Filial: ");
        fl.endereco = tec.nextLine();
        System.out.print("Digite o endereço da Filial: ");
        fl.contato = tec.nextLine();
        tec.close();
        return fl;
    }


    public static void autoReg(Livro livro, Biblioteca lib, int test){
        livro.titulo = "IT" + test;
        livro.codigo = "7878";
        livro.editora = "Panam";
        livro.area = "Terror";
        livro.ano = 2018;
        livro.valor = 50;
        livro.estoque = 10;
        lib.array.add(livro);
    }

    public static void main(String[] args) throws Exception{
        Scanner tec = new Scanner(System.in);
        Livro livro, bookI;
        ArrayList<Filial> filiais = new ArrayList<Filial>();

        int task, quant, quantFiliais;
        double price;
        String prog = "rodando";

        quantFiliais = 0;
        int count = 1;

        while(prog == "rodando"){
            livro = new Livro();
            System.out.println("1 – Cadastrar novo livro\n"+
            "2 - Listar livros\n"+
            "3 - Buscar livros por nome\n"+
            "4 - Buscar livros por categoria\n"+
            "5 - Buscar livros por preço\n"+
            "6 - Busca por quantidade em estoque\n"+
            "7 - Valor total no estoque\n"+
            "8 - Carregar estoque\n"+
            "9 - Atualizar arquivo de estoque\n"+
            "10 - Criar filial\n"+
            "11 - Adicionar Livro existente à uma filial \n"+
            "0 - Encerrar atividades\n");
            
            System.out.print("Digite o comando a ser realizado: ");
            task = tec.nextInt();
            switch(task){
                case 1:
                    System.out.print("Digite a filial ");
                    register(livro);
                    break;
                case 2:
                    for(int i = 0; i<.array.size(); i++) {
                        bookI = .array.get(i);
                        bookI.info();
                    }
                    break;
                case 3:
                    System.out.print("Informe o titulo do livro: ");
                    String nome = tec.next();
                    for(int i = 0; i < .array.size(); i++){
                        bookI = .array.get(i);
                        if(nome.equals(bookI.titulo) ){
                            bookI.info();
                        }
                    }
                    break;
                case 4:
                    System.out.print("Informe a categoria do livro: ");
                    String categ = tec.next();
                    for(int i = 0; i < .array.size(); i++){
                        bookI = .array.get(i);
                        if(categ.equals(bookI.area)){
                            bookI.info();
                        }
                    }
                    break;
                case 5:
                    System.out.print("Digite o preço máximo desejado: ");
                    price = tec.nextDouble();
                    for(int i = 0; i < .array.size(); i++){
                        bookI = .array.get(i);
                        if(price >= bookI.valor){
                            bookI.info();
                        }
                    }
                    break;
                case 6 :
                    System.out.print("Informe a quantidade mínima de estoque do livro: ");
                    quant = tec.nextInt();
                    for(int i = 0; i < .array.size(); i++){
                        bookI = .array.get(i);
                        if(quant <= bookI.estoque){
                            bookI.info();
                        }
                    }
                    break;
                case 7:
                    System.out.print("Informe o valor de estoque minimo do livro: ");
                    double totalEstoque = tec.nextDouble();
                    for(int i = 0; i < .array.size(); i++){
                        bookI = .array.get(i);
                        if(totalEstoque <= bookI.valorTotal()){
                            bookI.info();
                        }
                    }
                    break;
                case 8:
                    .loadFile();
                    break;
                case 9:
                    .loadFile();
                    break;
                case 10:
                    filiais.add(criarFilial(quantFiliais));
                    quantFiliais +=1;
                    break;
                case 0:
                    System.out.println("Deseja atualizar os dados antes de encerrar? (S/N)");
                    String resp = tec.next();
                    if(resp.equals("S")){
                        .loadFile();
                    }
                    System.out.println("Fim do programa.");
                    prog = "cabô";
                    break;
                //Cadastro automatico para teste do programa;//
                //Cadastro automatico para teste do programa;//
                case 77:
                    autoReg(livro, count);
                    count++;
                    break;
            }

        }
    }
}
