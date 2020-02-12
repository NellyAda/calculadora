package com.iteriam.sanitas.facade;

import java.math.BigDecimal;
import java.util.List;

import com.iteriam.sanitas.model.ResultadoOperacion;

public interface CalculadoraFacade {

   public ResultadoOperacion calcular(List<BigDecimal> operandos, String operacion);

}
