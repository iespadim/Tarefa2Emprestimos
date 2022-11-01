package com.bcopstein.Emprestimos;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@Disabled
class EmprestimosApplicationTests {
	@Autowired
	private EmprestimosApplication controller;
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

    @Test
    public void testeValorJurosCompostos() throws Exception {
        this.mockMvc
				.perform(get("/emprestimo/jurosCompostos?valor=1000&parcelas=10&taxa=0.0&segurado=false"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.taxa", is(0.0)));
    }

	@Test
	public void testeValorJurosSimples() throws Exception {
		this.mockMvc
				.perform(get("/emprestimo/jurosSimples?valor=1000&parcelas=10&taxa=0.0&segurado=false"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.valor", is(1000.0)))
				.andExpect(jsonPath("$.nroParcelas", is(10)))
				.andExpect(jsonPath("$.valorParcela", is(116.0)))
				.andExpect(jsonPath("$.valorTotal", is(1160.0)));
	}

}
