package com.iteriam.sanitas.service.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.iteriam.sanitas.service.Operacion;
import com.iteriam.sanitas.validador.impl.DosOperandosValidador;

@Component
public class RestaOperacion extends Operacion {

   public RestaOperacion() {
      super("resta", Arrays.asList(new DosOperandosValidador()));
   }

   @Override
   public BigDecimal ejecutar(List<BigDecimal> params) {
      return params.get(0).subtract(params.get(1));
   }

}
