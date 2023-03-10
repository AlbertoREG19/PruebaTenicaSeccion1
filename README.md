# Prueba tecnica - Seccion 1

## Nombre 
* **Espejel Gonzalez, Alberto Raul**

## Objetivo 馃搵
Crear un proceso con las herramientas disponibles por el usuario

Los ejercicios de programaci贸n tienen que incluir los procedimientos de instalaci贸n y ejecuci贸n de las herramientas a utilizar y los scripts que realizaran los procedimientos. Se puede realizar a trav茅s de Dockers. Pueden incluir pruebas unitarias o de integraci贸n. Se puede compartir por Github o cualquier repositorio o en un zip.

Nota: Junto con esta gu铆a te compartimos 1 data set con la informaci贸n sobre las compras de dos compa帽铆as ficticias que procesan con nosotros.
# Notas

````
La base de datos se encuentra dentro del proyecto, el archivo se llama bd.rar contiene todos los schemas necesarios
````

````
Para poder consumir el API sera la ruta localhost:8081/carga-csv/ruta_del_archivo.csv

Ejemplo
localhost:8081/carga-csv/C:data_prueba_tecnica.csv

````
### Especificaciones 馃搵

* Carga de informaci贸n

La informaci贸n proporcionada se debe de cargar en alguna base de datos. Puede ser estructurada o no estructurada. Ejemplo: MySQL, Postgres, MongoDB, etc.
Incluye comentarios del por qu茅 elegiste ese tipo de base de datos

```
Se escogio MySQL debido a que ya se a tenido experiencia con la base de datos y microservicios
```

* Extracci贸n

Se debe de realizar un procedimiento de extracci贸n de la informaci贸n anterior por medio de alg煤n lenguaje de programaci贸n que permita procesarlo. El formato final de la informaci贸n extra铆da puede ser CSV, Avro, parquet o el que se considere m谩s adecuado.

Agrega comentarios acerca del por qu茅 tuviste que utilizar el lenguaje y el formato que elegiste. Tambi茅n platicamos si te encontraste con alg煤n reto a la hora de extraer la informaci贸n.

````
Se utilizo el lenguaje de programacion JAVA debido a que es el lenguaje que solicitan en la vacante.
Se utilizo el formato CSV ya que fue el formato en que proporcionaron la informacion.

Las dificultades que encontre al realizar la extraccion fue el encontrar la manera de de que no tomara en cuenta los saltos de linea, me llevo
algo de timepo el buscar la manera correcta. De igual manera el numero grande del campo "amount" tuve que buscar un tipo de dato al cual se 
pudiera acoplar a los datos.
````
* Transformaci贸n

* Se propone el siguiente esquema para la informaci贸n
```
id VARCHAR(24) NOT NULL,
company_name VARCHAR(130),
company_id VARCHAR(24) NOT NULL,
amount DECIMAL(16,2) NOT NULL,
status VARCHAR(30) NOT NULL,
created_at TIMESTAMP NOT NULL,
updated_at TIMESTAMP
```
Realiza las transformaciones necesarias para que la informaci贸n extra铆da cumpla con el esquema. Puedes realizarlas con el lenguaje de programaci贸n de tu preferencia.

Incluye comentarios acerca de que transformaciones tuviste que realizar y que retos te encontraste en la implementaci贸n de estos mecanismos de transformaci贸n.

````
El reto que tuve a la hora de la transformacion fue el convertir de tipo "FECHA" a "TIMESTAMP".
````

* Dispersi贸n de la informaci贸n

Se debe de utilizar una base de datos MySQL, Postgres, MongoDB, etc. En esta base se va a crear un esquema estructurado basado en el ejercicio anterior, pero debemos de crear una tabla llamada charges donde tendremos la informaci贸n de las transacciones y otra llamada companies donde incluiremos la informaci贸n de las compa帽ias. Estas tablas deber谩n de estar relacionadas. Cargaremos la informaci贸n del dataset en estas dos tablas.
Incluye el diagrama de base de datos resultado de este ejercicio.

* SQL

Dise帽a una vista en la base de datos MySQL, Postgres, MongoDB, etc., de las tablas donde cargamos la informaci贸n transformada para que podamos ver el monto total transaccionado por d铆a para las diferentes compa帽铆as
```
CREATE VIEW total_transactions AS
SELECT companies.company_name, charges.created_at, SUM(charges.amount) as total_amount
FROM charges
INNER JOIN companies ON charges.company_id = companies.id
GROUP BY companies.company_name, charges.created_at;
```

## Comandos 馃洜

### Dockerizar y correr la aplicaci贸n
Ejecutar los siguientes comandos en una terminal situada en la carpeta ra铆z de este repositorio
* Generar el .jar de la aplicaci贸n
```
.\mvnw.cmd clean package -DskipTests
```
* Construir la im谩gen de Docker
```
docker build -t seccion1:1 .
```
* Generar el contenedor de Docker
```
docker run -p 8081:8081 -d --name seccion1 seccion1:1
```
* Finalizar la ejecuci贸n del contenedor (Opcional)
```
docker stop seccion1
```
