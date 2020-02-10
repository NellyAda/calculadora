package com.iteriam.sanitas.facade;

import java.math.BigDecimal;
import java.util.List;

public interface CalculadoraFacade {

   public BigDecimal calcular(List<BigDecimal> operandos, String operacion);

}
