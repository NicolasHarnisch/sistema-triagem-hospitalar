package servico;

import dados.GerenciadorArquivos;
import modelo.Paciente;

import java.util.List;

public class FilaAtendimento {
    private List<Paciente> fila;
    private GerenciadorArquivos gerenciador;

    public FilaAtendimento() {
        this.gerenciador = new GerenciadorArquivos();
        this.fila = gerenciador.lerPacientes();
    }

    public List<Paciente> getFila() {
        return fila;
    }

    public void setFila(List<Paciente> fila) {
        this.fila = fila;
    }

    public GerenciadorArquivos getGerenciador() {
        return gerenciador;
    }

    public void setGerenciador(GerenciadorArquivos gerenciador) {
        this.gerenciador = gerenciador;
    }

    public void adicionarPaciente(Paciente pac) {
        this.fila.add(pac);
        gerenciador.atendimentoPaciente(pac);
        System.out.println("Paciente " + pac.getNome() + " entrou na fila");
    }

    public Paciente chamarProximo() {
        if(this.fila.isEmpty()) {
            return null;
        }

        Paciente pacienteGrave = this.fila.getFirst();

        for (Paciente pac : this.fila) {
            if (pac.getNivelPrioridade() < pacienteGrave.getNivelPrioridade()) {
                pacienteGrave = pac;
            }
        }
        this.fila.remove(pacienteGrave);
        gerenciador.atualizarArquivo(this.fila);

        return pacienteGrave;
    }

    public int getQuantidadeFila(){
        return this.fila.size();
    }
}
