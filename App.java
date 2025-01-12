/*Se quiere diseñar e implementar una pequeña aplicación que procese un archivo con datos de empleados de una empresa (máximo 100 empleados) con el siguiente formato:  

### dni # nombre # ape1 # anyonac  ###fijo # factura # percent ############################################################ 

# 12345678Z # Ana Mª # del Campo # 2004 1100 # 2000 # 1.5 

# 23456789A # Juan # Martínez del Amo # 1990 1500 # 10000 # 3.0 

# 34567890B # Olga # Pérez # 2000 1100 # 5000 # 1.5 # 

Se supone que el archivo que se recibe cumple el formato especificado. 
Si el archivo no se puede abrir o no contiene datos, la aplicación terminará ordenadamente sin generar el archivo de salida, mostrando un mensaje al usuario que explique el error producido. 
Si el archivo se puede abrir y contiene datos, se leerán los datos de cada empleado y  se insertarán los datos en una estructura (que facilite su posterior filtrado y ordenación) 
Se añadirá a cada empleado un elemento adicional con el total de su nómina, calculado como el fijo más la cantidad de aplicar el porcentaje (campo percent) al campo factura; es decir total= fijo+factura*percent*0,01 
Se generará un archivo listado.html que muestre los empleados filtrados por un importe de facturación pasado por parametro es decir, solo deberán aparecer en el mismo los empleados cuya media supere la facturación de filtro que se recibió como argumento 
Y despues todos los empleados por orden de entrada. Se mostrará una tabla simple en formato HTML que contenga exclusivamente el dni, la facturación.

Criterios de calificación.
Si no compila un 0.
Se controlan las excepciones que se pueden producir (1 punto).
Se lee el archivo correctamente y se guardan los datos en una estructura(2 puntos).
Se crea el filtro que hace que cumpla la salida del enunciado (1 puntos).
Se crea el fichero con los datos y la estructura establecida en el enunciado (6 puntos). */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        GestionDatos gestionDatos = new GestionDatos();
        Scanner sc = new Scanner(System.in);
        //System.out.println("Ingrese el nombre del archivo");
        String archivo = "empleados.txt";
        gestionDatos.guardarDatosEmple(archivo);
        System.out.println("Ingrese por el limite de la facturacion");
        String limite = sc.nextLine();
        int axuLimite = 0;
        try {
            axuLimite = Integer.parseInt(limite);
            gestionDatos.guardarHtml(axuLimite);
        } catch (NumberFormatException e) {
            System.out.println("Debe ingresar un numero");
        }
    }
}
