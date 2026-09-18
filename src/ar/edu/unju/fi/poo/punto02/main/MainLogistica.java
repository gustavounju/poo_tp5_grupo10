package ar.edu.unju.fi.poo.punto02.main;

import java.time.LocalDate;
import ar.edu.unju.fi.poo.punto02.manager.ManagerLogistica;
import ar.edu.unju.fi.poo.punto02.model.Envio;
import ar.edu.unju.fi.poo.punto02.model.EstadoEnvio;
import ar.edu.unju.fi.poo.punto02.model.Paquete;
import ar.edu.unju.fi.poo.punto02.model.RutaDiaria;
import ar.edu.unju.fi.poo.punto02.model.Vehiculo;

public class MainLogistica {
    public static void main(String[] args) {
        ManagerLogistica manager = new ManagerLogistica();

        System.out.println("==================================================");
        System.out.println("SISTEMA DE GESTION LOGISTICA Y ENVIOS - GRUPO 10");
        System.out.println("==================================================");

        // 1. Mostrar flota disponible
        System.out.println("\n[1] FLOTA DE VEHICULOS REGISTRADA:");
        for (Vehiculo v : manager.getFlota()) {
            System.out.println(" * " + v);
        }

        // 2. Generar envios a partir de paquetes en deposito
        System.out.println("\n[2] GENERACION DE ENVIOS (Estado inicial: PENDIENTE):");
        Envio envio1 = manager.crearEnvio(manager.buscarPaquetePorCodigo("PKG001"));
        Envio envio2 = manager.crearEnvio(manager.buscarPaquetePorCodigo("PKG002"));
        Envio envio3 = manager.crearEnvio(manager.buscarPaquetePorCodigo("PKG003"));
        Envio envio4 = manager.crearEnvio(manager.buscarPaquetePorCodigo("PKG004"));
        Envio envio5 = manager.crearEnvio(manager.buscarPaquetePorCodigo("PKG005"));

        for (Envio e : manager.getEnviosRegistrados()) {
            System.out.println(" * " + e);
        }

        // 3. Crear Ruta Diaria con una unidad utilitaria menor (Kangoo: 650 kg max, 3.0 m3 max)
        Vehiculo utilitario = manager.buscarVehiculoPorPatente("AE123AB");
        RutaDiaria ruta1 = new RutaDiaria(101, LocalDate.now(), utilitario);

        System.out.println("\n[3] CARGA DE ENVIOS A LA RUTA N° 101 (" + utilitario.getModelo() + "):");
        
        // Paquetes chicos entran perfecto
        ruta1.agregarEnvio(envio1);
        ruta1.agregarEnvio(envio2);
        ruta1.agregarEnvio(envio4);

        // Intento de sobrecarga: el envio 3 pesa 520 kg y suma 2.20 m3, superando el tope de volumen
        System.out.println("\n-> Evaluando envio pesado/voluminoso (PKG003):");
        ruta1.agregarEnvio(envio3);

        // Intento con otro paquete que si cabe
        System.out.println("\n-> Evaluando envio mediano (PKG005):");
        ruta1.agregarEnvio(envio5);

        // 4. Mostrar resumen y cubicaje de la ruta armada
        System.out.println("\n[4] RESUMEN OPERATIVO DE LA RUTA:");
        ruta1.mostrarResumenRuta();

        // 5. Verificar estado de envios tras la carga
        System.out.println("\n[5] ENVIOS EN TRANSITO:");
        for (Envio e : manager.filtrarEnviosPorEstado(EstadoEnvio.EN_TRANSITO)) {
            System.out.println(" * " + e);
        }

        System.out.println("\n[6] ENVIOS QUE QUEDARON PENDIENTES EN DEPOSITO:");
        for (Envio e : manager.filtrarEnviosPorEstado(EstadoEnvio.PENDIENTE)) {
            System.out.println(" * " + e);
        }
    }
}