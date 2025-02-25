# 📌 Proyecto: Aplicaciones Web con Spring MVC y Mustache

Este repositorio contiene una aplicación web desarrollada con **Spring Boot**, **Spring MVC** y **Mustache** para la generación dinámica de contenido HTML. El objetivo de este proyecto es servir como base de aprendizaje y desarrollo de aplicaciones distribuidas, aplicando buenas prácticas en la organización de código y plantillas reutilizables.

---

## 🚀 **Características del Proyecto**
✅ Uso de **Spring Boot** para la configuración automática y facilidad de desarrollo.  
✅ Implementación del **patrón MVC** para organizar el código.  
✅ Generación de vistas dinámicas con **Mustache**.  
✅ Reutilización de **fragmentos de plantilla** (cabecera, pie de página).  
✅ Ejemplos de **iteraciones en listas, condiciones y renderizado de objetos** en Mustache.  
✅ Organización modular de controladores y plantillas HTML.

---

## 📂 **Estructura del Proyecto**
```
project-root/
│── src/
│   ├── main/java/com/example/springmvc/ejemplos_mustache
│   │   ├── controllers/       <-- Controladores para manejar las peticiones
│   │   │   ├── ProductController.java
│   │   │   ├── UserController.java
│   │   │   ├── PageController.java
│   │   ├── models/            <-- Clases de modelos de datos (POJOs)
│   │   │   ├── Product.java
│   │   │   ├── User.java
│   │   ├── EjemplosMustacheApplication.java   <-- Clase principal de Spring Boot
│   ├── resources/
│   │   ├── static/images/      <-- Carpeta para imágenes
│   │   ├── templates/          <-- Plantillas Mustache organizadas
│   │   │   ├── fragments/      <-- Fragmentos reutilizables (header/footer)
│   │   │   ├── pages/          <-- Páginas generales
│   │   │   ├── products/       <-- Listado de productos
│   │   │   ├── users/          <-- Perfiles de usuario
│   │   │   ├── dates/          <-- Ejemplos de uso de fechas
│   │   │   ├── forms/          <-- Plantillas para formularios (futuro desarrollo)
│   ├── application.properties  <-- Configuraciones de la aplicación
│── pom.xml                     <-- Dependencias de Maven
│── README.md                    <-- Este archivo 😉
```

---

## 🛠 **Requisitos**
- Java 17 o superior
- Maven 3+
- Un IDE como IntelliJ IDEA, Eclipse o VS Code con soporte para Java

---

## 🔧 **Cómo Ejecutar el Proyecto**
1️⃣ Clonar este repositorio:
```sh
git clone https://github.com/CristianInBits/DAD_Projects.git
cd DAD_Projects/ejemplos-mustache
```
2️⃣ Compilar y ejecutar con Maven:
```sh
mvn spring-boot:run
```
3️⃣ Acceder en el navegador:
```
http://localhost:8080/home
http://localhost:8080/products
http://localhost:8080/user
```

---

## ✨ **Mejoras Futuras**
✅ Manejo de formularios y envío de datos.  
✅ Autenticación y seguridad con **Spring Security**.  
✅ Conexión a base de datos con **Spring Data JPA**.  
✅ Carga y gestión de imágenes de usuario.  
✅ Pruebas unitarias para controladores y servicios.  

---

## 📜 **Licencia**
Este proyecto se distribuye bajo la licencia MIT.

---

¡Este README se irá actualizando conforme agreguemos más funcionalidades! 🚀