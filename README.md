## Instalación y configuración
#### Requisitos
Es necesario tener ambiente Java instalado
#### Instalación
Clona el proyecto

    git clone https:https://github.com/Jose026-byte/Citas-Medicas.git

#### Configuración

En la carpeta db es necesario agregar los siguientes archivos que servirán como bases de datos:

    Cita.csv
    doctors.csv
    patients.csv

## Uso del programa
Al iniciar la aplicación, se mostrará el menú principal con las siguientes opciones:

    Registrar y gestionar doctores.
    Registrar y gestionar pacientes. 
    Crear, modificar y cancelar cita

#### Crear
Para crear un registro de cualquier de los modelos es necesario entrar al modelo que queramos crear y después seleccionar la opción agregar.
Después llena los campos solicitados, esto guardará el registro en la base de datos.

#### Listado
Todos los modelos pueden listar los registros de la base de datos, para esto es necesario entrar al modelo requerido y seleccionar la opción Lista.
Esto mostrará una lista de los registros del modelo en la base de datos.

#### Eliminar
Si se desea eliminar un registro es necesario seleccionar el modelo y posteriormente seleccionar la opción eliminar.
Esta opción nos pedirá el ID del registro que queremos eliminar, este ID se puede consultar en el Listado.

#### Búsqueda
Para buscar un registro se puede hacer por número de ID, es necesario entrar al modelo que queremos buscar, seleccionar la opción búsqueda y posterioremente ingresar el ID.
Esto regresará el registro encontrado y en caso de no encontrar regresara un registro vacío:

    0,null,null,null

## Créditos
Sistema creado por Jose francisco Rosas.
## Licencia
Este programa se publica bajo la licencia [Apache v2.0](https://www.apache.org/licenses/LICENSE-2.0).
