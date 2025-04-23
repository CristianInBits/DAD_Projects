# 🗂️ Post Pagination Web (Versión Inicial con Paginación)

Este proyecto es una aplicación web en Spring Boot que muestra un listado paginado de publicaciones (posts) utilizando el motor de plantillas Mustache. La paginación se aplica directamente en el controlador usando el parámetro `Pageable`, y se visualiza en una página HTML generada desde `/templates/posts.mustache`.

---

## ✅ Funcionalidades actuales

- Mostrar todos los posts en una tabla paginada
- Navegar entre páginas con botones "anterior" y "siguiente"
- Visualización simple con título, autor y contenido del post

---

## 🛠️ Tecnologías utilizadas

- Java 24
- Spring Boot 3.4.4
- Spring Data JPA
- Spring Web MVC
- Spring Mustache (para plantillas)
- H2 Database (en memoria)
- Maven

---

## 📁 Estructura del proyecto

```bash
post-pagination-web/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── chatgpt/
│       │           └── code/
│       │               └── postpaginationweb/
│       │                   ├── controller/
│       │                   │   └── WebController.java
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

## 🌐 Acceso a la aplicación

- Página principal:
  - [http://localhost:8080/web/posts](http://localhost:8080/web/posts)

---

## 📖 Próximas extensiones

- [x] Filtrado por nombre de usuario (`?username=Juan`)
- [ ] Ordenación (`?sort=title,asc`)
- [ ] Paginación completa con controles más avanzados (números de página, salto rápido)
- [ ] Página de detalle de post

---

## 🧪 Datos de prueba

Se cargan automáticamente algunos posts al iniciar la aplicación desde el método `@PostConstruct` en el `WebController`.

---

## 📝 Notas adicionales

- La plantilla `posts.mustache` se encuentra en `src/main/resources/templates`
- El sufijo de los archivos Mustache no es `.html`, debe permanecer `.mustache` para que Spring los detecte correctamente
- El controlador **no** debe anotarse con `@RestController`, sino con `@Controller`
- No es necesario configurar `spring.mustache.suffix=.html` si los archivos terminan en `.mustache`

---

> Esta versión corresponde al **Ejercicio 2** del bloque de paginación en Spring MVC. Se irá extendiendo progresivamente con nuevas funcionalidades.
