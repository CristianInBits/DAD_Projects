# 📨 Ejemplo 2 - Comunicación asíncrona con objetos JSON (RabbitMQ)

Este ejemplo muestra cómo usar RabbitMQ para enviar mensajes estructurados en formato **JSON** entre un **productor** y un **consumidor**, utilizando **Spring Boot** y el convertidor `Jackson2JsonMessageConverter`.

---

## 🚀 Tecnologías utilizadas

* Java 17+
* Spring Boot 3+
* Spring AMQP (RabbitMQ)
* Jackson (para serializar/deserializar JSON)
* RabbitMQ

---

## 📂 Estructura del proyecto

```bash
comunicacion-rabbitmq-ejem2/
├── producer/
│   ├── Application.java
│   ├── Producer.java
│   └── ExampleData.java
├── consumer/
    ├── Application.java
    ├── Consumer.java
    └── ExampleData.java
```

---

## 🔁 Lógica de comunicación

* El **productor** genera objetos `ExampleData` cada segundo.
* RabbitMQ convierte ese objeto a JSON usando `MessageConverter`.
* El **consumidor** recibe el JSON y lo convierte automáticamente de nuevo a un objeto `ExampleData`.

Diagrama:

```mathematica
Producer (ExampleData) --> [Queue: messagesJson] --> Consumer (ExampleData)
```

---

## 🧠 Componentes clave

### `ExampleData.java`

Una clase POJO con tres campos:

* `String data`
* `int index`
* `boolean isEvenIndex`

Incluye getters/setters y un `toString()` que devuelve el objeto en formato JSON.

### `Producer.java`

* Usa `@Scheduled` para enviar un nuevo objeto cada segundo
* Usa `rabbitTemplate.convertAndSend("messagesJson", data)` para enviarlo

### `Consumer.java`

* Usa `@RabbitListener` para recibir objetos directamente deserializados
* El mensaje llega como `ExampleData data`

### `Application.java`

* Registra la cola "messagesJson"
* Registra un `MessageConverter` para indicar que se usará JSON:

```java
@Bean
public MessageConverter messageConverter() {
    return new Jackson2JsonMessageConverter();
}
```

---

## ▶️ Ejecución

1. Ejecuta RabbitMQ local con Docker:

    ```bash
    docker run --rm -p 5672:5672 -p 15672:15672 rabbitmq:3-management
    ```

2. Lanza el `producer`
3. Lanza el `consumer`
4. Verás por consola objetos JSON como:

```bash
{"data":"data 0","index":0,"evenIndex":true}
{"data":"data 1","index":1,"evenIndex":false}
...
```

---

## 📌 Conceptos aplicados

* Comunicación asíncrona con RabbitMQ
* Envio y recepción de objetos JSON
* Conversión automática con `Jackson2JsonMessageConverter`
* Inyección de `RabbitTemplate` y `MessageConverter`

---

## 🧪 Posibles ampliaciones

* Usar Exchange + RoutingKey
* Probar con otros tipos de datos
* Agregar validación de los objetos
* Manejar errores de deserialización
