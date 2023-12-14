import java.util.ArrayList;
public class Pet {
    private String especie, raca, nome;
    private int idade;
    private ArrayList<Tutor> tutores;
    private ArrayList<Consulta> atendimentos;


    public Pet(String especie, String raca, String nome, int idade) {
        this.especie = especie;
        this.raca = raca;
        this.nome = nome;
        this.idade = idade;

        this.tutores = new ArrayList<>();
        this.atendimentos = new ArrayList();
    }

    public String getEspecie() {
        return this.especie;
    }

    public String getRaca(){
        return this.raca;
    }

    public String getNome(){
        return this.nome;
    }

    public int getIdade(){
        return this.idade;
    }

    public void info_pet(){
        System.out.println("Especie: " + this.getEspecie());
        System.out.println("Raça: " + this.getRaca());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Idade: " + this.getIdade());
        System.out.println();
    }

    public void info_tutores() {
        System.out.println("Tutores: ");
        for (Tutor tutor : tutores) {
            tutor.info_tutor();
            System.out.println();
        }
    }
         public void info_consultas(){
            double valortotal = 0;
            System.out.println("Consultas do pet: " + this.getNome());
            for (int i=0; i< atendimentos.size(); i++) {
                atendimentos.get(i).info_consulta();
                double valor = atendimentos.get(i).valor;
                valortotal += valor;
            }
            System.out.println("Valor total das consultas: " + valortotal);
            System.out.println();
        }

        public void adicionaTutor(Tutor tutor){
            this.tutores.add(tutor);
        }

        public void adicionaConsulta (Consulta consulta){
            this.atendimentos.add(consulta);
        }

    }