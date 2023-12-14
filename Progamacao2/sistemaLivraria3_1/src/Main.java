import java.util.Scanner;
import java.util.ArrayList;
import java.io.file.Files;
import java.io.file.Path;

public class Main {

    public static Livro register(ArrayList<Livro> livros) {
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
        if (codFiliais >9) {
            fl.codigo = "#FL"+ codFiliais;
        }else{
            fl.codigo = "#FL0"+ codFiliais;
        }
        System.out.print("Digite o nome da Filial: ");
        fl.nome = tec.nextLine();
        System.out.print("Digite o endereço da Filial: ");
        fl.endereco = tec.nextLine();
        System.out.print("Digite o contato da Filial: ");
        fl.contato = tec.nextLine();
        System.out.println(fl.codigo + " -> '" + fl.nome + "' criada!");
        // tec.close();
        return fl;
    }
    //////REGISTRO AUTOMATICO DE FILIAIS
    public static Filial autoFilial(int codFiliais){
        Filial fl = new Filial();
        if (codFiliais >9) {
            fl.codigo = "#FL"+ codFiliais;
        }else{
            fl.codigo = "#FL0"+ codFiliais;
        }
        fl.nome = "Filial número " + codFiliais;
        fl.endereco = "Rua A" +(10 + codFiliais)*codFiliais;
        fl.contato = "(51)3200"+(50+codFiliais*2)*50;
        // tec.close();
        return fl;
    }

    //REGISTRO AUTOMATICO PARA TESTE DO PROGRAMA MAIS RAPIDO
    public static Livro autoReg(int autoIncrement, ArrayList<Livro> livros) {
        Livro novoLivro = new Livro();
        novoLivro.titulo = "It " + autoIncrement;
        
        novoLivro.codigo = "7878";

        novoLivro.editora = "Panam";

        novoLivro.area = "Terror";

        novoLivro.ano = 2018;
               
        novoLivro.valor = 25*autoIncrement;

        novoLivro.estoque = 5*autoIncrement;
        livros.add(novoLivro);
        return novoLivro;
    }

    public static String atualizaFiliais(ArrayList<Filial> filial){
        String stringTxt = "";
        Filial thisFilial;
        Livro thisLivro;
        for(int i = 0; i< filial.size(); i++){
            thisFilial = filial.get(i);
            stringTxt += thisFilial.codigo + ",";
            stringTxt += thisFilial.nome + ",";
            stringTxt += thisFilial.endereco + ",";
            stringTxt += thisFilial.contato + "\n";
            for(int u = 0; u < thisFilial.estoqueFilial.size(); u++){
                thisLivro = thisFilial.estoqueFilial.get(u);
                stringTxt += thisLivro.codigo + ",";
                stringTxt += thisLivro.titulo + ",";
                stringTxt += thisLivro.ano + ",";
                stringTxt += thisLivro.area + ",";
                stringTxt += thisLivro.editora + ",";
                stringTxt += "R$" + thisLivro.valor + ",";
                stringTxt += thisLivro.estoque + "\n";
            }
            stringTxt += "\n";
        }

        return stringTxt;

        //#FL01,Barra Sul,Diário de Noticias 80,3221-6369
    }

