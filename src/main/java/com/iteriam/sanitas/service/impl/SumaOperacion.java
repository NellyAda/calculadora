package com.iteriam.sanitas.service.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.iteriam.sanitas.service.Operacion;
import com.iteriam.sanitas.validador.impl.DosOperandosValidador;

@Component
public class SumaOperacion extends Operacion {

   public SumaOperacion() {
      super("suma", Arrays.asList(new DosOperandosValidador()));
   }

   @Override
   public BigDecimal ejecutar(List<BigDecimal> params) {
      return params.get(0).add(params.get(1));
   }

}
