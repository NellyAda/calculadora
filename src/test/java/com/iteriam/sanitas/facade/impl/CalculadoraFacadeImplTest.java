package com.iteriam.sanitas.facade.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.iteriam.sanitas.model.ResultadoOperacion;
import com.iteriam.sanitas.service.Operacion;
import com.iteriam.sanitas.service.impl.RestaOperacion;
import com.iteriam.sanitas.service.impl.SumaOperacion;

@ExtendWith(MockitoExtension.class)
public class CalculadoraFacadeImplTest {

   public CalculadoraFacadeImpl facade;

   @BeforeEach
   public void setUp() throws Exception {
      List<Operacion> operaciones = Arrays.asList(new RestaOperacion(), new SumaOperacion());
      facade = new CalculadoraFacadeImpl(operaciones);
   }

   @Test
   public void testCalcularSumaOK() {
      final List<BigDecimal> params = Arrays.asList(new BigDecimal(25), new BigDecimal(3));
      ResultadoOperacion resultado = facade.calcular(params, "suma");
      assertTrue(resultado.getValor().equals(new BigDecimal(28)));
      assertTrue(resultado.getErrMensajes().size() == 0);
   }

   @Test
   public void testCalcularSumaWrongParams() {
      final List<BigDecimal> params = Arrays.asList(new BigDecimal(25));
      ResultadoOperacion resultado = facade.calcular(params, "suma");
      assertTrue(resultado.getValor().equals(new BigDecimal(0)));
      assertTrue(resultado.getErrMensajes().size() == 1);
   }

   @Test
   public void testCalcularRestaOK() {
      final List<BigDecimal> params = Arrays.asList(new BigDecimal(25), new BigDecimal(3));
      ResultadoOperacion resultado = facade.calcular(params, "resta");
      assertTrue(resultado.getValor().equals(new BigDecimal(22)));
   }

   // @Disabled("Desactivado por el momento")
   @Test
   public void testMalaOperacion() {
      final List<BigDecimal> params = Arrays.asList(new BigDecimal(25), new BigDecimal(3));
      ResultadoOperacion resultado = facade.calcular(params, "bla");
      assertTrue(resultado.getValor().equals(new BigDecimal(0)));
      assertTrue(resultado.getErrMensajes().size() == 1);
   }

}
