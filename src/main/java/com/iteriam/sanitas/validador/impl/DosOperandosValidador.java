package com.iteriam.sanitas.validador.impl;

import java.math.BigDecimal;
import java.util.List;

import com.iteriam.sanitas.validador.Validador;

public class DosOperandosValidador implements Validador {

   @Override
   public boolean validar(List<BigDecimal> operandos) {
      return operandos.size() == 2;
   }

}
