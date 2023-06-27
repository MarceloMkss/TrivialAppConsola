-- Crear la tabla de preguntas
CREATE TABLE Preguntas (
    id INT PRIMARY KEY,
    texto_pregunta TEXT NOT NULL,
    categoria TEXT NOT NULL,
    dificultad TEXT NOT NULL
);

-- Crear la tabla de respuestas
CREATE TABLE Respuestas (
    id INT PRIMARY KEY,
    texto_respuesta TEXT NOT NULL,
    correcta BOOLEAN NOT NULL,
    pregunta_id INT,
    FOREIGN KEY (pregunta_id) REFERENCES Preguntas(id)
);

-- Insertar algunas preguntas
INSERT INTO Preguntas (id, texto_pregunta, categoria, dificultad) VALUES (1, '¿Cuál es la capital de Francia?', 'Geografía', 'Fácil');
INSERT INTO Preguntas (id, texto_pregunta, categoria, dificultad) VALUES (2, '¿Quién pintó la Mona Lisa?', 'Arte', 'Fácil');
INSERT INTO Preguntas (id, texto_pregunta, categoria, dificultad) VALUES (3, '¿Qué elemento químico tiene el símbolo Au?', 'Ciencia', 'Medio');

-- Insertar algunas respuestas
INSERT INTO Respuestas (id, texto_respuesta, correcta, pregunta_id) VALUES (1, 'Londres', false, 1);
INSERT INTO Respuestas (id, texto_respuesta, correcta, pregunta_id) VALUES (2, 'París', true, 1);
INSERT INTO Respuestas (id, texto_respuesta, correcta, pregunta_id) VALUES (3, 'Pablo Picasso', false, 2);
INSERT INTO Respuestas (id, texto_respuesta, correcta, pregunta_id) VALUES (4, 'Leonardo da Vinci', true, 2);

