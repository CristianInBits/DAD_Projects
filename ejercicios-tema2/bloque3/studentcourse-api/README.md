# 🎓 Student-Course API

Este proyecto implementa una API REST que permite gestionar estudiantes y cursos con relaciones bidireccionales usando Spring Boot y `@JsonView`.

## Endpoints disponibles

| Método | Endpoint            | Descripción                             |
|--------|---------------------|-----------------------------------------|
| GET    | `/api/students`     | Lista básica de estudiantes             |
| GET    | `/api/students/{id}`| Detalles de un estudiante (con cursos)  |
| GET    | `/api/courses`      | Lista básica de cursos                  |
| GET    | `/api/courses/{id}` | Detalles de un curso (con estudiantes)  |

## Tecnologías usadas

- Java 24+
- Spring Boot
- Jackson @JsonView
- API REST estilo RESTful

---

¡Prueba los endpoints con Postman o tu cliente favorito!