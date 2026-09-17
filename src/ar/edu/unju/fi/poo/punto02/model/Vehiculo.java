package ar.edu.unju.fi.poo.punto02.model;

public class Vehiculo {
    private String patente;
    private String modelo;
    private double capacidadKgMax;
    private double volumenM3Max;

    public Vehiculo(String patente, String modelo, double capacidadKgMax, double volumenM3Max) {
        this.patente = patente;
        this.modelo = modelo;
        this.capacidadKgMax = capacidadKgMax;
        this.volumenM3Max = volumenM3Max;
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

    public double getVolumenM3Max() {
        return volumenM3Max;
    }

    public void setVolumenM3Max(double volumenM3Max) {
        this.volumenM3Max = volumenM3Max;
    }

    @Override
    public String toString() {
        return "Vehiculo [" + patente + "] " + modelo + 
               " (Max: " + capacidadKgMax + " kg / " + volumenM3Max + " m3)";
    }
}