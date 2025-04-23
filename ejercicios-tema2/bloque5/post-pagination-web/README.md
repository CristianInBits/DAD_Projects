# 📃 Post Pagination Web (Mustache)

Este proyecto es una versión web del sistema de gestión de posts que utiliza **paginación** para mostrar los resultados y una interfaz desarrollada con **plantillas Mustache**. Forma parte del *Ejercicio 2* del bloque de paginación del curso de Spring Boot.

---

## 💡 Funcionalidades principales

- Visualización paginada de los posts.
- Navegación entre páginas usando enlaces dinámicos.
- Plantilla Mustache para el listado.

---

## 🧱 Estructura del proyecto

```bash
post-pagination-web/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── chatgpt/
│       │           └── code/
│       │               └── post_pagination_web/
│       │                   ├── controller/
│       │                   │   └── WebPostController.java
│       │                   ├── model/
│       │                   │   └── Post.java
│       │                   ├── repository/
│       │                   │   └── PostRepository.java
│       │                   └── Application.java
│       └── resources/
│           ├── templates/
│           │   └── posts.mustache
│           └── application.properties
├── README.md
└── pom.xml
```

---

## 🌐 Vista web disponible

- Listado: `http://localhost:8080/web/posts/`

---

## ⚙️ Paginación

- Número de página y tamaño gestionado por Spring automáticamente.
- Se puede acceder directamente a otras páginas mediante parámetros URL:

```
http://localhost:8080/web/posts/?page=1&size=5
```

---

## 🛠️ Tecnologías utilizadas

- Java 24
- Spring Boot 3
- Spring Data JPA
- Mustache (plantillas)
- H2 Database (en memoria)
- Maven

---

## 🧪 Próximas mejoras

- Filtro por nombre de usuario desde la web
- Ordenación por campos (username, título)
- Estilos visuales
- Controles de navegación más accesibles

---
