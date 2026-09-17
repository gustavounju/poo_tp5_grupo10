# Historias de Usuario — Punto 1 (Ecommerce)

## HU01: Agregar producto al carrito
* **Descripción:** Como usuario registrado, quiero poder seleccionar un producto del catálogo e indicar la cantidad deseada para agregarlo a mi carrito de compras.
* **Criterios de Aceptación:**
  * El sistema debe validar que el producto se encuentre activo.
  * Si el producto ya existe en el carrito, debe sumar la cantidad al ítem existente.
  * No se permite ingresar cantidades menores o iguales a cero.

---

## HU02: Remover producto del carrito
* **Descripción:** Como usuario, quiero quitar un producto del carrito para actualizar mi compra.
* **Criterios de Aceptación:**
  * Al solicitar la eliminación de un producto mediante su referencia o código, se da de baja el ítem de la lista.
  * Si el producto no existía en el carrito, la lista permanece inalterada.

---

## HU03: Visualizar importe total
* **Descripción:** Como usuario, quiero conocer en todo momento el importe total acumulado.
* **Criterios de Aceptación:**
  * Cada ítem calcula su subtotal multiplicando precio unitario por cantidad.
  * El total del carrito corresponde a la sumatoria de todos los subtotales de sus ítems.
  * Si el carrito está vacío, el total es 0.0.

---

## HU04: Mostrar detalle del carrito
* **Descripción:** Como usuario, quiero ver la lista completa de artículos en el carrito para revisar cantidades, precios y subtotales.
* **Criterios de Aceptación:**
  * Se listan todos los ítems agregados de manera legible.
  * Si no hay artículos, se informa que el carrito está vacío.

---

## HU05: Vaciar carrito
* **Descripción:** Como usuario, quiero vaciar todos los artículos del carrito en una sola acción.
* **Criterios de Aceptación:**
  * Se eliminan todos los elementos de la colección de ítems.
  * El importe total vuelve a 0.0.

---

## HU06: Administrar catálogo de productos
* **Descripción:** Como sistema, quiero disponer de un gestor de catálogo que almacene los productos y permita buscarlos por código.
* **Criterios de Aceptación:**
  * El catálogo se inicializa con al menos cinco productos activos.
  * La búsqueda por código retorna el producto coincidente o null si no existe.