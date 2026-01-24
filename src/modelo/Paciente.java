package modelo;

import java.time.LocalDate;

public class Paciente extends Pessoa {
    private String cartaoSUS;
    private String sintomaPrincipal;
    private int nivelPrioridade;

    public Paciente(String nome, String cpf, LocalDate dataNascimento, String cartaoSUS, String sintomaPrincipal) {
        super(nome, cpf, dataNascimento);
        this.cartaoSUS = cartaoSUS;
        this.sintomaPrincipal = sintomaPrincipal;
        this.nivelPrioridade = 0;
    }

    public String getCartaoSUS() {
        return cartaoSUS;
    }

    public void setCartaoSUS(String cartaoSUS) {
        this.cartaoSUS = cartaoSUS;
    }

    public String getSintomaPrincipal() {
        return sintomaPrincipal;
    }

    public void setSintomaPrincipal(String sintomaPrincipal) {
        this.sintomaPrincipal = sintomaPrincipal;
    }

    public int getNivelPrioridade() {
        return nivelPrioridade;
    }

    public void setNivelPrioridade(int nivelPrioridade) {
        this.nivelPrioridade = nivelPrioridade;
    }

    @Override
    public String mostrarDetalhes() {
        return "Detalhes do Paciente\n" +
                "Nome: " + getNome() + "\n" +
                "Cpf: " + getCpf() + "\n" +
                "Data de nascimento: " + getDataNascimento() + "\n" +
                "Numero Cartão SUS: " + getCartaoSUS() + "\n" +
                "Sintoma principal do Paciente: " + getSintomaPrincipal() + "\n";
    }
}
