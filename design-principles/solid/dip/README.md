## D - Dependency Inversion Principle (DIP)

### ¿Que nos dice?
- Los módulos de alto nivel **no deben depender** de módulos de bajo nivel. **Ambos deben depender de abstracciones.**
- Las abstracciones **no deben depender** de los detalles. **Los detalles deben depender de las abstracciones**.

### 🧠 ¿Qué significa esto?
En términos simples, **debemos programar contra interfaces (o abstracciones)**, no contra implementaciones concretas. 
Esto ayuda a que el código sea más desacoplado, flexible y fácil de mantener y probar.

### 🚀 Beneficios al aplicar DIP
- **Desacoplamiento:** `Notification` no depende directamente de `EmailService`.
- **Flexibilidad:** Puedes cambiar `EmailService` por otra clase (`SmsService`, `PushNotificationService`, etc.) 
- sin modificar `Notification`.
- **Facilidad para testear:** Puedes usar mocks fácilmente en pruebas unitarias.


