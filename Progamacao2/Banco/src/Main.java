import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    static ArrayList<Pessoa> Pessoas = new ArrayList<>();
    static ArrayList<Banco> Bancos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Pessoas.add(new Pessoa("lais", "paim", "800"));
        Bancos.add(new Banco("caixa", "4444", Bancos));

        Bancos.get(0).novaConta(Pessoas.get(0), "123", 10, 1);
        Bancos.get(0).novaConta(Pessoas.get(0), "123", 10, 2);

        menu();

    }

    static void menu(){
        System.out.print(
                """
                1- Gerenciar bancos
                2- Gerenciar pessoas
                0- Sair
                ->  """
        );
        String opcao = sc.next();


        switch (opcao){

            case "1":
                gerenciarBanco(); break;
            case "2":
                gerenciarPessoa(); break;
            case "0":
                System.out.println("Encerrando..."); break;
            default: 
                System.out.println("opcao invalida");
        }
        if (!opcao.equals("0")) menu();

    }
    static void gerenciarBanco(){
        System.out.print(
                """
                ---------------=<  BANCO  >=--------------
                1- Criar banco
                2- Acessar banco
                3- Criar conta
                4- Remover conta
                5- Todas contas do banco
                0- Voltar
                ----> """
        );
        String opcao = sc.next();

        switch (opcao){
            case "1" -> {
                sc.nextLine();
                System.out.print("Nome do banco: ");
                String nome = sc.nextLine();


                System.out.print("CNPJ: ");
                String cnpj = sc.nextLine();

                Bancos.add(new Banco(nome, cnpj, Bancos));
                System.out.printf("    Criado: id %d \n", Bancos.get(Bancos.size()-1).getId());
            }
            case "2" -> {

                sc.nextLine();
                System.out.print("Id do banco: ");
                int id = sc.nextInt();
                sc.nextLine();

                for (Banco banco : Bancos){
                    if (banco.getId() == id) {banco.infoBanco(); break;}
                }
            }
            case "3" ->{
                sc.nextLine();

                System.out.print("Corrente (1) ou Poupanca (2)? ");
                int type = sc.nextInt();

                System.out.print("Id do banco: ");
                int id = sc.nextInt();

                sc.nextLine();
                System.out.print("CPF titular: ");
                String cpf = sc.nextLine();

                System.out.print("senha: ");
                String senha = sc.nextLine();

                System.out.print("Taxa ou rendimento: ");
                double val = sc.nextInt();
                sc.nextLine();

                for (Banco banco : Bancos){
                    if (banco.getId() == id) {

                        for (Pessoa pessoa : Pessoas){
                            if (pessoa.getCpf().equals(cpf)){
                                banco.novaConta(pessoa, senha, val, type);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            case "4" -> {
                sc.nextLine();

                System.out.print("Id do banco: ");
                int idbanco = sc.nextInt();

                System.out.print("ID conta: ");
                int idconta = sc.nextInt();
                sc.nextLine();

                System.out.print("senha: ");
                String senha = sc.nextLine();

                for (Banco banco : Bancos){
                    if (banco.getId() == idbanco) { banco.fechaConta(idconta, senha); }
                    break;
                }
            }
            case "5" -> {
                sc.nextLine();

                System.out.print("Id do banco: ");
                int idbanco = sc.nextInt();
                sc.nextLine();

                for (Banco banco : Bancos){
                    if (banco.getId() == idbanco) { banco.infoContas(); }
                    break;
                }
            }
            case "0" -> System.out.println();
            default -> System.out.println("opcao invalida");
        }
        if (!opcao.equals("0")) gerenciarBanco();
    }
    static void gerenciarPessoa(){
        System.out.print(
                """
                ----------< Pessoa >-----------
                    1- Cadastrar Pessoa
                    2- Acessar conta
                    3- Todas contas de Pessoa
                    0- Voltar
                >>>"""
        );
        String opcao = sc.next();

        switch (opcao) {
            case "1" -> Pessoas.add(new Pessoa());
            case "2" -> {
                sc.nextLine();

                System.out.print("Digite o cpf: ");
                String cpf = sc.nextLine();

                int indexPessoa = 0;
                for (; indexPessoa<Pessoas.size(); indexPessoa++ ){

                    if (Pessoas.get(indexPessoa).getCpf().equals(cpf)) break;
                }

                System.out.print("ID conta: ");
                int idconta = sc.nextInt();

                sc.nextLine();
                System.out.print("senha: ");
                String senha = sc.nextLine();

                Conta conta = Pessoas.get(indexPessoa).getConta(idconta, senha);
                String optconta = "";
                if (conta != null){
                    do{
                        System.out.print("( 1- Info conta \n2- Deposito \n3- Saque \n4- Novo mes \n0- voltar )");
                        System.out.print(">>> ");
                        optconta = sc.nextLine();

                        switch (optconta){
                            case "1" -> conta.info();
                            case "2" -> conta.deposito();
                            case "3" -> conta.saque(senha);
                            case "4" -> conta.novoMes();
                        }
                    } while(!optconta.equals("0"));
                }
            }
            case "3" -> {
                sc.nextLine();

                System.out.print("CPF: ");
                String cpf = sc.nextLine();

                for (Pessoa pessoa : Pessoas){
                    if (pessoa.getCpf().equals(cpf)) pessoa.info_contas();
                }
            }
            case "0" -> System.out.println();
            default -> System.out.println("opcao invalida");
        }
        if (!opcao.equals("0")) gerenciarPessoa();
    }
}
