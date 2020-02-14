Calculadora
=================================================================
Se ha llevado a cabo una prueba de concepto de una calculadora con un número de operaciones bajo.
La implementación llevada a cabo permite una extensión muy sencilla de las operaciones ya que únicamente implica incluir una clase hija que implemente la operación deseada y los validadores asociados.
Además, estas nuevas operaciones pueden tener un número de parámetros variable (mínimo uno), ya que a la entrada no limitamos el número de parámetros de las operaciones.


Trazado de inclusiones realizadas en el código:

- Creamos el esqueleto mediante spring boot y las operaciones básicas y las clases de prueba. Todo muy básico
- Incluimos la API pasando los parametros por url
- Creamos validadores, sin integrarlos en el flujo del codigo. Puesto que se entiende que la lista de operaciones aumentará, creamos un validador para cada validación posible dentro de las operaciones implementadas.
- Integramos los validadores aunque queda pendiente codificar mensajes de error por cada validación fallida


Para generar el jar y ejecutarlo, utilizar los siguientes comandos: 

$ mvn install:install-file -Dfile=lib\tracer-1.0.0.jar -DgroupId=io.corp.calculator -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true
$ mvn clean package
$ java -jar target\calculadora-0.0.1-SNAPSHOT.jar

En un navegador introducir la siguiente URL:
http://localhost:8080/calculadora/calcular?operandos=25&operandos=3&operacion=suma

- operandos: OBLIGATORIO (al menos uno) Este parámetro aparecerá tantas veces como operandos tenga la operación. Admite números con decimales.
- operacion: OBLIGATORIO Toma el valor "suma" o "resta"