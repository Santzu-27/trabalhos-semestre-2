import java.util.ArrayList;

public class Veterinario extends Pessoa {
        int CRMV;
        String  turno;
        ArrayList<Consulta> atendimentos;
        Veterinario(String nome_completo, String endereco, String email, int CPF, int telefone){
            super(nome_completo, endereco, email, CPF, telefone);
            
        }
}
