# 📇 Contact API

API REST sencilla para la gestión de una agenda de contactos.

## 🧪 Endpoints disponibles

| Método  | Ruta                  | Descripción                        |
|---------|-----------------------|------------------------------------|
| GET     | `/contacts/`          | Lista todos los contactos          |
| GET     | `/contacts/{id}`      | Obtiene un contacto por ID         |
| POST    | `/contacts/`          | Crea un nuevo contacto             |
| PUT     | `/contacts/{id}`      | Reemplaza un contacto existente    |
| DELETE  | `/contacts/{id}`      | Elimina un contacto                |

## 🧱 Formato de contacto

```json
{
  "name": "Alice",
  "email": "alice@example.com",
  "phone": "123456789"
}