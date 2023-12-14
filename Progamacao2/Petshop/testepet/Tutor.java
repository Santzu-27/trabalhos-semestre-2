import java.util.ArrayList;
public class Tutor extends Pessoa {

    private ArrayList<Pet> pets;

    public Tutor (String nome_completo, int CPF, String endereco, String email){
        super (nome_completo, CPF, endereco, email);

        this.pets = new ArrayList<>();

    }
    public void info_tutor(){
        System.out.println("Nome: " + this.getNomeCompleto());
        System.out.println("CPF: " + this.getCPF());
        System.out.println("Endereço: " + this.getEndereco());
        System.out.println("Email: " + this.getEmail());
    }

    public void info_pets(){
        System.out.println("Informações dos pets: ");
        for (int i=0; i<this.pets.size(); i++){
            pets.get(i).info_pet();
        }
    }
    public void adicionaPet(Pet pet){
        this.pets.add(pet);
    }
}