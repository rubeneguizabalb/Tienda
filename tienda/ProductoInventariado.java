package tienda;

public class ProductoInventariado extends Producto {
    protected int cantidad;
    protected int beneficio;

    public ProductoInventariado(String identificacion, double precioBase, int cantidad, int beneficio) {
        super(identificacion, precioBase); 
        this.cantidad = cantidad;
        this.beneficio = beneficio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }

    public double precioFinal() {
        return precioBase * (1 + beneficio / 100.0);
    }

    @Override
    public String toString() {
        return cantidad + " " + identificacion + " (" + String.format("%.2f", precioBase) + ")(+" + beneficio + "%)";
    }
}

