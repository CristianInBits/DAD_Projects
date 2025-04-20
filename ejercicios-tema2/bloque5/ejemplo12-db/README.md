# 🌐 Ejemplo 12 – Relación M:N bidireccional con @JsonView (Team ↔ Player)

Este proyecto demuestra una relación **muchos‑a‑muchos bidireccional** entre `Team` y `Player`, utilizando `@ManyToMany`, proyecciones JSON basadas en `@JsonView` y una base de datos H2 en memoria.

---

## 💡 Funcionalidades

| Método | Endpoint         | Descripción                                           |
|:------:|:-----------------|:------------------------------------------------------|
| GET    | `/teams/`        | Lista todos los equipos con sus jugadores (vista TeamList) |
| GET    | `/players/{id}`  | Obtiene un jugador con los equipos en los que juega   |

---

## 📁 Estructura del proyecto

```bash
ejemplo12-db/
├── src/main/java/es/chatgpt/code/ejemplo12_db/
│   ├── controllers/TeamController.java
│   ├── models/Player.java
│   ├── models/Team.java
│   ├── repository/PlayerRepository.java
│   ├── repository/TeamRepository.java
│   └── Application.java
├── src/main/resources/application.properties
├── postman/ejemplo12-db.postman_collection.json
├── README.md
└── pom.xml
```

---

## 🔢 Endpoints disponibles

### Equipos

- **GET** `/teams/` – devuelve todos los equipos con jugadores (vista `TeamListView`)

### Jugadores

- **GET** `/players/{id}` – devuelve jugador + equipos (vista `PlayerView`)

*(Puedes ampliar con POST/PUT/DELETE si lo necesitas; actualmente es solo lectura.)*

---

## 🌐 Consola web H2

Disponible en: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

Actívala añadiendo:

```properties
spring.h2.console.enabled=true
```

---

## 📊 Colección Postman

Importa la colección:

```bash
postman/ejemplo12-db.postman_collection.json
```

Incluye pruebas para los endpoints anteriores.

---

## 🛠️ Tecnologías

- Java 24
- Spring Boot
- Spring Data JPA
- H2 Database
- Jackson `@JsonView`
- Maven
- Postman
