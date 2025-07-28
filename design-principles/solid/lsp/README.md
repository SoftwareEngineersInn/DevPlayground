## L - Liskov Substitution Principle (LSP)

### Las clases derivadas deben ser sustituibles por sus clases base sin alterar el comportamiento esperado.

#### Ejemplo:
Clase base `Bird` con método `fly()`. Subclase `Ostrich` no vuela.

#### 🔴 Malo:
```
Bird ostrich = new Ostrich();
ostrich.fly(); // ¡Error lógico!
```

#### 🟢 Bueno: Replantear jerarquía:
- Crear una interfaz `FlyingBird extends Bird`
- Solo las aves que vuelan la implementan.

📌 **Aplicación importante:** Evita bugs cuando usas herencia inapropiadamente.

#### ✅ Uso de `@Override`
1. **Verificación en tiempo de compilación**
   - El compilador comprobará que realmente estás sobrescribiendo 
   un método existente. Si te equivocas en el nombre, la firma o el tipo de retorno, el compilador te dará error.
     
🔍 Ejemplo sin `@Override` (pasa desapercibido):
```
public class Duck implements Bird {
    public void eattt() { // ¡Error tipográfico!
        System.out.println("Eating");
    }
}
```
Esto compila, pero no implementa realmente el método `eat()`
de la interfaz, y no te darás cuenta hasta que el programa falle o se comporte raro.

🔐 Ejemplo con `@Override`:
```
public class Duck implements Bird {
    @Override
    public void eattt() { // Error de compilación
        System.out.println("Eating");
    }
}
```
→ El compilador lanza un error: ***“Method does not override method from its superclass”***

2. **Mejora la legibilidad** 
   - Otros desarrolladores (¡o tú mismo en 6 meses!) pueden ver rápidamente que ese método está sobrescribiendo uno de una interfaz o clase base.
3. **Buenas prácticas y consistencia**
   - Es una convención aceptada por todos los linters, IDEs y revisores de código. Usarlo mejora la calidad y mantenibilidad del código.
4. **Es obligatorio en algunas versiones de Java**
   - Desde Java 6 en adelante, puedes usar `@Override` también para métodos de interfaces (antes solo se usaba con métodos heredados de clases).

✅ **Recomendación**
Siempre que sobrescribas un método de una interfaz o una superclase, usa `@Override`.

- Es una herramienta de verificación
- Evita errores silenciosos
- Hace tu código más claro y robusto