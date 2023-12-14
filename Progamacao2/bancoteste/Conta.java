package banco;

import java.util.Scanner;

public abstract class Conta {

    protected Pessoa titular;
    protected Banco banco;
    protected int id;
    protected double saldo = 0;
    protected String senha;
    final int type = 1;

    static Scanner input = new Scanner(System.in);

    Conta(Pessoa titular, Banco banco, String senha, int id){
        this.titular = titular;
        this.banco = banco;
        this.senha = senha;
        this.id = id;

    }

    void saque(double val, String senha){

        if (verificaSenha(senha)){

            if ((this.saldo - val) < 0){
                System.out.printf("Saldo insuficiente. Saldo atual: R$%.2f\n", this.saldo);
            }

            else{
                this.saldo -= val;
                System.out.printf("Sacado R$%.2f. Saldo atual: R$%.2f", val, this.saldo);
            }
        }

    }
    void saque(String senha){

        System.out.print("Digite o valor de saque: ");
        double val = input.nextDouble();

        input.nextLine();

        saque(val, senha);
    }
    void deposito(double val){
        this.saldo += val;
        System.out.printf("Depositado R$%.2f. Saldo atual: R$%.2f", val, this.saldo);

    }
    void deposito(){
        System.out.print("Digite o valor de deposito: ");
        double val = input.nextDouble();

        deposito(val);
    }
    boolean verificaSenha(String senha){

        if (senha.equals(this.senha)) return true;
        else {
            System.out.println("Senha incorreta");
            return false;
        }
    }
    void info(){}
    void novoMes(){}

}
