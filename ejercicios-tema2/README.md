# 📘 Ejercicios Prácticos - Spring Boot (Tema 2)

Este repositorio contiene una colección de ejercicios prácticos desarrollados con **Spring Boot** y **Mustache**, destinados a reforzar los conceptos fundamentales del desarrollo de aplicaciones web distribuidas.

Cada carpeta representa un proyecto independiente, generado con **Spring Initializr**, que puede ser ejecutado por separado desde su propia clase `Application.java`.

---

## 📁 Estructura del repositorio

```
ejercicios-tema2/
├── guestbook/           # Libro de visitas básico
└── README.md
```

---

## 📚 Ejercicios disponibles

| Proyecto           | Descripción                                                                 |
|--------------------|-----------------------------------------------------------------------------|
| `guestbook`        | Permite a los usuarios dejar su nombre y un mensaje visible públicamente.  |

Cada uno de estos ejercicios cuenta con:
- Su propio `pom.xml`
- Controladores, modelos y vistas separados
- Plantillas Mustache (`.html`) para la interfaz
- `application.properties` individual

---

## 🚀 Cómo ejecutar un ejercicio

1. Abre la carpeta correspondiente en tu IDE (IntelliJ / VS Code).
2. Ejecuta la clase `Application.java` dentro del paquete principal.
3. Accede a `http://localhost:8080/` en tu navegador para probar la app.

> 💡 Solo puedes ejecutar un ejercicio a la vez, ya que cada uno usa el puerto 8080 por defecto.

---

## 📌 Requisitos

- Java 17 o superior
- Maven 3.6+
- Navegador moderno

---

## ✅ Buenas prácticas seguidas

- Separación clara entre lógica y vistas
- Rutas RESTful bien definidas
- Uso de listas en memoria antes de persistencia
- Estilo limpio y modular

---

## ✍️ Autor y propósito

Este proyecto forma parte de una práctica guiada para el aprendizaje de Spring MVC, formularios web, controladores, vistas dinámicas y arquitectura básica de aplicaciones distribuidas en Java.


¡Continúa explorando y practicando! 😄