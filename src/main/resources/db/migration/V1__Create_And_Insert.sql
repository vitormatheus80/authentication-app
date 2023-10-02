CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name_user VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL
);

INSERT INTO users
(name_user, email, password_hash)
VALUES('vitor almeida', 'vitormatheus80@gmail.com', '');