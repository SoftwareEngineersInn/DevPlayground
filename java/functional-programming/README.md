## 📌 ¿Qué es la Programación Funcional?

**La programación funcional** es un paradigma de programación donde el foco está **en qué se quiere hacer en lugar de cómo hacerlo**, utilizando funciones como unidades fundamentales de composición.
En lugar de manipular estados y estructuras mutables (como en la programación imperativa), se centra en el uso de **funciones puras, inmutabilidad y expresiones**.

Ejemplo Conceptual:
```java
// Imperativo
List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> doubled = new ArrayList<>();
for (Integer n : nums) {
    doubled.add(n * 2);
}

// Funcional
List<Integer> doubled = nums.stream()
                            .map(n -> n * 2)
                            .toList();
```

### 📌 ¿Por qué nace?
La FP surge como alternativa al estilo imperativo (ej. Java clásico, C) y orientado a objetos (OOP).
Se empieza a popularizar porque:

1. **Mayor facilidad para el paralelismo y concurrencia** (evita estados compartidos).
2. **Código más declarativo y conciso** → describe el “qué”, no el “cómo”.
3. **Mejor testabilidad y mantenibilidad** gracias a funciones puras e inmutabilidad.
4. **Reutilización y composición** de funciones pequeñas en soluciones más complejas.

### 📌 Ventajas principales
- **Inmutabilidad**: Menos errores por estados compartidos.
- **Funciones puras**: Misma entrada → misma salida (fácil de testear).
- **Concisión**: Menos código repetitivo (ej. lambdas, streams).
- **Paralelismo natural**: Ideal para aprovechar CPUs multinúcleo.
- **Facilidad para razonar**: Evita efectos colaterales difíciles de rastrear.

### 📌 ¿Qué versiones de Java lo soportan?
- **Java < 8** → no tenía soporte nativo, solo librerías externas como **FunctionalJava** o **Guava** (parcialmente).

- **Java 8 (2014)** → llega el soporte oficial:
    - **Lambdas** (`(x) -> x * 2`)
    - **Interfaces funcionales** (`Predicate`, `Function`, `Supplier`, etc.)
    - **Streams API** (`.map()`, `.filter()`, `.reduce()`)
    - **Optional** para evitar `null`

- **Java 9+** → mejoras en Streams (`takeWhile`, `dropWhile`, `iterate` con condición).

- **Java 11+** → más métodos utilitarios (`var` en lambdas, `Optional.isEmpty`).

- **Java 17+** → patrones de matching, sellado de clases (que ayudan al estilo FP).

- **Java 21** → virtual threads (Project Loom) que se integran bien con enfoques reactivos/funcionales.

## ✅ Resumen:
La programación funcional en Java nace como respuesta a la complejidad y la necesidad de concurrencia. Desde **Java 8** ya tenemos lambdas, streams y `Optional`. Se aprovecha para escribir código más declarativo, menos propenso a errores y más fácil de paralelizar. Para casos más avanzados existen librerías como **Vavr** o entornos reactivos como **Spring WebFlux**.