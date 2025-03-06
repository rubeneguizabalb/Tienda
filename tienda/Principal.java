package tienda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre de la tienda: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce la capacidad máxima de productos: ");
        int maxProductos = scanner.nextInt();
        System.out.print("Introduce el dinero inicial de la tienda: ");
        double caja = scanner.nextDouble();

        Tienda tienda = new Tienda(nombre, maxProductos, caja);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Buscar producto");
            System.out.println("2. Añadir producto");
            System.out.println("3. Vender producto");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el identificador del producto: ");
                    String idBuscar = scanner.nextLine();
                    int indice = tienda.buscaProducto(idBuscar);
                    ProductoInventariado producto = tienda.getProducto(indice);
                    if (producto != null) {
                        System.out.println("Producto encontrado: " + producto);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }

                    break;
                case 2:
                    System.out.print("Identificador del producto: ");
                    String idAñadir = scanner.nextLine();
                    System.out.print("Precio base: ");
                    double precioBase = scanner.nextDouble();
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    System.out.print("Beneficio (%): ");
                    int beneficio = scanner.nextInt();
                    tienda.añadirProducto(idAñadir, precioBase, cantidad, beneficio);
                    break;
                case 3:
                    System.out.print("Identificador del producto: ");
                    String idVender = scanner.nextLine();
                    System.out.print("Cantidad a vender: ");
                    int cantidadVender = scanner.nextInt();
                    tienda.venderProducto(idVender, cantidadVender);
                    break;
                case 4:
                    tienda.mostrarInventario();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}

