package dados;

import modelo.Paciente;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorArquivos {
    private final File arquivo = new File("pacientes.txt");

    public void atendimentoPaciente(Paciente paciente) {
        try {
            System.out.println("SALVANDO NO ARQUIVO: " + arquivo.getAbsolutePath());
            FileWriter fw = new FileWriter(arquivo, true);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(paciente.getNome() + ";" +
                    paciente.getCpf() + ";" +
                    paciente.getDataNascimento() + ";" +
                    paciente.getCartaoSUS() + ";" +
                    paciente.getSintomaPrincipal() + ";" +
                    paciente.getNivelPrioridade());
            pw.flush();
            pw.close();
            fw.close();

            System.out.println("Dados gravados no arquivo");
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo");
        }
    }

    public List<Paciente> lerPacientes() {
        List<Paciente> lista = new ArrayList<>();

        if (!arquivo.exists()) {
            return lista;
        }

        try {
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();

            while (linha != null) {
                String[] dados = linha.split(";");

                String nome = dados[0];
                String cpf = dados[1];

                LocalDate dataNasc = LocalDate.parse(dados[2]);

                String cartaoSus = dados[3];
                String sintoma = dados[4];

                int prioridade = Integer.parseInt(dados[5]);

                Paciente p = new Paciente(nome, cpf, dataNasc, cartaoSus, sintoma);
                p.setNivelPrioridade(prioridade);

                lista.add(p);

                linha = br.readLine();
            }

            br.close();
            fr.close();

        } catch (Exception e) {
            System.out.println("Erro no arquivo: " + e.getMessage());
        }

        return lista;
    }

    public void atualizarArquivo(List<Paciente> listaPacientes) {
        try {
            FileWriter fw = new FileWriter(arquivo, false);
            PrintWriter pw = new PrintWriter(fw);

            for (Paciente p : listaPacientes) {
                pw.println(p.getNome() + ";" +
                        p.getCpf() + ";" +
                        p.getDataNascimento() + ";" +
                        p.getCartaoSUS() + ";" +
                        p.getSintomaPrincipal() + ";" +
                        p.getNivelPrioridade());
            }
            pw.close();
            fw.close();

        } catch (IOException e) {
            System.out.println("Erro ao atualizar arquivo: " + e.getMessage());
        }
    }
}
