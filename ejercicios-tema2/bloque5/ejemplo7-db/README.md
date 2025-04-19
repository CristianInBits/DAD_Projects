# 🧾 Ejemplo 7 – Relación 1 : 1 bidireccional con JsonView

Este proyecto demuestra cómo exponer una relación **uno‑a‑uno bidireccional** entre `Student` y `Project` usando Spring Boot, Spring Data JPA y **Jackson @JsonView** para controlar qué atributos se serializan en cada endpoint REST.

---

## 💡 Funcionalidades

- Listar todos los estudiantes – `GET /students/`
- Obtener un estudiante por ID – `GET /students/{id}`
- Listar todos los proyectos – `GET /projects/`
- Obtener un proyecto por ID – `GET /projects/{id}`
- Eliminar un estudiante (borra también su proyecto) – `DELETE /students/{id}`

> **Nota:** gracias a `cascade = CascadeType.ALL`, el borrado de un `Student` elimina automáticamente su `Project`. No hay endpoint para borrar proyectos para evitar incoherencias.

---

## 📁 Estructura del proyecto

```bash
ejemplo7-db/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── chatgpt/
│       │           └── code/
│       │                └── ejemplo7_db/
│       │                    ├── controllers/
│       │                    │   ├── advice/NoSuchElementExceptionCA.java
│       │                    │   └── SchoolController.java
│       │                    ├── models/
│       │                    │   ├── Project.java
│       │                    │   └── Student.java
│       │                    ├── repository/
│       │                    │   ├── ProjectRepository.java
│       │                    │   └── StudentRepository.java
│       │                    └── Application.java
│       └── resources/application.properties
├── postman/ejemplo7-db.postman_collection.json
├── pom.xml
└── README.md
```

---

## 🔢 Endpoints disponibles

| Método | Endpoint              | Vista JSON | Descripción                                                         |
|:------:|:----------------------|:----------:|:--------------------------------------------------------------------|
| GET    | `/students/`          | StudentView | Lista todos los estudiantes (incluye `project` con campos básicos)  |
| GET    | `/students/{id}`      | StudentView | Obtiene un estudiante por ID                                        |
| GET    | `/projects/`          | ProjectView | Lista todos los proyectos (incluye `student` con campos básicos)    |
| GET    | `/projects/{id}`      | ProjectView | Obtiene un proyecto por ID                                          |
| DELETE | `/students/{id}`      | StudentView | Borra el estudiante y *su* proyecto asociado                        |

---

## 🌐 Consola web H2

Disponible en: <http://localhost:8080/h2-console>

```properties
spring.h2.console.enabled=true
```

---

## 📊 Colección Postman

Importa la colección desde:

```bash
postman/ejemplo7-db.postman_collection.json
```

---

## 🛠️ Tecnologías utilizadas

- Java 24
- Spring Boot 3
- Spring Data JPA
- H2 Database (en memoria)
- Jackson (`@JsonView`)
- Maven
- Postman
