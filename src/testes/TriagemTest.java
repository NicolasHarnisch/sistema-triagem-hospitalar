package testes;

import modelo.Enfermeiro;
import modelo.Paciente;
import modelo.SinaisVitais;
import servico.Triagem;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class TriagemTest {

    Paciente paciente = new Paciente("Nícolas", "1234", LocalDate.now(), "12345", "Dor");
    Enfermeiro enf = new Enfermeiro("Enfermeiro", "123", LocalDate.now(), "5761", "123");

    @Test
    void testClassificacaoVermelha() {
        SinaisVitais sinaisGraves = new SinaisVitais(80, 36.5, 70, 0);
        Triagem triagem = new Triagem(paciente, enf, sinaisGraves);

        assertEquals("Vermelho - Emergência", triagem.getPrioridade());
        assertEquals(1, paciente.getNivelPrioridade());
    }

    @Test
    void testClassificacaoVerde() {
        SinaisVitais sinaisLeves = new SinaisVitais(80, 36.5, 98, 5);
        Triagem triagem = new Triagem(paciente, enf, sinaisLeves);

        assertEquals("Verde - Pouco Urgente", triagem.getPrioridade());
        assertEquals(4, paciente.getNivelPrioridade());
    }

    @Test
    void testClassificacaoAzul() {
        SinaisVitais sinaisNormais = new SinaisVitais(70, 36.5, 99, 0);
        Triagem triagem = new Triagem(paciente, enf, sinaisNormais);

        assertEquals("Azul - Não Urgente", triagem.getPrioridade());
        assertEquals(5, paciente.getNivelPrioridade());
    }
}