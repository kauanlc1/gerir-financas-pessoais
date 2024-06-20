INSERT INTO public.categorias (name) VALUES ('Eletrônicos');
INSERT INTO public.categorias (name) VALUES ('Roupas');
INSERT INTO public.categorias (name) VALUES ('Livros');
INSERT INTO public.categorias (name) VALUES ('Alimentos');
INSERT INTO public.categorias (name) VALUES ('Ferramentas');
INSERT INTO public.categorias (name) VALUES ('Jogos');
INSERT INTO public.categorias (name) VALUES ('Esportes');
INSERT INTO public.categorias (name) VALUES ('Beleza');
INSERT INTO public.categorias (name) VALUES ('Casa e Jardim');
INSERT INTO public.categorias (name) VALUES ('Automotivo');


INSERT INTO public.usuarios (idade, id, cpf, email, nome, nome_usuario, senha, sobrenome)
VALUES (30, '123e4567-e89b-12d3-a456-426614174000', '123.456.789-00', 'usuario1@example.com', 'Fulano', 'fulano123', 'senha123', 'Silva');

INSERT INTO public.usuarios (idade, id, cpf, email, nome, nome_usuario, senha, sobrenome)
VALUES (25, '223e4567-e89b-12d3-a456-426614174000', '987.654.321-00', 'usuario2@example.com', 'Ciclano', 'ciclano456', 'senha456', 'Santos');

INSERT INTO public.usuarios (idade, id, cpf, email, nome, nome_usuario, senha, sobrenome)
VALUES (35, '323e4567-e89b-12d3-a456-426614174000', '111.222.333-00', 'usuario3@example.com', 'Beltrano', 'beltrano789', 'senha789', 'Souza');

INSERT INTO public.usuarios (idade, id, cpf, email, nome, nome_usuario, senha, sobrenome)
VALUES (28, '423e4567-e89b-12d3-a456-426614174000', '444.555.666-00', 'usuario4@example.com', 'Maria', 'maria123', 'senhaMaria', 'Oliveira');

INSERT INTO public.usuarios (idade, id, cpf, email, nome, nome_usuario, senha, sobrenome)
VALUES (32, '523e4567-e89b-12d3-a456-426614174000', '777.888.999-00', 'usuario5@example.com', 'João', 'joao456', 'senhaJoao', 'Santana');

INSERT INTO public.usuarios (idade, id, cpf, email, nome, nome_usuario, senha, sobrenome)
VALUES (27, '623e4567-e89b-12d3-a456-426614174000', '000.111.222-00', 'usuario6@example.com', 'Ana', 'ana789', 'senhaAna', 'Rodrigues');

INSERT INTO public.usuarios (idade, id, cpf, email, nome, nome_usuario, senha, sobrenome)
VALUES (40, '723e4567-e89b-12d3-a456-426614174000', '333.444.555-00', 'usuario7@example.com', 'Pedro', 'pedro123', 'senhaPedro', 'Ferreira');

INSERT INTO public.usuarios (idade, id, cpf, email, nome, nome_usuario, senha, sobrenome)
VALUES (23, '823e4567-e89b-12d3-a456-426614174000', '666.777.888-00', 'usuario8@example.com', 'Carla', 'carla456', 'senhaCarla', 'Costa');

INSERT INTO public.usuarios (idade, id, cpf, email, nome, nome_usuario, senha, sobrenome)
VALUES (31, '923e4567-e89b-12d3-a456-426614174000', '999.000.111-00', 'usuario9@example.com', 'Lucas', 'lucas789', 'senhaLucas', 'Martins');

INSERT INTO public.usuarios (idade, id, cpf, email, nome, nome_usuario, senha, sobrenome)
VALUES (26, 'a23e4567-e89b-12d3-a456-426614174000', '222.333.444-00', 'usuario10@example.com', 'Mariana', 'mariana123', 'senhaMariana', 'Almeida');


-- Inserindo alguns dados de exemplo na tabela transacoes
INSERT INTO public.transacoes (amount, category_id, date, usuario_id, description)
VALUES (100.00, 1, '2024-06-20 12:00:00', '123e4567-e89b-12d3-a456-426614174000', 'Compra de celular');

INSERT INTO public.transacoes (amount, category_id, date, usuario_id, description)
VALUES (50.00, 2, '2024-06-21 15:30:00', '223e4567-e89b-12d3-a456-426614174000', 'Compra de camisetas');

INSERT INTO public.transacoes (amount, category_id, date, usuario_id, description)
VALUES (200.00, 3, '2024-06-22 10:00:00', '323e4567-e89b-12d3-a456-426614174000', 'Compra de livros');

INSERT INTO public.transacoes (amount, category_id, date, usuario_id, description)
VALUES (80.00, 4, '2024-06-23 14:00:00', '423e4567-e89b-12d3-a456-426614174000', 'Compra de alimentos');

INSERT INTO public.transacoes (amount, category_id, date, usuario_id, description)
VALUES (150.00, 5, '2024-06-24 09:30:00', '523e4567-e89b-12d3-a456-426614174000', 'Compra de ferramentas');

INSERT INTO public.transacoes (amount, category_id, date, usuario_id, description)
VALUES (120.00, 6, '2024-06-25 11:45:00', '623e4567-e89b-12d3-a456-426614174000', 'Compra de jogos');

INSERT INTO public.transacoes (amount, category_id, date, usuario_id, description)
VALUES (75.00, 7, '2024-06-26 13:20:00', '723e4567-e89b-12d3-a456-426614174000', 'Compra de equipamentos esportivos');

INSERT INTO public.transacoes (amount, category_id, date, usuario_id, description)
VALUES (60.00, 8, '2024-06-27 16:00:00', '823e4567-e89b-12d3-a456-426614174000', 'Compra de cosméticos');

INSERT INTO public.transacoes (amount, category_id, date, usuario_id, description)
VALUES (90.00, 9, '2024-06-28 14:30:00', '923e4567-e89b-12d3-a456-426614174000', 'Compra de móveis');

INSERT INTO public.transacoes (amount, category_id, date, usuario_id, description)
VALUES (70.00, 10, '2024-06-29 10:45:00', 'a23e4567-e89b-12d3-a456-426614174000', 'Compra de peças automotivas');