# Prueba tecnica - Seccion 1

## Nombre 
* **Espejel Gonzalez, Alberto Raul**

## Objetivo 📋
Crear un proceso con las herramientas disponibles por el usuario

Los ejercicios de programación tienen que incluir los procedimientos de instalación y ejecución de las herramientas a utilizar y los scripts que realizaran los procedimientos. Se puede realizar a través de Dockers. Pueden incluir pruebas unitarias o de integración. Se puede compartir por Github o cualquier repositorio o en un zip.

Nota: Junto con esta guía te compartimos 1 data set con la información sobre las compras de dos compañías ficticias que procesan con nosotros.
# Notas

````
La base de datos se encuentra dentro del proyecto, el archivo se llama bd.rar contiene todos los schemas necesarios
````

````
Para poder consumir el API sera la ruta localhost:8081/carga-csv/ruta_del_archivo.csv

Ejemplo
localhost:8081/carga-csv/C:data_prueba_tecnica.csv

````
### Especificaciones 📋

* Carga de información

La información proporcionada se debe de cargar en alguna base de datos. Puede ser estructurada o no estructurada. Ejemplo: MySQL, Postgres, MongoDB, etc.
Incluye comentarios del por qué elegiste ese tipo de base de datos

```
Se escogio MySQL debido a que ya se a tenido experiencia con la base de datos y microservicios
```

* Extracción

Se debe de realizar un procedimiento de extracción de la información anterior por medio de algún lenguaje de programación que permita procesarlo. El formato final de la información extraída puede ser CSV, Avro, parquet o el que se considere más adecuado.

Agrega comentarios acerca del por qué tuviste que utilizar el lenguaje y el formato que elegiste. También platicamos si te encontraste con algún reto a la hora de extraer la información.

````
Se utilizo el lenguaje de programacion JAVA debido a que es el lenguaje que solicitan en la vacante.
Se utilizo el formato CSV ya que fue el formato en que proporcionaron la informacion.

Las dificultades que encontre al realizar la extraccion fue el encontrar la manera de de que no tomara en cuenta los saltos de linea, me llevo
algo de timepo el buscar la manera correcta. De igual manera el numero grande del campo "amount" tuve que buscar un tipo de dato al cual se 
pudiera acoplar a los datos.
````
* Transformación

* Se propone el siguiente esquema para la información
```
id VARCHAR(24) NOT NULL,
company_name VARCHAR(130),
company_id VARCHAR(24) NOT NULL,
amount DECIMAL(16,2) NOT NULL,
status VARCHAR(30) NOT NULL,
created_at TIMESTAMP NOT NULL,
updated_at TIMESTAMP
```
Realiza las transformaciones necesarias para que la información extraída cumpla con el esquema. Puedes realizarlas con el lenguaje de programación de tu preferencia.

Incluye comentarios acerca de que transformaciones tuviste que realizar y que retos te encontraste en la implementación de estos mecanismos de transformación.

````
El reto que tuve a la hora de la transformacion fue el convertir de tipo "FECHA" a "TIMESTAMP".
````

* Dispersión de la información

Se debe de utilizar una base de datos MySQL, Postgres, MongoDB, etc. En esta base se va a crear un esquema estructurado basado en el ejercicio anterior, pero debemos de crear una tabla llamada charges donde tendremos la información de las transacciones y otra llamada companies donde incluiremos la información de las compañias. Estas tablas deberán de estar relacionadas. Cargaremos la información del dataset en estas dos tablas.
Incluye el diagrama de base de datos resultado de este ejercicio.

* SQL

Diseña una vista en la base de datos MySQL, Postgres, MongoDB, etc., de las tablas donde cargamos la información transformada para que podamos ver el monto total transaccionado por día para las diferentes compañías
```
CREATE VIEW total_transactions AS
SELECT companies.company_name, charges.created_at, SUM(charges.amount) as total_amount
FROM charges
INNER JOIN companies ON charges.company_id = companies.id
GROUP BY companies.company_name, charges.created_at;
```

## Comandos 🛠

### Dockerizar y correr la aplicación
Ejecutar los siguientes comandos en una terminal situada en la carpeta raíz de este repositorio
* Generar el .jar de la aplicación
```
.\mvnw.cmd clean package -DskipTests
```
* Construir la imágen de Docker
```
docker build -t seccion1:1 .
```
* Generar el contenedor de Docker
```
docker run -p 8081:8081 -d --name seccion1 seccion1:1
```
* Finalizar la ejecución del contenedor (Opcional)
```
docker stop seccion1
```
