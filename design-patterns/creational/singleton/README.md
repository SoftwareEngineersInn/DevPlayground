## Singleton

### 🧠 ¿Por qué nace el patrón Singleton?

El **patrón Singleton** nace para **asegurar que una clase tenga una única instancia y proporcionar un punto de acceso global a ella.** Es útil cuando:

- Solo se necesita **una instancia compartida** a lo largo del ciclo de vida de una aplicación.
- Esa instancia debe ser **globalmente accesible**, pero **controlada**.

Ejemplos típicos de uso:
- Pool de conexiones.
- Registro de logs.
- Configuración de la aplicación.
- Cache global

### ✅ Ventajas del patrón Singleton
- **Control del ciclo de vida:** se asegura que solo exista una instancia.
- **Menor consumo de recursos:** evita instanciaciones repetidas de objetos costosos.
- **Acceso global y centralizado:** cualquier parte del sistema puede usar la misma instancia.
- **Facilita compartir estado** entre componentes.

### ⚠️ Desventajas
- Introduce **estado global mutable**, lo que puede llevar a problemas en pruebas y concurrencia.
- **Acopla** firmemente a una implementación específica.
- **Difícil de testear** (aunque Spring lo resuelve).
- Rompe el principio de responsabilidad única si se abusa del patrón.

### 🌱 Singleton en Spring Boot
En Spring Boot **las clases anotadas** con `@Component`, `@Service`, `@Repository` o `@Controller` **son singletons por defecto.** 
Spring gestiona el ciclo de vida de los beans y garantiza que solo exista una instancia 
(a menos que se configure otro scope como `prototype`).

> Ejemplos **ok/wrong** pueden ser encontrados dentro de la carpeta `src`

### 🧪 ¿Dónde es útil realmente aplicar esta corrección?
Situaciones típicas:
- Servicios que manejan conexiones, como `DatabaseService`, `EmailService`, `CacheService`, `PaymentGatewayService`.
- Clases de utilidades con estado (aunque en general es mejor que las utilidades sean `static` y sin estado).

### ¿Y si no uso Spring?
Tendrías que implementar el patrón Singleton a mano:

```java
public class EmailService {
    private static final EmailService instance = new EmailService();

    private EmailService() {} // constructor privado

    public static EmailService getInstance() {
        return instance;
    }

    public void send(String to, String message) {
        System.out.println("Sending email to " + to);
    }
}
```
> Pero en aplicaciones modernas, especialmente con Spring, **no se recomienda implementar singletons a mano**. Spring te da eso de forma limpia, desacoplada y testable mediante inyección de dependencias.

## ¿Por que no se usa `@Autowired` en este caso?
No se usa porque Spring Boot **lo hace automáticamente a partir de Spring 4.3**, siempre y cuando:
- La clase tiene **solo un constructor.**
- Ese constructor **recibe beans que Spring puede inyectar.**

Entonces este código: 
```java
@RestController
public class UserController {
    private final EmailService emailService;

    public UserController(EmailService emailService) {
        this.emailService = emailService;
    }
}
```
Es equivalente a: 
```java
@RestController
public class UserController {
    private final EmailService emailService;

    @Autowired
    public UserController(EmailService emailService) {
        this.emailService = emailService;
    }
}
```
> Ambos funcionan igual, pero el primero es más **limpio y moderno**. De hecho, en la comunidad Spring, se considera **una 
buena práctica preferir la inyección por constructor sin `@Autowired` explícito** cuando hay un solo constructor.

### ✅ Recomendación actual (Spring moderno)
- **Usa inyección por constructor** (mejor para pruebas unitarias y evita dependencias ocultas).
- **Omite `@Autowired` en el constructor si hay solo uno.**
- Evita inyección por campo (`@Autowired` directamente sobre atributos) porque dificulta pruebas y viola el principio de inmutabilidad.

### 💡 Resumen
| **Forma** | **¿Recomendada?** | **Comentario** |
| :--- | --- | --- |
| Inyección por constructor con `@Autowired` | ✅ | Bien, pero algo más verbosa |
| Inyección por constructor sin `@Autowired` | ✅✅ | ✅ Mejor práctica si solo hay un constructor |
| Inyección por campo (`@Autowired` en atributos) | ⚠️ | No recomendado para clases complejas o testeo |
| Inyección por setter | ⛔ | Poco usada; útil solo en casos opcionales |
