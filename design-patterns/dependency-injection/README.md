## Dependency Injection Pattern
El patrón de diseño **Inyección de Dependencias (Dependency Injection, DI)** es una forma de implementar el principio de 
inversión de dependencias (el “D” de SOLID). Su objetivo principal es **desacoplar** las clases de sus dependencias, 
facilitando el mantenimiento, la reutilización y las pruebas del código.

### 🧠 ¿Qué es la Inyección de Dependencias?
En lugar de que una clase **cree** sus propias dependencias (es decir, que use `new` internamente), 
se le **inyectan desde el exterior**, ya sea a través del constructor, un método setter o 
directamente en un campo (en el caso de frameworks como Spring).

### De que maneras se puede utilizar DI
- Método `constructor`
- Métodos `setter`
- `Interfaz`

### ✅ Ventajas
- Bajo acoplamiento entre clases
- Facilita la escritura de pruebas unitarias (mocking de dependencias).
- Mejora la legibilidad y mantenibilidad.
- Permite cambiar fácilmente la implementación de las dependencias.

> ejemplos ok/wrong pueden ser encontrados dentro de la carpeta `src`

### Dudas comunes

#### 💡 ¿Por qué usar una interfaz Engine?

> **No necesitas una interfaz… hasta que sí la necesitas.**

Usar una interfaz te permite **abstraer el comportamiento esperado** (`run()`) sin preocuparte de cómo se implementa. 
La clase que depende de un `Engine` (como `Car`) **no necesita saber si es diésel, eléctrico o un mock de pruebas.**

#### ✅ Ventajas clave de usar una interfaz

##### **1. Abstracción y desacoplamiento**
Tu clase `Car` depende de la **abstracción** (`Engine`), no de una implementación concreta (`DieselEngine`, `ElectricEngine`).

```java
Car car = new Car(new DieselEngine()); // o new ElectricEngine()
```
➡ Esto permite **cambiar comportamientos sin modificar la clase** `Car`.

##### **2. Sustitución sencilla de comportamiento**
Si mañana creas una clase `HybridEngine`, solo necesitas hacer:

```java
public class HybridEngine implements Engine {
    public void run() {
        System.out.println("Hybrid engine running...");
    }
}
```
Y sin tocar `Car`, ya puedes usarlo:
```java
Car car = new Car(new HybridEngine());
```

##### **3. Facilita pruebas unitarias (Mocking)**
Durante las pruebas, puedes inyectar un **mock** de `Engine`, sin lógica real:

```java
public class MockEngine implements Engine {
    public void run() {
        System.out.println("Mock engine for test");
    }
}

Car car = new Car(new MockEngine());
```
➡ Si usas `DieselEngine` o `ElectricEngine` directamente en el código, no puedes simular ni controlar 
su comportamiento para pruebas.

##### **4. Aplica el principio SOLID - DIP (Dependency Inversion Principle)**
> Las clases de alto nivel no deben depender de clases concretas, sino de abstracciones.

`Car` es una clase de alto nivel que **debería depender de una interfaz** (`Engine`), no de una clase concreta (`DieselEngine`).

#### **🤔 ¿Y si no uso interfaz?**
Podrías hacer esto:
```java
public class Car {
    private DieselEngine engine;

    public Car(DieselEngine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.run();
    }
}
```
Pero ahora:
- Estás **casado con** `DieselEngine`.
- No puedes usar `ElectricEngine` sin modificar `Car`.
- No puedes simular `engine.run()` para pruebas.
- Tienes alto acoplamiento.

#### **⚠️ Cuando no necesitas una interfaz**
Si estás haciendo un programa **muy pequeño, sin lógica compleja, sin pruebas automatizadas y sin intención de extender**, 
podrías omitir la interfaz. Pero a medida que el sistema crece, el **costo de no haber usado interfaces** se vuelve mayor

#### **🧠 Frase útil para recordar**
> ***"Programa contra interfaces, no contra implementaciones."***
>
Esto da libertad a tu sistema para **crecer sin romper lo ya construido.**