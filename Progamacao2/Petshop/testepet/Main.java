import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {

        ArrayList<Tutor> tutores = new ArrayList<>();
        ArrayList<Pet> pets = new ArrayList<>();
        ArrayList<Veterinario> veterinarios = new ArrayList<>();
        ArrayList<Consulta> consultas = new ArrayList<>();

        tutores.add (new Tutor("João", 123, "Rua X", "joao@gmail.com"));
        tutores.add (new Tutor("Maria", 456, "Rua Y", "maria@gmail.com"));

        pets.add (new Pet ("Cachorro", "Poodle", "Pluto", 2));
        pets.add (new Pet ("Gato", "siames", "mimi", 3));

        veterinarios.add (new Veterinario ("Laura", 123, "Rua X", "joao@gmail.com", 345, "Manhã"));
        veterinarios.add (new Veterinario ("Gabriel", 345, "Rua Y", "joao@gmail.com", 789, "Noite"));


        consultas.add (new Consulta (veterinarios.get(0), pets.get(0), tutores.get(0),500, "20/06/2022"));
        veterinarios.get(0).adicionaConsulta(consultas.get(consultas.size()-1));
        pets.get(0).adicionaConsulta(consultas.get(consultas.size()-1));
        pets.get(0).adicionaTutor(tutores.get(0));
        tutores.get(0).adicionaPet(pets.get(0));


        consultas.add (new Consulta (veterinarios.get(0), pets.get(1), tutores.get(1), 600, "20/09/2022"));
        veterinarios.get(0).adicionaConsulta (consultas.get(consultas.size()-1));
        pets.get(1).adicionaConsulta(consultas.get(consultas.size()-1));
        pets.get(1).adicionaTutor(tutores.get(1));
        tutores.get(1).adicionaPet(pets.get(1));

        consultas.add (new Consulta (veterinarios.get(1), pets.get(0), tutores.get(0), 800, "20/08/2022"));
        veterinarios.get(1).adicionaConsulta(consultas.get(consultas.size()-1));
        pets.get(0).adicionaConsulta(consultas.get(consultas.size()-1));
        pets.get(0).adicionaTutor(tutores.get(0));
        tutores.get(0).adicionaPet(pets.get(0));


        consultas.add (new Consulta (veterinarios.get(1), pets.get(1), tutores.get(1), 900, "20/08/2023"));
        veterinarios.get(1).adicionaConsulta(consultas.get(consultas.size()-1));
        pets.get(1).adicionaConsulta(consultas.get(consultas.size()-1));
        pets.get(1).adicionaTutor(tutores.get(1));
        tutores.get(1).adicionaPet(pets.get(1));


        System.out.println("Informações dos tutores: ");
        for (Tutor tutor: tutores){
            tutor.info_tutor();
            System.out.println();
        }

        System.out.println();

        System.out.println("Informações das consultas: ");
        for (Consulta consulta : consultas){
            consulta.info_consulta();
            System.out.println();
        }
        System.out.println();

        System.out.println("Informações dos pets: ");
        for (Pet pet: pets){
            pet.info_pet();
            System.out.println();
        }
        System.out.println();

        System.out.println("Informações dos veterinários: ");
        for (Veterinario veterinario: veterinarios){
            veterinario.info_veterinario();
            System.out.println();
        }
        System.out.println();

        System.out.println("Informações das consultas dos Pets");
        for (int i=0; i<pets.size(); i++){
            pets.get(i).info_consultas();
            System.out.println();
        }
        System.out.println();

        System.out.println("Informações das consultas dos veterinarios");
        for (int i=0; i<veterinarios.size(); i++){
            veterinarios.get(i).info_consultas();
            System.out.println();
        }
        System.out.println();
    }
}