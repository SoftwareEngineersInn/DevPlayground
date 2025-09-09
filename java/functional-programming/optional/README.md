## 🔹 ¿Qué es `Optional`?
`Optional<T>` es una clase introducida en **Java 8** que representa un **contenedor** que puede o no tener un valor.

Su **objetivo es evitar el uso abusivo de** `null` y, por tanto, reducir los riesgos de `NullPointerException` `(NPE)`.

### 🔹 ¿Por qué nace?
Antes de Java 8, el patrón más común para indicar ausencia de un valor era devolver `null`.

Esto traía problemas:
- Los desarrolladores olvidaban comprobar `null`.
- Generaba código defensivo lleno de `if (obj != null)`.
- Los `NPE` se volvieron uno de los errores más comunes en Java.
`Optional` nace como una forma más expresiva y segura de **representar ausencia de valor**.

### 🔹 Ventajas
1. **Expresividad semántica** → Indica claramente que un método puede no devolver un valor.

   Ej: `Optional<User> findById(Long id)` es más claro que `User findById(Long id)`.

2. **Evita null checks repetitivos** → Se usan operaciones como `ifPresent`, `orElse`, `map`, etc.
3. **Promueve código declarativo** → Se combina con Streams y Lambdas para mayor legibilidad.
4. **Mejor manejo en repositorios y servicios** → En Spring Boot, muchos repositorios (`JpaRepository`, `CrudRepository`) ya devuelven `Optional` en métodos como `findById`.

### 🔹 Ejemplo clásico sin `Optional` (imperativo)
```java
public User getUser(Long id) {
    User user = userRepository.findById(id);
    if (user != null) {
        return user;
    } else {
        throw new UserNotFoundException("User not found");
    }
}
```
Problemas:
- Hay que verificar `null` explícitamente.
- Es fácil olvidar validarlo.

### 🔹 Ejemplo mejorado con `Optional`
```java
public User getUser(Long id) {
   return userRepository.findById(id)  // devuelve Optional<User>
           .orElseThrow(() -> new UserNotFoundException("User not found"));
}
```
Ventajas:
- Eliminamos chequeo `null`.
- Código más limpio y seguro.
- El contrato del método indica claramente que puede no haber resultado.

### 🔹 Otros usos comunes de `Optional`
1. Evitar `if (obj != null)` innecesarios

```java
Optional<String> maybeName = Optional.ofNullable(request.getName());

String name = maybeName.orElse("Default Name");
```

2. Operar solo si existe el valor

```java
userRepository.findById(1L)
    .ifPresent(user -> sendEmail(user));
```

3. Transformaciones con map

```java
String email = userRepository.findById(1L)
    .map(User::getEmail)        // solo si existe el usuario
    .orElse("no-email@domain.com");
```
