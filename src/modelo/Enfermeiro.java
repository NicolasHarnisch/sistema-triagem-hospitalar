package modelo;

import java.time.LocalDate;

public class Enfermeiro extends Pessoa{
    private String registroProfissional;
    private String senha;

    public Enfermeiro(String nome, String cpf, LocalDate dataNascimento, String registroProfissional, String senha) {
        super(nome, cpf, dataNascimento);
        this.registroProfissional = registroProfissional;
        this.senha = senha;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String mostrarDetalhes() {
        return "Detalhes do Enfermeiro\n" +
                "Nome: " + getNome() + "\n" +
                "Cpf: " + getCpf() + "\n" +
                "Data de atendimento: " + getDataNascimento() + "\n" +
                "Registro Profissional: " + getRegistroProfissional() + "\n";
    }
}
