# Historias de Usuario — Punto 2 (Logística y Envíos)

## HU01: Registro y cubicaje de paquetes
* **Descripción:** Como despachante de depósito, quiero registrar paquetes indicando código, destinatario, dirección, peso en kilogramos y volumen en metros cúbicos para que el sistema evalúe su admisibilidad en los transportes.
* **Criterios de Aceptación:**
  * El peso (kg) y el volumen (m³) deben ser valores estrictamente mayores a cero.
  * Cada paquete debe identificarse con un código alfanumérico único.
  * Debe permitir consultar las dimensiones y peso para cálculos de cubicaje.

---

## HU02: Gestión de flota y capacidad de vehículos
* **Descripción:** Como coordinador de logística, quiero registrar los vehículos de reparto especificando patente, modelo, capacidad máxima de peso (kg) y volumen límite (m³) para evitar la sobrecarga de las unidades.
* **Criterios de Aceptación:**
  * No se permite registrar capacidades o volúmenes menores o iguales a cero.
  * La patente debe servir como clave única de identificación dentro de la flota.

---

## HU03: Creación y seguimiento de envíos
* **Descripción:** Como despachante, quiero vincular un paquete a un envío y controlar su estado operativo (PENDIENTE, EN_TRANSITO, ENTREGADO, CANCELADO) para mantener la trazabilidad de la entrega.
* **Criterios de Aceptación:**
  * Todo envío recién creado debe inicializarse por defecto en estado `PENDIENTE`.
  * Debe permitir transicionar el estado conforme avanza la distribución física.
  * Cada envío debe asociarse a un identificador secuencial o código único.

---

## HU04: Asignación de envíos a la ruta diaria
* **Descripción:** Como planificador de distribución, quiero asignar envíos a una ruta diaria encabezada por un vehículo específico, verificando que no se exceda la capacidad disponible de la unidad.
* **Criterios de Aceptación:**
  * Al intentar agregar un envío, el sistema debe comprobar que la suma del peso actual más el peso del nuevo paquete no supere el peso máximo del vehículo.
  * Se debe realizar la misma validación restrictiva para el volumen total acumulado en m³.
  * Si la carga supera cualquiera de los dos límites, el envío debe ser rechazado y el sistema debe emitir un mensaje de advertencia.
  * Si la asignación es exitosa, el estado del envío debe cambiar a `EN_TRANSITO`.

---

## HU05: Monitoreo de ocupación y totales de la ruta
* **Descripción:** Como despachante de ruta, quiero visualizar el peso total cargado, el volumen total y el porcentaje de ocupación del vehículo para optimizar el rendimiento del viaje.
* **Criterios de Aceptación:**
  * El sistema debe calcular en tiempo real la sumatoria de peso y volumen de todos los envíos cargados.
  * Debe calcular y mostrar el porcentaje de ocupación respecto al límite máximo tanto de peso como de volumen.
  * Debe permitir listar en detalle todos los paquetes a bordo con sus destinatarios y direcciones.