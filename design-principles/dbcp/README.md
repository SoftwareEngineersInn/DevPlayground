## Design by Contract (DbC)

El principio **Design by Contract (DbC)**, o **Diseño por Contrato**, es una metodología propuesta por **Bertrand Meyer** 
(creador del lenguaje Eiffel) que se basa en definir claramente los **"contratos"** entre los componentes de un software 
(por ejemplo, entre una clase y sus métodos).

### 🧠 ¿Qué es Design by Contract?
Especifica que cada método o función tiene:
1. **Precondiciones**: Qué debe cumplirse *antes* de ejecutar el método (qué espera recibir).
2. **Postcondiciones**: Qué debe cumplirse *después* de ejecutar el método (qué garantiza).
3. **Invariantes**: Condiciones que deben mantenerse siempre verdaderas durante la vida del objeto 
(por ejemplo, que un atributo no sea nulo).

Esto ayuda a que el software sea:
- Más robusto.
- Más mantenible.
- Menos propenso a errores ocultos.

### 📌 Ejemplo básico en Java (sin librerías externas)
Aunque Java no implementa DbC de forma nativa como Eiffel, puedes simularlo con validaciones y excepciones:

````java
public class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance must be >= 0"); // Precondición
        }
        this.balance = initialBalance;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be > 0"); // Precondición
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds"); // Precondición
        }

        double oldBalance = balance;
        balance -= amount;

        // Postcondición
        if (balance != oldBalance - amount) {
            throw new AssertionError("Postcondition failed: incorrect balance after withdrawal");
        }
    }

    public double getBalance() {
        return balance;
    }
}
````
#### ✅ ¿Dónde se ve el "contrato"?
- **Cliente del método** (`withdraw`): **debe respetar las precondiciones**: no pasar montos negativos y no pedir más de lo disponible.
- **Método** `withdraw`: garantiza la postcondición: el saldo se reduce correctamente.
- **La clase** `BankAccount`: podría tener **invariantes**, como que `balance >= 0`.

***SIN EMBARGO, El código anterior viola SRP (Single Responsibility Principle)***
> 🎯 Aplicar un principio de diseño no debe significar violar otro.

### 💡 ¿Cómo se puede respetar SRP y aplicar Design by Contract?
Podrías separar las validaciones del modelo de dominio. Aquí van algunas ideas para lograrlo:

#### ✅ Opción 1: Delegar contratos a una clase externa (Contract Validator)
````java
public class BankAccountContract {

    public static void checkWithdraw(BankAccount account, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be > 0");
        }
        if (amount > account.getBalance()) {
            throw new IllegalStateException("Insufficient funds");
        }
    }
}
````

````java
public class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) {
        BankAccountContract.checkWithdraw(this, amount); // delegamos validación

        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
````
Ventajas:
- La lógica de dominio y los contratos están **claramente separados**.
- Puedes **reutilizar los contratos** para testing, validaciones cruzadas o front-end.
- Cumples **SRP** y aplicas **DbC**.

#### ✅ Opción 2: Usar anotaciones + validadores externos (Java moderno)
Con JSR 380 o Spring Boot:
````java
public class BankAccount {

    @PositiveOrZero
    private double balance;

    public void withdraw(@Positive double amount) {
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
    }
}
````
Luego usas un **validador externo** para evaluar las anotaciones (por ejemplo, con Hibernate Validator o Spring `@Validated`).

### 🧠 Recuerda
> Aplicar un principio de diseño no debe significar violar otro.

Cuando diseñes con **DbC en Java**, lo ideal es:
- Separar la lógica de **contrato (verificación)** del objeto de **dominio (modelo)**.
- Usar librerías o anotaciones si es posible.
- Mantener las clases con **una única razón para cambiar (SRP)**.

### 🎯 Ventajas de usar Design by Contract
- Detectas errores **antes** de que se propaguen.
- Facilita el **debugging**.
- Mejora la **documentación implícita**: cada método deja claro qué espera y qué ofrece.
- Es útil para **TDD y pruebas automáticas**.