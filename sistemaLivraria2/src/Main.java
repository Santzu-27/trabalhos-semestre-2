import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void mostraLivro(ArrayList<Livro> lista, int i){
        System.out.println(">> Cod#" + lista.get(i).codigo+"\n" +
                                "Titulo/Editora: " + lista.get(i).titulo + "/" + lista.get(i).editora+ "\n" +
                                "Categoria: " + lista.get(i).area + "\n" +//
                                "Ano: " + lista.get(i).ano + "\n" +//
                                "Valor: " + lista.get(i).valor + "\n"+ //
                                "Estoque: " + lista.get(i).estoque + "\n"+ //
                                "Valor total em estoque: " + lista.get(i).valorTotal()
                        );
    }

    public static void main(String[] args){
        Scanner tec = new Scanner(System.in);
        int comando;
        String programa = "rodando";
        
        ArrayList<Livro> listaDeLivros = new ArrayList<Livro>();
        
        while(programa == "rodando"){
            Livro livro = new Livro();
            System.out.println("1 – Cadastrar novo livro\n"+
            "2 - Listar livros\n"+
            "3 - Buscar livros por nome\n"+
            "4 - Buscar livros por categoria\n"+
            "5 - Buscar livros por preço\n"+
            "6 - Busca por quantidade em estoque\n"+
            "7 - Valor total no estoque\n"+
            "0 - Encerrar atividades\n");
            
            System.out.print("Digite o comando a ser realizado: ");
            comando = tec.nextInt();
            switch(comando){
                case 1:
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
                    listaDeLivros.add(livro);
                    break;
                case 2:
                    for(int i = 0; i<listaDeLivros.size(); i++) {
                        System.out.println(">> Cod#" + listaDeLivros.get(i).codigo+"\n" +
                                "Titulo/Editora: " + listaDeLivros.get(i).titulo + "/" + listaDeLivros.get(i).editora+ "\n" +
                                "Categoria: " + listaDeLivros.get(i).area + "\n" +//
                                "Ano: " + listaDeLivros.get(i).ano + "\n" +//
                                "Valor: " + listaDeLivros.get(i).valor + "\n"+ //
                                "Estoque: " + listaDeLivros.get(i).estoque + "\n"+ //
                                "Valor total em estoque: " + listaDeLivros.get(i).valorTotal()
                        );
                    }
                    break;
                case 3:
                    System.out.print("Informe o titulo do livro: ");
                    String nome = tec.next();
                    for(int i = 0; i < listaDeLivros.size(); i++){
                        if(nome == listaDeLivros.get(i).titulo){
                            // System.out.println("Teste");
                            livro.get;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Informe a categoria do livro: ");
                    String categ = tec.next();
                    for(int i = 0; i < listaDeLivros.size(); i++){
                        if(categ == listaDeLivros.get(i).area){
                            mostraLivro(listaDeLivros, i);
                        }
                    }
                    break;
                case 5:
                    System.out.print("Digite o preço máximo desejado: ");
                    double preco = tec.nextDouble();
                    for(int i = 0; i < listaDeLivros.size(); i++){
                        if(preco >= listaDeLivros.get(i).valor){
                            mostraLivro(listaDeLivros, i);
                        }
                    }
                    break;
                case 6 :
                    System.out.print("Informe a quantidade mínima de estoque do livro: ");
                    int quant = tec.nextInt();
                    for(int i = 0; i < listaDeLivros.size(); i++){
                        if(quant <= listaDeLivros.get(i).estoque){
                            mostraLivro(listaDeLivros, i);
                        }
                    }
                    break;
                case 7:
                    System.out.print("Informe o valor de estoque minimo do livro: ");
                    double totalEstoque = tec.nextDouble();
                    for(int i = 0; i < listaDeLivros.size(); i++){
                        if(totalEstoque <= listaDeLivros.get(i).valorTotal()){
                            mostraLivro(listaDeLivros, i);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Fim do programa.");
                    programa = "cabô";
                    break;
            }

        }
    }
}
