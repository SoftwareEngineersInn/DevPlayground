## Design Patterns

### ¿Qué son?

Los patrones de diseño de software nacen como una forma de capturar **soluciones comprobadas a problemas recurrentes en el desarrollo de software**. No son reglas estrictas, sino **guías reutilizables que ayudan** a resolver ciertos tipos de problemas de diseño de forma más eficiente, estructurada y mantenible.

### ¿Dónde y cuándo nacen?

El concepto de patrones de diseño en software toma inspiración de **la arquitectura tradicional** (edificios), específicamente del trabajo del arquitecto **Christopher Alexander**, quien en los años 70 documentó patrones arquitectónicos que resolvían problemas comunes en urbanismo y construcción. Su obra más influyente fue *A Pattern Language*.

A finales de los 80 e inicios de los 90, este enfoque fue adaptado al desarrollo de software, siendo popularizado en 1994 por el famoso libro:

> **"Design Patterns: Elements of Reusable Object-Oriented Software"**
por el *Gang of Four* (GoF): Erich Gamma, Richard Helm, Ralph Johnson y John Vlissides. 

### 🎯 ¿Por qué surgieron?

Los patrones de diseño surgieron como respuesta a **necesidades reales del desarrollo de software**:

1. **Evitar reinventar la rueda**

Permiten reutilizar soluciones que ya han funcionado bien en otros proyectos.

2. **Mejorar la comunicación entre desarrolladores**

En lugar de explicar una solución desde cero, puedes decir: "Aquí usamos un patrón *Factory Method*".

3. **Fomentar buenas prácticas de diseño**

Ayudan a cumplir principios como SOLID, separación de responsabilidades, bajo acoplamiento, alta cohesión, etc.

4. **Hacer el código más mantenible y extensible**

Al aplicar estructuras probadas, es más fácil modificar y ampliar el software sin romper su arquitectura.

5. **Facilitar la comprensión y la documentación**

Usar un patrón conocido hace que el diseño sea más predecible y entendible por otros desarrolladores

### 🧩 Clasificación general de los patrones GoF
Los 23 patrones descritos por el GoF se dividen en tres grupos:
- **Creacionales** – Cómo se crean los objetos

    Ej.: Singleton, Factory Method, Abstract Factory, Builder, Prototype.

- **Estructurales** – Cómo se organizan las clases y objetos

    Ej.: Adapter, Composite, Decorator, Facade, Proxy, Bridge.

- **Comportamiento** – Cómo interactúan los objetos entre sí

    Ej.: Observer, Strategy, Command, Iterator, State, Mediator.

### 🛠 Ejemplo simple del problema que resuelven

**Problema común**: Tienes múltiples clases que hacen lo mismo de forma ligeramente distinta, y necesitas instanciarlas de forma flexible.

**Solución tradicional**: `if...else`, código duplicado, difícil de mantener.

**Solución con patrón**: Usar un patrón como *Factory Method* permite instanciar diferentes clases sin acoplar el código al tipo concreto.

## ✅ Conclusión
Los patrones de diseño **no son recetas mágicas**, pero sí herramientas valiosas que permiten crear sistemas más robustos, mantenibles y escalables. Entender *cuándo y por qué* aplicarlos es tan importante como saber *qué hacen*.