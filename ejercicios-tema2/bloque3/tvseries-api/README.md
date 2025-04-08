# 🎬 TV Series API

This project is a RESTful API built with **Spring Boot** to demonstrate the use of `@JsonView` for JSON serialization. It simulates a basic library of TV series and their actors.

## 📦 Features

- List all TV series (basic info)
- View full details of a TV series, including actors
- List all actors (basic info)
- View full details of an actor, including series

## 🚀 Endpoints

| Method | URL                 | Description                          |
|--------|---------------------|--------------------------------------|
| GET    | `/series`           | Get basic info of all series         |
| GET    | `/series/{id}`      | Get detailed info of a single series |
| GET    | `/actors`           | Get basic info of all actors         |
| GET    | `/actors/{id}`      | Get detailed info of a single actor  |

## 🔍 Example JSON Output

### `GET /series`

```json
[
  {
    "id": 0,
    "title": "Planet Earth",
    "releaseYear": 2006
  },
  {
    "id": 1,
    "title": "Breaking Bad",
    "releaseYear": 2008
  }
]