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

@Service
public class CalculadoraFacadeImpl implements CalculadoraFacade {

   private List<Operacion> operaciones;

   @Autowired
   public CalculadoraFacadeImpl(List<Operacion> operaciones) {
      this.operaciones = operaciones;
   }

   @Override
   public ResultadoOperacion calcular(List<BigDecimal> operandos, String operador) {
      Optional<Operacion> optOperacion = operaciones.stream().filter(op -> operador.equals(op.getOperador())).findAny();
      List<String> mensajesError = new ArrayList<>();
      BigDecimal valor = new BigDecimal(0);
      if (optOperacion.isPresent()) {
         Operacion operacion = optOperacion.get();
         List<Validador> validadores = operacion.getValidadores();
         validadores.forEach(validador -> {
            mensajesError.addAll(validador.validar(operandos));
         });
         if (mensajesError.isEmpty()) {
            valor = operacion.ejecutar(operandos);
         }
      } else {
         mensajesError.add("Operación no disponible");
      }

      ResultadoOperacion resultado = new ResultadoOperacion();
      resultado.setErrMensajes(mensajesError);
      resultado.setValor(valor);

      return resultado;
   }

}
