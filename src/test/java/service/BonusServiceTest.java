package service;

import modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    public static BonusService service;

    public static final String NOME_FUNCIONARIO = "William Bigas Mauro";
    public static final LocalDate DATA_NASCIMENTO = LocalDate.of(1997, 11, 21);

    public static Funcionario funcionario;

    @BeforeEach
    void carregaVariaveis() {
        service = new BonusService();
        funcionario = new Funcionario(NOME_FUNCIONARIO, DATA_NASCIMENTO);
    }

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        funcionario.setSalario(new BigDecimal("25000"));
        assertEquals(new BigDecimal("0.00"), service.calcularBonus(funcionario));
    }

    @Test
    void bonusDeveriaSerDezPorCentoDoSalario() {
        funcionario.setSalario(new BigDecimal("2500"));
        assertEquals(new BigDecimal("250.00"), service.calcularBonus(funcionario));
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDeExatamenteDezMilReais() {
        funcionario.setSalario(new BigDecimal("10000"));
        assertEquals(new BigDecimal("1000.00"), service.calcularBonus(funcionario));
    }

}