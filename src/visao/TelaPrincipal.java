package visao;

import excecoes.DadoInvalidoException;
import modelo.Enfermeiro;
import modelo.Paciente;
import modelo.SinaisVitais;
import servico.FilaAtendimento;
import servico.Triagem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TelaPrincipal extends JFrame {

    JTextField campoNome, campoCpf, campoData, campoSus, campoSintoma;
    JTextField campoBatimentos, campoTemp, campoOxi, campoDor;
    JTextArea areaTextoFila;

    FilaAtendimento fila;
    Enfermeiro enfermeiro;

    public TelaPrincipal() {
        fila = new FilaAtendimento();
        enfermeiro = new Enfermeiro("Enfermeiro Chefe", "1234", LocalDate.now(), "01", "1234");

        setTitle("Trabalho Final - Triagem");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 2, 10, 0));

        JPanel painelEsquerdo = new JPanel();
        painelEsquerdo.setLayout(new BorderLayout());

        JPanel formCampos = new JPanel();
        formCampos.setLayout(new GridLayout(10, 2, 5, 5));

        formCampos.add(new JLabel(" Nome do Paciente:"));
        campoNome = new JTextField();
        formCampos.add(campoNome);

        formCampos.add(new JLabel(" CPF:"));
        campoCpf = new JTextField();
        formCampos.add(campoCpf);

        formCampos.add(new JLabel(" Data Nasc (dd/mm/aaaa):"));
        campoData = new JTextField();
        formCampos.add(campoData);

        formCampos.add(new JLabel(" Cartão SUS:"));
        campoSus = new JTextField();
        formCampos.add(campoSus);

        formCampos.add(new JLabel(" Sintoma:"));
        campoSintoma = new JTextField();
        formCampos.add(campoSintoma);

        formCampos.add(new JLabel(" Batimentos (BPM):"));
        campoBatimentos = new JTextField();
        formCampos.add(campoBatimentos);

        formCampos.add(new JLabel(" Temperatura (Cº):"));
        campoTemp = new JTextField();
        formCampos.add(campoTemp);

        formCampos.add(new JLabel(" Oxigenação (%):"));
        campoOxi = new JTextField();
        formCampos.add(campoOxi);

        formCampos.add(new JLabel(" Nível de Dor (0-10):"));
        campoDor = new JTextField();
        formCampos.add(campoDor);

        formCampos.add(new JLabel(""));
        formCampos.add(new JLabel(""));

        JButton botaoCadastrar = new JButton("CADASTRAR E CLASSIFICAR");
        botaoCadastrar.setPreferredSize(new Dimension(0, 50));

        painelEsquerdo.add(formCampos, BorderLayout.CENTER);
        painelEsquerdo.add(botaoCadastrar, BorderLayout.SOUTH);

        JPanel painelDireito = new JPanel();
        painelDireito.setLayout(new BorderLayout());

        painelDireito.add(new JLabel("  Lista de Espera (Por Prioridade):"), BorderLayout.NORTH);

        areaTextoFila = new JTextArea();
        areaTextoFila.setEditable(false);
        painelDireito.add(new JScrollPane(areaTextoFila), BorderLayout.CENTER);

        JButton botaoAtender = new JButton("CHAMAR PRÓXIMO PACIENTE");
        botaoAtender.setPreferredSize(new Dimension(0, 50));
        painelDireito.add(botaoAtender, BorderLayout.SOUTH);

        add(painelEsquerdo);
        add(painelDireito);


        atualizarVisualizacaoFila();

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliqueCadastrar();
            }
        });

        botaoAtender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliqueAtender();
            }
        });
    }

    private void cliqueCadastrar() {
        try {
            if (campoNome.getText().isEmpty()) throw new DadoInvalidoException("O campo Nome não pode estar vazio!");

            String nome = campoNome.getText();
            String cpf = campoCpf.getText();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(campoData.getText(), formatador);
            String sus = campoSus.getText();
            String sintoma = campoSintoma.getText();

            int bpm = Integer.parseInt(campoBatimentos.getText());
            double temp = Double.parseDouble(campoTemp.getText());
            int oxi = Integer.parseInt(campoOxi.getText());
            int dor = Integer.parseInt(campoDor.getText());

            Paciente p = new Paciente(nome, cpf, data, sus, sintoma);
            SinaisVitais sv = new SinaisVitais(bpm, temp, oxi, dor);
            Triagem t = new Triagem(p, enfermeiro, sv);

            fila.adicionarPaciente(p);

            JOptionPane.showMessageDialog(this, "Prioridade: " + t.getPrioridade());
            limpar();
            atualizarVisualizacaoFila();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro nos dados: " + ex.getMessage());
        }
    }

    private void cliqueAtender() {
        Paciente p = fila.chamarProximo();
        if (p != null) {
            JOptionPane.showMessageDialog(this, "Chamando: " + p.getNome());
            atualizarVisualizacaoFila();
        } else {
            JOptionPane.showMessageDialog(this, "Fila Vazia");
        }
    }

    private void atualizarVisualizacaoFila() {
        areaTextoFila.setText("");
        List<Paciente> lista = fila.getFila();
        for (Paciente p : lista) {
            areaTextoFila.append("Prioridade " + p.getNivelPrioridade() + " - " + p.getNome() + "\n");
        }
    }

    private void limpar() {
        campoNome.setText(""); campoCpf.setText(""); campoData.setText("");
        campoSus.setText(""); campoSintoma.setText(""); campoBatimentos.setText("");
        campoTemp.setText(""); campoOxi.setText(""); campoDor.setText("");
    }

    public static void main(String[] args) {
        new TelaPrincipal().setVisible(true);
    }
}