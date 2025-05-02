# API SPA - Desafio Técnico

## Descripción

Desafio técnico de previred. Api Nuevo Spa.

## Datos contacto

- **Desarrollador Senior**: Sebastián Picardo
- **Correo**: sebastian.picardo@gmail.com

## Tecnologías Utilizadas

IDE Eclipse

## Endpoints

# Login Post

http://localhost:8080/auth/login
{
"username": "admin",
"password": "$2a$10$7gDoyXvKbgVdfyIFs9u/ceZGZGcKZzOhK5Vf6d5uwKDJbz6bJvFNS"
}

# POST http://localhost:8080/api/tareas: Crear una nueva tarea.

curl --location --request POST 'http://localhost:8080/api/tareas' \
--header 'Authorization: Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc0NjIyMjc5MiwiZXhwIjoxNzQ2MjU4NzkyfQ.jXlcrg3SHL8RUo7vqEqnTi6v8WWcDGDl1Cr9ePSoWNPMvB1kV9mILHPu9Rz46GoV' \
--header 'Content-Type: application/json' \
--data-raw '{
"titulo": "Tarea ejemplo",
"descripcion": "Descripción de prueba",
"usuarioId": 1,
"estadoId": 2
}
'

# GET http://localhost:8080/api/tareas: Listar todas las tareas.

curl --location --request GET 'http://localhost:8080/api/tareas' \
--header 'Authorization: Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc0NjIyMjc5MiwiZXhwIjoxNzQ2MjU4NzkyfQ.jXlcrg3SHL8RUo7vqEqnTi6v8WWcDGDl1Cr9ePSoWNPMvB1kV9mILHPu9Rz46GoV'

# PUT http://localhost:8080/api/tareas/{id}: Actualizar una tarea existente.

curl --location --request PUT 'http://localhost:8080/api/tareas/1' \
--header 'Authorization: Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc0NjIyMjc5MiwiZXhwIjoxNzQ2MjU4NzkyfQ.jXlcrg3SHL8RUo7vqEqnTi6v8WWcDGDl1Cr9ePSoWNPMvB1kV9mILHPu9Rz46GoV' \
--header 'Content-Type: application/json' \
--data-raw '{
"nombre": "Nueva tarea",
"descripcion": "Descripción de la tarea",
"estado": "Pendiente"
}
'

# DELETE http://localhost:8080/api/tareas/{id}: Eliminar una tarea.

curl --location --request DELETE 'http://localhost:8080/api/tareas/2' \
--header 'Authorization: Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc0NjIyMjc5MiwiZXhwIjoxNzQ2MjU4NzkyfQ.jXlcrg3SHL8RUo7vqEqnTi6v8WWcDGDl1Cr9ePSoWNPMvB1kV9mILHPu9Rz46GoV'

```

```
