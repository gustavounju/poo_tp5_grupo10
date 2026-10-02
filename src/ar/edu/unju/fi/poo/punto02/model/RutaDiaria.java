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

    public double getPesoTotalCargado() {
        double total = 0.0;
        for (Envio e : envios) {
            total += e.getPesoTotal();
        }
        return total;
    }

    public double getVolumenTotalCargado() {
        double total = 0.0;
        for (Envio e : envios) {
            total += e.getVolumenTotal();
        }
        return total;
    }

    public boolean agregarEnvio(Envio envio) {
        if (envio == null || !envio.tienePaquetes()) {
            System.out.println("RECHAZADO: El envio no posee paquetes o es nulo.");
            return false;
        }

        double nuevoPeso = getPesoTotalCargado() + envio.getPesoTotal();
        double nuevoVolumen = getVolumenTotalCargado() + envio.getVolumenTotal();

        if (nuevoPeso > vehiculo.getCapacidadKgMax()) {
            System.out.println("RECHAZADO: El envio #" + envio.getId() + " excede el peso maximo (" 
                    + vehiculo.getCapacidadKgMax() + " kg). Intentado: " + nuevoPeso + " kg.");
            envio.setEstado(EstadoEnvio.EN_ALMACEN);
            return false;
        }

        if (nuevoVolumen > vehiculo.getVolumenDm3Max()) {
            System.out.println("RECHAZADO: El envio #" + envio.getId() + " excede el volumen maximo (" 
                    + vehiculo.getVolumenDm3Max() + " dm3). Intentado: " + nuevoVolumen + " dm3.");
            envio.setEstado(EstadoEnvio.EN_ALMACEN);
            return false;
        }

        envios.add(envio);
        envio.asignarRuta();
        System.out.println("ASIGNADO: Envio #" + envio.getId() + " agregado a la ruta del vehiculo " + vehiculo.getPatente());
        return true;
    }

    public void mostrarResumenRuta() {
        System.out.println("==================================================");
        System.out.println("Ruta Diaria N°: " + idRuta + " - Fecha: " + fecha);
        System.out.println("Vehiculo: " + vehiculo);
        System.out.println("Cantidad de Envios: " + envios.size());
        System.out.println("Carga Peso actual: " + getPesoTotalCargado() + " kg - Max: " + vehiculo.getCapacidadKgMax() + " kg");
        System.out.println("Carga Volumen actual: " + getVolumenTotalCargado() + " dm3 - Max: " + vehiculo.getVolumenDm3Max() + " dm3");
        System.out.println("--- Envios a bordo ---");
        for (Envio e : envios) {
            System.out.println("  * " + e);
        }
        System.out.println("==================================================");
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
}