# 🐶 Dog Image API

Este proyecto es un cliente REST desarrollado con **Spring Boot** que consume la API pública de [Dog CEO](https://dog.ceo/dog-api/), y añade una funcionalidad personalizada para guardar imágenes aleatorias de perros localmente.

---

## 🎯 Funcionalidades

- Obtener una imagen aleatoria de un perro desde `https://dog.ceo/api/breeds/image/random`
- Guardar la imagen localmente en la carpeta `images/random/`
- Devolver la ruta local donde se ha almacenado la imagen

---

## 🚀 Cómo ejecutar

1. Asegúrate de tener Java 24+ instalado.
2. Clona el repositorio y entra en el directorio del proyecto:

   ```bash
   cd dog-image-api
   ```

3. Ejecuta la aplicación:

   ```bash
   ./mvnw spring-boot:run
   ```

4. Accede al siguiente endpoint desde tu navegador o Postman:

   ```bash
   GET http://localhost:8080/dog-image/save
   ```

   Ejemplo de respuesta:

   ```json
   {
     "savedImagePath": "/ruta/del/proyecto/images/random/image-uuid.jpg"
   }
   ```

---

## 📁 Estructura de carpetas

```arduino
dog-image-api/
├── images/
│   └── random/
│       └── image-*.jpg
├── src/
│   └── main/
│       └── java/
│           └── es/chatgpt/code/dogimageapi/
│               ├── controllers/
│               │   └── DogImageController.java
│               ├── models/
│               │   └── DogImageResponse.java
│               ├── services/
│               │   └── DogImageService.java
│               └── DogImageApiApplication.java
├── pom.xml
└── README.md
```

---

## 📦 Dependencias utilizadas

- Spring Boot Starter Web
- Spring Web (RestTemplate)
- Jackson (conversión JSON)
- Java NIO para manejo de archivos
