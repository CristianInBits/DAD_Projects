// README.md
# 🧾 Item Manager DB API

API REST para gestionar una lista de items con almacenamiento persistente usando una base de datos relacional mediante **Spring Data JPA**.

---

## ✅ Funcionalidades

- Listar todos los items
- Consultar un item por ID
- Crear un nuevo item
- Editar un item existente
- Borrar un item
- Manejo de errores 404 con `@ControllerAdvice`

---

## 📂 Estructura del proyecto

```bash
item-manager-db-api/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── codeurjc/
│       │           └── itemmanager/
│       │               ├── controllers/
│       │               │   └── ItemController.java
│       │               ├── models/
│       │               │   └── Item.java
│       │               ├── repository/
│       │               │   └── ItemRepository.java
│       │               └── advice/
│       │                   └── NoSuchElementExceptionCA.java
│       └── resources/
│           └── application.properties
├── postman/
│   └── item-manager-db-api.postman_collection.json
├── README.md
└── pom.xml
```

---

## 🔗 Endpoints principales

| Método | Endpoint       | Descripción                        |
|--------|----------------|------------------------------------|
| GET    | `/items/`      | Obtener todos los items            |
| GET    | `/items/{id}`  | Obtener un item por ID             |
| POST   | `/items/`      | Crear un nuevo item                |
| PUT    | `/items/{id}`  | Actualizar un item existente       |
| DELETE | `/items/{id}`  | Eliminar un item                   |

---

## 💻 Consola H2

Disponible en: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa` (por defecto)

---

## 📬 Colección Postman

Incluye una colección Postman para probar todos los endpoints disponibles.

---

## 🛠️ Tecnologías usadas

- Java 24+
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Postman
