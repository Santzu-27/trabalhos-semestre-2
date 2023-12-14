package banco;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    static ArrayList<Pessoa> todasPessoas = new ArrayList<>();
    static ArrayList<Banco> todosBancos = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        todasPessoas.add(new Pessoa("pedro", "silva", "123"));
        todosBancos.add(new Banco("itau", "555", todosBancos));

        todosBancos.get(0).novaConta(todasPessoas.get(0), "123", 10, 1);
        todosBancos.get(0).novaConta(todasPessoas.get(0), "123", 10, 2);

        opcoes();

    }

    static void opcoes(){
        System.out.print(
                """
                    =========== menu ===========
                        1- Gerenciar bancos
                        2- Gerenciar pessoas
                        0- Sair
                >>>"""
        );
        String opt = input.next();


        switch (opt){

            case "1" -> gerenciarBanco();
            case "2" -> gerenciarPessoa();
            case "0" -> System.out.println("Encerrando...");
            default -> System.out.println("opcao invalida");

        }
        if (!opt.equals("0")) opcoes();

    }
    static void gerenciarBanco(){
        System.out.print(
                """
                    ============ banco ============
                        1- Criar banco
                        2- Acessar banco
                        3- Criar conta
                        4- Remover conta
                        5- Todas contas do banco
                        0- Voltar
                >>>"""
        );
        String opt = input.next();

        switch (opt){
            case "1" -> {
                input.nextLine();
                System.out.print("Nome do banco: ");
                String nome = input.nextLine();


                System.out.print("CNPJ: ");
                String cnpj = input.nextLine();

                todosBancos.add(new Banco(nome, cnpj, todosBancos));
                System.out.printf("    Criado: id %d \n", todosBancos.get(todosBancos.size()-1).getId());
            }
            case "2" -> {

                input.nextLine();
                System.out.print("Id do banco: ");
                int id = input.nextInt();
                input.nextLine();

                for (Banco banco : todosBancos){
                    if (banco.getId() == id) {banco.infoBanco(); break;}
                }
            }
            case "3" ->{
                input.nextLine();

                System.out.print("Corrente (1) ou Poupanca (2)? ");
                int type = input.nextInt();

                System.out.print("Id do banco: ");
                int id = input.nextInt();

                input.nextLine();
                System.out.print("CPF titular: ");
                String cpf = input.nextLine();

                System.out.print("senha: ");
                String senha = input.nextLine();

                System.out.print("Taxa ou rendimento: ");
                double val = input.nextInt();
                input.nextLine();


                for (Banco banco : todosBancos){
                    if (banco.getId() == id) {

                        for (Pessoa pessoa : todasPessoas){
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
                input.nextLine();

                System.out.print("Id do banco: ");
                int idbanco = input.nextInt();

                System.out.print("ID conta: ");
                int idconta = input.nextInt();
                input.nextLine();

                System.out.print("senha: ");
                String senha = input.nextLine();

                for (Banco banco : todosBancos){
                    if (banco.getId() == idbanco) { banco.fechaConta(idconta, senha); }
                    break;
                }
            }
            case "5" -> {
                input.nextLine();

                System.out.print("Id do banco: ");
                int idbanco = input.nextInt();
                input.nextLine();

                for (Banco banco : todosBancos){
                    if (banco.getId() == idbanco) { banco.infoContas(); }
                    break;
                }
            }
            case "0" -> System.out.println();
            default -> System.out.println("opcao invalida");
        }
        if (!opt.equals("0")) gerenciarBanco();
    }
    static void gerenciarPessoa(){
        System.out.print(
                """
                    ============ pessoa ============
                        1- Cadastrar Pessoa
                        2- Acessar conta
                        3- Todas contas de Pessoa
                        0- Voltar
                >>>"""
        );
        String opt = input.next();

        switch (opt) {
            case "1" -> todasPessoas.add(new Pessoa());
            case "2" -> {
                input.nextLine();

                System.out.print("Digite o cpf: ");
                String cpf = input.nextLine();

                int indexPessoa = 0;
                for (; indexPessoa<todasPessoas.size(); indexPessoa++ ){

                    if (todasPessoas.get(indexPessoa).getCpf().equals(cpf)) break;
                }

                System.out.print("ID conta: ");
                int idconta = input.nextInt();

                input.nextLine();
                System.out.print("senha: ");
                String senha = input.nextLine();

                Conta conta = todasPessoas.get(indexPessoa).getConta(idconta, senha);
                String optconta = "";
                if (conta != null){
                    System.out.print("( 1- Info conta \n2- Deposito \n3- Saque \n4- Novo mes \n0- voltar )");
                    do{
                        System.out.print(">>> ");
                        optconta = input.nextLine();

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
                input.nextLine();

                System.out.print("CPF: ");
                String cpf = input.nextLine();

                for (Pessoa pessoa : todasPessoas){
                    if (pessoa.getCpf().equals(cpf)) pessoa.info_contas();
                }
            }
            case "0" -> System.out.println();
            default -> System.out.println("opcao invalida");
        }
        if (!opt.equals("0")) gerenciarPessoa();
    }
}
