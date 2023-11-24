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
        return fl;
    }
    //////REGISTRO AUTOMATICO DE FILIAIS
    public static Filial autoFilial(int codFiliais){
        Filial fl = new Filial();
        fl.codigo = codFiliais;
        fl.nome = "Filial número " + codFiliais;
        fl.endereco = "Rua A" +10*codFiliais;
        fl.contato = (50+codFiliais)*50+"4500";
        // tec.close();
        return fl;
    }

    //REGISTRO AUTOMATICO PARA TESTE DO PROGRAMA MAIS RAPIDO
    public static Livro autoReg(ArrayList livros, int autoIncrement) {
        Livro novoLivro = new Livro();
        novoLivro.titulo = "It " + autoIncrement;
        
        novoLivro.codigo = "7878";

        novoLivro.editora = "Panam";

        novoLivro.area = "Terror";

        novoLivro.ano = 2018;
               
        novoLivro.valor = 50*autoIncrement;

        novoLivro.estoque = 5*autoIncrement;
        livros.add(novoLivro);

        return novoLivro;
    }

    public static void main(String[] args) throws Exception{
        Scanner tec = new Scanner(System.in);
        ArrayList<Filial> filiais = new ArrayList<Filial>();
        ArrayList<Livro> livros = new ArrayList<Livro>();

        int task, autoIncrementFiliais, codFilial, codigoCadastro, autoIncrementLivros;
        String prog = "rodando";
        Livro existente = new Livro();
        autoIncrementFiliais = 0;
        autoIncrementLivros = 0;

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
                    System.out.print("Digite o código da filial a cadastrado o livro -> #FL");
                    codigoCadastro = tec.nextInt();
                    filiais.get(codigoCadastro).estoqueFilial.add(register(livros));
                    break;
                case 2:
                    System.out.print("Digite o código do livro - > COD#");
                    String codBusca = tec.next();
                    boolean encontrado = false;
                    for(int i = 0; i < filiais.size(); i++) {
                        encontrado = filiais.get(i).buscaCodigo(codBusca, encontrado);
                    }
                    break;
                case 3:
                    System.out.print("Digite o código da filial que deseja buscar: #FL");
                    codFilial = tec.nextInt();
                    filiais.get(codFilial).busca();
                    break;
                case 6:
                    filiais.add(criarFilial(autoIncrementFiliais));
                    autoIncrementFiliais +=1;
                    break;
                case 7:
                    System.out.print("Digite o código do livro a ser adicionado: ");
                    String codLivro = tec.nextLine();
                    codLivro = tec.nextLine();
                    System.out.print("Digite o código da filial a adicionar o livro: #FL");
                    codFilial = tec.nextInt();
                    for(int i = 0; i < filiais.size(); i++){
                        existente = filiais.get(i).encontraExistente(codLivro);
                        if(existente.codigo.equals(codLivro)){
                            break;
                        }
                        System.out.println(existente.titulo + " " + existente.estoque);
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
                    System.out.print("Digite o código da filial a cadastrada os livros -> #FL");
                    codigoCadastro = tec.nextInt();
                    autoIncrementLivros +=1;
                    filiais.get(codigoCadastro).estoqueFilial.add(autoReg(livros, autoIncrementLivros));
                    break;
                case 88:
                    filiais.add(autoFilial(autoIncrementFiliais));
                    autoIncrementFiliais +=1;
                    break;
            }

        }
    }
}
