## I - Interface Segregation Principle (ISP)
Los clientes **no deberían estar obligados** a depender de **interfaces** que **no**.

## Ejemplo:
Una interfaz `Bird` con métodos `eat()`, `fly()`, `swim()`.

#### 🔴 Malo: Una impresora simple debe implementar métodos innecesarios como fax().

#### 🟢 Bueno:
Divide la interfaz en interfaces pequeñas:
- `Bird`
- `FlyingBird`
- `SwimmingBird`

#### 📌 Aplicación importante: Mejora la flexibilidad y la reutilización de interfaces.

## 🎯 ¿Por qué se cumple ISP al aplicar correctamente LSP?

#### 📌 **Recordatorio rápido**:
**LSP (Liskov Substitution Principle)**: Las clases derivadas deben poder sustituir a sus clases base sin romper el comportamiento del programa.

**ISP (Interface Segregation Principle)**: Los clientes no deben verse forzados a depender de interfaces que no usan.

## 🔄 Relación directa entre ambos principios
Al aplicar LSP correctamente en un contexto de herencia e interfaces, te darás cuenta de que:
- Si una clase hija no necesita implementar cierto comportamiento de su clase padre o de una interfaz, entonces esa interfaz está mal diseñada desde el punto de vista de ISP.
- La solución es dividir esa interfaz en interfaces más pequeñas, específicas, y que representen claramente una sola responsabilidad o capacidad → y eso es exactamente lo que ISP propone.

## 🧠 Conclusión
- ✔️ Si aplicás correctamente LSP, y para eso diseñás tus interfaces de forma más granular y específica, estás naturalmente cumpliendo también ISP.
- 📐 Ambos principios trabajan juntos para lograr cohesión, reutilización y bajo acoplamiento