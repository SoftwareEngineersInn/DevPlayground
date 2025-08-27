##  📌 ¿Qué es el patrón Prototype?
El patrón **Prototype** es un patrón **creacional** que permite **crear nuevos objetos a partir de la clonación de un 
objeto existente**, en lugar de instanciar clases de forma directa con `new`.

La idea es que cuando un objeto es **costoso de crear o configurar**, en lugar de repetir el proceso de inicialización cada 
vez, se genera una copia (clon) del objeto prototipo ya existente.

### 📌 ¿Por qué nace?
El patrón surge principalmente para:
- Evitar **costos altos de creación** de objetos complejos (por ejemplo, inicialización con múltiples dependencias, carga de datos pesados, etc.).
- Poder **crear nuevas instancias dinámicamente en tiempo de ejecución** sin depender de la clase concreta (lo que facilita extensibilidad).
- Reutilizar un objeto inicializado como "molde" para generar nuevos objetos con las mismas características.

### 📌 Ventajas
- ✔️ Reduce el **acoplamiento** porque no se necesita conocer la clase exacta para crear nuevos objetos.
- ✔️ Útil cuando la **creación de objetos es costosa**.
- ✔️ **Permite clonar objetos con configuraciones ya definidas** (plantillas, configuraciones pesadas).
- ✔️ Simplifica la creación de objetos en **árboles jerárquicos o estructuras complejas**.

> Ejemplos **ok/wrong** pueden ser encontrados dentro de la carpeta `src`

### 📌 ¿Qué problema corrige?
- **Sin Prototype:** cada nuevo `Report` tardaba 2 segundos en inicializarse
- **Con Prototype:** solo el primero tarda 2 segundos, y todos los demás se clonan en milisegundos.
- Además, evitamos **acoplarnos** a `new Report()` **en cada lugar del código**, usando un servicio centralizado que gestiona el prototipo.

### 👉 Conclusión:
El patrón **Prototype** es ideal cuando necesitamos **crear muchos objetos similares, costosos de instanciar, y queremos clonar un "molde" preconfigurado** en vez de repetir la construcción.