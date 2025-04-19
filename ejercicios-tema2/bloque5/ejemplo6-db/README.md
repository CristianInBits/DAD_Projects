# 🧾 Ejemplo 6 – Relación 1 : 1 con Cascade ALL

Proyecto de ejemplo que muestra una relación uno‑a‑uno **unidireccional** entre `Student` y `Project`, esta vez con **`cascade = CascadeType.ALL`** para que el ciclo de vida de ambas entidades esté ligado. Se ejecuta sobre Spring Boot y base de datos H2 en memoria.

---

## 💡 Funcionalidades

- Listar todos los estudiantes (GET `/students/`)
- Listar todos los proyectos   (GET `/projects/`)
- Eliminar un estudiante (DELETE `/students/{id}`) → borra también su proyecto
- Eliminar un proyecto  (DELETE `/projects/{id}`) → solo si no está referenciado

---

## 📁 Estructura del proyecto

```bash
ejemplo6-db/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── chatgpt/
│       │           └── code/
│       │                └── ejemplo6_db/
│       │                    ├── controllers/
│       │                    │   ├── advice/
│       │                    │   │       └── NoSuchElementExceptionCA.java
│       │                    │   └── SchoolController.java
│       │                    ├── models/
│       │                    │   ├── Project.java
│       │                    │   └── Student.java
│       │                    ├── repository/
│       │                    │    ├── ProjectRepository.java
│       │                    │    └── StudentRepository.java
│       │                    └── Application.java
│       └── resources/
│           └── application.properties
├── postman/
│   └── ejemplo6-db.postman_collection.json
├── README.md
└── pom.xml
```

---

## 🔢 Endpoints disponibles

| Método | Endpoint              | Descripción                                                        |
|:------:|:----------------------|:-------------------------------------------------------------------|
| GET    | `/students/`          | Devuelve la lista de estudiantes (incluye proyecto, si existe)     |
| GET    | `/projects/`          | Devuelve la lista de proyectos                                     |
| DELETE | `/students/{id}`      | Borra el estudiante y **su** proyecto asociado                     |
| DELETE | `/projects/{id}`      | Borra el proyecto (solo si ningún estudiante lo referencia)        |

---

## 🌐 Consola web H2

Disponible en: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

Asegúrate de habilitarla con:

```properties
spring.h2.console.enabled=true
```

---

## 📊 Colección Postman

Importa la colección desde:

```bash
postman/ejemplo6-db.postman_collection.json
```

---

## 🛠️ Tecnologías utilizadas

- Java 24  
- Spring Boot  
- Spring Data JPA  
- H2 Database  
- Maven  
- Postman
