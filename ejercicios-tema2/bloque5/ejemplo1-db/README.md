# 🧪 Ejemplo 1 - Customer DB (Spring Data JPA + H2)

Este proyecto demuestra el uso básico de **Spring Data JPA** con una base de datos en memoria **H2**. Se define una entidad `Customer` que se persiste y consulta utilizando un repositorio.

## ⚙️ Tecnologías usadas

- Java 24+
- Spring Boot
- Spring Data JPA
- H2 Database

## 📦 Funcionalidades

- Creación automática de tabla `Customer` usando anotaciones JPA
- Guardado y consulta de clientes en una base de datos H2 en memoria
- Ejecución automática de código al iniciar con `CommandLineRunner`
- Métodos personalizados de consulta (`findByLastName`, `findByFirstName`)

## ▶️ Cómo ejecutar

1. Ejecuta la clase `DataBaseUsage.java` (es un `@Controller` que implementa `CommandLineRunner`)
2. El programa insertará y consultará datos automáticamente al iniciar.

## 🧰 Acceder a la consola web de H2

1. Abre tu navegador y entra a: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
2. Configura el acceso:
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **User Name**: `sa`
   - **Password**: *(déjalo vacío)*
3. Podrás visualizar y consultar la tabla `CUSTOMER`

> 📌 Asegúrate de tener la propiedad activada en `application.properties`: