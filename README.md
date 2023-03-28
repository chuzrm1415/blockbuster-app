# BlockBuster-App

* Nombre: Jesús Rojas Monge.
* Carnet: 2015023095.



Aplicación para poner en practica los conocimientos adquiridos en el curso de Bases de datos 1.

Esta deberia de contar con los metodos CRUD's para el mantenimiento de 4 tablas dentro de la base de datos.

##### NOTA: La ejecución del programa hace uso de Apache Maven ( https://maven.apache.org/ )


#
## Pre-compilación:
```bash
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
```bash
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
```bash
mvn exec:java -Dexec.args="loanc 1 3 2021-02-12" //Fecha de la forma aaaa-mm-dd

mvn exec:java -Dexec.args="loanr"

mvn exec:java -Dexec.args="loanrid 1"

mvn exec:java -Dexec.args="loand 1 3"
```

 ### Tabla Film:

 | Comando | Funcion |
 |---------|---------|
 | movc + {titulo} + {fecha} + {categoria} | Crea una pelicula |
 | movr    | Imprime todos las peliculas |
 | movrid + {id pelicula} | Imprime la pelicula asociada |
 | movd + {id pelicula} | Elimina la pelicula con los id's respectivos |
 | movu + {id pelicula} + {titulo} + {fecha} + {cat} | Actualiza la pelicula con el id respectivo |

Ejemplos:
```bash
mvn exec:java -Dexec.args="movc Titanic 1997-17-12 4" //Fecha de la forma aaaa-mm-dd

mvn exec:java -Dexec.args="movr"

mvn exec:java -Dexec.args="movrid 1"

mvn exec:java -Dexec.args="movd 1"

mvn exec:java -Dexec.args="movu 11 Titanic 1997-17-12 4"
```


 ### Tabla Film:
 No implementada por cuestiones de tiempo. :c


 ## Evaluación

 Nota: 8.5
