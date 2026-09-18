package ar.edu.unju.fi.poo.punto02.manager;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.poo.punto02.model.Envio;
import ar.edu.unju.fi.poo.punto02.model.EstadoEnvio;
import ar.edu.unju.fi.poo.punto02.model.Paquete;
import ar.edu.unju.fi.poo.punto02.model.Vehiculo;

public class ManagerLogistica {
    private List<Vehiculo> flota;
    private List<Paquete> paquetesAlmacen;
    private List<Envio> enviosRegistrados;
    private int contadorEnvios;

    public ManagerLogistica() {
        this.flota = new ArrayList<>();
        this.paquetesAlmacen = new ArrayList<>();
        this.enviosRegistrados = new ArrayList<>();
        this.contadorEnvios = 1;
        precargarDatos();
    }

    private void precargarDatos() {
        // Precarga de Vehiculos
        flota.add(new Vehiculo("AE123AB", "Renault Kangoo Furgon", 650.0, 3.0));
        flota.add(new Vehiculo("AF456CD", "Mercedes-Benz Sprinter", 1800.0, 10.5));

        // Precarga de Paquetes en deposito
        paquetesAlmacen.add(new Paquete("PKG001", "Maria Gomez", "Av. Siria 450, San Pedro", 15.0, 0.08));
        paquetesAlmacen.add(new Paquete("PKG002", "Juan Carlos Perez", "Calle Alberdi 120, La Mendieta", 45.0, 0.25));
        paquetesAlmacen.add(new Paquete("PKG003", "Distribuidora del Norte", "Ruta 34 Km 1198", 520.0, 2.20));
        paquetesAlmacen.add(new Paquete("PKG004", "Lucia Fernandez", "Barrio Providencia Mza 4", 8.5, 0.04));
        paquetesAlmacen.add(new Paquete("PKG005", "Taller San Jose", "Av. 9 de Julio 890", 250.0, 1.10));
    }

    public List<Vehiculo> getFlota() {
        return flota;
    }

    public List<Paquete> getPaquetesAlmacen() {
        return paquetesAlmacen;
    }

    public List<Envio> getEnviosRegistrados() {
        return enviosRegistrados;
    }

    public Vehiculo buscarVehiculoPorPatente(String patente) {
        if (patente == null) return null;
        for (Vehiculo v : flota) {
            if (v.getPatente().equalsIgnoreCase(patente)) {
                return v;
            }
        }
        return null;
    }

    public Paquete buscarPaquetePorCodigo(String codigo) {
        if (codigo == null) return null;
        for (Paquete p : paquetesAlmacen) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    public Envio crearEnvio(Paquete paquete) {
        if (paquete == null) return null;
        Envio nuevo = new Envio(contadorEnvios++, paquete);
        enviosRegistrados.add(nuevo);
        return nuevo;
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
}