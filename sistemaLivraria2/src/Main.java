import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileInputStream;

public class Main {

    public static void register(Livro livro, Biblioteca lib) {
        Scanner tec = new Scanner(System.in);
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
        lib.array.add(livro);
    }

    public static void autoReg(Livro livro, Biblioteca lib){
        livro.titulo = "IT";
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
        Biblioteca library = new Biblioteca();
        Livro livro, bookI;
        FileInputStream file = new FileInputStream("src/txtData.txt");
        int task, quant;
        double price;
        String prog = "rodando";
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
            "0 - Encerrar atividades\n");
            
            System.out.print("Digite o comando a ser realizado: ");
            task = tec.nextInt();
            switch(task){
                case 1:
                    register(livro, library);
                    break;
                case 2:
                    for(int i = 0; i<library.array.size(); i++) {
                        bookI = library.array.get(i);
                        bookI.info();
                    }
                    break;
                case 3:
                    System.out.print("Informe o titulo do livro: ");
                    String nome = tec.next();
                    for(int i = 0; i < library.array.size(); i++){
                        bookI = library.array.get(i);
                        if(nome.equals(bookI.titulo) ){
                            bookI.info();
                        }
                    }
                    break;
                case 4:
                    System.out.print("Informe a categoria do livro: ");
                    String categ = tec.next();
                    for(int i = 0; i < library.array.size(); i++){
                        bookI = library.array.get(i);
                        if(categ.equals(bookI.area)){
                            bookI.info();
                        }
                    }
                    break;
                case 5:
                    System.out.print("Digite o preço máximo desejado: ");
                    price = tec.nextDouble();
                    for(int i = 0; i < library.array.size(); i++){
                        bookI = library.array.get(i);
                        if(price >= bookI.valor){
                            bookI.info();
                        }
                    }
                    break;
                case 6 :
                    System.out.print("Informe a quantidade mínima de estoque do livro: ");
                    quant = tec.nextInt();
                    for(int i = 0; i < library.array.size(); i++){
                        bookI = library.array.get(i);
                        if(quant <= bookI.estoque){
                            bookI.info();
                        }
                    }
                    break;
                case 7:
                    System.out.print("Informe o valor de estoque minimo do livro: ");
                    double totalEstoque = tec.nextDouble();
                    for(int i = 0; i < library.array.size(); i++){
                        bookI = library.array.get(i);
                        if(totalEstoque <= bookI.valorTotal()){
                            bookI.info();
                        }
                    }
                    break;
                case 8:
                    
                    break;
                case 9:

                    break;
                case 0:
                    System.out.println("Fim do programa.");
                    prog = "cabô";
                    break;
                //Cadastro automatico para teste do programa;//
                //Cadastro automatico para teste do programa;//
                case 77:
                    autoReg(livro, library);
                    break;  
            }

        }
    }
}
