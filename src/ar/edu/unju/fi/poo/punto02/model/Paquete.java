package ar.edu.unju.fi.poo.punto02.model;

public class Paquete {
    private String codigo;
    private String destinatario;
    private String direccion;
    private double pesoKg;
    private double volumenM3;

    public Paquete(String codigo, String destinatario, String direccion, double pesoKg, double volumenM3) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.direccion = direccion;
        this.pesoKg = pesoKg;
        this.volumenM3 = volumenM3;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public double getVolumenM3() {
        return volumenM3;
    }

    public void setVolumenM3(double volumenM3) {
        this.volumenM3 = volumenM3;
    }

    @Override
    public String toString() {
        return "Paquete [" + codigo + "] Destinatario: " + destinatario + 
               " | Dir: " + direccion + " | Peso: " + pesoKg + " kg | Vol: " + volumenM3 + " m3";
    }
}