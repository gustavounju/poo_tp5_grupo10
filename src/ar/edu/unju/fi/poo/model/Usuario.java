package ar.edu.unju.fi.poo.model;

public class Usuario {
    private String id;
    private String nombre;
    private String email;
    private CarritoDeCompras carrito;

    public Usuario(String id, String nombre, String email, CarritoDeCompras carrito) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.carrito = carrito;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CarritoDeCompras getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoDeCompras carrito) {
        this.carrito = carrito;
    }

    public void agregarAlCarrito(Producto p, int cantidad) {
        if (carrito != null) {
            carrito.agregar(p, cantidad);
        }
    }

    public void removerDelCarrito(Producto p) {
        if (carrito != null) {
            carrito.remover(p);
        }
    }

    public void verTotalCarrito() {
        if (carrito != null) {
            System.out.println("Total del carrito de " + nombre + ": $" + carrito.total());
        }
    }

    public void mostrarCarrito() {
        System.out.println("--- Contenido del Carrito (Usuario: " + nombre + ") ---");
        if (carrito == null || carrito.getItems().isEmpty()) {
            System.out.println("(El carrito esta vacio)");
            return;
        }
        for (ItemCarrito item : carrito.getItems()) {
            System.out.println("  * " + item);
        }
        System.out.println("Importe Total acumulado: $" + carrito.total());
    }
}