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
    Biblioteca library = new Biblioteca();
    String titulo, codigo, editora, area;
    int ano, estoque;
    double valor;

    public double valorTotal() {
        return estoque * valor;
    }

    public void info() {
        System.out.println(">> Cod#" + this.codigo + "\n" +
                "Titulo/Editora: " + this.titulo + "/" + this.editora + "\n" +
                "Categoria: " + this.area + "\n" + //
                "Ano: " + this.ano + "\n" + //
                "Valor: " + this.valor + "\n" + //
                "Estoque: " + this.estoque + "\n" + //
                "Valor total em estoque: " + valorTotal());
    }

}
