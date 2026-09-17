package ar.edu.unju.fi.poo.manager;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.poo.model.Producto;

public class ManagerProducto {
    private List<Producto> productos;

    public ManagerProducto() {
        this.productos = new ArrayList<>();
        inicializarProductos();
    }

    private void inicializarProductos() {
        productos.add(new Producto("P001", "Notebook Gamer 15.6", 850000.0, true));
        productos.add(new Producto("P002", "Mouse Inalambrico RGB", 18500.0, true));
        productos.add(new Producto("P003", "Teclado Mecanico Switch Azul", 45000.0, true));
        productos.add(new Producto("P004", "Monitor Curvo 24 Full HD", 195000.0, true));
        productos.add(new Producto("P005", "Auriculares Bluetooth Con Microfono", 32000.0, true));
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto p) {
        if (p != null) {
            productos.add(p);
        }
    }

    public Producto buscarPorCodigo(String codigo) {
        if (codigo == null) {
            return null;
        }
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }
}