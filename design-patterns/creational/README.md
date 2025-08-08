## Patrones de diseño Creacionales

Los **patrones de diseño creacionales** son un conjunto de soluciones reutilizables orientadas a resolver problemas relacionados con **la creación de objetos** en el desarrollo de software. En lugar de crear objetos de manera directa con `new`, estos patrones proporcionan mecanismos que **mejoran la flexibilidad, reutilización y escalabilidad del código.**

### 🔧 ¿Qué son los patrones de diseño creacionales?
Son patrones que abstraen el proceso de instanciación de objetos. Su objetivo es:

- Controlar cómo y cuándo se crean los objetos.
- Ocultar los detalles del proceso de creación.
- Desacoplar la lógica de creación del uso del objeto.

### 🧠 Resumen 
| **Patrón** | **¿Cuándo usarlo en APIs Java?** |
| --- | --- |
| **Singleton** | Servicios globales, configuración, logs. |
| **Factory Method** | 	Crear objetos según lógica de negocio o tipo de entrada. |
| **Abstract Factory** | Crear familias de componentes según el tipo de API (REST/SOAP/etc). |
| **Builder** | Construcción de objetos complejos (DTOs, responses). |
| **Prototype** | Clonar configuraciones o plantillas. |
