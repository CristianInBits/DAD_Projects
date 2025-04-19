# 🧾 Ejemplo 5 – Relación 1:1 Unidireccional en Spring Data JPA

Este proyecto ilustra cómo modelar y exponer vía API REST una relación uno‑a‑uno **unidireccional** entre dos entidades (`Student` ↔ `Project`) usando Spring Boot, Spring Data JPA y una base de datos H2 en memoria. Incluye:

- Definición de las entidades con `@OneToOne`
- Persistencia y carga automáticas de la asociación
- Serialización JSON limpia con Jackson
- Manejo de errores 404 con `@ControllerAdvice`

---

## 💡 Funcionalidades

- Listar todos los estudiantes (GET  `/students/`)
- Listar todos los proyectos   (GET  `/projects/`)
- Eliminar un estudiante       (DELETE `/students/{id}`)
- Eliminar un proyecto         (DELETE `/projects/{id}`)

> **Nota:** No existe cascada de borrado, por lo que un proyecto sólo se podrá eliminar si ningún estudiante lo referencia.

---

## 📁 Estructura del proyecto

```bash
ejemplo5-db/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── codeurjc/
│       │           └── board/
│       │               ├── controllers/
│       │               │   ├── advice/
│       │               │   │       └── NoSuchElementExceptionCA.java
│       │               │   └── SchoolController.java
│       │               ├── models/
│       │               │   ├── Project.java
│       │               │   └── Student.java
│       │               ├── repository/
│       │               │    ├── ProjectRepository.java
│       │               │    └── StudentRepository.java
│       │               └── Application.java
│       └── resources/
│           └── application.properties
├── postman/
│   └── ejemplo5-db.postman_collection.json
├── README.md
└── pom.xml
```

---

## 🔢 Endpoints disponibles

| Método | Endpoint              | Descripción                                                   |
|:------:|:----------------------|:--------------------------------------------------------------|
| GET    | `/students/`          | Devuelve lista de todos los estudiantes (incluye proyecto si existe) |
| GET    | `/projects/`          | Devuelve lista de todos los proyectos                        |
| DELETE | `/students/{id}`      | Elimina el estudiante con ese ID (no elimina su proyecto)    |
| DELETE | `/projects/{id}`      | Elimina el proyecto con ese ID, sólo si no está referenciado |

---

## 🌐 Consola web H2

Accesible en: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

> Activa la consola añadiendo en `application.properties`:

> ```properties
> spring.h2.console.enabled=true
> ```

---

## 📊 Colección Postman

Importa las pruebas desde:

```bash
postman/ejemplo5-db.postman_collection.json
```

---

## 🛠️ Tecnologías utilizadas

- Java 24  
- Spring Boot  
- Spring Data JPA  
- H2 Database (en memoria)  
- Jackson (`@JsonInclude`)  
- Maven  
- Postman  
