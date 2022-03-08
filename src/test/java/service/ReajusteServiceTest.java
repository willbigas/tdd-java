package service;

import modelo.Desempenho;
import modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("William Bigas Mauro" , LocalDate.now() , new BigDecimal("1000.00"));
    }

    @Test
    public void reajusteDeveriaSerDeTrezPorCentoQuandoDesempenhoForADesejar() {
        service.concederReajuste(funcionario , Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00") , funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzPorCentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario , Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00") , funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForOtimo() {
        service.concederReajuste(funcionario , Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00") , funcionario.getSalario());
    }
}
