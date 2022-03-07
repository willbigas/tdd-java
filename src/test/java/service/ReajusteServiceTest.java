package service;

import modelo.Desempenho;
import modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveriaSerDeTrezPorCentoQuandoDesempenhoForADesejar() {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("William Bigas Mauro" , LocalDate.now() , new BigDecimal("1000.00"));
        service.concederReajuste(funcionario , Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00") , funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzPorCentoQuandoDesempenhoForBom() {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("William Bigas Mauro" , LocalDate.now() , new BigDecimal("1000.00"));
        service.concederReajuste(funcionario , Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00") , funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForOtimo() {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("William Bigas Mauro" , LocalDate.now() , new BigDecimal("1000.00"));
        service.concederReajuste(funcionario , Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00") , funcionario.getSalario());
    }
}
