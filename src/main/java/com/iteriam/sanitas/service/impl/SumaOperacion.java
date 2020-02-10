package com.iteriam.sanitas.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.iteriam.sanitas.service.Operacion;

public class SumaOperacion implements Operacion {

   @Override
   public BigDecimal ejecutar(List<BigDecimal> params) {
      return params.get(0).add(params.get(1));
   }

}
