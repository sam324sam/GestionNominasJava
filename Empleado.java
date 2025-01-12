public class Empleado {
    /*### dni # nombre # ape1 # anyonac  ###fijo # factura # percent ############################################################  */
    String dni;
    String nombre;
    String ape1;
    int anyonac;
    int fijo;
    int factura;
    Double percent;
    Double totalNomina;
    public Empleado(String dni, String nombre, String ape1, int anyonac, int fijo, int factura, Double percent) {
        this.dni = dni;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.anyonac = anyonac;
        this.fijo = fijo;
        this.factura = factura;
        this.percent = percent;
        this.totalNomina = fijo+factura*percent*0.01;
    }
    @Override
    public String toString() {
        return "Empleado [dni=" + dni + ", nombre=" + nombre + ", ape1=" + ape1 + ", anyonac=" + anyonac + ", fijo="
                + fijo + ", factura=" + factura + ", percent=" + percent + ", nomina= "+totalNomina;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApe1() {
        return ape1;
    }
    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }
    public int getAnyonac() {
        return anyonac;
    }
    public void setAnyonac(int anyonac) {
        this.anyonac = anyonac;
    }
    public int getFijo() {
        return fijo;
    }
    public void setFijo(int fijo) {
        this.fijo = fijo;
    }
    public int getFactura() {
        return factura;
    }
    public void setFactura(int factura) {
        this.factura = factura;
    }
    public Double getPercent() {
        return percent;
    }
    public void setPercent(Double percent) {
        this.percent = percent;
    }
    public Double getTotalNomina() {
        return totalNomina;
    }
    public void setTotalNomina(Double totalNomina) {
        this.totalNomina = totalNomina;
    }
    
}
