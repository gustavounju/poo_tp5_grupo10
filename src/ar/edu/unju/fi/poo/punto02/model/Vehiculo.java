package ar.edu.unju.fi.poo.punto02.model;

public class Vehiculo {
    private String patente;
    private String modelo;
    private double capacidadKgMax;
    private double volumenDm3Max;

    public Vehiculo(String patente, String modelo, double capacidadKgMax, double volumenDm3Max) {
        this.patente = patente;
        this.modelo = modelo;
        this.capacidadKgMax = capacidadKgMax;
        this.volumenDm3Max = volumenDm3Max;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getCapacidadKgMax() {
        return capacidadKgMax;
    }

    public void setCapacidadKgMax(double capacidadKgMax) {
        this.capacidadKgMax = capacidadKgMax;
    }

    public double getVolumenDm3Max() {
        return volumenDm3Max;
    }

    public void setVolumenDm3Max(double volumenDm3Max) {
        this.volumenDm3Max = volumenDm3Max;
    }

    @Override
    public String toString() {
        return "Vehiculo [" + patente + "] " + modelo + " (Capacidad: " + capacidadKgMax + " kg / " + volumenDm3Max + " dm3)";
    }
}