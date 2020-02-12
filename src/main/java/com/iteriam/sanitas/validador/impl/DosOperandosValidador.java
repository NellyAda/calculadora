package com.iteriam.sanitas.validador.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.iteriam.sanitas.validador.Validador;

public class DosOperandosValidador implements Validador {

   @Override
   public List<String> validar(List<BigDecimal> operandos) {
      List<String> mensajesError = new ArrayList<>();
      if (operandos.size() != 2) {
         mensajesError.add("El número de operandos debe ser 2");
      }
      return mensajesError;
   }

}
