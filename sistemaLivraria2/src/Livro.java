public class Livro {
        // ● Titulo
    // ● Código
    // ● Editora
    // ● Área
    // ● Ano
    // ● Valor
    // ● Quantidade em Estoque

    String titulo, codigo, editora, area;
    int ano, estoque;
    double valor;

    public double valorTotal(){
        return estoque * valor;
    }

    public void info(){
        System.out.println(">> Cod#" + lista.get(i).codigo+"\n" +
                                "Titulo/Editora: " + lista.get(i).titulo + "/" + lista.get(i).editora+ "\n" +
                                "Categoria: " + lista.get(i).area + "\n" +//
                                "Ano: " + lista.get(i).ano + "\n" +//
                                "Valor: " + lista.get(i).valor + "\n"+ //
                                "Estoque: " + lista.get(i).estoque + "\n"+ //
                                "Valor total em estoque: " + lista.get(i).valorTotal()
                        );
    }
    

}
