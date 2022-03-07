package service;

import modelo.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BonusService {

    final BigDecimal LIMITE_DE_BONUS = new BigDecimal("1000");
    final BigDecimal VALOR_PADRAO_DE_BONIFICACAO = new BigDecimal("0.1");

    public BigDecimal calcularBonus(Funcionario funcionario) {
        BigDecimal valor = funcionario.getSalario().multiply(VALOR_PADRAO_DE_BONIFICACAO);

        if (valorMaiorQueLimiteDeBonus(valor)) {
            valor = BigDecimal.ZERO;
        }
        return valor.setScale(2 , RoundingMode.HALF_UP);
    }

    private boolean valorMaiorQueLimiteDeBonus(BigDecimal valor) {
        return valor.compareTo(LIMITE_DE_BONUS) > 0;
    }
}
