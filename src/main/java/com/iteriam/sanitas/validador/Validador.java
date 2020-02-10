package com.iteriam.sanitas.validador;

import java.math.BigDecimal;
import java.util.List;

public interface Validador {

   /**
    * Este metodo valida una lista de operandos
    * 
    * @param operandos - lista no nula de operandos
    * @return true si se validan los operandos, eoc devuelve false
    */
   public boolean validar(List<BigDecimal> operandos);
}
