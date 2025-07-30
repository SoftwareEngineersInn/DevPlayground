## DRY ("Don't Repeat Yourself")

### Es uno de los principios fundamentales del desarrollo de software limpio y mantenible.

### 🔍 ¿Qué dice el principio DRY?
>**"Cada fragmento de conocimiento debe tener una única representación inequívoca en el sistema."**

En otras palabras, **si tienes lógica repetida**, considera **extraerla** en un solo lugar. Repetir código puede llevar 
a errores, dificultades para mantener el sistema y aumentar el esfuerzo para hacer cambios.

### Ventajas de DRY
Una de las **principales ventajas** del principio DRY es que **facilita el mantenimiento del código**, pero hay otras muy 
importantes.

**1. Reducción de errores**
- Si tienes una lógica duplicada en varios lugares y necesitas cambiarla, corres el riesgo de **olvidar actualizar uno de 
ellos**. DRY reduce ese riesgo, porque **solo hay un lugar que modificar**.
> 📌 ***Ejemplo***: Si cambias una fórmula de negocio o una validación, lo haces en un solo método.

**2. Mayor reutilización de código**
- Aplicar DRY te obliga a escribir métodos reutilizables, lo que **fomenta una arquitectura más modular**. Esto te ayuda 
a **no reinventar la rueda** en cada clase o módulo.
> 📌 ***Ejemplo***: Puedes reutilizar utilidades de validación, formateo, conversiones, etc., en múltiples servicios.

**3. Mejor comprensión del sistema**
- Un código sin repeticiones **suele ser más corto y más claro**. Otros desarrolladores (o tú mismo en unos meses) 
pueden entender más fácil qué hace cada parte.
> 📌 ***Ejemplo***: Un único método `validarUsuario()` es más legible que tener los mismos `if` 
repetidos por todo el código.

**4. Facilita las pruebas unitarias**
- Cuando encapsulas la lógica repetida en un solo lugar, puedes **probar esa lógica una vez con pruebas unitarias**. 
No necesitas escribir las mismas pruebas para cada uso.
> 📌 ***Ejemplo***: Si tienes `calcularIVA(precio)`, puedes probar solo esa función, sin repetir pruebas para cada clase 
que la use.

**5. Promueve principios SOLID**
- Aplicar DRY te lleva naturalmente a aplicar otros principios como:
    - **SRP (Responsabilidad Única)**: cada método hace solo una cosa.
    - **OCP (Abierto/Cerrado)**: puedes extender el comportamiento sin modificarlo directamente.
    - **DIP (Inversión de dependencias)** reduces acoplamientos innecesarios al reutilizar interfaces

### 📌 Cuándo NO aplicar DRY
A veces, intentar aplicar DRY prematuramente puede **complejizar innecesariamente** tu diseño. 
Por ejemplo, si dos métodos se parecen pero todavía tienen comportamientos diferentes, 
**no los unifiques demasiado pronto**. DRY aplica mejor cuando la duplicación es **evidente y estable**.