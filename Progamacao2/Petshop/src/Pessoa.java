import java.util.ArrayList;

public class Pessoa {
    private String nome_completo, endereco, email;
    private int CPF;
    private ArrayList<Integer> telefone = new ArrayList<Integer>();

    Pessoa(String nome_completo, String endereco, String email, int CPF, int telefone){
        this.nome_completo = nome_completo;
        this.endereco = endereco;
        this.email = email;
        this.CPF = CPF; 
        // this.telefone.add(telefone);
    }
}
