# 🧪 Comparativa: Métodos derivados vs JPQL

Este proyecto muestra cómo realizar **consultas equivalentes** en Spring Data JPA utilizando tanto **métodos derivados** (por nombre) como **consultas personalizadas con JPQL**. Incluye ejemplos prácticos sobre filtrado de `Post` por autor o título, ilustrando cuándo conviene usar cada estrategia.

---

## 💡 Funcionalidades

| Método | Endpoint | Parámetros | Implementación | Descripción |
|--------|----------|------------|----------------|-------------|
| GET | `/posts/` | `username` (opcional) | Derived | Devuelve todos los posts o los del usuario indicado |
| GET | `/posts/jpql` | `username` (obligatorio) | JPQL | Devuelve los posts filtrados por `username` usando @Query |

---

## 📁 Estructura del proyecto

```bash
comparativa-consultas/
├── src/main/java/es/chatgpt/code/comparativa/
│   ├── models/
│   │   └── Post.java
│   ├── repository/
│   │   └── PostRepository.java
│   ├── controllers/
│   │   └── PostController.java
│   └── Application.java
├── src/main/resources/application.properties
├── postman/comparativa-consultas.postman_collection.json
├── pom.xml
└── README.md
```

---

## 📦 Entidad principal

```java
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String title;
    private String text;

    // Constructor vacío y con parámetros + getters/setters
}
```

---

## 🧠 Repositorio

```java
public interface PostRepository extends JpaRepository<Post, Long> {

    // Derived queries
    List<Post> findByUsername(String username);

    // JPQL query
    @Query("SELECT p FROM Post p WHERE p.username = ?1")
    List<Post> getByUsername(String username);
}
```

---

## 🌐 Controlador REST

```java
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository posts;

    @PostConstruct
    public void init() {
        posts.save(new Post("Pepe", "¿Alguien vende bici?", "Busco una bici en buen estado"));
        posts.save(new Post("Juan", "Ideas de recetas", "¿Qué hacer con garbanzos?") );
    }

    // Derived method
    @GetMapping("/")
    public List<Post> getPosts(@RequestParam(required = false) String username) {
        if (username != null) {
            return posts.findByUsername(username);
        } else {
            return posts.findAll();
        }
    }

    // JPQL Mehtod
    @GetMapping("/posts/jpql")
    public List<Post> getPostsJPQL(@RequestParam(required = false) String username) {
        if (username == null) {
            return postRepository.findAll(); // método de JpaRepository
        } else {
            return postRepository.getByUsername(username); // @Query
        }
    }
}
```

---

## Opción mas elegante

Podrías tener una única consulta JPQL que devuelva todos los posts si username es null, y si no, filtre:

```java
@Query("""
    SELECT p FROM Post p
    WHERE :username IS NULL OR p.username = :username
""")
List<Post> findByUsernameOptional(@Param("username") String username);
```

Y en el controlador simplemente:

```java
@GetMapping("/posts/jpql")
public List<Post> getPostsJPQL(@RequestParam(required = false) String username) {
    return postRepository.findByUsernameOptional(username);
}
```

🟢 Ventaja: solo necesitas un método, y todo se resuelve en la base de datos
🟡 Requiere saber escribir bien la cláusula WHERE :param IS NULL OR ...

---

## 🌐 Consola H2

Disponible en: <http://localhost:8080/h2-console>

```properties
spring.h2.console.enabled=true
```

---

## 📊 Colección Postman

Importa desde:

```bash
postman/comparativa-consultas.postman_collection.json
```

Incluye:

- GET `/posts/` (todos)
- GET `/posts/?username=Pepe` (filtro derivado)
- GET `/posts/jpql?username=Pepe` (filtro JPQL)

---

## 🛠️ Tecnologías utilizadas

- Java 24
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Postman
