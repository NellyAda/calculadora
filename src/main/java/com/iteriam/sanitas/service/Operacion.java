package com.iteriam.sanitas.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import com.iteriam.sanitas.validador.Validador;

public abstract class Operacion {

   private String operador;

   private List<Validador> validadores;

   public Operacion(String operador) {
      this.operador = operador;
      this.validadores = Collections.<Validador>emptyList();
   }

   public Operacion(String operador, List<Validador> validadores) {
      this.operador = operador;
      this.validadores = validadores;
   }

   public String getOperador() {
      return operador;
   }

   public void setOperador(String operador) {
      this.operador = operador;
   }

   public List<Validador> getValidadores() {
      return validadores;
   }

   public void setValidadores(List<Validador> validadores) {
      this.validadores = validadores;
   }

   /**
    * This method executes the operation related to the class
    * 
    * @param params - list of parameters to operate
    * @return a not null {@link BigDecimal}
    */
   public abstract BigDecimal ejecutar(List<BigDecimal> params);

}
