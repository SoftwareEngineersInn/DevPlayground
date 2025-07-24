## S - Single Responsibility Principle (SRP)
### Una clase debe tener una, y solo una razón para cambiar.

#### Ejemplo:
Supón que tienes una clase `InvoiceManager` que:
- Calcula el total de una factura
- Guarda la factura en la base de datos
- Imprime la factura

#### 🔴 Malo: Todo en una sola clase: cálculo, persistencia y presentación.

#### 🟢 Bueno:
`InvoiceCalculator`
`InvoiceRepository`
`InvoicePrinter`

#### Cada clase con una única responsabilidad.

### 📌 Aplicación importante: 
Mejora el mantenimiento y testeo. Si cambia la forma de imprimir, no afectas el cálculo.

### ✅ Consideraciones Importantes
#### Usar Inyección de dependencias:
- Evita problemas de alto acoplamiento
  - Si una clase como `InvoicePrinter` cambia su constructor o depende de algo más, también tienes que cambiar aquella clase de `servicio` que haga uso de las clases que proveen las diferentes responsabilidades.

- Facilita el testing
  - Gracias a la inyección de dependencias, se puede recurrir a usar `mocks` para probar el `servicio` ya que este crea 
sus propias dependencias.
