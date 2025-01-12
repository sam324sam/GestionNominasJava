import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestionDatos {
    ArrayList<Empleado> empleadosGuardar = new ArrayList<>();

    public void guardarDatosEmple(String archivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String dni = null;
            String nombre = null;
            String ape1 = null;
            int anyonac = 0;
            int fijo = 0;
            int factura = 0;
            Double percent = null;
            String[] axu;
            String linea = " ";
            while (linea != null) {
                linea = br.readLine();
                String[] auxiliar = linea.split("#");
                for (int i = 0; i < auxiliar.length; i++) {
                    if (i == 1) {
                        dni = auxiliar[i];
                    } else if (i == 2) {
                        nombre = auxiliar[i];
                    } else if (i == 3) {
                        ape1 = auxiliar[i];
                    } else if (i == 4) {
                        axu = auxiliar[i].split(" ");
                        for (int j = 0; j < axu.length; j++) {
                            if (!axu[j].equals("")) {
                                fijo = Integer.parseInt(axu[j]);
                                if (j == 1) {
                                    anyonac = Integer.parseInt(axu[j]);
                                } else if (j == 2) {
                                    fijo = Integer.parseInt(axu[j]);
                                }
                            }
                        }
                    } else if (i == 5) {
                        axu = auxiliar[i].split(" ");
                        for (int j = 0; j < axu.length; j++) {
                            if (!axu[j].equals("")) {
                                factura = Integer.parseInt(axu[j]);
                            }
                        }
                    } else if (i == 6) {
                        axu = auxiliar[i].split(" ");
                        for (int j = 0; j < axu.length; j++) {
                            if (!axu[j].isEmpty()) {
                                percent = Double.parseDouble(axu[j]);
                            }
                        }
                    }
                }
                Empleado empleado = new Empleado(dni, nombre, ape1, anyonac, fijo, factura, percent);
                empleadosGuardar.add(empleado);
                System.out.println(empleado.toString());
                linea = br.readLine();
            }
            ordenarEmpleados(empleadosGuardar);
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No existe el fichero");
        } catch (IOException ex) {
            System.out.println("No se puede leer el fichero fichero");
        }
    }

    public static void ordenarEmpleados(ArrayList<Empleado> empleadosGuardar) {
        empleadosGuardar.sort((e1, e2) -> Integer.compare(e1.anyonac, e2.anyonac));
    }

    public void guardarHtml(int limite) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Empleados.html"));
            bw.write("<h2>Empleado que tiene mas de " + limite + "</h2>");
            bw.write("<table border=" + 1 + ">");
            for (Empleado empleado : empleadosGuardar) {
                if (empleado.getTotalNomina() >= limite) {
                    bw.write("<tr>");
                    bw.write("<th>Dni</th>");
                    bw.write("<th>Nomina</th>");
                    bw.write("</tr>");
                    bw.write("<tr>");
                    bw.write("<td><center>" + empleado.getDni() + "</center></td>");
                    bw.write("<td>" + empleado.getTotalNomina() + "</td>");
                    bw.write("</tr>");
                }
            }
            bw.write("</table>");
            bw.write("<h2>Todos los empleados</h2>");
            for (Empleado empleado : empleadosGuardar) {
                bw.write("<table border=" + 1 + ">");
                bw.write("<tr>");
                bw.write("<th>Dni</th>");
                bw.write("<th>Nomina</th>");
                bw.write("</tr>");
                bw.write("<tr>");
                bw.write("<td><center>" + empleado.getDni() + "</center></td>");
                bw.write("<td>" + empleado.getTotalNomina() + "</td>");
                bw.write("</tr>");
            }
            bw.flush();
            bw.close();
        } catch (

        FileNotFoundException ex) {
            System.out.println("No existe el fichero");
        } catch (IOException ex) {
            System.out.println("No se puede leer el fichero fichero");
        }
    }

    public void mostrarempleados() {
        for (Empleado empleado : empleadosGuardar) {
            System.out.println(empleado.toString());
        }
    }
}
