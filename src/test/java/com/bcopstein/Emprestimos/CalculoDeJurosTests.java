package com.bcopstein.Emprestimos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculoDeJurosTests {
    @Test
    public void testeValorJurosCompostos() {
        CalculoDeJuros c = new CalculoDeJuros();
        double valor = 1000;
        int parcelas = 10;
        double taxa = 0.0;
        double resultado = c.jurosEmprestimoJurosCompostos(valor, taxa, parcelas);
        Assertions.assertEquals(104.62212541120425, resultado);
    }

    @Test
    public void testeValorJurosSimples() {
        CalculoDeJuros c = new CalculoDeJuros();
        double valor = 1000;
        int parcelas = 10;
        double taxa = 0.0;
        double resultado = c.jurosEmprestimoJurosSimples(valor, taxa, parcelas);
        Assertions.assertEquals(100, resultado);
    }
}
