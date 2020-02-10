package com.iteriam.sanitas.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.iteriam.sanitas.service.Operacion;

public class RestaOperacionTest {

   private final Operacion operacion = new RestaOperacion();

   @Test
   public void ejecutarOK() {
      final List<BigDecimal> params = Arrays.asList(new BigDecimal(25), new BigDecimal(3));
      final BigDecimal resultado = operacion.ejecutar(params);
      assertTrue(resultado.equals(new BigDecimal(22)));
   }

}
