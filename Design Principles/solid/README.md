## Que se entiende por S.O.L.I.D.

**SRP (Single Responsibility Principle)** nos invita a desarrollar pensando en que cada clase, método o módulo debe tener una única responsabilidad clara. Eso significa que debe existir por una sola razón para cambiar. Esta claridad promueve alta cohesión (todo lo que hace la clase está directamente relacionado con su propósito) y, al evitar mezclar responsabilidades, también contribuye al bajo acoplamiento.

**OCP (Open/Closed Principle)** nos dice que el código debe estar abierto a extensión pero cerrado a modificación. Cuando anticipamos cambios futuros, estructuramos nuestro diseño para extender funcionalidades (añadiendo nuevas clases o comportamientos) sin necesidad de modificar el código existente, reduciendo así el riesgo de errores en funcionalidades ya probadas.

**LSP (Liskov Substitution Principle)** establece que las subclases deben poder usarse en lugar de sus superclases sin alterar el comportamiento esperado. Esto implica que las subclases deben respetar el contrato de la clase base. Si se rompe este principio, usualmente estamos ante una herencia mal aplicada. Seguir LSP garantiza que nuestras jerarquías de clases sean predecibles y cohesivas.

**ISP (Interface Segregation Principle)** nos enseña a crear interfaces específicas y pequeñas, en lugar de interfaces grandes que fuerzan a las clases que las implementan a usar métodos que no necesitan. Esto permite que cada clase implemente solo el comportamiento que le corresponde, ayudando a mantener la cohesión y evitando acoplamientos innecesarios.

**DIP (Dependency Inversion Principle)** nos dice que las clases de alto nivel (como servicios o controladores) no deben depender de clases concretas (implementaciones), sino de abstracciones (interfaces). La lógica de bajo nivel (por ejemplo, cómo se envía un email) también debería depender de interfaces. Así logramos un acoplamiento débil, ya que las clases se conectan a través de contratos comunes (interfaces), y además, el sistema se vuelve fácilmente extensible a nuevas implementaciones sin tocar la lógica principal.

### 🧠 Bonus mental model
Piensa en los principios SOLID como un equipo de fútbol:

- SRP es como decir: "Cada jugador tiene su posición clara" → cohesión.
- OCP es el sistema táctico que permite cambiar de estrategia sin cambiar a los jugadores.
- LSP asegura que cualquier suplente puede sustituir al titular sin afectar el rendimiento.
- ISP da a cada jugador solo las instrucciones necesarias para su rol, sin sobrecargarlos.
- DIP es el entrenador (alto nivel) que diseña jugadas sin saber qué jugador exacto va a ejecutarlas, solo necesita que cumplan cierto perfil.