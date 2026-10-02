package ar.edu.unju.fi.poo.punto02.main;

import java.time.LocalDate;
import ar.edu.unju.fi.poo.punto02.manager.ManagerEnvios;
import ar.edu.unju.fi.poo.punto02.model.Envio;
import ar.edu.unju.fi.poo.punto02.model.EstadoEnvio;
import ar.edu.unju.fi.poo.punto02.model.Paquete;
import ar.edu.unju.fi.poo.punto02.model.RutaDiaria;
import ar.edu.unju.fi.poo.punto02.model.Vehiculo;

public class MainEnvios {
    public static void main(String[] args) {
        ManagerEnvios manager = new ManagerEnvios();
        System.out.println("=== SISTEMA DE GESTION LOGISTICA Y ENVIOS - TP5 ===");

        System.out.println("\n--- Flota de Vehiculos Registrados ---");
        for (Vehiculo v : manager.getVehiculosRegistrados()) {
            System.out.println(v);
        }

        Envio envio1 = manager.crearEnvio("Distribuidora Central", "Maria Gomez", "Av. Siria 450, San Pedro");
        envio1.agregarPaquete(new Paquete("PKG001", "Caja herramientas", 15.0, 80.0));
        envio1.agregarPaquete(new Paquete("PKG002", "Juego de llaves", 5.0, 20.0));

        Envio envio2 = manager.crearEnvio("Empresa Textil", "Juan Carlos Perez", "Calle Alberdi 120, La Mendieta");
        envio2.agregarPaquete(new Paquete("PKG003", "Rollos de tela", 45.0, 250.0));

        Envio envioSinPaquetes = manager.crearEnvio("Remitente X", "Cliente Sin Carga", "Calle Falsa 123");

        Envio envioPesado = manager.crearEnvio("Metalurgica Norte", "Taller San Jose", "Ruta 34 Km 1198");
        envioPesado.agregarPaquete(new Paquete("PKG004", "Pieza pesada", 700.0, 1500.0));

        System.out.println("\n--- Demostracion de mostrarInfo() de un Envio ---");
        envio1.mostrarInfo();

        Vehiculo kangoo = manager.buscarVehiculoPorPatente("AE123AB");
        RutaDiaria ruta1 = new RutaDiaria(101, LocalDate.now(), kangoo);

        System.out.println("\n--- Pruebas de Asignacion a Ruta Diaria ---");
        System.out.println("1. Asignar Envio sin paquetes:");
        ruta1.agregarEnvio(envioSinPaquetes);

        System.out.println("\n2. Asignar Envio 1 (20 kg):");
        ruta1.agregarEnvio(envio1);

        System.out.println("\n3. Asignar Envio 2 (45 kg):");
        ruta1.agregarEnvio(envio2);

        System.out.println("\n4. Asignar Envio con sobrepeso (700 kg en Kangoo de max 650 kg):");
        ruta1.agregarEnvio(envioPesado);

        System.out.println("\n--- Resumen de la Ruta ---");
        ruta1.mostrarResumenRuta();

        System.out.println("\n--- Simulacion de Estados de Envio ---");
        envio1.setEstado(EstadoEnvio.ENTREGADO);
        System.out.println("-> Envio #1 entregado.");

        envio2.devolver();
        System.out.println("-> Envio #2 marcado como DEVUELTO mediante devolver().");

        System.out.println("\n--- Reporte: Envios en Deposito (EN_ALMACEN) ---");
        for (Envio e : manager.filtrarEnviosPorEstado(EstadoEnvio.EN_ALMACEN)) {
            System.out.println(e);
        }

        System.out.println("\n--- Reporte: Envios Devueltos (DEVUELTO) ---");
        for (Envio e : manager.filtrarEnviosPorEstado(EstadoEnvio.DEVUELTO)) {
            System.out.println(e);
        }
    }
}