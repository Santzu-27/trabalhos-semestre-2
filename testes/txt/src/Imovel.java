import java.util.Scanner;

public class Imovel {
    String dono, contato, endereco, CEP;
    double valor, area;
    int qtdQuartos;

    public Imovel (){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Qual o nome do proprietario:");
        this.dono = teclado.nextLine();
        System.out.println("Qual o contato do proprietario:");
        this.contato = teclado.nextLine();
        System.out.println("Qual o endereco do imovel:");
        this.endereco = teclado.nextLine();
        System.out.println("Qual o valor do imovel:");
        this.valor = teclado.nextDouble();
    }
    public Imovel (String dono, String contato, double valor){
        this.dono = dono;
        this.contato = contato;
        this.valor = valor;
    }

    public void info(){
        System.out.println();
        System.out.println(">>> Informacoes de imovel");
        System.out.println("Proprietario: " + this.dono + " | " + this.contato);
        System.out.println("Endereco:" + this.endereco);
        System.out.println("CEP:" + this.CEP);
        System.out.println("Valor: R$ " + this.valor);
        System.out.println("Area m2: " + this.area);
        System.out.println("Quartos:" + this.qtdQuartos);
    }

    public void alteraContato(String novoContato){
        this.contato = novoContato;
        System.out.println("Contato alterado!");
    }

    public void alteraContato(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o novo contato:");
        this.contato = teclado.nextLine();
        System.out.println("Contato alterado!");
    }
}
