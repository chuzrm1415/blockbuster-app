# BlockBuster-App

* Nombre: Jesús Rojas Monge.
* Carnet: 2015023095.



Aplicación Para poner en practica los conocimientos adquiridos en el curso de Bases de datos 1.

Esta deberia de contar con los metodos CRUD's para el mantenimiento de 4 tablas dentro de la base de datos.

##### NOTA: La ejecución del programa hace uso de Apache Maven ( https://maven.apache.org/ )


#
## Pre-compilación:
```sh
mvn clean install
```

 Actualmente algunos de los comandos fueron modificados para evitar conflictos en sus nombres, asi como por la implementacion de la base de datos.

 ## Comandos de ejecucion para cada tabla:
 Por diseño de la base de datos, se se insertan ID's a la hora de crear filas; solo son usados para busquedas.

 ### Tabla Category:

 | Comando | Funcion |
 |---------|---------|
 | catc + {descrip} | Crea una categoria |
 | catr    | Imprime todas las categorias |
 | catrid + {id} | Imprime la categoria con el id respectivo |
 | catd + {id} | Elimina la categoria con el id respectivo |
 | catu + {id} + {descrip} | Actualiza la categoria con el id respectivo |

Ejemplos:
```sh
mvn exec:java -Dexec.args="catc Terror"

mvn exec:java -Dexec.args="catr"

mvn exec:java -Dexec.args="catrid 1"

mvn exec:java -Dexec.args="catd 1"

mvn exec:java -Dexec.args="catu 1 Parodia"
```

 ### Tabla Loan:

 | Comando | Funcion |
 |---------|---------|
 | loanc + {id pelicula} + {id cliente} + {fecha} | Crea una prestamo |
 | loanr    | Imprime todos los prestamos |
 | loanrid + {id pelicula} | Imprime el prestamos de esa pelicula |
 | loand + {id pelicula} + {id cliente} | Elimina el prestamos con los id's respectivos |

Ejemplos:
```sh
mvn exec:java -Dexec.args="loanc 1 3 2021-02-12" //Fecha de la forma aaaa-mm-dd

mvn exec:java -Dexec.args="loanr"

mvn exec:java -Dexec.args="loanrid 1"

mvn exec:java -Dexec.args="loand 1 3"
```