## Abstract Factory Pattern
El **Abstract Factory** es un patrón de diseño creacional que **proporciona una interfaz para crear familias de objetos 
relacionados o dependientes sin especificar sus clases concretas**.

En otras palabras:
- No crea un objeto aislado (como Factory Method)
- Crea **grupos o familias de objetos** que tienen sentido entre sí.
- El cliente no necesita conocer las clases concretas que se están instanciando.

### Por qué nace
El problema que resuelve es:
- Cuando tienes **múltiples productos relacionados** y quieres garantizar que se usen **coherentemente juntos**.
- Cuando el código del cliente **no debe depender** de clases concretas.
- Cuando una aplicación debe poder **cambiar fácilmente de “familia” de productos** (p. ej., cambiar de una base de datos SQL a NoSQL o de un estilo de UI oscuro a claro).

Ejemplo sencillo fuera de código:
- Imagina que tienes una fábrica de muebles:
  - Familia Victoriana → Silla victoriana, Mesa victoriana, Sofá victoriano.
  - Familia Moderna → Silla moderna, Mesa moderna, Sofá moderno.
>No quieres que accidentalmente alguien mezcle una silla victoriana con una mesa moderna.

### Ventajas
- **Desacoplamiento**: El cliente no conoce las clases concretas.
- **Coherencia**: Todos los objetos creados son de la misma “familia”.
- **Facilidad para cambiar familias**: Basta con cambiar la fábrica que se inyecta.
- **Cumple SRP y OCP**: Separas la creación de objetos de su uso, y puedes añadir nuevas familias sin modificar el código cliente.

> Ejemplos **ok/wrong** pueden ser encontrados dentro de la carpeta `src`