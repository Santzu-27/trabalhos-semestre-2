
import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    private final String nome, cnpj;
    private final int id;
    private ArrayList<Conta> contasBanco = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    Banco(String nome, String cnpj, ArrayList<Banco> todosBancos){
        this.nome = nome;
        this.cnpj = cnpj;
        this.id = genIdBanco(todosBancos);
    }
    void infoBanco(){
        System.out.printf(
                "Nome do banco: %s \n CNPJ: %s \nNumero do banco: %d\n",
                    this.nome,        this.cnpj,        this.id
        );
    }
    void infoContas(){
        for(Conta conta : contasBanco){
            conta.info();
        }
    }
    void novaConta(Pessoa titular, String senha, double val, int type){

        if(type == 1) contasBanco.add(new Corrente(titular, this, senha, genIdConta(), val));

        else if (type == 2) contasBanco.add(new Poupanca(titular, this, senha, genIdConta(), val));

        titular.addConta(contasBanco.get(contasBanco.size() - 1));
    }
    void fechaConta(int id, String senha){

        Conta conta_to_remove = null;

        for (Conta conta : contasBanco){
            if (conta.id == id){
                contasBanco.remove(conta);
                conta_to_remove = conta;
                break;
            }
        }
        if (conta_to_remove != null) conta_to_remove.titular.removeConta(conta_to_remove, senha);
    }

    int genIdConta(){
        int id = 1;
        for(Conta conta : contasBanco){
            id++;
        }
        // System.out.printf("ID conta: %d\n", id);
        return id;
    }

    int genIdBanco(ArrayList<Banco> bancos){
        int id = 1;

        for(Banco banco : bancos){
            id++;
        }
        // System.out.printf("ID banco: %d\n", id);
        return id;

    }
    String getNome(){ return this.nome; }
    int getId(){ return this.id; }
}