    public static void carregarEstoque(Path path, ArrayList<Filial> filiais) throws Exception{
        Filial thisFilial;
        String linha;
        String [] sl;
        int i;
        Scanner arquivo = new Scanner(path);
        //Remover atuais
        for(i = 0; i < filiais.size(); i++){
            thisFilial = filiais.get(i);
            filiais.remove(thisFilial);
        }
        
        int quantFiliais = 0;
        while (arquivo.hasNextLine()) {
            linha = arquivo.nextLine();
            sl = linha.split(",");
            if(sl.length == 4){
                Filial novaFilial = new Filial();
                novaFilial.codigo = sl[0];
                novaFilial.nome = sl[1];
                novaFilial.endereco = sl[2];
                novaFilial.contato = sl[3];
                filiais.add(novaFilial);
            }
            if (sl.length == 7) {
                Livro novoLivro = new Livro();
                novoLivro.codigo = sl[0];
                novoLivro.titulo = sl[1];
                novoLivro.ano= Integer.parseInt(sl[2]);
                novoLivro.area = (sl[3]);
                novoLivro.editora = sl[4];
                
                sl[5] = sl[5].replace("R$", "");
                System.out.println(sl[5]);
                novoLivro.valor = Double.parseDouble(sl[5]);
                
                novoLivro.estoque = Integer.parseInt(sl[6]);
                filiais.get(quantFiliais).estoqueFilial.add(novoLivro);
            }
            if(sl.length <= 1){
                quantFiliais++;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Scanner tec = new Scanner(System.in);
        ArrayList<Filial> filiais = new ArrayList<Filial>();
        ArrayList<Livro> livros = new ArrayList<Livro>();
        Path path = Path.of("C:\\Users\\gabi2\\OneDrive\\Área de Trabalho\\ADS\\trabalhos-semestre-2\\Progamacao2\\sistemaLivraria3_1\\src\\textData.txt");
       
        int task, autoIncrementFiliais, codFilial, codigoCadastro, autoIncrementLivros;
        String prog = "rodando";
        Livro existente = new Livro();
        autoIncrementFiliais = 0;
        autoIncrementLivros = 0;
        
        while(prog == "rodando"){
            System.out.println(
            "1 - Cadastrar novo livro\n"+
            "2 - Buscar livro por código \n"+
            "3 - Buscar em filial \n" +
            "4 - Carregar estoque\n"+
            "5 - Atualizar arquivo de estoque\n"+
            "6 - Criar filial\n"+
            "7 - Adicionar Livro existente à uma filial \n"+
            "8 - Mostrar filiais existentes\n"+
            "8 - Mostrar todos os livros existentes\n"+
            "0 - Encerrar atividades\n"
            );
            
            System.out.print("Digite o comando a ser realizado: ");
            task = tec.nextInt();
            switch(task){
                case 1:
                    System.out.print("Digite o código da filial a cadastrado o livro -> #FL");
                    codigoCadastro = tec.nextInt();
                    filiais.get(codigoCadastro).addLivro(register(livros));
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
                case 4:
                    carregarEstoque(path, filiais);
                    break;                
                case 5:
                    String txt = atualizaFiliais(filiais);
                    Files.writeString(path, txt);
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
                    }
                    existente = filiais.get(codFilial).addExistente(existente);
                    for(int i = 0; i < livros.size(); i++){
                        if(existente.codigo == livros.get(i).codigo){
                            System.out.println(existente.estoque);
                            System.out.println(livros.get(i).estoque);
                            livros.get(i).estoque += existente.estoque;
                        }
                    }
                    break;
                case 8:
                    for(int i = 0; i < filiais.size(); i++){
                        filiais.get(i).info();
                        System.out.println();
                        System.out.println();
                    }
                    break;
                case 9:
                    for(int i = 0; i<livros.size(); i++){
                        livros.get(i).info(true);
                    }
                    break;
                case 0:
                    System.out.println("Deseja atualizar os dados antes de encerrar? (S/N)");
                    String resp = tec.next();
                    if(resp.equals("S")){
                        atualizaFiliais(filiais);
                    }
                    System.out.println("Fim do programa.");
                    prog = "cabô";
                    break;
                // Cadastros automaticos para teste do programa;//
                // Cadastros automaticos para teste do programa;//
                case 77:
                    System.out.print("Digite o código da filial a cadastrada os livros -> #FL");
                    codigoCadastro = tec.nextInt();
                    autoIncrementLivros += 1;
                    filiais.get(codigoCadastro).addLivro(autoReg(autoIncrementLivros, livros));
                    break;
                case 88:
                    filiais.add(autoFilial(autoIncrementFiliais));
                    autoIncrementFiliais +=1;
                    break;
                default:
                    System.out.println("Digite um comando válido");
                    break;
            }

        }
    }
}
/*
I have a Class named Filial.
On my Main class, i created a ArrayList of it:

`ArrayList<Filial> filiais = new ArrayList<Filial>();
`

Still on my Main, i created a method:
```
    public static void atualizaFiliais(ArrayList filial){
        Filial thisFilial = filial.get(0); // <======Error
```

But i get this error when i try do this, thats say:

> 'Type mismatch cannot convert from Object to Filial' 

Why cant i do this?

 I also tried to set its attributes but also get error, for example:

**Filial.java**
```
public class Filial {
    String nome, endereco, contato, codigo;
```

**Main.java**
```
   public static void atualizaFiliais(ArrayList filial){
             String txta;
             txta = filial.get(0).nome //<====== Error
```

in that case it happens to appear the error on nome:
> 
> 'nome cannot be resolved or is not a field'
 */