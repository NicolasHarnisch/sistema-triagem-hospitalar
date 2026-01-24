package testes;

import modelo.Paciente;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    void testCriacaoPaciente() {
        Paciente p = new Paciente("João Silva", "123.456.789-00", LocalDate.of(1990, 5, 20), "SUS123", "Dor de cabeça");

        assertEquals("João Silva", p.getNome());
        assertEquals("SUS123", p.getCartaoSUS());
        assertEquals(0, p.getNivelPrioridade());
    }

    @Test
    void testAlterarPrioridade() {
        Paciente p = new Paciente("manu", "111", LocalDate.now(), "6061", "Febre");
        p.setNivelPrioridade(1);
        assertEquals(1, p.getNivelPrioridade(), "A prioridade deveria ter sido atualizada para 1");
    }
}