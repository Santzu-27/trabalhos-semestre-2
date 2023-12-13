import java.util.ArrayList;

public class Tutor extends Pessoa{
    ArrayList<Pet> pets = new ArrayList<>();
    Tutor(String nome_completo, String endereco, String email, int CPF, int telefone){
        super(nome_completo, endereco, email, CPF, telefone);
    }
}
