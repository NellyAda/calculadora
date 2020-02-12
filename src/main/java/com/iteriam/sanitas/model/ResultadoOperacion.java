package com.iteriam.sanitas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ResultadoOperacion implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = -3637812550902212134L;
   private BigDecimal valor;
   private List<String> errMensajes;

   public BigDecimal getValor() {
      return valor;
   }

   public void setValor(BigDecimal valor) {
      this.valor = valor;
   }

   public List<String> getErrMensajes() {
      if (errMensajes == null) {
         errMensajes = new ArrayList<>();
      }
      return errMensajes;
   }

   public void setErrMensajes(List<String> errMensajes) {
      this.errMensajes = errMensajes;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((errMensajes == null) ? 0 : errMensajes.hashCode());
      result = prime * result + ((valor == null) ? 0 : valor.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      ResultadoOperacion other = (ResultadoOperacion) obj;
      if (errMensajes == null) {
         if (other.errMensajes != null)
            return false;
      } else if (!errMensajes.equals(other.errMensajes))
         return false;
      if (valor == null) {
         if (other.valor != null)
            return false;
      } else if (!valor.equals(other.valor))
         return false;
      return true;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("ResultadoOperacion [valor=");
      builder.append(valor);
      builder.append(", errMensajes=");
      builder.append(errMensajes);
      builder.append("]");
      return builder.toString();
   }
}
