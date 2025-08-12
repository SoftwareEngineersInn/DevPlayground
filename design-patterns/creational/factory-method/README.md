## Factory Method Pattern

Es un **patrón de diseño creacional** cuyo objetivo es **definir un método para crear objetos sin especificar su clase concreta**.
En vez de usar `new` directamente en el código cliente, delegas la creación del objeto a un **método fábrica** que decide qué instancia devolver.

### ¿Por qué nace este patrón?
Surge para resolver estos problemas comunes:
1. **Acoplamiento alto al usar `new` directamente**

   Si tu clase cliente instancia objetos concretos, está fuertemente acoplada a esas implementaciones. Esto rompe el principio **OCP** (Open/Closed) de SOLID.

2. **Dificultad para cambiar el tipo de objeto creado**

   Si en muchos lugares del código creas un objeto con `new`, cambiar a otra clase requiere modificar varias partes del sistema.

3. **Necesidad de delegar la decisión de qué objeto crear**

   A veces, la elección de qué clase instanciar depende de datos dinámicos (configuración, parámetros, contexto)

### ✅ Ventajas
- **Bajo acoplamiento** → El cliente no conoce las clases concretas.
- **Cumple OCP** → Puedes agregar nuevas implementaciones sin tocar el código cliente.
- **Código más limpio y mantenible** → Centralizas la lógica de creación.
- **Facilita pruebas unitarias** → Puedes inyectar fácilmente mocks o instancias personalizadas.

> Ejemplos **ok/wrong** pueden ser encontrados dentro de la carpeta `src`

💡 **Nota:** En Spring Boot muchas veces este patrón se combina con **inyección de dependencias** + 
`@Qualifier` o con un **Map de beans** para evitar `if-else` en la fábrica.

### Diagrama de depenencias (comparativa)

#### 🔴 Antes del Factory Method (acoplamiento alto)
```ngix
NotificationService
   ├──> EmailNotification
   └──> SmsNotification
```
- `NotificationService` **depende directamente** de las clases concretas.
- Si **agregas** `PushNotification`, tienes que **modificar** `NotificationService`.
- Rompe **OCP** y aumenta el costo de mantenimiento.

#### 🟢  Después del Factory Method (acoplamiento bajo)
```scss
NotificationService
   └──> Notification (interfaz)
           ▲
           │  (decide la fábrica)
  NotificationFactory
      ├──> EmailNotification
      ├──> SmsNotification
      └──> PushNotification
```
- `NotificationService` **solo depende** de la interfaz `Notification`.
- **La fábrica** es la que conoce las implementaciones concretas.
- Para agregar `PushNotification`:
  - No tocas `NotificationService`.
  - Solo modificas la fábrica (o mejor, en un diseño aún más limpio, ni siquiera la modificas si usas un registro automático con Spring).
- Cumple **DIP** (principio de inversión de dependencias) y **OCP**.

>💡 En otras palabras, el **acoplamiento** (las flechas directas hacia clases concretas) se mueve **fuera** del código de negocio y se concentra en un único lugar (la fábrica).
Eso simplifica cambios, reduce errores y facilita pruebas.