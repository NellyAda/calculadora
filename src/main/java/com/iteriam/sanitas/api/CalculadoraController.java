package com.iteriam.sanitas.api;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iteriam.sanitas.facade.CalculadoraFacade;

@RestController
@RequestMapping(path = "/calculadora")
public class CalculadoraController {

   @Autowired
   public CalculadoraFacade facade;

   @GetMapping(value = "/calcular")
   public ResponseEntity<BigDecimal> calcular(@RequestParam List<BigDecimal> operandos,
         @RequestParam String operacion) {
      BigDecimal resultado = facade.calcular(operandos, operacion);
      return new ResponseEntity<BigDecimal>(resultado, HttpStatus.OK);
   }

}
