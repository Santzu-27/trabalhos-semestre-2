public class Poupanca extends Conta{

    private final double rendimento;
    private int saques = 3;

    Poupanca(Pessoa titular, Banco banco, String senha, int id, double rendimento) {
        super(titular, banco, senha, id);
        this.rendimento = rendimento;
    }

    void info(){
        System.out.printf(
                """
                    Nome do banco: %s
                    Numero da conta: %d
                    Titular: %s %s
                    Saldo: %.2f
                    Rendimento mensal : %.1f %%
                    Saques restantes: %d
                    
                """,
                super.banco.getNome(),
                super.id,
                super.titular.nome, super.titular.sobrenome,
                super.saldo,
                this.rendimento,
                this.saques
        );
    }
    void saque(String senha){
        if (this.saques > 0){
            super.saque(senha);
            this.saques--;
        }
        else System.out.println("Numero maximo de saques no mes ja atingido. ");
    }
    void novoMes(){
        this.saques = 3;
        super.saldo = this.saldo * ( (this.rendimento/100)+1 );
        System.out.printf("(passo o mes) Saldo: R$%.2f, numero de saques restituido.\n", super.saldo);
    }

}
