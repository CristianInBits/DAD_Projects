# 🏆 Ejemplo 10 – Relación 1 : N bidireccional (Player ↔ Team)

En este proyecto se modela una relación **uno‑a‑muchos bidireccional**: cada `Team` tiene muchos `Player` y cada `Player` pertenece a un único `Team`.  Se tapa la referencia inversa en la serialización JSON con `@JsonIgnore` para evitar ciclos infinitos.

---

## 💡 Funcionalidades

| Método | Endpoint       | Descripción                              |
|:------:|:---------------|:-----------------------------------------|
| GET    | `/teams/`      | Lista todos los equipos con sus jugadores|
| GET    | `/players/{id}`| Obtiene un jugador por ID                |

---

## 📁 Estructura del proyecto

```bash
ejemplo10-db/
└── src/main/java/es/chatgpt/code/ejemplo10_db/
    ├── controllers/
    │   ├── advice/NoSuchElementExceptionCA.java
    │   └── TeamController.java
    ├── models/Player.java
    ├── models/Team.java
    ├── repository/PlayerRepository.java
    ├── repository/TeamRepository.java
    └── Application.java
└── src/main/resources/application.properties
└── postman/ejemplo10-db.postman_collection.json
└── pom.xml
```

---

## 🌐 Consola web H2

Disponible en [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

```properties
spring.h2.console.enabled=true
```

---

## 📊 Colección Postman

Importa las peticiones desde:

```bash
postman/ejemplo10-db.postman_collection.json
```

---

## 🛠️ Tecnologías usadas

- Java 24
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Postman
