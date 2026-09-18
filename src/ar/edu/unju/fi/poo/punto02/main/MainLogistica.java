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

        System.out.println("SISTEMA DE GESTION LOGISTICA Y ENVIOS - TP5 GRUPO 10");

        // Mostrar flota disponible
        System.out.println("\nflota de vehiculos registrados:");
        System.out.println("=========================================================================");
        for (Vehiculo v : manager.getFlota()) {
            System.out.println(v);
        }

        
        // Generar envios a partir de paquetes en deposito
        System.out.println("\ngeneracion de envios (Estado inicial: GENERADOS pasan a EN_ALMACEN):");
        System.out.println("=========================================================================");
        Envio envio1 = manager.crearEnvio(manager.buscarPaquetePorCodigo("PKG001"));
        Envio envio2 = manager.crearEnvio(manager.buscarPaquetePorCodigo("PKG002"));
        Envio envio3 = manager.crearEnvio(manager.buscarPaquetePorCodigo("PKG003"));
        Envio envio4 = manager.crearEnvio(manager.buscarPaquetePorCodigo("PKG004"));
        Envio envio5 = manager.crearEnvio(manager.buscarPaquetePorCodigo("PKG005"));

        for (Envio e : manager.getEnviosRegistrados()) {
            System.out.println(e); // Llama a Envio.toString() y este a su vez a Paquete.toString()
        }

        // Crear Ruta Diaria con una unidad utilitaria menor (Kangoo: 650 kg max, 3.0 m3 max)
        Vehiculo utilitario = manager.buscarVehiculoPorPatente("AF456CD");
        RutaDiaria ruta1 = new RutaDiaria(101, LocalDate.now(), utilitario);
        
        System.out.println("\n[Prueba] Asignacion de envio sin paquete:");
        System.out.println("=========================================================================");
        Envio envioSinPaquete = new Envio(99, null);

        boolean asignado = ruta1.agregarEnvio(envioSinPaquete);

        if (!asignado) {
            System.out.println("Validacion correcta: El envio sin paquete fue rechazado y no se sumo a la ruta.");
        }
        
        
        

        System.out.println("\ncargo en la ruta 101 los envios (" + utilitario.getModelo() + "):");
        System.out.println("=========================================================================");
        // todos son paquetes chicos
        ruta1.agregarEnvio(envio1);
        ruta1.agregarEnvio(envio2);
        ruta1.agregarEnvio(envio4);

        // ejemplo de sobrecarga: el envio 3 pesa 520 kg y suma 2.20 m3, superando el maximo de volumen
        System.out.println("\nEvaluando envio de paquete con mucho m3 (PKG003 - ENVIO 3 - Peso: 520.0 kg - Vol: 5 m3:");
        System.out.println("=========================================================================");
        ruta1.agregarEnvio(envio3);

        // se intenta con otro paquete de menos m3
        System.out.println("\nEvaluando envio de paquete con mucho peso (PKG005 - ENVIO 5 - Peso: 250.0 kg - Vol: 1.1 m3:");
        System.out.println("=========================================================================");
        ruta1.agregarEnvio(envio5);

        // mostrar resumen de la ruta creada
        System.out.println("\nresumen de la ruta creada:");
        System.out.println("=========================================================================");
        ruta1.mostrarResumenRuta();

        // Verificar estado de envios tras la carga
        System.out.println("\nenvios en transito");
        System.out.println("=========================================================================");

        for (Envio e : manager.filtrarEnviosPorEstado(EstadoEnvio.EN_RUTA)) {
            System.out.println(e);
        }

        System.out.println("\nenvios pendientes en deposito (EN_ALMACEN)");
        System.out.println("=========================================================================");

   //     boolean hayPendientes = false;

        for (Envio e : manager.filtrarEnviosPorEstado(EstadoEnvio.EN_ALMACEN)) {
            System.out.println(e);
    //        hayPendientes = true;
        }

//        if (!hayPendientes) {
//            System.out.println("Sin paquetes en el Almacen.");
//        }
        
        
     // SIMULACION DE CIERRE DE RUTA Y OTROS ESTADOS
     System.out.println("");
     System.out.println("simulacion de posibles estados de envio");
     System.out.println("=========================================================================");

     // Simular entrega exitosa (envio1 llega a destino)
     envio1.setEstado(EstadoEnvio.ENTREGADO);
     System.out.println("-> Envio #1 entregado con exito en destino.");

     // Simular devolucion (envio2 no se pudo entregar en La Mendieta)
     envio2.devolver(); // Cambia a EstadoEnvio.DEVUELTO
     System.out.println("-> Envio #2 no pudo entregarse: se procesa devolucion al deposito.");

     // Simular cancelacion (envio3 es cancelado por el cliente)
     envio4.setEstado(EstadoEnvio.CANCELADO);
     System.out.println("-> Envio #4 cancelado a solicitud del cliente.");

     // Reporte final clasificado por estado
     System.out.println("\nreporte general de envios por estado:");
     System.out.println("ENTREGADOS");
     for (Envio e : manager.filtrarEnviosPorEstado(EstadoEnvio.ENTREGADO)) {
         System.out.println(e);
     }

     System.out.println("\nDEVUELTOS");
     for (Envio e : manager.filtrarEnviosPorEstado(EstadoEnvio.DEVUELTO)) {
         System.out.println(e);
     }

     System.out.println("\nCANCELADOS");
     for (Envio e : manager.filtrarEnviosPorEstado(EstadoEnvio.CANCELADO)) {
         System.out.println(e);
     }

     System.out.println("\nEN RUTA");
     for (Envio e : manager.filtrarEnviosPorEstado(EstadoEnvio.EN_RUTA)) {
         System.out.println(e);
     }

     System.out.println("\nEN ALMACEN");
     for (Envio e : manager.filtrarEnviosPorEstado(EstadoEnvio.EN_ALMACEN)) {
         System.out.println(e);
     }
    }
}