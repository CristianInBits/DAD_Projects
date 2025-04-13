# 🎬 Movie Manager API

API RESTful desarrollada con Spring Boot y Spring Data JPA para la gestión de una colección de películas.

---

## ✨ Funcionalidades

- Listar todas las películas
- Consultar una película por ID
- Crear una nueva película
- Reemplazar los datos de una película existente
- Eliminar una película
- Buscar películas por director

---

## 📁 Estructura del proyecto

```pgsql
movie-manager-api/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── codeurjc/
│       │           └── movies/
│       │               ├── controllers/
│       │               │   └── MovieController.java
|       |               ├── controlexceptions/
│       │               │   └── NoSuchElementExceptionhandler.java
│       │               ├── models/
│       │               │   └── Movie.java
│       │               └── repository/
│       │                   └── MovieRepository.java
│       └── resources/
│           ├── application.properties
├── postman/
│   └── movie-manager-api.postman_collection.json
├── README.md
└── pom.xml
```

---

## 🔗 Endpoints

| Método | URL              | Descripción                          |
|--------|------------------|--------------------------------------|
| GET    | /movies/         | Obtener todas las películas          |
| GET    | /movies/{id}     | Obtener una película por ID          |
| POST   | /movies/         | Crear una nueva película             |
| PUT    | /movies/{id}     | Reemplazar datos de una película     |
| DELETE | /movies/{id}     | Eliminar una película                |
| GET    | /movies?director=| Buscar películas por director        |

---

## 🧪 Consola H2

Accede a la consola de H2 para inspeccionar la base de datos:

```bash
http://localhost:8080/h2-console
```

---

## 📬 Colección Postman

La carpeta `postman/` contiene una colección para probar todos los endpoints del proyecto.

---

## 🚀 Tecnologías utilizadas

- Java 24+
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Postman
