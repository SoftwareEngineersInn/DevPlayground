# ¿Qué son?

Los **principios de diseño en desarrollo** de software son guías fundamentales que ayudan a los desarrolladores a escribir código **más limpio, mantenible, reutilizable y escalable.** No son reglas estrictas, pero sí buenas prácticas ampliamente aceptadas que permiten construir software de calidad y facilitar su evolución con el tiempo.

# 

### ¿Por qué nacen los principios de diseño?

Nacen como **respuesta a problemas reales** que aparecieron durante la evolución del software:

1. Código difícil de mantener: sistemas que al mínimo cambio se rompían o requerían modificar muchas partes del código.

2. Alta dependencia entre módulos: cuando todo está acoplado, es casi imposible cambiar una parte sin afectar otra.

3. Falta de reutilización: mucho código duplicado y difícil de generalizar.

4. Escalabilidad limitada: sistemas que no soportaban el crecimiento en funcionalidades o usuarios.

5. Efecto cascada en cambios: modificar una funcionalidad generaba errores en otras que parecían no tener relación.

6. Dificultad en las pruebas: sistemas sin modularidad dificultaban el uso de pruebas automatizadas (unitarias o de integración).

#

### ¿Qué buscan lograr estos principios?

- Bajo acoplamiento y alta cohesión.
- Separación de responsabilidades.
- Facilidad de mantenimiento y evolución.
- Fomentar la reutilización de componentes.
- Facilitar el trabajo en equipo (código más entendible por otros).
- Reducción de errores en tiempo de desarrollo y producción.

# 

### Ejemplos de principios conocidos

- **SOLID** (cinco principios orientados a objetos):
  - Single Responsibility
  - Open/Closed
  - Liskov Substitution
  - Interface Segregation
  - Dependency Inversion

- **DRY** (Don't Repeat Yourself)
- **KISS** (Keep It Simple, Stupid)
- **YAGNI** (You Aren’t Gonna Need It)
- **Principio de menor sorpresa** (el sistema debe comportarse como el usuario espera)
- **Principio de diseño por contrato** (Design by Contract)

### 🧠 ¿Por qué aplicar principios o patrones "por si acaso" puede ser un problema?

Porque:
- Todo patrón introduce complejidad.
- Si el problema que intenta resolver no existe todavía, lo que se introduce es complejidad innecesaria, no valor.
- Los principios como DRY, YAGNI, KISS, SOLID, etc., deben aplicarse con criterio, no de forma dogmática.

### ⚠️ Ejemplo de principio mal aplicado: DRY + patrones innecesarios
Supongamos que tenés dos clases en una app con métodos parecidos:

```java
public class UserService {
    public void sendWelcomeEmail(User user) { ... }
}

public class AdminService {
    public void sendWelcomeEmail(Admin admin) { ... }
}
```

Aplicar **DRY de forma automática** te podría llevar a crear una jerarquía como esta:

```java
public abstract class AbstractService<T> {
    public void sendWelcomeEmail(T user) { ... }
}
```

Y luego:

```java
public class UserService extends AbstractService<User> { }
public class AdminService extends AbstractService<Admin> { }
```

Esto **parece DRY y "elegante"**, pero:
- Es más difícil de leer.
- No hay ganancia real (el código duplicado era mínimo).
- Se introdujo abstracción prematura (y tal vez nunca tengas más de esos dos casos).
- Se perdió claridad a cambio de muy poco.

>Conclusión: A veces duplicar una línea es más simple y mantenible que una jerarquía que sólo sirve para aplicar un principio.

#

💬 Un buen enfoque: principios como ***guías***, no ***mandamientos***
- ✅ Usa principios cuando hay evidencia de que los necesitas.
- ✅ Refactorizá cuando tengas datos concretos: código duplicado repetido, cambio frecuente en una parte, acoplamiento alto, etc.
- ❌ No uses patrones “porque suenan bien” o “porque todos usan ese en GitHub”.
- ❌ No apliques principios de forma automática sin analizar el contexto y la complejidad.

#

🧠 Una frase que resume bien esta mentalidad:
>**"Hazlo funcionar, hazlo simple, luego hazlo elegante si lo necesitas."**

#

## En resumen

Los principios de diseño **nacen de la experiencia** acumulada en décadas de desarrollo de software para **evitar errores comunes**, y ayudan a los equipos a **construir sistemas más sólidos, adaptables y comprensibles**. Aunque no garantizan que el software será perfecto, sí ofrecen un camino claro para que sea más profesional y sostenible en el tiempo.