package ar.edu.unju.fi.poo;

import ar.edu.unju.fi.poo.manager.ManagerProducto;
import ar.edu.unju.fi.poo.model.CarritoDeCompras;
import ar.edu.unju.fi.poo.model.Producto;
import ar.edu.unju.fi.poo.model.Usuario;

public class MainEcommerce {
    public static void main(String[] args) {
        ManagerProducto manager = new ManagerProducto();

        // Instanciar a un usuario con su correspondiente carrito de compras
        
        System.out.println("Creacion de Usuario y Carrito");
        CarritoDeCompras carrito = new CarritoDeCompras(1);
        Usuario usuario = new Usuario("U001", "Gustavo Murad", "24217436@unju.fi.edu.ar", carrito);
        System.out.println("Usuario registrado: " + usuario.getNombre() + " (" + usuario.getEmail() + ")");

        // Buscar y agregar productos al carrito
        
        Producto mouse = manager.buscarPorCodigo("P002");
        Producto teclado = manager.buscarPorCodigo("P003");
        Producto auriculares = manager.buscarPorCodigo("P005");

        usuario.agregarAlCarrito(mouse, 2);
        usuario.agregarAlCarrito(teclado, 1);
        usuario.agregarAlCarrito(auriculares, 1);
        System.out.println("Productos cargados al carrito correctamente.");

        // Mostrar el importe total
        System.out.println("Mostrar importe total");
        usuario.verTotalCarrito();

        // Mostrar el carrito
        System.out.println("Mostrar detalle del carrito");
        usuario.mostrarCarrito();

        // Buscar un producto y removerlo del carrito
        System.out.println("Buscar y remover producto (Teclado Mecanico)");
        Producto prodARemover = manager.buscarPorCodigo("P003");
        usuario.removerDelCarrito(prodARemover);
        System.out.println("Producto " + prodARemover.getNombre() + " removido.");

        // Mostrar el importe total actualizado y detalle
        System.out.println("Mostrar importe total actualizado");
        usuario.verTotalCarrito();
        usuario.mostrarCarrito();

        // Vaciar el carrito y verificar
        System.out.println("Vaciar el carrito");
        usuario.getCarrito().vaciar();
        usuario.verTotalCarrito();
        usuario.mostrarCarrito();
    }
}