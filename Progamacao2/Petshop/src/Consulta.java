public class Consulta {
    Veterinario veterinario;
    Pet paciente;
    Tutor acompanhante;
    double valor;
    String data;
    Consulta(Veterinario veterinario, Pet paciente, Tutor acompanhante,Double valor, String data){
        this.veterinario = veterinario;
        this.paciente = paciente;
        this.acompanhante = acompanhante;
        this.data = data;
    }
}
