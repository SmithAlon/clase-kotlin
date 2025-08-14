En este repositorio serán almacenadas las prácticas del desarrollo móvil.

Lenguaje usado : Kotlin
IDE: IntelliJ IDEA 2022.3.2 (Community Edition)


# Guía de Kotlin para Desarrolladores con Experiencia en JS/TS, Python y Java

## 1. ¿Qué es Kotlin?
Kotlin es un lenguaje moderno, estáticamente tipado, creado por JetBrains. Corre en la JVM, se transpila a JavaScript y se usa mucho para Android.

## 2. Sintaxis Básica

### Variables
- `val` para inmutables (como `const` en JS)
- `var` para mutables (como `let` en JS)

```kotlin
val nombre = "Alon"    // inmutable
var edad = 30          // mutable
```

### Tipado
- Inferencia de tipos, pero puedes declarar el tipo explícitamente.
- Similar a TypeScript.

```kotlin
val saludo: String = "Hola"
var contador: Int = 0
```

### Funciones
- Sintaxis similar a Python/TS, pero con tipos.
- Return implícito para funciones de una línea.

```kotlin
fun suma(a: Int, b: Int): Int {
    return a + b
}

// Versión corta
fun sumaCorta(a: Int, b: Int) = a + b
```

### Null Safety
- Por defecto, las variables no pueden ser null.
- Usa `?` para permitir nulos.

```kotlin
var puedeSerNulo: String? = null
puedeSerNulo = "Ahora NO es null"
```

## 3. Estructuras de Control

- If/else, when (switch mejorado), for, while.

```kotlin
val resultado = if (edad > 18) "Adulto" else "Menor"

when (edad) {
    18 -> println("Tienes 18")
    in 19..30 -> println("Eres joven")
    else -> println("Edad desconocida")
}
```

## 4. Clases y Objetos

- Similar a Java, pero más conciso y con propiedades por defecto.

```kotlin
class Persona(val nombre: String, var edad: Int)

val p = Persona("Ana", 25)
println(p.nombre)
```

### Data Classes (como DTOs o POJOs pero automáticos)

```kotlin
data class Usuario(val id: Int, val email: String)
```

## 5. Funciones Lambda y Colecciones

- Muy similar a JS/TS/Python.

```kotlin
val lista = listOf(1, 2, 3, 4)
val pares = lista.filter { it % 2 == 0 }
val cuadrados = lista.map { it * it }
```

## 6. Extensiones

- Puedes agregar funciones a clases existentes (como los prototypes de JS).

```kotlin
fun String.saludar() = "Hola $this"

println("Alon".saludar()) // "Hola Alon"
```

## 7. Interoperabilidad con Java

- Puedes usar cualquier librería Java.
- Puedes llamar código Java desde Kotlin y viceversa.

## 8. Herramientas y Entorno

- Usa IntelliJ IDEA o Android Studio (ambos de JetBrains).
- Compila a JVM, JS o Native.

## 9. Recursos Útiles

- [Kotlin Playground](https://play.kotlinlang.org/)
- [Documentación oficial](https://kotlinlang.org/docs/home.html)
- [Comparación oficial: Kotlin vs Java](https://kotlinlang.org/docs/comparison-to-java.html)

## 10. Ejemplo Completo

```kotlin
fun main() {
    val usuarios = listOf("Ana", "Luis", "Pedro")
    usuarios.forEach { println("Hola, $it!") }
}
```

---

**Resumen de diferencias clave respecto a JS/TS/Python/Java:**
- Sintaxis más concisa que Java, similar a Python/TS.
- Tipado estricto y seguro por defecto (null safety).
- Lambdas y manejo de colecciones muy ergonómico.
- Permite programación orientada a objetos y funcional.
- Interoperable con Java (puedes mezclar ambos sin problemas).

¿Quieres ejemplos avanzados, ver cómo se haría X en Kotlin, o tienes un caso de uso concreto?
