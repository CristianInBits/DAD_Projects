# 🏆 Ejemplo 16 - Consultas JPQL sobre relaciones indirectas

Este proyecto demuestra cómo realizar **consultas JPQL avanzadas** sobre relaciones entre varias entidades que **no están directamente conectadas** entre sí, utilizando únicamente `@ManyToOne` y sin necesidad de declarar atributos explícitos en ambas direcciones.  

Las entidades implicadas son:

- `Team` (Equipo)
- `Match` (Partido)
- `Tournament` (Torneo)

---

## 💡 Funcionalidades

- Guardado de partidos entre equipos asignados a torneos
- Consulta de partidos de un torneo
- Consulta de equipos que participan en un torneo
- Consulta de torneos en los que ha participado un equipo

---

## 📁 Estructura del proyecto

```bash
ejemplo16-db/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── codeurjc/
│       │           └── db/
│       │               ├── models/
│       │               │   ├── Match.java
│       │               │   ├── Team.java
│       │               │   └── Tournament.java
│       │               ├── repository/
│       │               │   ├── MatchRepository.java
│       │               │   ├── TeamRepository.java
│       │               │   └── TournamentRepository.java
│       │               └── controllers/
│       │                   └── DataBaseSandbox.java
│       └── resources/
│           └── application.properties
├── postman/
│   └── ejemplo16-db.postman_collection.json
├── README.md
└── pom.xml
```

---

## 🔢 Endpoints disponibles

| Método | Endpoint                      | Descripción                                         |
|--------|-------------------------------|-----------------------------------------------------|
| GET    | `/tournaments/team/{id}`      | Torneos en los que ha jugado un equipo             |
| GET    | `/teams/tournament/{id}`      | Equipos que han jugado en un torneo                |
| GET    | `/matches/tournament/{id}`    | Partidos asociados a un torneo específico          |

---

## 🌐 Consola web H2

Disponible en: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

> Para activarla asegúrate de tener esta propiedad:

```properties
spring.h2.console.enabled=true
```

---

## 📊 Colección Postman

Puedes importar la colección desde:

```bash
postman/ejemplo16-db.postman_collection.json
```

Incluye pruebas para:

- Consultar torneos por equipo
- Consultar equipos por torneo
- Consultar partidos por torneo

---

## 🛠️ Tecnologías utilizadas

- Java 24
- Spring Boot
- Spring Data JPA
- H2 Database (en memoria)
- JPQL
- Maven
- Postman
