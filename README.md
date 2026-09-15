# Programación Orientada a Objetos — Trabajo Práctico Nº 5
**Carrera:** Analista Programador Universitario (APU)  
**Institución:** Facultad de Ingeniería – Universidad Nacional de Jujuy (UNJu)  
**Sede:** Extensión Áulica San Pedro  
**Ciclo Lectivo:** 2026  
**Fecha de Entrega:** 18/09/2026  

---

## 👥 Integrantes — Grupo 10
* Gustavo Elias Murad — LU: APU002128 — GitHub: [@gustavounju]


---

## 📌 Descripción del Proyecto
Este repositorio contiene la resolución del Trabajo Práctico Nº 5 enfocado en el diseño orientado a objetos, relaciones entre clases (asociación, agregación, composición, dependencia) y el uso del framework de colecciones (`Collections` / `List`) en el lenguaje de programación Java.

El trabajo se divide en dos módulos principales:
1. **Módulo Ecommerce:** Gestión de carritos de compra, catálogo de productos y usuarios.
2. **Módulo Logística:** Gestión de despachos, cálculo de capacidad por peso en vehículos, paquetes, estados de envío y asignación de rutas diarias.

---

## 🛠️ Tecnologías y Herramientas
* **Lenguaje:** Java 17 (o superior)
* **Gestor de dependencias:** Apache Maven
* **Entorno de Desarrollo (IDE):** Eclipse IDE / Spring Tools Suite (STS)
* **Control de versiones:** Git & GitHub

---

## 📂 Estructura del Proyecto

```text
poo_tp5_grupo10/
├── doc/                            # Diagramas UML e historias de usuario
│   ├── diagrama_ecommerce.png
│   └── diagrama_logistica.png
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ar/edu/unju/fi/poo/
│   │   │       ├── manager/
│   │   │       │   ├── ManagerProducto.java
│   │   │       │   └── ManagerEnvios.java
│   │   │       ├── model/
│   │   │       │   ├── CarritoDeCompras.java
│   │   │       │   ├── Envio.java
│   │   │       │   ├── EstadoEnvio.java
│   │   │       │   ├── ItemCarrito.java
│   │   │       │   ├── Paquete.java
│   │   │       │   ├── Producto.java
│   │   │       │   ├── RutaDiaria.java
│   │   │       │   ├── Usuario.java
│   │   │       │   └── Vehiculo.java
│   │   │       ├── MainEcommerce.java
│   │   │       └── MainEnvios.java
│   │   └── resources/
│   └── test/
├── .gitignore
├── pom.xml
└── README.md
```

---

## 📋 Historias de Usuario (Resumen)

### Ejercicio 1 — Ecommerce
* **HU01 - Agregar al carrito:** Como usuario, deseo seleccionar productos y cantidades para cargarlos a mi carrito de compras.
* **HU02 - Remover del carrito:** Como usuario, deseo quitar productos agregados previamente del carrito.
* **HU03 - Cálculo de total:** Como usuario, deseo ver el importe total actualizado de mi compra según los subtotales de cada ítem.
* **HU04 - Vaciar carrito:** Como usuario, deseo limpiar todos los artículos de mi carrito en una sola operación.

### Ejercicio 2 — Logística y Despachos
* **HU05 - Registro de paquetes y envíos:** Como operador, deseo registrar envíos con sus paquetes calculando el peso total acumulado.
* **HU06 - Validación y asignación de ruta:** Como despachante, deseo asignar un envío a una ruta diaria verificando que el vehículo no supere su capacidad máxima en kg y que el envío posea paquetes.
* **HU07 - Ciclo de vida y estados:** Como operador, deseo actualizar el estado de los envíos (`GENERADO`, `EN_ALMACEN`, `EN_RUTA`, `ENTREGADO`, `DEVUELTO`, `CANCELADO`) según las operaciones del flujo operativo.

---

## 🚀 Ejecución

1. Clonar el repositorio:
   ```bash
   git clone [https://github.com/](https://github.com/)[organizacion-o-usuario]/poo_tp5_grupo10.git
   cd poo_tp5_grupo10
   ```
2. Importar en Eclipse o STS como **Existing Maven Project**.
3. Ejecutar las clases principales de prueba:
   * **Punto 1:** `ar.edu.unju.fi.poo.MainEcommerce`
   * **Punto 2:** `ar.edu.unju.fi.poo.MainEnvios`
