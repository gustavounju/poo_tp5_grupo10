package ar.edu.unju.fi.poo.punto02.manager;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.poo.punto02.model.Envio;
import ar.edu.unju.fi.poo.punto02.model.EstadoEnvio;
import ar.edu.unju.fi.poo.punto02.model.Vehiculo;

public class ManagerEnvios {
    private List<Envio> enviosRegistrados;
    private List<Vehiculo> vehiculosRegistrados;
    private int contadorEnvios;

    public ManagerEnvios() {
        this.enviosRegistrados = new ArrayList<>();
        this.vehiculosRegistrados = new ArrayList<>();
        this.contadorEnvios = 1;
        precargarDatos();
    }

    private void precargarDatos() {
        vehiculosRegistrados.add(new Vehiculo("AE123AB", "Renault Kangoo", 650.0, 3000.0));
        vehiculosRegistrados.add(new Vehiculo("AF456CD", "Mercedes-Benz Sprinter", 1800.0, 10500.0));
    }

    public Envio crearEnvio(String remitente, String destinatario, String direccionEntrega) {
        Envio nuevo = new Envio(contadorEnvios++, remitente, destinatario, direccionEntrega);
        nuevo.setEstado(EstadoEnvio.EN_ALMACEN);
        enviosRegistrados.add(nuevo);
        return nuevo;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            vehiculosRegistrados.add(vehiculo);
        }
    }

    public Vehiculo buscarVehiculoPorPatente(String patente) {
        if (patente == null) return null;
        for (Vehiculo v : vehiculosRegistrados) {
            if (v.getPatente().equalsIgnoreCase(patente)) {
                return v;
            }
        }
        return null;
    }

    public Envio buscarEnvioPorId(int id) {
        for (Envio e : enviosRegistrados) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public List<Envio> filtrarEnviosPorEstado(EstadoEnvio estado) {
        List<Envio> filtrados = new ArrayList<>();
        for (Envio e : enviosRegistrados) {
            if (e.getEstado() == estado) {
                filtrados.add(e);
            }
        }
        return filtrados;
    }

    public List<Envio> getEnviosRegistrados() {
        return enviosRegistrados;
    }

    public List<Vehiculo> getVehiculosRegistrados() {
        return vehiculosRegistrados;
    }
}