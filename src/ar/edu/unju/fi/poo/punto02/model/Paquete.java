package ar.edu.unju.fi.poo.punto02.model;

public class Paquete {
    private String codigo;
    private String descripcion;
    private double pesoKg;
    private double volumenDm3;

    public Paquete(String codigo, String descripcion, double pesoKg, double volumenDm3) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.pesoKg = pesoKg;
        this.volumenDm3 = volumenDm3;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public double getVolumenDm3() {
        return volumenDm3;
    }

    public void setVolumenDm3(double volumenDm3) {
        this.volumenDm3 = volumenDm3;
    }

    @Override
    public String toString() {
        return "Paquete [" + codigo + "] " + descripcion + " - Peso: " + pesoKg + " kg - Vol: " + volumenDm3 + " dm3";
    }
}