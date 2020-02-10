package com.iteriam.sanitas.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.iteriam.sanitas.service.Operacion;

public class RestaOperacion implements Operacion {

   @Override
   public BigDecimal ejecutar(List<BigDecimal> params) {
      return params.get(0).subtract(params.get(1));
   }

}
