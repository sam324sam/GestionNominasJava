![Estado](https://img.shields.io/badge/Estado-Acabado-brightgreen?style=plastic)

# Aplicación para la Gestión de Datos de Empleados

## Descripción
Este proyecto consiste en una aplicación desarrollada en Java para procesar un archivo con datos de empleados de una empresa. Fue desarrollado como parte de un examen del primer año del ciclo formativo de Desarrollo de Aplicaciones Web (DAW).

La aplicación lee un archivo de texto con información de empleados, realiza cálculos para determinar la nómina total de cada empleado, y genera un archivo HTML con dos tablas:
1. Empleados cuya nómina supera un límite especificado por el usuario.
2. Todos los empleados en orden de entrada.

## Características
- **Gestor de excepciones:** Maneja errores como la falta del archivo de entrada o datos corruptos.
- **Estructura eficiente:** Almacena los datos en una lista para facilitar el filtrado y la ordenación.
- **Cálculo de nómina:** Calcula el total de la nómina de cada empleado utilizando la fórmula:
  ```
  total = fijo + (factura * percent * 0.01)
  ```
- **Salida en HTML:** Genera un archivo `Empleados.html` con los resultados en formato tabla.

## Formato del Archivo de Entrada
El archivo de entrada debe tener el siguiente formato:
```
# dni # nombre # ape1 # anyonac  ###fijo # factura # percent ############################################################
# 12345678Z # Ana Mª # del Campo # 2004 1100 # 2000 # 1.5
# 23456789A # Juan # Martínez del Amo # 1990 1500 # 10000 # 3.0
# 34567890B # Olga # Pérez # 2000 1100 # 5000 # 1.5
```

## Estructura del Código
### Clases Principales

#### **Clase `App`**
La clase principal que inicializa la aplicación. Su función es:
1. Pedir al usuario el límite de facturación para filtrar empleados.
2. Invocar los métodos de la clase `GestionDatos` para procesar y generar el archivo HTML.

#### **Clase `Empleado`**
Representa un empleado con los siguientes atributos:
- `dni`, `nombre`, `ape1`, `anyonac`, `fijo`, `factura`, `percent`, `totalNomina`.

El cálculo de la nómina total se realiza en su constructor.

#### **Clase `GestionDatos`**
Encargada de:
1. **Leer y procesar datos:** Lee el archivo de entrada y convierte cada línea en un objeto `Empleado`.
2. **Filtrar y ordenar:** Ordena a los empleados por año de nacimiento y filtra por límite de facturación.
3. **Generar HTML:** Crea el archivo `Empleados.html` con los datos formateados en tablas.

## Uso
### Entrada
1. Asegúrate de que el archivo `empleados.txt` esté en el directorio raíz del proyecto.
2. Ejecuta el programa y proporciona el límite de facturación cuando se solicite.

### Salida
Se genera un archivo `Empleados.html` con el siguiente formato:
- **Tabla 1:** Empleados cuya nómina supera el límite especificado.
- **Tabla 2:** Todos los empleados en orden de entrada, mostrando su DNI y nómina.

## Ejemplo de Salida
```html
<h2>Empleado que tiene mas de 2400</h2>
<table border=1>
<tr>
<th>Dni</th>
<th>Nomina</th>
</tr>
<tr>
<td><center>23456789A</center></td>
<td>1800.0</td>
</tr>
</table>
<h2>Todos los empleados</h2>
<table border=1>
<tr>
<th>Dni</th>
<th>Nomina</th>
</tr>
<tr>
<td><center>34567890B</center></td>
<td>1175.0</td>
</tr>
<tr>
<td><center>12345678Z</center></td>
<td>1130.0</td>
</tr>
```

## Consideraciones
- El archivo de entrada debe cumplir estrictamente con el formato especificado.
- Si no se puede abrir el archivo, se mostrará un mensaje de error y el programa finalizará sin generar el archivo HTML.
- El programa solo filtra y genera tablas basadas en el límite proporcionado por el usuario.

