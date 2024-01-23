import java.util.ArrayList;
import java.util.Scanner;

public class Pessoa {
    String nome, sobrenome;
    private final String cpf;
    private ArrayList<Conta> contas = new ArrayList<>();
    static Scanner input = new Scanner(System.in);


    Pessoa(String nome, String sobrenome, String cpf){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }
    Pessoa(){
        System.out.print("Nome: ");
        this.nome = input.nextLine();

        System.out.print("Sobrenome: ");
        this.sobrenome = input.nextLine();

        System.out.print("CPF: ");
        this.cpf = input.nextLine();
    }


    void info(){
        System.out.printf("Nome completo: %s %s\nCPF: %s", this.nome, this.sobrenome, this.cpf);
    }

    void info_contas(){
        for (Conta conta : contas){
            conta.info();
        }
    }
    void addConta(Conta conta) {
        this.contas.add(conta);
        System.out.printf("ID conta: %d\n", this.contas.get(this.contas.size() - 1).id);
    }
    void removeConta(Conta conta, String senha) { if (conta.verificaSenha(senha))this.contas.remove(conta); }
    String getCpf() { return cpf; }

    Conta getConta(int id, String senha) {
        for (Conta conta : contas){
            if (id == conta.id && senha.equals(conta.senha)){ return conta;}
        }
        return null;
    }
}
