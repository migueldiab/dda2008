# Actualizaciones y Versionado #
El sistema cuenta con un avanzado sistema de versionado para poder utilizar siempre la última versión disponible. Accediendo a http://code.google.com/p/dda2008/ puede ver las últimas versiones del producto, asi como enviar reportes de errores encontrados o solicitar nuevas funcionalidades.
También puede acceder a la WIKI en línea dónde encontrará la versión mas actualizada de este documento y contribuir a la comunidad con sus experiencias y conocimientos.

# Diagramas de Clase #
Un diagrama de clases es un tipo de diagrama estático que describe la estructura de un sistema mostrando sus clases, atributos y las relaciones entre ellos. Los diagramas de clases son utilizados durante el proceso de análisis y diseño de los sistemas, donde se crea el diseño conceptual de la información que se manejará en el sistema, y los componentes que se encargaran del funcionamiento y la relación entre uno y otro.
[Wikipedia](Wikipedia.md).

# Diagrama de Clase Conceptual #

Primer modelo de diseño conceptual de sistema con las clases de especificación del mismo. En el mismo se muestran la estructura de Presupuestos con sus Artículos y de éstos con sus Medidas.
De la misma manera los Presupuestos están asociados a un usuario (el dueño del mismo).
Los usuarios tienen un sistema de permisos dependiendo del grupo al que pertenezcan que le permiten acceder a las funcionalidades del sistema.

![http://dda2008.googlecode.com/svn/trunk/dda2008/doc/Diagrama%20de%20Clases%20Conceptual.png](http://dda2008.googlecode.com/svn/trunk/dda2008/doc/Diagrama%20de%20Clases%20Conceptual.png)

# Diagrama de Clase de Diseño #

![http://dda2008.googlecode.com/svn/trunk/dda2008/doc/Diagrama%20de%20Clases%20de%20Dise%C3%B1o.png](http://dda2008.googlecode.com/svn/trunk/dda2008/doc/Diagrama%20de%20Clases%20de%20Dise%C3%B1o.png)

# Pruebas funcionales #
Una prueba funcional es una prueba basada en la ejecución, revisión y retroalimentación de las funcionalides (previamente) diseñadas para el software. Las pruebas funcionales se hacen mediante el diseño de modelos de prueba que buscan evaluar cada una de las opciones con las que cuenta el paquete informático.
[Wikipedia](Wikipedia.md).

## TestUsuario ##
Descripción	Prueba el comportamiento al crear, borrar, modificar y obtener un usuario. Teniendo en cuenta consistencia, duplicados, etc.


## TestArticulo ##
Descripción	Prueba el comportamiento al crear, borrar, modificar y obtener un artículo. Teniendo en cuenta consistencia, duplicados, etc.


## TestGrupo ##
Descripción	Prueba el comportamiento al crear, borrar, modificar y obtener un grupo. Teniendo en cuenta consistencia, duplicados, etc.


# Manual de Usuario #

## Acceso al Sistema ##
Al iniciar, el sistema soicitará al usuario las credenciales para acceder al mismo.
Si es la primera vez que ejecuta el sistema, puede usar los usuarios por defecto
Id : admin
Clave admin
Permite acceder como administrador
Id : gestor
Clave : gestor
Permite acceder como gestor.
Una vez logueado al sistema, podrá ver el menú principal con las opciones disponibles según su nivel de acceso.

## Menu Principal ##
```
Bienvenido Administrador
------------------------------
|   Principal
------------------------------
1-Articulos
2-Presupuestos
3-Consultas
4-Usuarios
5-Cerrar Sesión
6-Salir
------------------------------
|  Seleccione Opción :
```
```
	Bienvenido Gestor
------------------------------
|   Principal
------------------------------
1-Presupuestos
2-Consultas
3-Cerrar Sesión
4-Salir
------------------------------
|  Seleccione Opción :
```
Desde el menú principal, seleccionando la opción deseada, se pueden acceder a los sub-menúes.
De querer cerrar la sesión o cambiár el usuario, puede elegir el ítem Cerrar Sesión.
Para cerrar el sistema completamente, elija Salir

## Navegación ##
```
------------------------------
|   Presupuestos
------------------------------
1-Crear Nuevo
2-Eliminar
3-Modificar
4-Listados
5-Finalizar Presupuesto
6-Copiar Presupuesto
7-Menu Anterior
------------------------------
|  Seleccione Opción : 	
```

Desde el cualquier sub-menú, puede elegir la acción deseada, o puede volver con el último ítem del menú, al menú anterior.

# Configuración General #

## Requisitos ##
# Windows 98 ó superior
# Java v1.4 ó superior


# Glosario #

Elemento de glosario	Descripción