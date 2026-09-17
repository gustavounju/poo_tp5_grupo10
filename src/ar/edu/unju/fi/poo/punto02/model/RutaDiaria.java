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
            return false;
        }

        double nuevoPeso = getPesoTotalCargado() + envio.getPaquete().getPesoKg();
        double nuevoVolumen = getVolumenTotalCargado() + envio.getPaquete().getVolumenM3();

        if (nuevoPeso > vehiculo.getCapacidadKgMax()) {
            System.out.println("RECHAZADO: El envio #" + envio.getId() + 
                               " supera la capacidad en peso (" + nuevoPeso + " kg / max " + vehiculo.getCapacidadKgMax() + " kg)");
            return false;
        }

        if (nuevoVolumen > vehiculo.getVolumenM3Max()) {
            System.out.println("RECHAZADO: El envio #" + envio.getId() + 
                               " supera la capacidad en volumen (" + nuevoVolumen + " m3 / max " + vehiculo.getVolumenM3Max() + " m3)");
            return false;
        }

        envios.add(envio);
        envio.setEstado(EstadoEnvio.EN_TRANSITO);
        System.out.println("ASIGNADO: Envio #" + envio.getId() + " agregado a la ruta del vehiculo " + vehiculo.getPatente());
        return true;
    }

    public void mostrarResumenRuta() {
        System.out.println("==================================================");
        System.out.println("Ruta Diaria N°: " + idRuta + " | Fecha: " + fecha);
        System.out.println(vehiculo);
        System.out.println("Cantidad de Envios: " + envios.size());
        
        double pesoActual = getPesoTotalCargado();
        double volActual = getVolumenTotalCargado();
        double ocupacionPeso = (pesoActual / vehiculo.getCapacidadKgMax()) * 100.0;
        double ocupacionVol = (volActual / vehiculo.getVolumenM3Max()) * 100.0;

        System.out.printf("Carga Peso: %.2f kg / %.2f kg (%.1f%%)\n", pesoActual, vehiculo.getCapacidadKgMax(), ocupacionPeso);
        System.out.printf("Carga Volumen: %.2f m3 / %.2f m3 (%.1f%%)\n", volActual, vehiculo.getVolumenM3Max(), ocupacionVol);
        System.out.println("--- Envios a bordo ---");
        for (Envio e : envios) {
            System.out.println(" * " + e);
        }
        System.out.println("==================================================");
    }
}