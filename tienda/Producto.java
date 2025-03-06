package tienda;

public class Producto {
    protected String identificacion;
    protected double precioBase;

    public Producto(String identificacion, double precioBase) {
        this.identificacion = identificacion;
        this.precioBase = precioBase;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String toString() {
        return identificacion + " (" + String.format("%.2f", precioBase) + ")";
    }
}

