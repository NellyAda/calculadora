package com.iteriam.sanitas.facade.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteriam.sanitas.facade.CalculadoraFacade;
import com.iteriam.sanitas.model.ResultadoOperacion;
import com.iteriam.sanitas.service.Operacion;
import com.iteriam.sanitas.validador.Validador;

import io.corp.calculator.TracerImpl;

@Service
public class CalculadoraFacadeImpl implements CalculadoraFacade {

   private List<Operacion> operaciones;

   private final TracerImpl tracer = new TracerImpl();

   @Autowired
   public CalculadoraFacadeImpl(List<Operacion> operaciones) {
      this.operaciones = operaciones;
   }

   @Override
   public ResultadoOperacion calcular(List<BigDecimal> operandos, String operador) {
      Optional<Operacion> optOperacion = operaciones.stream().filter(op -> operador.equals(op.getOperador())).findAny();
      ResultadoOperacion resultado;
      if (optOperacion.isPresent()) {
         Operacion operacion = optOperacion.get();
         resultado = validarEjecutar(operandos, operacion);

      } else {
         resultado = new ResultadoOperacion();
         List<String> mensajesError = new ArrayList<>();
         mensajesError.add("Operación no disponible");
         resultado.setErrMensajes(mensajesError);
      }
      return resultado;

   }

   /**
    * Este método valida el operando y ejecuta la operacion
    * 
    * @param operandos
    * @param operacion
    * @return
    */
   private ResultadoOperacion validarEjecutar(List<BigDecimal> operandos, Operacion operacion) {
      List<Validador> validadores = operacion.getValidadores();
      ResultadoOperacion resultado = new ResultadoOperacion();
      List<String> mensajesError = resultado.getErrMensajes();
      validadores.forEach(validador -> {
         mensajesError.addAll(validador.validar(operandos));
      });
      if (mensajesError.isEmpty()) {
         BigDecimal valor = operacion.ejecutar(operandos);
         tracer.trace(valor);
         resultado.setValor(valor);
      }

      return resultado;
   }

}
