package com.iteriam.sanitas.service;

import java.math.BigDecimal;
import java.util.List;

public interface Operacion {

   /**
    * This method executes the operation related to the class
    * 
    * @param params - list of parameters to operate
    * @return a not null {@link BigDecimal}
    */
   public BigDecimal ejecutar(List<BigDecimal> params);

}
