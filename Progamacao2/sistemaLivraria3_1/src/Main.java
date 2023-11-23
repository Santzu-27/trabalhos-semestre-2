import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static Livro register(ArrayList livros) {
        Scanner tec = new Scanner(System.in);
        Livro novoLivro = new Livro();
        System.out.print("Titulo do Livro -> ");
        novoLivro.titulo = tec.next();

        System.out.print("Código -> ");
        novoLivro.codigo = tec.next();

        System.out.print("Editora -> ");
        novoLivro.editora = tec.next();

        System.out.print("Categoria -> ");
        novoLivro.area = tec.next();

        System.out.print("Ano -> ");
        novoLivro.ano = tec.nextInt();
        
        System.out.print("Valor -> ");
        novoLivro.valor = tec.nextDouble();

        System.out.print("Quantidade em estoque -> ");
        novoLivro.estoque = tec.nextInt();
        livros.add(novoLivro);
        return novoLivro;
    }

    public static Filial criarFilial(int codFiliais) {
        Scanner tec = new Scanner(System.in);
        Filial fl = new Filial();
        fl.codigo = codFiliais;
        System.out.print("Digite o nome da Filial: ");
        fl.nome = tec.nextLine();
        System.out.print("Digite o endereço da Filial: ");
        fl.endereco = tec.nextLine();
        System.out.print("Digite o contato da Filial: ");
        fl.contato = tec.nextLine();
        // tec.close();
        fl.info();
        return fl;
    }

    public static void autoReg(Livro livro, int test) {
        livro.titulo = "IT" + test;
        livro.codigo = "7878";
        livro.editora = "Panam";
        livro.area = "Terror";
        livro.ano = 2018;
        livro.valor = 50;
        livro.estoque = 10;
    }

    public static void main(String[] args) throws Exception{
        Scanner tec = new Scanner(System.in);
        Livro livro, livroI;
        ArrayList<Filial> filiais = new ArrayList<Filial>();
        ArrayList<Livro> livros = new ArrayList<Livro>();
        int task, quant, codigosFiliais, codFilial;
        double price;
        String prog = "rodando";

        codigosFiliais = 0;
        int count = 1;

        while(prog == "rodando"){
            System.out.println(
            "1 – Cadastrar novo livro\n"+
            "2 - Buscar livro por código \n"+
            "3 - Buscar em filial \n" +
            "4 - Carregar estoque\n"+
            "5 - Atualizar arquivo de estoque\n"+
            "6 - Criar filial\n"+
            "7 - Adicionar Livro existente à uma filial \n"+
            "0 - Encerrar atividades\n"
            );
            
            System.out.print("Digite o comando a ser realizado: ");
            task = tec.nextInt();
            switch(task){
                case 1:
                    System.out.print("Digite a filial a ser cadastrada os livros -> #FL");
                    int codigoCadastro = tec.nextInt();
                    filiais.get(codigoCadastro).estoqueFilial.add(register(livros));
                    break;
                case 2:
                    System.out.print("Digite o código do livro - > COD#");
                    String codBusca = tec.next();
                    for(int i = 0; i < filiais.size(); i++) {
                        filiais.get(i).buscaCodigo(codBusca);
                    }
                    break;
                case 3:
                    System.out.println("Digite o código da filial que deseja buscar: ");
                    codFilial = tec.nextInt();
                    filiais.get(codFilial).busca();
                    break;
                case 6:
                    filiais.add(criarFilial(codigosFiliais));
                    codigosFiliais +=1;
                    break;
                case 7:
                    System.out.println("Digite o código do livro a ser adicionado: ");
                    String codLivro = tec.nextLine();
                    System.out.println("Digite o código da filial a adicionar o livro: #FL");
                    codFilial = tec.nextInt();
                    Livro existente = new Livro();
                    for(int i = 0; i < filiais.size(); i++){
                        existente = filiais.get(i).buscaCodigo(codLivro);
                    }
                    filiais.get(codFilial).addExistente(existente);
                    break;
                case 0:
                    System.out.println("Deseja atualizar os dados antes de encerrar? (S/N)");
                    String resp = tec.next();
                    if(resp.equals("S")){
                        // .loadFile();
                    }
                    System.out.println("Fim do programa.");
                    prog = "cabô";
                    break;
                // Cadastro automatico para teste do programa;//
                // Cadastro automatico para teste do programa;//
                case 77:
                    // autoReg(livro, count);
                    count++;
                    break;
            }

        }
    }
}
