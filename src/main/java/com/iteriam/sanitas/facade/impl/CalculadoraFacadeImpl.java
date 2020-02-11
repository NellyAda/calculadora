package com.iteriam.sanitas.facade.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteriam.sanitas.facade.CalculadoraFacade;
import com.iteriam.sanitas.service.Operacion;
import com.iteriam.sanitas.validador.Validador;

@Service
public class CalculadoraFacadeImpl implements CalculadoraFacade {

   private List<Operacion> operaciones;

   @Autowired
   public CalculadoraFacadeImpl(List<Operacion> operaciones) {
      this.operaciones = operaciones;
   }

   @Override
   public BigDecimal calcular(List<BigDecimal> operandos, String operador) {
      Optional<Operacion> optOperacion = operaciones.stream().filter(op -> operador.equals(op.getOperador())).findAny();
      Operacion operacion = optOperacion.get();
      List<Validador> validadores = operacion.getValidadores();
      validadores.forEach(validador -> {
         if (!validador.validar(operandos)) {
            // TODO Tracear el error
            throw new RuntimeException("Problemas en la validación de la operación");
         }
      });
      return operacion.ejecutar(operandos);
   }

}
