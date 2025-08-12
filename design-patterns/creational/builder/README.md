## Builder Pattern

El patrón Builder es un patrón de diseño creacional cuyo propósito principal es **separar la construcción de un objeto 
complejo de su representación**, permitiendo crear diferentes representaciones del mismo objeto utilizando el mismo 
proceso de construcción.

### 🧱 ¿Qué es el patrón Builder?

Es un patrón que se utiliza cuando se necesita construir un objeto que:
- Tiene muchos **parámetros opcionales**.
- Puede ser configurado de diversas formas.
- **Es inmutable** (una vez creado, no se puede cambiar).

El patrón permite construir objetos paso a paso, y puede proporcionar una representación clara y legible al momento de instanciar.

### 🧬 ¿Por qué nace?
Surge como respuesta a problemas que presentan otras formas de construcción de objetos, como:

#### 🔹 Uso excesivo de constructores con muchos parámetros (telescoping constructors):
```java
new User("Juan", "Pérez", 30, "jp@gmail.com", "123456", "Costa Rica", true);
```
Este enfoque es difícil de leer, propenso a errores y no escalable.

#### 🔹 Uso de objetos mutables con setters:
```java
User user = new User();
user.setName("Juan");
user.setLastName("Pérez");
// ...
```
Aunque más legible, rompe el principio de inmutabilidad y puede dejar al objeto en un estado inconsistente si no se 
llaman todos los setters requeridos.

### Ventajas del patrón Builder
- ✔️ Mejora la **legibilidad** del código.
- ✔️ Permite **validación** al momento de construir el objeto.
- ✔️ Ayuda a mantener **inmutabilidad**.
- ✔️ Separa la **lógica de construcción** del objeto de su representación.
- ✔️ Se adapta bien a objetos con **parámetros opcionales** o con configuración variable.

> Ejemplos **ok/wrong** pueden ser encontrados dentro de la carpeta `src`