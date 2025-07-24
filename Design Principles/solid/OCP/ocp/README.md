## O - Open/Closed Principle (OCP)

### Las clases deben estar abiertas para extensión pero cerradas para modificación.

#### Ejemplo:
Tienes una clase `ShapeAreaCalculator` que calcula el área de figuras geométricas con un `if` gigante:

```
if (shape instanceof Circle) { ... }
else if (shape instanceof Square) { ... }
```

#### 🔴 Malo: Cada vez que agregas una figura nueva, tienes que modificar la clase.
#### 🟢 Bueno: Usa polimorfismo

```
interface Shape {
    double area();
}

class Circle implements Shape {
    double area() { return Math.PI * radius * radius; }
}
```

#### 📌 Aplicación importante: Permite escalar funcionalidad sin alterar código probado.

#### ✔️ Polimorfismo es la forma más clásica de aplicar OCP en POO.
#### 🧰 Pero OCP también se puede lograr con:
- Composición e inyección de comportamientos
- Fábricas y configuración
- Plugins
- Arquitectura basada en eventos

### ❓ ¿No es contradictorio decir que algo se puede "extender" pero no "modificar"?

#### 🔧 Modificar código = Cambiar el código fuente existente
Estás abriendo un archivo `.java`, tocando métodos, cambiando lógica, corriendo el riesgo de romper lo que ya funcionaba.

#### 🔴 Ejemplo (violación de OCP):
```
public double calculateDiscount(Customer customer) {
    if (customer.getType().equals("PREMIUM")) {
        return 0.20;
    } else if (customer.getType().equals("GOLD")) {
        return 0.15;
    } else {
        return 0.05;
    }
}
```
- Si agregas un nuevo tipo de cliente, tienes que modificar esta función.

#### 🧩 Extender código = Agregar nuevo comportamiento sin tocar el código existente
Usas mecanismos como herencia, interfaces, composición, delegación, configuración externa, etc.

```
public interface DiscountPolicy {
    double getDiscount(Customer customer);
}

public class PremiumDiscount implements DiscountPolicy {
    public double getDiscount(Customer c) { return 0.20; }
}

```
- Luego puedes registrar múltiples políticas de descuento y seleccionarlas dinámicamente.
  No tocas el código original. Lo "extiendes" agregando nuevas clases.

#### 🔁 ¿Por qué esto es útil?
- Evita errores en código ya probado.
- Mejora la mantenibilidad: puedes agregar nuevas funcionalidades sin miedo.
- Facilita las pruebas: cada extensión puede probarse en aislamiento.
- Escala mejor: otros desarrolladores pueden crear nuevas extensiones sin tocar el núcleo
