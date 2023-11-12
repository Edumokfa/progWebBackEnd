docker build -t integracao-tabela-fipe .
docker run -p 8080:8080 integracao-tabela-fipe

docker run --name postgres-container -e POSTGRES_PASSWORD=root -d -p 5432:5432 postgres

Para a criação das tabelas no banco de dados

Acessar o banco padrão (postgres)

executar este comando

create database jersey_jax_rs;

após executar com sucesso, acessar o banco jersey_jax_rs
e então executar a criação das tabelas a seguir:

CREATE TABLE brand (
    id serial PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE model (
    id serial PRIMARY KEY,
    name VARCHAR(255),
    brand_id integer,
    FOREIGN KEY (brand_id) REFERENCES brand (id)
);

CREATE TABLE public.vehicle (
    id serial PRIMARY KEY,
    fipe_code VARCHAR(255),
    type VARCHAR(1),
    value NUMERIC,
    model_id integer,
    year integer,
    gas VARCHAR(1),
    FOREIGN KEY (model_id) REFERENCES model (id)
);

insert into brand (name) values ('VW'), ('FIAT');

insert into model (name, brand_id) values ('Gol', 1), ('Palio', 2);

insert into vehicle (fipecode, type, value, model_id, year, gas) values ('45392874892374', 'C', 45000, 1, 2023, 'G'), ('45392874892372', 'C', 30000, 2, 2023, 'G');
