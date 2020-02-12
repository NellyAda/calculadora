package com.iteriam.sanitas.validador;

import java.math.BigDecimal;
import java.util.List;

public interface Validador {

   /**
    * Este metodo valida una lista de operandos
    * 
    * @param operandos - lista no nula de operandos
    * @return lista de mensajes de error
    */
   public List<String> validar(List<BigDecimal> operandos);
}
