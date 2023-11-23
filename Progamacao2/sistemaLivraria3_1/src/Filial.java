
/*● Código (valor numérico)
● Nome da filial
● Endereço da filial
● Contato da filial
● Livros em estoque */
import java.util.Scanner;
import java.util.ArrayList;

public class Filial {
    int codigo;
    String nome, endereco, contato;
    ArrayList<Livro> estoqueFilial = new ArrayList<Livro>();

    public void info() {

        if (codigo > 9)
            System.out.println("#FL" + codigo);
        else
            System.out.println("#FL0" + codigo);

        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Contato: " + contato);
    }

    public void listagemEstoque() {
        for (int i = 0; i < estoqueFilial.size(); i++) {
            estoqueFilial.get(i).info();
        }
    }

    public void buscaCodigo(String codigoBuscado) {
        boolean encontrado = false;
        double valorTotal = 0;
        for (int i = 0; i < estoqueFilial.size(); i++) {
            Livro livroBuscado = estoqueFilial.get(i);
            if (codigoBuscado.equals(livroBuscado.codigo) && !encontrado) {
                System.out.println(">>>>> COD#"+livroBuscado.codigo);
                System.out.println("Titulo/Editora: "+livroBuscado.codigo +"/"+ livroBuscado.editora);
                System.out.println("Categoria: "+livroBuscado.area);
                System.out.println("Ano: "+livroBuscado.ano);
                encontrado = true;
            }
            if (codigoBuscado.equals(livroBuscado.codigo) && encontrado) {
                System.out.println("Valor: " + livroBuscado.valor +" >>> " + "Filial " + this.nome + ", estoque : " + livroBuscado.estoque );
                valorTotal += livroBuscado.valorTotal();
            }
        }
        System.out.println("Valor total em estoque: " + valorTotal);
    }
    public Livro encontraExistente(String codigoBuscado) {
        Livro existente = new Livro();
        for (int i = 0; i < estoqueFilial.size(); i++) {
            if (codigoBuscado.equals(estoqueFilial.get(i).codigo)) {
                existente = estoqueFilial.get(i);
            }
        }
        return existente;
    }

    public void addExistente(Livro existente) {
        Scanner tec = new Scanner(System.in);
        Livro novoLivro = new Livro();
        novoLivro.titulo = existente.titulo;
        novoLivro.ano = existente.ano;
        novoLivro.area = existente.area;
        novoLivro.editora = existente.editora;
        System.out.print("Qual a quantidade em estoque nesta filial? ");
        novoLivro.estoque = tec.nextInt();
        System.out.print("Qual o valor? R$");
        novoLivro.valor = tec.nextDouble();
        estoqueFilial.add(novoLivro);
    }
    public void busca() {
        double preco;
        Scanner tec = new Scanner(System.in);
        System.out.println(
                "Qual buscar quer fazer? \n" +
                        "1 - Buscar por título \n" +
                        "2 - Buscar por categoria \n" +
                        "3 - Buscar por preço máximo \n" +
                        "4 - Buscar por preço mínimo \n" +
                        "5 - Buscar por quantidade em estoque \n");
        int comando = tec.nextInt();
        switch (comando) {
            case 1:
                System.out.print("Informe o titulo do livro: ");
                String nome = tec.next();
                for (int i = 0; i < estoqueFilial.size(); i++) {
                    if (nome.equals(estoqueFilial.get(i).titulo)) {
                        estoqueFilial.get(i).info();
                    }
                }
                break;
            case 2:
                System.out.print("Informe a categoria do livro: ");
                String categ = tec.next();
                for (int i = 0; i < estoqueFilial.size(); i++) {
                    if (categ.equals(estoqueFilial.get(i).area)) {
                        estoqueFilial.get(i).info();
                    }
                }
                break;
            case 3:
                System.out.print("Digite o preço máximo desejado: ");
                preco = tec.nextDouble();
                for (int i = 0; i < estoqueFilial.size(); i++) {
                    if (preco >= estoqueFilial.get(i).valor) {
                        estoqueFilial.get(i).info();
                    }
                }
                break;
            case 5:
                System.out.print("Informe a quantidade mínima de estoque do livro: ");
                int quant = tec.nextInt();
                for (int i = 0; i < estoqueFilial.size(); i++) {
                    if (quant <= estoqueFilial.get(i).estoque) {
                        estoqueFilial.get(i).info();
                    }
                }
                break;
            case 4:
                System.out.print("Informe o valor minimo do livro: ");
                preco = tec.nextDouble();
                for (int i = 0; i < estoqueFilial.size(); i++) {
                    if (preco <= estoqueFilial.get(i).valorTotal()) {
                        estoqueFilial.get(i).info();
                    }
                }
                break;
            default:
                break;
        }
    }
}
