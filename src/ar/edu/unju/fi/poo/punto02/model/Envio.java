package ar.edu.unju.fi.poo.punto02.model;

import java.time.LocalDate;

public class Envio {
    private int id;
    private Paquete paquete;
    private EstadoEnvio estado;
    private LocalDate fechaCreacion;

    public Envio(int id, Paquete paquete) {
        this.id = id;
        this.paquete = paquete;
        this.estado = EstadoEnvio.PENDIENTE;
        this.fechaCreacion = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public EstadoEnvio getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnvio estado) {
        this.estado = estado;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Envio #" + id + " [" + estado + "] - " + paquete;
    }
}