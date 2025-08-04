## LSP (The Least Surprise Principle)

### ¿Qué nos dice?
El **Principio de Menor Sorpresa** (Principle of Least Surprise), también conocido como *Principio de Menor Asombro*, 
es un principio de diseño que establece que **el comportamiento de un sistema, librería o componente debe ser predecible
y coherente con las expectativas del usuario o desarrollador**. Es decir, **nada debe sorprender innecesariamente.**

### 🌟 ¿Por qué es importante?
- **Reduce la curva de aprendizaje.**
- **Minimiza errores de uso.**
- **Hace que el código sea más intuitivo y mantenible.**
- **Facilita la colaboración en equipos de desarrollo.**

### 🧠 ¿Qué significa "sorpresa"?
Una sorpresa ocurre cuando un componente no se comporta como uno espera naturalmente. Esto puede ser por nombres 
confusos, métodos que hacen más de lo que aparentan, efectos colaterales inesperados, entre otros.

### ✅ Ejemplo: nombres intuitivos
```java
List<String> users = new ArrayList<>();
users.add("Alice");
users.clear(); // Este método elimina todos los elementos
```
`clear()` es un buen nombre: **es exactamente lo que se espera que haga**

### ❌ Mal nombre (sorpresa):
```java
users.reset(); // Supón que esto también elimina todos los elementos, pero el nombre no es claro
```
El nombre `reset()` puede dar a entender que se reinicia algo, pero **no necesariamente 
se espera que borre todos los datos.**

### 🧩 Buenas prácticas para aplicar el principio
- Usa nombres de métodos, clases y variables **autoexplicativos.**
- **Evita efectos colaterales ocultos.**
- **Sigue las convenciones del lenguaje y del equipo.**
- Documenta claramente cualquier comportamiento **no evidente.**
- Usa patrones de diseño conocidos (como el patrón Builder, DAO, etc.) para que otros desarrolladores sepan qué esperar.

### 🏁 Conclusión
El **principio de menor sorpresa** no se trata de escribir código más corto o más rápido, sino de escribir **código más 
claro y coherente**. En Java, eso se traduce en usar nombres descriptivos, mantener responsabilidades claras y evitar 
comportamientos ocultos.