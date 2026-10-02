package ar.edu.unju.fi.poo.punto02.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Envio {
    private int id;
    private String remitente;
    private String destinatario;
    private String direccionEntrega;
    private EstadoEnvio estado;
    private LocalDate fechaCreacion;
    private List<Paquete> paquetes;

    public Envio(int id, String remitente, String destinatario, String direccionEntrega) {
        this.id = id;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.direccionEntrega = direccionEntrega;
        this.estado = EstadoEnvio.GENERADO;
        this.fechaCreacion = LocalDate.now();
        this.paquetes = new ArrayList<>();
    }

    public void agregarPaquete(Paquete paquete) {
        if (paquete != null) {
            this.paquetes.add(paquete);
        }
    }

    public void despachar() {
        this.estado = EstadoEnvio.EN_RUTA;
    }

    public void devolver() {
        this.estado = EstadoEnvio.DEVUELTO;
    }

    public void asignarRuta() {
        this.estado = EstadoEnvio.EN_RUTA;
    }

    public double getPesoTotal() {
        double total = 0.0;
        for (Paquete p : paquetes) {
            total += p.getPesoKg();
        }
        return total;
    }

    public double getVolumenTotal() {
        double total = 0.0;
        for (Paquete p : paquetes) {
            total += p.getVolumenDm3();
        }
        return total;
    }

    public boolean tienePaquetes() {
        return !this.paquetes.isEmpty();
    }

    public void mostrarInfo() {
        System.out.println("--------------------------------------------------");
        System.out.println("Envio ID: " + id + " | Estado: " + estado + " | Fecha: " + fechaCreacion);
        System.out.println("Remitente: " + remitente);
        System.out.println("Destinatario: " + destinatario);
        System.out.println("Direccion de entrega: " + direccionEntrega);
        System.out.println("Paquetes asociados (" + paquetes.size() + "):");
        for (Paquete p : paquetes) {
            System.out.println("  -> " + p);
        }
        System.out.println("Peso Total: " + getPesoTotal() + " kg | Volumen Total: " + getVolumenTotal() + " dm3");
        System.out.println("--------------------------------------------------");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public EstadoEnvio getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnvio estado) {
        this.estado = estado;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    @Override
    public String toString() {
        return "Envio #" + id + " [" + estado + "] a " + destinatario + " (" + direccionEntrega + ") - Paquetes: " + paquetes.size() + " (" + getPesoTotal() + " kg)";
    }
}