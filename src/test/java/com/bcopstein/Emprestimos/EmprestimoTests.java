package com.bcopstein.Emprestimos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EmprestimoTests {
    static final double VALOR_EMPRESTIMO = 1000.0;
    static final double TAXA_EMPRESTIMO = 0.035;
    static final int NRO_PARCELAS = 5;


    @Test
    public void testaCustoTotal_jurosSimplesSemSeguro(){
        CalculoDeJuros calculoDeJuros = mock(CalculoDeJuros.class);
        when(calculoDeJuros.jurosEmprestimoJurosSimples(VALOR_EMPRESTIMO,TAXA_EMPRESTIMO,NRO_PARCELAS)).thenReturn(200.0);


        Emprestimo emprestimoSemSeguroJurosSimples  = new Emprestimo.Builder(calculoDeJuros).valor(VALOR_EMPRESTIMO).taxa(TAXA_EMPRESTIMO).parcelas(NRO_PARCELAS).jurosSimples().semSeguro().build();
        double valorIof = VALOR_EMPRESTIMO * Emprestimo.IOF;
        assertEquals(VALOR_EMPRESTIMO+225.0+valorIof,emprestimoSemSeguroJurosSimples.custoTotal());
    }

    @Test
    public void testaCustoTotal_jurosCompostoscomSeguro(){
        CalculoDeJuros calculoDeJuros = mock(CalculoDeJuros.class);
        when(calculoDeJuros.jurosEmprestimoJurosCompostos(VALOR_EMPRESTIMO,TAXA_EMPRESTIMO,NRO_PARCELAS)).thenReturn(246.18193765312526);

        Emprestimo emprestimoSemSeguroJurosSimples  = new Emprestimo.Builder(calculoDeJuros).valor(VALOR_EMPRESTIMO).taxa(TAXA_EMPRESTIMO).parcelas(NRO_PARCELAS).jurosCompostos().comSeguro().build();
        double valorIof = VALOR_EMPRESTIMO * Emprestimo.IOF;
        assertEquals(VALOR_EMPRESTIMO+246.18193765312526+valorIof,emprestimoSemSeguroJurosSimples.custoTotal());
    }

    @Test
    public void TestaValorParcela(){
        CalculoDeJuros calculoDeJuros = mock(CalculoDeJuros.class);
        when(calculoDeJuros.jurosEmprestimoJurosSimples(VALOR_EMPRESTIMO,TAXA_EMPRESTIMO,NRO_PARCELAS)).thenReturn(200.0);

        Emprestimo emprestimoSemSeguroJurosSimples  = new Emprestimo.Builder(calculoDeJuros).valor(VALOR_EMPRESTIMO).taxa(TAXA_EMPRESTIMO).parcelas(NRO_PARCELAS).jurosSimples().semSeguro().build();
        double valorIof = VALOR_EMPRESTIMO * Emprestimo.IOF;
        assertEquals(emprestimoSemSeguroJurosSimples.custoTotal()/NRO_PARCELAS,emprestimoSemSeguroJurosSimples.valorParcela());
    }
}
