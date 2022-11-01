package com.bcopstein.Emprestimos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class integrationTests {
    static final double VALOR_EMPRESTIMO = 1000.0;
    static final double TAXA_EMPRESTIMO = 0.035;
    static final int NRO_PARCELAS = 5;

    CalculoDeJuros calculoDeJuros;


    @Test
    public void testaCustoTotal_jurosSimplesSemSeguro(){
        calculoDeJuros = new CalculoDeJuros();

        Emprestimo emprestimoSemSeguroJurosSimples  = new Emprestimo.Builder(calculoDeJuros).valor(VALOR_EMPRESTIMO).taxa(TAXA_EMPRESTIMO).parcelas(NRO_PARCELAS).jurosSimples().semSeguro().build();
        double valorIof = VALOR_EMPRESTIMO * Emprestimo.IOF;
        assertEquals(VALOR_EMPRESTIMO+225.0+valorIof,emprestimoSemSeguroJurosSimples.custoTotal());
    }

    @Test
    public void testaCustoTotal_jurosCompostoscomSeguro(){
        calculoDeJuros = new CalculoDeJuros();

        Emprestimo emprestimoSemSeguroJurosSimples  = new Emprestimo.Builder(calculoDeJuros).valor(VALOR_EMPRESTIMO).taxa(TAXA_EMPRESTIMO).parcelas(NRO_PARCELAS).jurosCompostos().comSeguro().build();
        double valorIof = VALOR_EMPRESTIMO * Emprestimo.IOF;
        assertEquals(VALOR_EMPRESTIMO+246.18193765312526+valorIof,emprestimoSemSeguroJurosSimples.custoTotal());
    }

    @Test
    public void TestaValorParcela(){
        calculoDeJuros = new CalculoDeJuros();

        Emprestimo emprestimoSemSeguroJurosSimples  = new Emprestimo.Builder(calculoDeJuros).valor(VALOR_EMPRESTIMO).taxa(TAXA_EMPRESTIMO).parcelas(NRO_PARCELAS).jurosSimples().semSeguro().build();
        double valorIof = VALOR_EMPRESTIMO * Emprestimo.IOF;
        assertEquals(emprestimoSemSeguroJurosSimples.custoTotal()/NRO_PARCELAS,emprestimoSemSeguroJurosSimples.valorParcela());
    }
}
