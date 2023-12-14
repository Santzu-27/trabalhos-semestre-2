public class Consulta {
    Veterinario veterinario;
    Pet paciente;
    Tutor acompanhante;
    double valor;
    String data;

    public Consulta(Veterinario veterinario, Pet paciente, Tutor acompanhante, double valor, String data){

        this.veterinario = veterinario;
        this.paciente = paciente;
        this.acompanhante = acompanhante;
        this.valor = valor;
        this.data = data;

    }

    public void info_consulta(){
        System.out.println("Veterinário: " + veterinario.getNomeCompleto());
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Acompanhante: " + acompanhante.getNomeCompleto());
        System.out.println("Valor: " + valor);
        System.out.println("Data: " + data);
        System.out.println();
    }
}
