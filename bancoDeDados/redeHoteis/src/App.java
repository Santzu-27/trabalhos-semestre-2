import DAO.itens_lavanderiaDAO;

import java.util.Scanner;
import entitys.itens_lavanderia;
public class App {
    public static void main(String[] args) throws Exception {
        // Class.forName("com.mysql.cj.jdbc.Driver");
        boolean rodando = true;
        int funcao;
        Scanner sc = new Scanner(System.in);
        // item1.setDescricao("lavagemzinha");
        // item1.setUnidade(2);
        // item1.setValor(21.5);
        
        while (rodando = true) {
            System.out.println("1 - Inserir Item");
            System.out.println("2 - Deletar Item");
            System.out.print("-> ");
            funcao = sc.nextInt();
            int cod;
            switch (funcao) {
                case 1:
                    itens_lavanderia novoitem = new itens_lavanderia();
                    System.out.print("Digite a descrição: ");
                    sc.nextLine();
                    String desc = sc.nextLine();
                    novoitem.setDescricao(desc);
                    
                    System.out.print("Digite a unidade: ");
                    int unid = sc.nextInt();
                    novoitem.setUnidade(unid);
                    
                    System.out.print("Digite o valor: ");
                    double valor = sc.nextDouble();
                    novoitem.setValor(valor);
                    new itens_lavanderiaDAO().cadastraItem(novoitem);
                    break;
                case 2:  
                    System.out.print("Digite o código do item a ser deletado: ");
                    cod = sc.nextInt();
                    itens_lavanderia novoitem2 = new itens_lavanderia();
                    novoitem2.setCodigo(cod);
                    new itens_lavanderiaDAO().deletaItem(novoitem2);
                    break;
                    default:
                    rodando = false;
                    break;
                    case 3:
                        System.out.println("Lista de Itens");
                        itens_lavanderiaDAO itemN = new itens_lavanderiaDAO();
                        itens_lavanderia[] itens = itemN.selecionar();
                        for (int i=0; i<itens.length; i++) {
                            System.out.println(
                                "Codigo " + itens[i].getCodigo() + " - "+ itens[i].getDescricao() + "\n"+
                                "Valor unitário -> " + itens[i].getValor() +"\n"+
                                "Unidade -> " + itens[i].getUnidade()
                            );
                        }
                    break;
                
            }
        };

        
    }
}


