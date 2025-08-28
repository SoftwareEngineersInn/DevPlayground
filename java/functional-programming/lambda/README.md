### 🔹 ¿Qué son las lambdas en Java? `(parametros) -> { cuerpo de la lógica}`
Una **lambda expression** es básicamente una función anónima (sin nombre) que puedes pasar como argumento o almacenar en 
una variable.

Introducidas en **Java 8**, permiten escribir código más conciso y expresivo al trabajar con **interfaces funcionales** 
(interfaces con un único método abstracto, como `Runnable`, `Callable`, `Comparator`, `Predicate`, etc.).

👉 Ejemplo básico:

```java
// Imperativo
Runnable r1 = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hola Mundo");
    }
};

// Con lambda
Runnable r2 = () -> System.out.println("Hola Mundo");
```

<details>

**<summary>🔹 Sintaxis general de una expresión lambda en Java </summary>**

```java
   (parametros) -> { cuerpo }
```
👉 Esto representa una **función anónima**:

- **Parámetros** → los valores de entrada.
- **Operador** `->` → separa los parámetros de la lógica.
- **Cuerpo** → el bloque de código que define qué hace la función.

#### 🔹 Ejemplo básico
```java
   (int a, int b) -> { return a + b; }
```

Descomponiendo:
1. `(int a, int b)` → los parámetros de la función (a y b).
2. `->` → indica que lo siguiente es la lógica.
3. `{ return a + b; }` → el cuerpo de la función, devuelve la suma.

👉 Esto implementa la **interface funcional**:

```java
@FunctionalInterface
interface Operacion {
    int ejecutar(int a, int b);
}
```

Y la podemos usar así:

```java
Operacion suma = (a, b) -> a + b;
System.out.println(suma.ejecutar(5, 3)); // 8
```

#### 🔹 Variantes de sintaxis
Dependiendo del caso, Java permite simplificaciones:

1. **Sin tipos en parámetros** (Java los infiere):
```java
(a, b) -> a + b
```

2. **Un solo parámetro → paréntesis opcionales**:
```java
nombre -> nombre.toUpperCase()
```

3. **Un solo statement → llaves y `return` opcionales**:
```java
(a, b) -> a + b
```
equivale a
```java
(a, b) -> { return a + b; }
```

4. **Method reference** (cuando solo llamamos a un método):
```java
nombres.forEach(System.out::println);
```
equivale a
```java
nombres.forEach(n -> System.out.println(n));
```

#### 🔹 Conexión con interfaces funcionales
Las lambdas en Java **siempre implementan una interfaz funcional**.
Ejemplos incluidos en `java.util.function`:
- `Predicate<T>` → `(T t) -> boolean`
- `Function<T,R>` → `(T t) -> R`
- `Consumer<T>` → `(T t) -> void`
- `Supplier<T>` → `() -> T`

Ejemplo:
```java
Predicate<String> empiezaConL = s -> s.startsWith("L");
System.out.println(empiezaConL.test("Lucía")); // true
```

#### 📌 Resumiendo:
- Una **lambda** en Java es azúcar sintáctica para implementar interfaces funcionales.
- `(parametros) -> { cuerpo }` es su forma general.
- Se pueden simplificar quitando paréntesis, llaves o `return` cuando el contexto es claro.
- Son la base de **Streams** y facilitan el **código declarativo** en Spring y Java.

</details>

### 🔹 ¿Por qué nacen?
Antes de Java 8, trabajar con **colecciones, concurrencia o callbacks** implicaba mucho **boilerplate** (clases anónimas largas).
El mundo ya se estaba moviendo hacia el **paradigma funcional** (Scala, Kotlin, JavaScript, C# LINQ) y Java necesitaba adaptarse para:
- Reducir código repetitivo.
- Permitir **programación declarativa** (qué quiero hacer, no cómo).
- Integrarse con **Streams API** para trabajar con datos de forma más natural.

### 🔹 Ventajas principales
1. **Menos código repetitivo** → menos verbosidad.
2. **Más expresividad** → se entiende el “qué” sin tanto “cómo”.
3. **Paralelismo más simple** → gracias a `parallelStream()`.
4. **Integración con Streams** → colecciones y datos se procesan más limpio.
5. **Facilitan programación reactiva** → útil en frameworks como Spring WebFlux.

> [!IMPORTANT]
> Ejemplos Imperativo vs Programacion Funcinal y Lambdas pueden ser encotrados en el folder `src` 
