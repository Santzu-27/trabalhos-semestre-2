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
    int estoqueTotal = 0;

    public double valorTotal() {
        return estoque * valor;
    }

    public void info() {
        System.out.println(">> Cod#" + codigo + "\n" +
                "Titulo/Editora: " + titulo + "/" + editora + "\n" +
                "Categoria: " + area + "\n" + //
                "Ano: " + ano + "\n" + //
                "Valor: " + valor + "\n" + //
                "Estoque: " + estoque + "\n" + //
                "Valor total em estoque: " + valorTotal());
    }

}
