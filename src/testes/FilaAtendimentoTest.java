package testes;

import modelo.Paciente;
import servico.FilaAtendimento;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class FilaAtendimentoTest {

    @Test
    void testOrdemDePrioridade() {
        FilaAtendimento fila = new FilaAtendimento();
        fila.getFila().clear();

        Paciente pLeve = new Paciente("Leve", "1", LocalDate.now(), "1", "A");
        pLeve.setNivelPrioridade(4);

        Paciente pGrave = new Paciente("Grave", "2", LocalDate.now(), "2", "B");
        pGrave.setNivelPrioridade(1);

        Paciente pMedio = new Paciente("Medio", "3", LocalDate.now(), "3", "C");
        pMedio.setNivelPrioridade(3);

        fila.adicionarPaciente(pLeve);
        fila.adicionarPaciente(pGrave);
        fila.adicionarPaciente(pMedio);

        Paciente proximo = fila.chamarProximo();

        assertNotNull(proximo);
        assertEquals("Grave", proximo.getNome());
        assertEquals(1, proximo.getNivelPrioridade());
    }
}