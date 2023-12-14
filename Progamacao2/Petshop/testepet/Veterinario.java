import java.util.ArrayList;
public class Veterinario extends Pessoa {
    public int CRMV;
    public ArrayList<Consulta> atendimentos;
    String turno;

    Veterinario (String nome_completo, int CPF, String endereco, String email, int CRMV, String turno){
        super (nome_completo, CPF, endereco, email);
        this.CRMV = CRMV;
        this.turno = turno;

        this.atendimentos = new ArrayList<>();

    }
    public void info_veterinario(){
        System.out.println("Nome: " + this.getNomeCompleto());
        System.out.println("CPF: " + this.getCPF());
        System.out.println("Endereço: " + this.getEndereco());
        System.out.println("Email: " + this.getEmail());
        System.out.println("CRMV: " + this.CRMV);
        System.out.println("Turno: " + this.turno);
    }

    public void info_consultas (){
        double valortotal = 0;
        System.out.println("Informações das consultas do(a) veterinário(a): " + this.getNomeCompleto());
        for (int i = 0; i < this.atendimentos.size(); i++){
            this.atendimentos.get(i).info_consulta();
            double valor = this.atendimentos.get(i).valor;
            valortotal += valor;

        }
        System.out.println("Valor total das consultas: " + valortotal);
        System.out.println();
    }
    public void adicionaConsulta (Consulta consulta){
        this.atendimentos.add(consulta);
    }
}



