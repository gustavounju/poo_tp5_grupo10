# Historias de Usuario — Punto 2 (Gestión Logística y Envíos)

## HU01: Registro de paquetes
* **Descripción:** Como despachante de depósito, quiero registrar paquetes indicando código, descripción, peso en kg y volumen en decímetros cúbicos (dm³), para tener identificada la carga a trasladar.
* **Criterios de Aceptación:**
  * El paquete debe registrar código, descripción, peso (kg) y volumen (dm³).
  * Los valores de peso y volumen deben ser numéricos y mayores a cero.
  * Debe permitir consultar el peso y volumen para los cálculos de carga.

---

## HU02: Registro de vehículos de reparto
* **Descripción:** Como coordinador de logística, quiero registrar vehículos indicando patente, modelo, capacidad máxima de peso en kg y volumen en dm³, para conocer el límite de carga admisible por unidad.
* **Criterios de Aceptación:**
  * Debe registrar patente, modelo, capacidad máxima de peso (kg) y capacidad de volumen (dm³).
  * La patente identifica unívocamente al vehículo en la flota.

---

## HU03: Creación y preparación de envíos
* **Descripción:** Como despachante, quiero crear un envío con sus datos de entrega y asociarle uno o más paquetes, para consolidar la mercadería de un destinatario.
* **Criterios de Aceptación:**
  * El envío debe registrar id, remitente, destinatario, dirección de entrega y lista de paquetes asociados.
  * Todo envío nuevo debe inicializarse por defecto en estado `GENERADO`.
  * Un envío puede contener uno o más paquetes agregados mediante la operación `agregarPaquete()`.
  * Debe permitir consultar la información completa del envío y sus paquetes con `mostrarInfo()`.

---

## HU04: Asignación de envíos a la ruta diaria
* **Descripción:** Como planificador de logística, quiero armar una ruta diaria asignando envíos a un vehículo, para despachar únicamente las cargas que no superen la capacidad de la unidad.
* **Criterios de Aceptación:**
  * Un envío no puede ser asignado a una ruta si no tiene al menos un paquete cargado.
  * La suma del peso acumulado de la ruta más el peso total del nuevo envío no debe superar la capacidad de peso del vehículo.
  * La suma del volumen acumulado de la ruta más el volumen del nuevo envío no debe superar la capacidad volumétrica en dm³ del vehículo.
  * Si la carga excede los límites, el envío es rechazado y regresa a estado `EN_ALMACEN`.
  * Si la carga es admitida, el envío se incorpora a la ruta y pasa automáticamente a estado `EN_RUTA` mediante `asignarRuta()` o `despachar()`.

---

## HU05: Seguimiento y cambio de estado del envío
* **Descripción:** Como transportista o despachante, quiero actualizar el estado operativo de los envíos (ENTREGADO, DEVUELTO, CANCELADO), para reflejar el resultado final del despacho.
* **Criterios de Aceptación:**
  * Debe permitir marcar un envío como `ENTREGADO` al completar la entrega al destinatario.
  * Debe permitir registrar un envío como `DEVUELTO` si no pudo entregarse, mediante la operación `devolver()`.
  * El sistema debe permitir filtrar y listar los envíos registrados según su estado actual.