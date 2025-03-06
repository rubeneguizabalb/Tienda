package tienda;

public class Tienda {
    private String nombre;
    private final int maxProducto;
    private ProductoInventariado[] inventario;
    private int ultimaEntrada;
    private double caja;

    public Tienda(String nombre, int maxProducto, double caja) {
        this.nombre = nombre;
        this.maxProducto = maxProducto;
        this.inventario = new ProductoInventariado[maxProducto];
        this.ultimaEntrada = 0;
        this.caja = caja;
    }
    
    // Métodos funcionales
    public int buscaProducto(String id) {
        for (int i = 0; i < ultimaEntrada; i++) {
        	Producto producto = inventario[i];
            if (producto.getIdentificacion().equals(id)) {
                return i;
            }
        }
        return ultimaEntrada;
    }

    public void añadirProducto(String id, double p, int c, int b) {
        int indice = buscaProducto(id);

        if (indice < ultimaEntrada) { // El producto ya existe
            inventario[indice].setPrecioBase(p);
            
            int cantidadActual = inventario[indice].getCantidad();
            inventario[indice].setCantidad(cantidadActual + c);
            
            inventario[indice].setBeneficio(b);
        } else { // Producto nuevo
            if (ultimaEntrada < maxProducto && caja >= (c * p)) {
                inventario[ultimaEntrada] = new ProductoInventariado(id, p, c, b);
                caja -= c * p;
                ultimaEntrada++;
            } else {
                System.out.println("No se puede añadir el producto: inventario lleno o dinero insuficiente.");
            }
        }
    }

    public void venderProducto(String id, int c) {
        int indice = buscaProducto(id);
        if (indice < ultimaEntrada) {
            ProductoInventariado producto = inventario[indice];
            if (producto.getCantidad() >= c) {
                caja += c * producto.precioFinal();
                producto.setCantidad(producto.getCantidad() - c);
                if (producto.getCantidad() == 0) {
                    // Eliminamos el producto del inventario
                    for (int i = indice; i < ultimaEntrada - 1; i++) {
                        inventario[i] = inventario[i + 1];
                    }
                    inventario[ultimaEntrada - 1] = null;
                    ultimaEntrada--;
                }
            } else {
                System.out.println("No hay suficiente cantidad del producto.");
            }
        } else {
            System.out.println("El producto no existe en el inventario.");
        }
    }

    public void mostrarInventario() {
        System.out.println("Inventario de la tienda " + nombre + ":");
        for (int i = 0; i < ultimaEntrada; i++) {
            System.out.println(inventario[i]);
        }
        System.out.println("Dinero en caja: " + String.format("%.2f", caja));
    }
    
    public ProductoInventariado getProducto(int index) {
        if (index >= 0 && index < ultimaEntrada) {
            return inventario[index];
        }
        return null;
    }

    // Getters y Setters (Para acceso en caso de ser necesario)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMaxProducto() {
        return maxProducto;
    }

    public ProductoInventariado[] getInventario() {
        return inventario;
    }

    public void setInventario(ProductoInventariado[] inventario) {
        this.inventario = inventario;
    }

    public int getUltimaEntrada() {
        return ultimaEntrada;
    }

    public void setUltimaEntrada(int ultimaEntrada) {
        this.ultimaEntrada = ultimaEntrada;
    }

    public double getCaja() {
        return caja;
    }

    public void setCaja(double caja) {
        this.caja = caja;
    }
}

