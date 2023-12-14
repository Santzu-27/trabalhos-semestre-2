package banco;

public class Corrente extends Conta{

    private final double taxa;

    Corrente(Pessoa titular, Banco banco, String senha, int id, double taxa) {
        super(titular, banco, senha, id);
        this.taxa = taxa;
    }

    void novoMes(){
        super.saldo -= taxa;
        System.out.printf("(passo o mes) Saldo: R$%.2f\n", super.saldo);
    }
    void info(){
        System.out.printf(
                """
                    Nome do banco: %s
                    Numero da conta: %d
                    Titular: %s %s
                    Saldo: %.2f
                    Taxa mensal: R$%.2f
                    
                """,
                super.banco.getNome(),
                super.id,
                super.titular.nome, super.titular.sobrenome,
                super.saldo,
                this.taxa
        );
    }

}
