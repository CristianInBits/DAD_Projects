# 📘 Ejercicios Prácticos - Spring Boot (Tema 2)

Este repositorio contiene una colección de ejercicios prácticos desarrollados con **Spring Boot** y **Mustache**, destinados a reforzar los conceptos fundamentales del desarrollo de aplicaciones web distribuidas.

Cada carpeta representa un proyecto independiente, generado con **Spring Initializr**, que puede ser ejecutado por separado desde su propia clase `Application.java`.

---

## 📁 Estructura del repositorio

```
ejercicios-tema2/
├── book-library/       # Mini libreria con inyecciones
├── forum-service/      # Mini foro con inyecciones
├── forum/              # Mini foro de discusión
├── guestbook/          # Libro de visitas básico
├── product-catalog/    # Catálogo de productos
├── session-demo/       # Session de usuario httpsession
├── session-scope-demo/ # Session de usuario @SessionScope
├── survey-app/         # Apliación encuenta @SessionScope
├── todo-list/          # Lista de tareas pendientes
└── README.md
```

---

## 📚 Ejercicios disponibles

| Proyecto           | Descripción                                                                 |
|--------------------|-----------------------------------------------------------------------------|
| `book-library`     | Biblioteca de libros simple con creación, visualización y eliminación de libros. Usa servicios, rutas REST y plantillas Mustache. |
| `forum-service`    | Versión estructurada del foro con Postservie e inyecciones                 |
| `forum`            | Mini foro para publicar, ver y eliminar mensajes de discusión.             |
| `guestbook`        | Permite a los usuarios dejar su nombre y un mensaje visible públicamente.  |
| `product-catalog`  | Catálogo CRUD simple con nombre, descripción y precio.                     |
| `session-demo`     | Gestión de sesión con `HttpSession` para almacenar atributos por usuario.  |
| `session-scope`    | Gestión de sesión con `@SessionScope`, enfoque más elegante y orientado a objetos. |
| `survey-app`           | Aplicación de encuesta con respuestas guardadas en sesión (`@SessionScope`) y contador global. |
| `todo-list`        | Gestor de tareas donde pueden añadirse, completarse y eliminarse.          |

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