package ar.edu.unju.fi.poo.punto01.model;

public class ItemCarrito {
    private int id;
    private Producto producto;
    private int cantidad;

    public ItemCarrito(int id, Producto producto, int cantidad) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double subTotal() {
        return producto.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", producto=" + producto.getNombre() + ", cantidad=" + cantidad + 
               ", subtotal=$" + subTotal() + "]";
    }
}