package ar.edu.unju.fi.poo.punto01.model;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private boolean activo;

    public Producto() {
    }

    public Producto(String codigo, String nombre, double precio, boolean activo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.activo = activo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=$" + precio + ", activo=" + activo + "]";
    }
}
