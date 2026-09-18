package ar.edu.unju.fi.poo.punto02.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RutaDiaria {
    private int idRuta;
    private LocalDate fecha;
    private Vehiculo vehiculo;
    private List<Envio> envios;

    public RutaDiaria(int idRuta, LocalDate fecha, Vehiculo vehiculo) {
        this.idRuta = idRuta;
        this.fecha = fecha;
        this.vehiculo = vehiculo;
        this.envios = new ArrayList<>();
    }

    public int getIdRuta() {
        return idRuta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public List<Envio> getEnvios() {
        return envios;
    }

    public double getPesoTotalCargado() {
        double total = 0.0;
        for (Envio e : envios) {
            total += e.getPaquete().getPesoKg();
        }
        return total;
    }

    public double getVolumenTotalCargado() {
        double total = 0.0;
        for (Envio e : envios) {
            total += e.getPaquete().getVolumenM3();
        }
        return total;
    }

    public boolean agregarEnvio(Envio envio) {
        if (envio == null || envio.getPaquete() == null) {
            System.out.println("RECHAZADO: Envio invalido o sin paquete.");
            return false;
        }

        Paquete pkg = envio.getPaquete();
        double nuevoPeso = getPesoTotalCargado() + pkg.getPesoKg();
        double nuevoVolumen = getVolumenTotalCargado() + pkg.getVolumenM3();

        // Validar sobrepeso
        if (nuevoPeso > vehiculo.getCapacidadKgMax()) {
        	System.out.println("RECHAZADO: El envio #" + envio.getId() + " (" + pkg.getPesoKg() + " kg) excede la carga. El vehiculo lleva " + getPesoTotalCargado() + " kg y su maximo permitido es " + vehiculo.getCapacidadKgMax() + " kg (Total intentado enviar este paquete seria: " + nuevoPeso + " kg).");            
        	envio.setEstado(EstadoEnvio.EN_ALMACEN); // vuelve al almacen
            return false;
        }

        // Validar sobrevolumen
        if (nuevoVolumen > vehiculo.getVolumenM3Max()) {
        	System.out.println("RECHAZADO: El envio #" + envio.getId() + " (" + pkg.getVolumenM3() + " m3) excede el volumen. El vehiculo lleva " + getVolumenTotalCargado() + " m3 y su maximo permitido es " + vehiculo.getVolumenM3Max() + " m3 (Total intentado: " + nuevoVolumen + " m3).");
            envio.setEstado(EstadoEnvio.EN_ALMACEN); // vuelve al almacen
            return false;
        }

        // Si supero las dos pruebas de cubicaje, sube al vehiculo
        envios.add(envio);
        envio.despachar(); // Pasa a EN_RUTA
        System.out.printf("ASIGNADO: Envio #%d agregado a la ruta del vehiculo %s\n", 
                envio.getId(), vehiculo.getPatente());
        return true;
    }

    public void mostrarResumenRuta() {
        System.out.println("Ruta Diaria N°: " + idRuta + " - Fecha: " + fecha);
        System.out.println(vehiculo);
        System.out.println("Cantidad de Envios: " + envios.size());
        
        double pesoActual = getPesoTotalCargado();
        double volActual = getVolumenTotalCargado();
 
        System.out.println("Carga Peso actual de todos los paquetes: " + pesoActual + " kg - Maximo del vehiculo: " + vehiculo.getCapacidadKgMax() + " kg");
 
        System.out.println("Carga en Volumen de todos los paquetes: " + volActual + " m3 - Maximo del vehiculo: " + vehiculo.getVolumenM3Max() + " m3");
        System.out.println("--- Envios a bordo del vehiculo---");
        for (Envio e : envios) {
            System.out.println(e);
        }
    }
}