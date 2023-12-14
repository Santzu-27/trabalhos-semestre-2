import java.util.ArrayList;

public class Pessoa {
    private String nome_completo;
    private int CPF;
    private String endereco;
    private ArrayList<Integer> telefones;
    private String email;

    Pessoa (String nome_completo, int CPF, String endereco, String email){
        this.nome_completo = nome_completo;
        this.CPF = CPF;
        this.endereco = endereco;
        this.email = email;
        this.telefones = new ArrayList<>();
    }

    public String getNomeCompleto(){
        return this.nome_completo;
    }

    public int getCPF(){
        return this.CPF;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public String getEmail(){
        return this.email;
    }

    public void info_pessoa (){
        System.out.println("Segue abaixo os dados da pessoa:");
        System.out.println("Nome completo: " + this.nome_completo);
        System.out.println("CPF: " + this.CPF);
        System.out.println("Endereco: " + this.endereco);
        System.out.println("E-mail: " + this.email);
    }

    public void info_contato (){
        for (int i=0; i< this.telefones.size(); i++) {
            System.out.println("Telefones: " + this.telefones.get(i));
        }
    }
}