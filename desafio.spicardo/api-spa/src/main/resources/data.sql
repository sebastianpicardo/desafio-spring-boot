-- pass encriptada en BCrypt , es admin123 , generada con PasswordEncoder
INSERT INTO usuario (id, username, password) VALUES (1, 'admin', '$2a$10$7gDoyXvKbgVdfyIFs9u/ceZGZGcKZzOhK5Vf6d5uwKDJbz6bJvFNS');

-- user123 
INSERT INTO usuario (id, username, password) 
VALUES (2, 'usuario1', '$2a$10$Ay.NWY3gyPo8sTBB9oX.YO9D7S9DaFuyAmJxaerZP1vLVACDwqPpW');

-- test123
INSERT INTO usuario (id, username, password) 
VALUES (3, 'usuario2', '$2a$10$vn4Vt0hDq0BMoXjPrcAy/ehSrgM3ylHaazxYlyikSrTtYHz2V4L8C');


-- Estados de tarea
INSERT INTO estado_tarea (id, nombre) VALUES (1, 'Pendiente');
INSERT INTO estado_tarea (id, nombre) VALUES (2, 'En Progreso');
INSERT INTO estado_tarea (id, nombre) VALUES (3, 'Completada');
