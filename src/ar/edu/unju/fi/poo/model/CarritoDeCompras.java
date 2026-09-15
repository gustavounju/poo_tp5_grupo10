package ar.edu.unju.fi.poo.model;

import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompras {
    private int id;
    private List<ItemCarrito> items;
    private int contadorItems;

    public CarritoDeCompras(int id) {
        this.id = id;
        this.items = new ArrayList<>();
        this.contadorItems = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ItemCarrito> getItems() {
        return items;
    }

    public void agregar(Producto p, int cantidad) {
        if (p == null || !p.isActivo() || cantidad <= 0) {
            return;
        }
        // Si el producto ya esta en el carrito, se incrementa la cantidad
        for (ItemCarrito item : items) {
            if (item.getProducto().getCodigo().equals(p.getCodigo())) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }
        // Si no existe, se agrega como un nuevo item
        items.add(new ItemCarrito(contadorItems++, p, cantidad));
    }

    public void remover(Producto p) {
        if (p != null) {
            items.removeIf(item -> item.getProducto().getCodigo().equals(p.getCodigo()));
        }
    }

    public double total() {
        double acum = 0.0;
        for (ItemCarrito item : items) {
            acum += item.subTotal();
        }
        return acum;
    }

    public void vaciar() {
        items.clear();
    }
}