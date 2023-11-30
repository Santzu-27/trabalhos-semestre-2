import java.util.Scanner;

public class Livro {
    // ● Titulo
    // ● Código
    // ● Editora
    // ● Área
    // ● Ano
    // ● Valor
    // ● Quantidade em Estoque
    Scanner tec = new Scanner(System.in);
    String titulo, codigo, editora, area;
    int ano, estoque;
    double valor;

    public double valorTotal() {
        return estoque * valor;
    }

    public void info(boolean geral) {
        System.out.println(">> Cod#" + codigo + "\n" +
                "Titulo/Editora: " + titulo + "/" + editora + "\n" +
                "Categoria: " + area + "\n" + //
                "Ano: " + ano + "\n" + //
                "Valor: " + valor + "\n" + //
                "Estoque: " + estoque
                ) ;//
                if (geral == true) {
                    return;
                }
                System.out.println("Valor total em estoque: " + valorTotal());
    }

}
