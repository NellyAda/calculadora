package com.iteriam.sanitas.validador.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DosOperandosValidadorTest {

   private final DosOperandosValidador validador = new DosOperandosValidador();

   @Test
   public void testValidarOK() {
      List<BigDecimal> operandos = Arrays.asList(new BigDecimal(0), new BigDecimal(0));
      boolean valido = validador.validar(operandos);
      assertTrue(valido);
   }

   @Test
   public void testValidarUnOperando() {
      List<BigDecimal> operandos = Arrays.asList(new BigDecimal(0));
      boolean valido = validador.validar(operandos);
      assertFalse(valido);
   }

}
