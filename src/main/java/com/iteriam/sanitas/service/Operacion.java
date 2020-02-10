package com.iteriam.sanitas.service;

import java.math.BigDecimal;
import java.util.List;

public abstract class Operacion {

   private String operador;

   public Operacion(String operador) {
      this.operador = operador;
   }

   public String getOperador() {
      return operador;
   }

   public void setOperador(String operador) {
      this.operador = operador;
   }

   /**
    * This method executes the operation related to the class
    * 
    * @param params - list of parameters to operate
    * @return a not null {@link BigDecimal}
    */
   public abstract BigDecimal ejecutar(List<BigDecimal> params);

}
