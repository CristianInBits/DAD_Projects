# 📚 Library Manager API

API REST sencilla para la gestión de una biblioteca. Permite crear, consultar, actualizar y eliminar libros almacenados en una base de datos en memoria H2.

---

## ✅ Funcionalidades

- Crear un libro 📘
- Listar todos los libros 📚
- Consultar un libro por ID 🔎
- Buscar libros por autor ✍️
- Reemplazar un libro existente 🔄
- Eliminar un libro 🗑️

---

## 📁 Estructura del proyecto

```bash
library-manager-api/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── codeurjc/
│       │           └── library/
│       │               ├── controllers/
│       │               │   └── BookController.java
│       │               ├── models/
│       │               │   └── Book.java
│       │               └── repository/
│       │                   └── BookRepository.java
│       └── resources/
│           └── application.properties
├── postman/
│   └── library-manager-api.postman_collection.json
├── README.md
└── pom.xml
```

---

## 🔗 Endpoints disponibles

Consulta la tabla adjunta (más arriba) para conocer los endpoints y su descripción.

---

## 🧪 Consola H2

Puedes acceder a la consola web de la base de datos en:  
👉 `http://localhost:8080/h2-console`  
URL JDBC: `jdbc:h2:mem:librarydb`

---

## 📬 Colección Postman

Disponible en la carpeta `postman/` para probar todos los endpoints.

---

## 🛠️ Tecnologías utilizadas

- Java 24
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Postman
