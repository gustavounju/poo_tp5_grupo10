package ar.edu.unju.fi.poo.punto02.main;

import java.time.LocalDate;
import ar.edu.unju.fi.poo.punto02.manager.ManagerLogistica;
import ar.edu.unju.fi.poo.punto02.model.Envio;
import ar.edu.unju.fi.poo.punto02.model.EstadoEnvio;
//import ar.edu.unju.fi.poo.punto02.model.Paquete;
import ar.edu.unju.fi.poo.punto02.model.RutaDiaria;
import ar.edu.unju.fi.poo.punto02.model.Vehiculo;

public class MainLogistica {
    public static void main(String[] args) {
        ManagerLogistica manager = new ManagerLogistica();

        System.out.println("SISTEMA DE GESTION LOGISTICA Y ENVIOS - GRUPO 10");

        // Mostrar flota disponible
        System.out.println("flota de vehiculos registrados:");
        for (Vehiculo v : manager.getFlota()) {
            System.out.println(v);
        }

        
        // Generar envios a partir de paquetes en deposito
        System.out.println("generacion de envios (Estado inicial: PENDIENTE):");
        Envio envio1 = manager.crearEnvio(manager.buscarPaquetePorCodigo("PKG001"));
        Envio envio2 = manager.crearEnvio(manager.buscarPaquetePorCodigo("PKG002"));
        Envio envio3 = manager.crearEnvio(manager.buscarPaquetePorCodigo("PKG003"));
        Envio envio4 = manager.crearEnvio(manager.buscarPaquetePorCodigo("PKG004"));
        Envio envio5 = manager.crearEnvio(manager.buscarPaquetePorCodigo("PKG005"));

        for (Envio e : manager.getEnviosRegistrados()) {
            System.out.println(e);
        }

        // Crear Ruta Diaria con una unidad utilitaria menor (Kangoo: 650 kg max, 3.0 m3 max)
        Vehiculo utilitario = manager.buscarVehiculoPorPatente("AF456CD");
        RutaDiaria ruta1 = new RutaDiaria(101, LocalDate.now(), utilitario);
        
        System.out.println("[Prueba] Asignacion de envio sin paquete:");
        Envio envioSinPaquete = new Envio(99, null);

        boolean asignado = ruta1.agregarEnvio(envioSinPaquete);

        if (!asignado) {
            System.out.println("Validacion correcta: El envio sin paquete fue rechazado y no se sumo a la ruta.");
        }
        
        
        

        System.out.println("cargo en la ruta 101 los envios (" + utilitario.getModelo() + "):");
        
        // todos son paquetes chicos
        ruta1.agregarEnvio(envio1);
        ruta1.agregarEnvio(envio2);
        ruta1.agregarEnvio(envio4);

        // ejemplo de sobrecarga: el envio 3 pesa 520 kg y suma 2.20 m3, superando el maximo de volumen
        System.out.println("intento enviar paquete pesado y/o voluminoso (PKG003):");
        ruta1.agregarEnvio(envio3);

        // se intenta con otro paquete de menos m3
        System.out.println("Evaluando envio mediano (PKG005):");
        ruta1.agregarEnvio(envio5);

        // mostrar resumen de la ruta creada
        System.out.println("resumen de la ruta creada:");
        ruta1.mostrarResumenRuta();

        // Verificar estado de envios tras la carga
        System.out.println("envios en transito");
        for (Envio e : manager.filtrarEnviosPorEstado(EstadoEnvio.EN_TRANSITO)) {
            System.out.println(e);
        }

        System.out.println("--- Envios pendientes en deposito ---");
        boolean hayPendientes = false;

        for (Envio e : manager.filtrarEnviosPorEstado(EstadoEnvio.PENDIENTE)) {
            System.out.println(e);
            hayPendientes = true;
        }

        if (!hayPendientes) {
            System.out.println("Sin paquetes en el deposito.");
        }
    }
}