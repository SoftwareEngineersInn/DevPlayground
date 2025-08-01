## Principio YAGNI (You Aren’t Gonna Need It)

>El principio **YAGNI** ("You Aren’t Gonna Need It", o "No lo vas a necesitar") es una de las prácticas fundamentales del 
desarrollo ágil y de XP (Extreme Programming). Su objetivo es evitar escribir código que aún no es necesario, incluso 
si crees que podrías necesitarlo en el futuro. 

### 🧠 ¿Qué enseña YAGNI?
> No implementes funcionalidades hasta que realmente las necesites.

Esto ayuda a mantener el código: 
- Más limpio.
- Más fácil de mantener.
- Más fácil de probar.
- Menos propenso a errores innecesarios.

### ⚠️ ¿Por qué YAGNI es tan importante?
Porque muchas veces los desarrolladores intentan "adelantarse" a requisitos futuros con frases como:
- “Seguro después van a querer que esto sea configurable”.
- “Voy a hacer este módulo más genérico por si se reutiliza después”.
- “Mejor lo convierto desde ya en un microservicio”.

Y lo que suele pasar es que:
- **Nunca se necesita** esa funcionalidad.
- Se introduce complejidad y bugs.
- Se pierde tiempo y esfuerzo que pudo usarse en cosas que **sí eran prioritarias.**

## 🎯 Recomendaciones prácticas en Java
- No crees interfaces, servicios o clases base abstractas si solo hay una implementación y 
no hay uso real de polimorfismo aún.

#### ❌ Mal uso:
```java
public interface PaymentService {
    void pay();
}

public class CreditCardPaymentService implements PaymentService {
    public void pay() { ... }
}
```
#### ✅ Aplicando YAGNI (cuando sólo hay una forma de pago):
```java
public class PaymentService {
    public void pay() { ... }
}
```
- No parametrices clases con genéricos innecesarios si no hay múltiples tipos usándolos.
- No apliques patrones de diseño si no solucionan un problema concreto actual.

### 🧩 Relación con otros principios
YAGNI se complementa con:
- **KISS:** Keep It Simple, Stupid.
- **DRY:** Don’t Repeat Yourself (aunque con cuidado de no abstraer prematuramente).
- **Lean:** Elimina el desperdicio (waste) en el desarrollo.