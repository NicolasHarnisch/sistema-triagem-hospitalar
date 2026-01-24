package servico;

import modelo.Enfermeiro;
import modelo.Paciente;
import modelo.SinaisVitais;

public class Triagem implements Classificar {
    private Paciente paciente;
    private Enfermeiro enfermeiro;
    private SinaisVitais sinaisVitais;
    private String prioridade;

    public Triagem(Paciente paciente, Enfermeiro enfermeiro, SinaisVitais sinaisVitais) {
        this.paciente = paciente;
        this.enfermeiro = enfermeiro;
        this.sinaisVitais = sinaisVitais;
        classificarRiscos(sinaisVitais);
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    public SinaisVitais getSinaisVitais() {
        return sinaisVitais;
    }

    public void setSinaisVitais(SinaisVitais sinaisVitais) {
        this.sinaisVitais = sinaisVitais;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public void classificarRiscos(SinaisVitais sinais) {
        if (sinais.getOxigenacao() < 80 || sinais.getBatimentoCardiaco() > 140 || sinais.getNivelDor() >= 9 || sinais.getTemperatura() >= 41.0) {
            this.prioridade = "Vermelho - Emergência";
            paciente.setNivelPrioridade(1);
        } else if (sinais.getOxigenacao() < 85 || sinais.getBatimentoCardiaco() > 120 || sinais.getNivelDor() >= 7 || sinais.getTemperatura() >= 39.0) {
            this.prioridade = "Laranja - Muito Urgente";
            paciente.setNivelPrioridade(2);
        } else if (sinais.getOxigenacao() < 90 || sinais.getBatimentoCardiaco() > 110 || sinais.getNivelDor() >= 6 || sinais.getTemperatura() >= 38.0) {
            this.prioridade = "Amarelo - Urgente";
            paciente.setNivelPrioridade(3);
        } else if (sinais.getOxigenacao() < 94 || sinais.getBatimentoCardiaco() > 100 || sinais.getNivelDor() >= 5 || sinais.getTemperatura() >= 37.0) {
            this.prioridade = "Verde - Pouco Urgente";
            paciente.setNivelPrioridade(4);
        } else {
            this.prioridade = "Azul - Não Urgente";
            paciente.setNivelPrioridade(5);
        }
    }
}
