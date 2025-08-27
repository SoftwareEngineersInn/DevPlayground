## 📌 ¿Qué es la Programación Funcional?

**La programación funcional** es un paradigma de programación donde el foco está **en qué se quiere hacer en lugar de cómo hacerlo**, utilizando funciones como unidades fundamentales de composición.
En lugar de manipular estados y estructuras mutables (como en la programación imperativa), se centra en el uso de **funciones puras, inmutabilidad y expresiones**.

Ejemplo Conceptual:
```java
// Imperativo
List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> doubled = new ArrayList<>();
for (Integer n : nums) {
    doubled.add(n * 2);
}

// Funcional
List<Integer> doubled = nums.stream()
                            .map(n -> n * 2)
                            .toList();
```